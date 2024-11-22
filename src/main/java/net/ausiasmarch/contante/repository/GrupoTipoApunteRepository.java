package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GrupoTipoApunteEntity;


public interface GrupoTipoApunteRepository extends JpaRepository<GrupoTipoApunteEntity, Long> {
     Page<GrupoTipoApunteEntity> findByTituloContainingOrDescripcionContaining(
            String filter1, String filter2, Pageable oPageable);
 
}
