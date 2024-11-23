package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GruposubcuentaEntity;

public interface GruposubcuentaRepository extends JpaRepository<GruposubcuentaEntity, Long> {

    Page<GruposubcuentaEntity> findByDescripcionContaining(
        String filter1, Pageable oPageable);
    
}
