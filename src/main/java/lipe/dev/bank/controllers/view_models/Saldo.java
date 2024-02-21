package lipe.dev.bank.controllers.view_models;

import com.fasterxml.jackson.annotation.JsonProperty;
import theleo.jstruct.Struct;

import java.time.Instant;

@Struct
public class Saldo {
    public int total;
    public int limite ;

    @JsonProperty("data_extrato")
    public Instant dataExtrato = Instant.now();
}