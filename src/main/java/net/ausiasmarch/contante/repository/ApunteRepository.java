package net.ausiasmarch.contante.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.ApunteEntity;
import net.ausiasmarch.contante.entity.AsientoEntity;

public interface  ApunteRepository extends JpaRepository<ApunteEntity, Long> {

    Page<ApunteEntity> findByDescripcionContainingOrComentariosContaining (
           String filter1, String filter2, Pageable oPageable);

           @Query(value = "SELECT * FROM apunte WHERE (descripcion LIKE %:strDescripcion% OR comentarios LIKE %:strComentarios%) AND id_asiento=:id_asiento", nativeQuery = true)
  Page<ApunteEntity> findByAsientoIdAndDescripcionContainingOrComentariosContaining(String strDescripcion,
      String strComentarios, Long id_asiento, Pageable oPageable);

  Page<ApunteEntity> findByAsientoId(Long id_asiento, Pageable oPageable);

}

