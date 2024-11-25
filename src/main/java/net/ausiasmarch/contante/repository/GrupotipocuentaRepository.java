package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GrupotipocuentaEntity;

public interface GrupotipocuentaRepository extends JpaRepository<GrupotipocuentaEntity, Long> {

    Page<GrupotipocuentaEntity> findByTituloContainingOrDescripcionContaining(
            String filter1, String filter2, Pageable oPageable);

}
