package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import net.ausiasmarch.contante.entity.CuentaEntity;
import net.ausiasmarch.contante.entity.GrupocuentaEntity;


public interface GrupocuentaRepository extends JpaRepository<GrupocuentaEntity, Long> {

    Page<GrupocuentaEntity> findByTituloContaining(
            String filter1, Pageable oPageable);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM grupocuenta WHERE id_cuenta = :id_cuenta AND id_balance = :id_balance", nativeQuery = true)
    int deleteByIds(@Param("id_balance") Long id_balance, @Param("id_cuenta") Long id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO grupocuenta (titulo, descripcion, orden, id_cuenta, id_balance) VALUES (' ', ' ', 0 ,:id_cuenta, :id_balance)", nativeQuery = true)
    int createByIds(@Param("id_balance") Long id_balance, @Param("id_cuenta") Long id_cuenta);
      
}
