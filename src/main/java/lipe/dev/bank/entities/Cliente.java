package lipe.dev.bank.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @Id
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cliente_seq")
    @EqualsAndHashCode.Include
    private int id;

    @Column(nullable = false)
    private int saldo;
    @Column(nullable = false)
    private int limite;
    @Column(nullable = false)
    private int versao;
}
