package lipe.dev.bank.repositories;

import lipe.dev.bank.controllers.view_models.Limite;
import lipe.dev.bank.entities.*;
import lipe.dev.bank.repositories.projections.IExtrato;
import lipe.dev.bank.repositories.projections.ILimite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>
{

    @Query(value = "WITH updated as (UPDATE cliente SET saldo=saldo-?2 WHERE id=?1 AND abs(saldo - ?2) <= limite RETURNING *) select limite, saldo, true linhaAfetada from updated", nativeQuery = true)
    ILimite debitar(int id, int valor);

    @Query(value = "WITH updated as (UPDATE cliente SET saldo=saldo+?2 WHERE id=?1 RETURNING *) select limite, saldo, true linhaAfetada from updated", nativeQuery = true)
    ILimite creditar(int id, int valor);


    @Modifying
    @Query(value = "INSERT INTO transacao( cliente_id, valor, tipo, descricao, criado_em) values( ?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void AdicionaTransacao(int id, int valor, char tipo, String descricao, Instant criadoEm);

    @Query(value = "SELECT l.limite, l.saldo, l.versao FROM cliente l WHERE Id=?1", nativeQuery = true)
    Optional<ILimite> obterLimite(int id);

    @Query(value = "SELECT c.id, c.saldo total, c.limite, t.valor, t.descricao, t.tipo, t.criado_em AS criadoEm \n" +
            "   FROM Cliente c \n" +
            "   left join Transacao t on t.cliente_id = c.id \n" +
            "WHERE c.id = ?1 \n" +
            "ORDER BY t.id DESC \n" +
            "LIMIT 10", nativeQuery = true)
    List<IExtrato> obterExtrato(int id);
}