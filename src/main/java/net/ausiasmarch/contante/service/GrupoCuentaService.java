package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupoCuentaEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.GrupoCuentaRepository;

@Service
public class GrupoCuentaService implements ServiceInterface<GrupoCuentaEntity> {

    @Autowired
    GrupoCuentaRepository oGrupoCuentaRepository;

    @Autowired
    RandomService oRandomService;

    private String[] arrTitulo = { "Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4", "Titulo 5" };

    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupoCuentaEntity oGrupoCuentaEntity = new GrupoCuentaEntity();
            oGrupoCuentaEntity.setTitulo(arrTitulo[oRandomService.getRandomInt(0, arrTitulo.length - 1)]);
            oGrupoCuentaEntity.setDescripcion("descripcion aleatoria");
            oGrupoCuentaEntity.setOrden(i + 1);
            oGrupoCuentaEntity.setId_cuenta(i + 1L);
            oGrupoCuentaEntity.setId_balance(i + 1L);
            oGrupoCuentaRepository.save(oGrupoCuentaEntity);
        }
        return oGrupoCuentaRepository.count();
    }

    public Page<GrupoCuentaEntity> getPage(Pageable oPageable, Optional<String> filter) {

        if (filter.isPresent()) {
            return oGrupoCuentaRepository
                    .findByTituloContaining(filter.get(), oPageable);
        } else {
            return oGrupoCuentaRepository.findAll(oPageable);
        }
    }

    public GrupoCuentaEntity get(Long id) {
        return oGrupoCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GrupoCuenta no encontrada"));
    }

    public Long count() {
        return oGrupoCuentaRepository.count();
    }

    public Long delete(Long id) {
        oGrupoCuentaRepository.deleteById(id);
        return 1L;
    }

    public GrupoCuentaEntity create(GrupoCuentaEntity oGrupoCuentaEntity) {
        return oGrupoCuentaRepository.save(oGrupoCuentaEntity);
    }

    public GrupoCuentaEntity update(GrupoCuentaEntity oGrupoCuentaEntity) {
        GrupoCuentaEntity oGrupoCuentaEntityFromDatabase = oGrupoCuentaRepository.findById(oGrupoCuentaEntity.getId())
                .get();
        if (oGrupoCuentaEntity.getTitulo() != null) {
            oGrupoCuentaEntityFromDatabase.setTitulo(oGrupoCuentaEntity.getTitulo());
        }
        if (oGrupoCuentaEntity.getDescripcion() != null) {
            oGrupoCuentaEntityFromDatabase.setDescripcion(oGrupoCuentaEntity.getDescripcion());
        }
        if (oGrupoCuentaEntity.getOrden() != 0) {
            oGrupoCuentaEntityFromDatabase.setOrden(oGrupoCuentaEntity.getOrden());
        }
        if (oGrupoCuentaEntity.getId_cuenta() != 0) {
            oGrupoCuentaEntityFromDatabase.setId_cuenta(oGrupoCuentaEntity.getId_cuenta());
        }
        if (oGrupoCuentaEntity.getId_balance() != 0) {
            oGrupoCuentaEntityFromDatabase.setId_balance(oGrupoCuentaEntity.getId_balance());
        }
        return oGrupoCuentaRepository.save(oGrupoCuentaEntityFromDatabase);
    }

    public Long deleteAll() {
        oGrupoCuentaRepository.deleteAll();
        return this.count();
    }

}
