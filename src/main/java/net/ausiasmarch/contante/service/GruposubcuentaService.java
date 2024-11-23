package net.ausiasmarch.contante.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GruposubcuentaEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.GruposubcuentaRepository;
@Service
public class GruposubcuentaService {
    
    @Autowired
    GruposubcuentaRepository oGrupoSubCuentaRepository;

    @Autowired
    RandomService oRandomService;

    @Autowired
    SubcuentaService oSubcuentaService;

    @Autowired
    BalanceService oBalanceService;

    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GruposubcuentaEntity ogGrupoSubCuentaEntity = new GruposubcuentaEntity();
            ogGrupoSubCuentaEntity.setTitulo("Grupo subcuenta " + i + oRandomService.getRandomInt(999, 9999));
            ogGrupoSubCuentaEntity.setDescripcion(ogGrupoSubCuentaEntity.getTitulo());
            ogGrupoSubCuentaEntity.setOrden(i);
            ogGrupoSubCuentaEntity.setSubcuenta(oSubcuentaService.randomSelection());
            ogGrupoSubCuentaEntity.setBalance(oBalanceService.randomSelection());
            oGrupoSubCuentaRepository.save(ogGrupoSubCuentaEntity);
        }
        return oGrupoSubCuentaRepository.count();
    }

    public Page<GruposubcuentaEntity> getPage(Pageable oPageable, Optional<String> filter) {

        if (filter.isPresent()) {
            return oGrupoSubCuentaRepository
                    .findByDescripcionContaining(filter.get(), oPageable);
        } else {
            return oGrupoSubCuentaRepository.findAll(oPageable);
        }
    }

    public GruposubcuentaEntity get(Long id) {
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

    public GruposubcuentaEntity create(GruposubcuentaEntity oGrupoSubCuentaEntity) {
        return oGrupoSubCuentaRepository.save(oGrupoSubCuentaEntity);
    }

    public GruposubcuentaEntity update(GruposubcuentaEntity oGrupoSubCuentaEntity) {
        GruposubcuentaEntity oGrupoSubCuentaEntityFromDatabase = oGrupoSubCuentaRepository.findById(oGrupoSubCuentaEntity.getId())
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

    public GruposubcuentaEntity randomSelection() {
        return oGrupoSubCuentaRepository.findAll()
                .get(oRandomService.getRandomInt(0, (int) (oGrupoSubCuentaRepository.count() - 1)));
    }
}
