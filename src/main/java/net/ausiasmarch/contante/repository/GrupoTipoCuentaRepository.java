package net.ausiasmarch.contante.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.contante.entity.GrupotipocuentaEntity;

public interface GrupoTipoCuentaRepository extends JpaRepository<GrupotipocuentaEntity, Long> {

    Page<GrupotipocuentaEntity> findByTituloContainingOrDescripcionContainingOrOrdenContainingOrIdTipoCuentaContainingIdBalanceContaining(
            String filter2, String filter3, String filter4, String filter5, String filter6, Pageable oPageable);


}
