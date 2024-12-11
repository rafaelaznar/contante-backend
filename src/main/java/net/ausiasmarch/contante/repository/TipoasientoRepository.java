package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import net.ausiasmarch.contante.entity.TipoasientoEntity;

public interface TipoasientoRepository extends JpaRepository<TipoasientoEntity, Long> {

    Page<TipoasientoEntity> findByDescripcionContaining(
            String filter, Pageable oPageable);

    @Query(value = """
            SELECT ta.* FROM tipoasiento ta
            JOIN grupotipoasiento gta ON ta.id = gta.id_tipoasiento
            JOIN balance b ON gta.id_balance = b.id
            WHERE b.id = :idBalance
            """, nativeQuery = true)
    Page<TipoasientoEntity> findByBalance(Pageable oPageable, Long idBalance);

    @Transactional
    @Modifying
    @Query(value = """
            DELETE FROM grupotipoasiento WHERE id_tipoasiento = :idTipoasiento AND id_balance = :idBalance
            """, nativeQuery = true)
    int deleteRelation(Long idTipoasiento, Long idBalance);

    @Transactional
    @Modifying
    @Query(value = """
            INSERT INTO grupotipoasiento (id_tipoasiento, id_balance, titulo, descripcion, orden) VALUES (:idTipoasiento, :idBalance, '', '', 0)
            """, nativeQuery = true)
    int addRelation(Long idTipoasiento, Long idBalance);
}
