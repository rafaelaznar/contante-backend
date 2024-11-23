package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.TipocuentaEntity;

public interface TipocuentaRepository extends JpaRepository<TipocuentaEntity, Long> {

    Page<TipocuentaEntity> findByDescripcionContainingOrCreditoOdebitoContainingOrComentariosContaining(
            String filter2, String filter3, String filter4, Pageable oPageable);


}
