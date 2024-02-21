package lipe.dev.bank.repositories.projections;

import theleo.jstruct.Struct;

public interface ILimite {
    int getLimite();
    int getSaldo();
    boolean getLinhaAfetada();
}