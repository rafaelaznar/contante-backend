package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ausiasmarch.contante.entity.GrupocuentaEntity;


public interface GrupocuentaRepository extends JpaRepository<GrupocuentaEntity, Long> {

    Page<GrupocuentaEntity> findByTituloContaining(
            String filter1, Pageable oPageable);

      
}
