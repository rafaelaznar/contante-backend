package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.TipoapunteEntity;

public interface TipoapunteRepository extends JpaRepository<TipoapunteEntity, Long> {

    Page<TipoapunteEntity> findByDescripcionContainingOrComentariosContaining(
            String filter1, String filter2, Pageable oPageable);

    @Query(value = "SELECT t.* FROM tipoapunte t INNER JOIN grupotipoapunte g ON t.id = g.id_tipoapunte WHERE g.id_balance = :idBalance", nativeQuery = true)
    Page<TipoapunteEntity> BalanceIdTipoApunte(Long idBalance, Pageable oPageable);

    @Query(value = "SELECT * FROM tipoapunte t WHERE t.id NOT IN (SELECT g.id_tipoapunte FROM grupotipoapunte g WHERE g.id_balance = :idBalance);", nativeQuery = true)
    Page<TipoapunteEntity> RestXBalance(Long idBalance, Pageable oPageable);
}
