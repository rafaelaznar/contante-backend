package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.BalanceEntity;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {

    Page<BalanceEntity> findByTituloContainingOrDescripcionContaining(
            String filter2, String filter3, Pageable oPageable);

    @Query(value = "SELECT b.* FROM balance b, grupotipoapunte g WHERE b.id = g.id_balance and g.id_tipoapunte=:id_tipoapunte", nativeQuery = true)
    Page<BalanceEntity> findAllXTipoapunte(Long id_tipoapunte, Pageable oPageable);

    @Query(value = "SELECT b.* FROM balance b, grupotipoapunte g WHERE b.id = g.id_balance and g.id_tipoapunte=:id_tipoapunte and (b.titulo LIKE %:strFilter% or b.descripcion LIKE %:strFilter%)", nativeQuery = true)
    Page<BalanceEntity> findByTituloContainingOrDescripcionContainingXTipoapunte(Long id_tipoapunte,String strFilter, Pageable oPageable);

    @Query(value = "SELECT b.* FROM balance b, grupotipocuenta g WHERE b.id = g.id_balance and g.id_tipocuenta=:id_tipocuenta", nativeQuery = true)
    Page<BalanceEntity> findAllXTipocuenta(Long id_tipocuenta, Pageable oPageable);

    @Query(value = "SELECT b.* FROM balance b, grupotipocuentag WHERE b.id = g.id_balance and g.id_tipocuenta=:id_tipocuenta and (b.titulo LIKE %:strFilter% or b.descripcion LIKE %:strFilter%)", nativeQuery = true)
    Page<BalanceEntity> findByTituloContainingOrDescripcionContainingXTipocuenta(Long id_tipocuenta,String strFilter, Pageable oPageable);

}
