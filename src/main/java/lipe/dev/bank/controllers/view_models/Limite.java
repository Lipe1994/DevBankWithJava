package lipe.dev.bank.controllers.view_models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import theleo.jstruct.Struct;

@Struct
final public class Limite {

    public Limite(int limite, int saldo)
    {
        this.limite = limite;
        this.saldo = saldo;
    }
    public int limite;
    public int saldo;

    @JsonIgnore
    public boolean linhaAfetada;
}

