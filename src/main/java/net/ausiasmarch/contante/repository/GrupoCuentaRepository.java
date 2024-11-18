package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GrupoCuentaEntity;

public interface GrupoCuentaRepository extends JpaRepository<GrupoCuentaEntity, Long> {

    Page<GrupoCuentaEntity> findByTituloContaining(
            String filter1, Pageable oPageable);
}
