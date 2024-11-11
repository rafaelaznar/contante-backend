package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ausiasmarch.contante.entity.SubCuentaEntity;
public interface ServiceSubCuentaInterface {
    
    
        public Long randomCreate(Long cantidad);
    
        public Page<SubCuentaEntity> getPage(Pageable oPageable, Optional<String> filter);
    
        public SubCuentaEntity get(Long id);
    
        public Long count();
    
        public Long delete(Long id);
    
        public SubCuentaEntity create(SubCuentaEntity oApunteEntity);
    
        public SubCuentaEntity update(SubCuentaEntity oApunteEntity);
    
        public Long deleteAll();

    
} 
