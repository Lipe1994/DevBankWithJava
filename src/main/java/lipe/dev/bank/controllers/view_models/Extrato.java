package lipe.dev.bank.controllers.view_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import theleo.jstruct.Struct;
import java.util.ArrayList;
import java.util.List;

@Struct
public class Extrato {
    public  Extrato(){}
    public Saldo saldo;

    @JsonProperty("ultimas_transacoes")
    public List<TransacaoResumo> ultimasTransacoes = new ArrayList<TransacaoResumo>();
}