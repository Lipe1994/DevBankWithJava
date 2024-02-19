package lipe.dev.bank.controllers.view_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Extrato {
    public  Extrato(){}
    public Saldo saldo;
    @JsonProperty("ultimas_transacoes")
    public List<TransacaoResumo> ultimasTransacoes = new ArrayList<TransacaoResumo>();

    public class Saldo {
        public int total;
        public int limite ;

        @JsonProperty("data_extrato")
        public Instant dataExtrato = Instant.now();
    }

    public class TransacaoResumo
    {
        public TransacaoResumo(int valor, char tipo, String descricao, Instant criadoEm)
        {
            this.valor = valor;
            this.tipo = tipo;
            this.descricao = descricao;
            this.criadoEm = criadoEm;
        }

        public int valor;
        public char tipo;
        public String descricao;

        @JsonProperty("criado_em")
        public Instant criadoEm;
    }
}