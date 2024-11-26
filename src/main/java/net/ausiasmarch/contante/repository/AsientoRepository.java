package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.ausiasmarch.contante.entity.AsientoEntity;

public interface AsientoRepository extends JpaRepository<AsientoEntity, Long> {

  Page<AsientoEntity> findByDescripcionContainingOrComentariosContaining(
      String filter2, String filter3, Pageable oPageable);

  @Query(value = "SELECT * FROM asiento WHERE (descripcion LIKE %:strDescripcion% OR comentarios LIKE %:strComentarios%) AND id_usuario=:id_usuario", nativeQuery = true)
  Page<AsientoEntity> findByUsuarioIdAndDescripcionContainingOrComentariosContaining(String strDescripcion,
      String strComentarios, Long id_usuario, Pageable oPageable);

  Page<AsientoEntity> findByUsuarioId(Long id_usuario, Pageable oPageable);

  @Query(value = "SELECT * FROM asiento WHERE (descripcion LIKE %:strDescripcion% OR comentarios LIKE %:strComentarios%) AND id_tipoasiento=:id_tipoasiento", nativeQuery = true)
  Page<AsientoEntity> findByTipoasientoIdAndDescripcionContainingOrComentariosContaining(String strDescripcion,
      String strComentarios, Long id_tipoasiento, Pageable oPageable);

  Page<AsientoEntity> findByTipoasientoId(Long id_tipoasiento, Pageable oPageable);
  

}
