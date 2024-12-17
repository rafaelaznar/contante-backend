package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import net.ausiasmarch.contante.entity.CuentaEntity;



public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

    Page<CuentaEntity> findByCodigoContainingOrDescripcionContaining(
            String filter1, String filter2, Pageable oPageable);

    @Query(value = "SELECT * FROM cuenta WHERE (codigo LIKE %:strCodigo% OR descripcion LIKE %:strDescripcion%) AND id_tipocuenta=:id_tipocuenta", nativeQuery = true)
    Page<CuentaEntity> findByTipocuentaIdAndCodigoContainingOrDescripcionContaining(
            Long id_tipocuenta, String strCodigo, String strDescripcion, Pageable oPageable);

    Page<CuentaEntity> findByTipocuentaId(Long id_tipocuenta, Pageable oPageable);

    @Query(value = "SELECT c.* FROM cuenta c, grupocuenta gc WHERE c.id = gc.id_cuenta and gc.id_balance=:id_balance", nativeQuery = true)
    Page<CuentaEntity> findAllXBalance(Long id_balance, Pageable oPageable);

    @Query(value = "SELECT * FROM cuenta c3 WHERE c3.id NOT IN ( SELECT c2.id_cuenta FROM grupocuenta c2 WHERE c2.id_balance = :id_balance );", nativeQuery = true)
    Page<CuentaEntity> findAllXBalanceNoTiene(Long id_balance, Pageable oPageable);
    
}
