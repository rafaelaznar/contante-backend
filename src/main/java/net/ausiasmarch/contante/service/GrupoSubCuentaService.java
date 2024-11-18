package net.ausiasmarch.contante.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupoSubCuentaEntity;
import net.ausiasmarch.contante.entity.TipousuarioEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.GrupoSubCuentaRepository;
@Service
public class GrupoSubCuentaService {
    
    @Autowired
    GrupoSubCuentaRepository oGrupoSubCuentaRepository;

    @Autowired
    RandomService oRandomService;


    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupoSubCuentaEntity ogGrupoSubCuentaEntity = new GrupoSubCuentaEntity();
            ogGrupoSubCuentaEntity.setDescripcion("Tipo usuario " + i + oRandomService.getRandomInt(999, 9999));
            
            oGrupoSubCuentaRepository.save(ogGrupoSubCuentaEntity);
        }
        return oGrupoSubCuentaRepository.count();
    }

    public Page<GrupoSubCuentaEntity> getPage(Pageable oPageable, Optional<String> filter) {

        if (filter.isPresent()) {
            return oGrupoSubCuentaRepository
                    .findByDescripcionContaining(filter.get(), oPageable);
        } else {
            return oGrupoSubCuentaRepository.findAll(oPageable);
        }
    }

    public GrupoSubCuentaEntity get(Long id) {
        return oGrupoSubCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    public Long count() {
        return oGrupoSubCuentaRepository.count();
    }

    public Long delete(Long id) {
        oGrupoSubCuentaRepository.deleteById(id);
        return 1L;
    }

    public GrupoSubCuentaEntity create(GrupoSubCuentaEntity oGrupoSubCuentaEntity) {
        return oGrupoSubCuentaRepository.save(oGrupoSubCuentaEntity);
    }

    public GrupoSubCuentaEntity update(GrupoSubCuentaEntity oGrupoSubCuentaEntity) {
        GrupoSubCuentaEntity oGrupoSubCuentaEntityFromDatabase = oGrupoSubCuentaRepository.findById(oGrupoSubCuentaEntity.getId())
                .get();
        if (oGrupoSubCuentaEntity.getDescripcion() != null) {
            oGrupoSubCuentaEntityFromDatabase.setDescripcion(oGrupoSubCuentaEntity.getDescripcion());
        }
        return oGrupoSubCuentaRepository.save(oGrupoSubCuentaEntityFromDatabase);
    }

    public Long deleteAll() {
        oGrupoSubCuentaRepository.deleteAll();
        return this.count();
    }
}
