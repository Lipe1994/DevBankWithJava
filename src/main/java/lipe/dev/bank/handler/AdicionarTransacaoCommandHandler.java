package lipe.dev.bank.handler;

import lipe.dev.bank.exceptions.BusinessException;
import lipe.dev.bank.handler.commands.AdicionarTransacaoCommand;
import lipe.dev.bank.repositories.ClienteRepository;
import lipe.dev.bank.controllers.view_models.Limite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

import static java.lang.Math.abs;

@Service
public class AdicionarTransacaoCommandHandler {
    private static Logger logger = LoggerFactory.getLogger(AdicionarTransacaoCommandHandler.class);
    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Limite handle(int id, AdicionarTransacaoCommand command)
    {
        var optionalLimite = repository.obterLimite(id);
        if (optionalLimite.isEmpty())
        {
            logger.warn("Cliente não encontrado");
            throw new BusinessException("Cliente não encontrado");
        }

        var limite = optionalLimite.get().getLimite();
        var saldo = optionalLimite.get().getSaldo();
        var versao = optionalLimite.get().getVersao();

        switch (command.tipo)
        {
            case 'd':
                if (abs((saldo - (int)command.valor)) > limite)
                {
                    logger.warn("Não tem limite");
                    throw new BusinessException("Não tem limite");
                }
                saldo -= (int)command.valor;
                break;
            case 'c':
                saldo +=  (int)command.valor;
                break;
            default:
                logger.warn("Tipo desconhecido");
                throw new BusinessException("Tipo desconhecido");
        }

        var rowsAffected = repository.AtualizaSaldo(id, saldo, versao, (versao + 1));
        if(rowsAffected < 1)
        {
            logger.warn("Não foi possível atualizar o saldo");
            throw new BusinessException("Não foi possível atualizar o saldo");
        }

        repository.AdicionaTransacao(id, (int)command.valor, command.tipo, command.descricao, Instant.now());

        return new Limite(limite, saldo);
    }
}
