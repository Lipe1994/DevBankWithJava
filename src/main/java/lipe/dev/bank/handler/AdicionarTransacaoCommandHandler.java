package lipe.dev.bank.handler;

import lipe.dev.bank.exceptions.BusinessException;
import lipe.dev.bank.handler.commands.AdicionarTransacaoCommand;
import lipe.dev.bank.repositories.ClienteRepository;
import lipe.dev.bank.controllers.view_models.Limite;
import lipe.dev.bank.repositories.projections.ILimite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class AdicionarTransacaoCommandHandler {
    private static Logger logger = LoggerFactory.getLogger(AdicionarTransacaoCommandHandler.class);
    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Limite handle(int id, AdicionarTransacaoCommand command)
    {
        ILimite resumo;
        switch (command.tipo)
        {
            case 'd':
                resumo = repository.debitar(id, (int) command.valor);
                break;
            case 'c':
                resumo = repository.creditar(id, (int) command.valor);
                break;
            default:
                throw new BusinessException("Tipo desconhecido");
        }


        if(resumo == null || !resumo.getLinhaAfetada())
        {
            logger.warn("Não foi possível atualizar o saldo");
            throw new BusinessException("Não foi possível atualizar o saldo");
        }

        repository.AdicionaTransacao(id, (int)command.valor, command.tipo, command.descricao, Instant.now());

        return new Limite(resumo.getLimite(), resumo.getSaldo());
    }
}
