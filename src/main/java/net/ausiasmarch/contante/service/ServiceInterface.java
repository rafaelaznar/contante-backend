package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.contante.entity.UsuarioEntity;

public interface ServiceInterface {

    public Long randomCreate(Long cantidad);

    public Page<UsuarioEntity> getPage(Pageable oPageable, Optional<String> filter);

    public UsuarioEntity get(Long id);

    public Long count();

    public Long delete(Long id);

    public UsuarioEntity create(UsuarioEntity oUsuarioEntity);

    public UsuarioEntity update(UsuarioEntity oUsuarioEntity);

    public Long deleteAll();

}
