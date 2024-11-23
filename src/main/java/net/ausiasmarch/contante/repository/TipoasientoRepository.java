package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.TipoasientoEntity;

public interface TipoasientoRepository extends JpaRepository <TipoasientoEntity, Long> {
    
    Page<TipoasientoEntity> findByDescripcionContaining(
            String filter, Pageable oPageable);

}
