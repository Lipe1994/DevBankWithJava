package lipe.dev.bank.controllers.view_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import theleo.jstruct.Struct;

import java.time.Instant;

@Struct
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