package lipe.dev.bank.repositories.projections;


import java.time.Instant;

public interface IExtrato {
    int getId();
    int getTotal();
    int getLimite();
    Integer getValor();
    String getDescricao();
    Character getTipo();
    Instant getCriadoEm();

}