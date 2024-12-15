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

     @Query(value = """
            SELECT c.* FROM cuenta c
            JOIN grupocuenta ca ON c.id = ca.id_cuenta
            JOIN balance b ON ca.id_balance = b.id
            WHERE b.id = :idBalance
            """, nativeQuery = true)
    Page<CuentaEntity> findByBalance(Pageable oPageable, Long idBalance);
    @Transactional
    @Modifying
    @Query(value = """
            DELETE FROM grupocuenta WHERE id_cuenta = :idCuenta AND id_balance = :idBalance
            """, nativeQuery = true)
    int deleteRelation(Long idCuenta, Long idBalance);
    @Transactional
    @Modifying
    @Query(value = """
            INSERT INTO grupocuenta (id_cuenta, id_balance, titulo, descripcion, orden) VALUES (:idCuenta, :idBalance, '', '', 0)
            """, nativeQuery = true)
    int addRelation(Long idCuenta, Long idBalance);
    
}
