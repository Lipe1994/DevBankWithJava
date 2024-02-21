package lipe.dev.bank.handler.commands;

import theleo.jstruct.Struct;

@Struct
public class AdicionarTransacaoCommand {
    public double valor;
    public char tipo;
    public String descricao;
}
