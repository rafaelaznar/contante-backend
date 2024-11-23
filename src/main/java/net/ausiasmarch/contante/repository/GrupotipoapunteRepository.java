package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GrupotipoapunteEntity;


public interface GrupotipoapunteRepository extends JpaRepository<GrupotipoapunteEntity, Long> {
     Page<GrupotipoapunteEntity> findByTituloContainingOrDescripcionContaining(
            String filter1, String filter2, Pageable oPageable);
 
}
