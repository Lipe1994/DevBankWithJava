package lipe.dev.bank.controllers;

import lipe.dev.bank.handler.commands.AdicionarTransacaoCommand;
import lipe.dev.bank.handler.AdicionarTransacaoCommandHandler;
import lipe.dev.bank.controllers.view_models.Extrato;
import lipe.dev.bank.repositories.ClienteRepository;
import lipe.dev.bank.controllers.view_models.Limite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private static Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private AdicionarTransacaoCommandHandler handler;

    @PostMapping("{id}/transacoes")
    @ResponseStatus(HttpStatus.OK)
    public Limite adicionarTransacao(@PathVariable int id, @RequestBody AdicionarTransacaoCommand command)
    {
        if (id < 1 || id > 5)
        {
            logger.warn("Id não encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null);
        }

        if ((command.descricao == null || command.descricao.isBlank()) ||
                (command.descricao.length() > 10) ||
                ((command.valor - (int)command.valor) > 0) ||
                (command.tipo != 'd' && command.tipo != 'c'))
        {
            logger.warn("Não passou nas validações do command");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "");
        }

        return handler.handle(id, command);
    }

    @GetMapping("{id}/extrato")
    @ResponseStatus(HttpStatus.OK)
    public Extrato extrato(@PathVariable int id)
    {
        if (id < 1 || id > 5)
        {
            logger.warn("Id não encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null);
        }

        var projecao = repository.obterExtrato(id);

        var extrato = new Extrato();
        var saldo = extrato.new Saldo();
        saldo.total = projecao.getFirst().getTotal();
        saldo.limite = projecao.getFirst().getLimite();

        extrato.saldo = saldo;

        if(projecao.getFirst().getValor() != null)
            for(int i = 0; i < projecao.size(); i++)
            {
                var t = projecao.get(i);
                extrato.ultimasTransacoes.add(extrato.new TransacaoResumo(t.getValor(), t.getTipo(), t.getDescricao(), t.getCriadoEm()));
            }

        return extrato;
    }
}
