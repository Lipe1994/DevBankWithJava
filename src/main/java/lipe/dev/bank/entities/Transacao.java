package lipe.dev.bank.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "serial")
    @EqualsAndHashCode.Include
    private int id;

    @Column(nullable = false)
    private  int valor;
    @Column(length = 10, nullable = false)
    private String descricao;
    @Column(nullable = false, length = 1)
    private char tipo;

    @Column(insertable=false, updatable=false)
    private int clienteId;

    private Instant criadoEm;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
}
