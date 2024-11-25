package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.SubcuentaEntity;

public interface SubcuentaRepository extends JpaRepository<SubcuentaEntity, Long> {

    Page<SubcuentaEntity> findByDescripcionContaining(
        String filter1, Pageable oPageable);

}
