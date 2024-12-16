package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.TipocuentaEntity;

public interface TipocuentaRepository extends JpaRepository<TipocuentaEntity, Long> {

    Page<TipocuentaEntity> findByDescripcionContainingOrComentariosContaining(
            String filter2, String filter3, Pageable oPageable);

    @Query(value = "SELECT COUNT(*) FROM cuenta, subcuenta WHERE cuenta.id_tipocuenta=:id AND subcuenta.id_cuenta=cuenta.id", nativeQuery = true)
    Long getPageSubcuenta(Long id);

}
