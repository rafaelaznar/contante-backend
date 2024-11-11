package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.contante.entity.BalanceEntity;

public interface ServiceInterfaceBalance {

    public Long randomCreate(Long cantidad);

    public Page<BalanceEntity> getPage(Pageable oPageable, Optional<String> filter);

    public BalanceEntity get(Long id);

    public Long count();

    public Long delete(Long id);

    public BalanceEntity create(BalanceEntity oBalanceEntity);

    public BalanceEntity update(BalanceEntity oBalanceEntity);

    public Long deleteAll();

}
