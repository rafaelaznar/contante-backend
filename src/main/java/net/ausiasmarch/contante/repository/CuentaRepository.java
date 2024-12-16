package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.CuentaEntity;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

    Page<CuentaEntity> findByCodigoContainingOrDescripcionContaining(
            String filter1, String filter2, Pageable oPageable);

    @Query(value = "SELECT * FROM cuenta WHERE (codigo LIKE %:strCodigo% OR descripcion LIKE %:strDescripcion%) AND id_tipocuenta=:id_tipocuenta", nativeQuery = true)
    Page<CuentaEntity> findByTipocuentaIdAndCodigoContainingOrDescripcionContaining(
            Long id_tipocuenta, String strCodigo, String strDescripcion, Pageable oPageable);

    Page<CuentaEntity> findByTipocuentaId(Long id_tipocuenta, Pageable oPageable);

    @Query(value = "SELECT c.* FROM cuenta c, grupocuenta g WHERE c.id = g.id_cuenta and g.id_balance=:id_balance ", nativeQuery = true)
    Page<CuentaEntity> findByBalance(Long id_balance, Pageable oPageable);
    
}
