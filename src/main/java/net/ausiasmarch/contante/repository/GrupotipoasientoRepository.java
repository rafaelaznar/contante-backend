package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import net.ausiasmarch.contante.entity.GrupotipoasientoEntity;


public interface GrupotipoasientoRepository extends JpaRepository<GrupotipoasientoEntity, Long>{

     Page<GrupotipoasientoEntity> findByTituloContainingOrDescripcionContaining(
            String filter2, String filter3, Pageable oPageable);

    
}
