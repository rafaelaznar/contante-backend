package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GrupoSubCuentaEntity;

public interface GrupoSubCuentaRepository extends JpaRepository<GrupoSubCuentaEntity, Long> {

    Page<GrupoSubCuentaEntity> findByDescripcionContaining(
        String filter1, Pageable oPageable);
    
}
