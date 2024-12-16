package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.TipocuentaEntity;

public interface TipocuentaRepository extends JpaRepository<TipocuentaEntity, Long> {

    Page<TipocuentaEntity> findByDescripcionContainingOrComentariosContaining(
            String filter2, String filter3, Pageable oPageable);

    @Query(value = "SELECT t.* FROM tipocuenta t, grupotipocuenta g WHERE t.id = g.id_tipocuenta and g.id_balance=:id_balance", nativeQuery = true)
    Page<TipocuentaEntity> findAllXBalance(Long id_balance, Pageable oPageable);

    @Query(value = "SELECT DISTINCT t3.* FROM tipocuenta t3 WHERE t3.id NOT IN ( SELECT t2.id_tipocuenta FROM grupotipocuenta t2 WHERE t2.id_balance = :id_balance );", nativeQuery = true)
    Page<TipocuentaEntity> findAllXBalanceNoTiene(Long id_balance, Pageable oPageable);
}
