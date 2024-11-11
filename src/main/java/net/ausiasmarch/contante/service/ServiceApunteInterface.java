package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.contante.entity.ApunteEntity;

public interface ServiceApunteInterface {

    public Long randomCreate(Long cantidad);

    public Page<ApunteEntity> getPage(Pageable oPageable, Optional<String> filter);

    public ApunteEntity get(Long id);

    public Long count();

    public Long delete(Long id);

    public ApunteEntity create(ApunteEntity oApunteEntity);

    public ApunteEntity update(ApunteEntity oApunteEntity);

    public Long deleteAll();

}
