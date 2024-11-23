package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupocuentaEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.GrupocuentaRepository;

@Service
public class GrupocuentaService implements ServiceInterface<GrupocuentaEntity> {

    @Autowired
    GrupocuentaRepository oGrupoCuentaRepository;

    @Autowired
    RandomService oRandomService;

    @Autowired
    CuentaService oCuentaService;

    @Autowired
    BalanceService oBalanceService;

    private String[] arrTitulo = { "Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4", "Titulo 5" };

    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupocuentaEntity oGrupoCuentaEntity = new GrupocuentaEntity();
            oGrupoCuentaEntity.setTitulo(arrTitulo[oRandomService.getRandomInt(0, arrTitulo.length - 1)]);
            oGrupoCuentaEntity.setDescripcion("descripcion aleatoria");
            oGrupoCuentaEntity.setOrden(i + 1);
            oGrupoCuentaEntity.setCuenta(oCuentaService.randomSelection());
            oGrupoCuentaEntity.setBalance(oBalanceService.randomSelection());
            oGrupoCuentaRepository.save(oGrupoCuentaEntity);
        }
        return oGrupoCuentaRepository.count();
    }

    public Page<GrupocuentaEntity> getPage(Pageable oPageable, Optional<String> filter) {

        if (filter.isPresent()) {
            return oGrupoCuentaRepository
                    .findByTituloContaining(filter.get(), oPageable);
        } else {
            return oGrupoCuentaRepository.findAll(oPageable);
        }
    }

    public GrupocuentaEntity get(Long id) {
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

    public GrupocuentaEntity create(GrupocuentaEntity oGrupoCuentaEntity) {
        return oGrupoCuentaRepository.save(oGrupoCuentaEntity);
    }

    public GrupocuentaEntity update(GrupocuentaEntity oGrupoCuentaEntity) {
        GrupocuentaEntity oGrupoCuentaEntityFromDatabase = oGrupoCuentaRepository.findById(oGrupoCuentaEntity.getId())
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
        if (oGrupoCuentaEntity.getCuenta() != null) {
            oGrupoCuentaEntityFromDatabase.setCuenta(oCuentaService.get(oGrupoCuentaEntity.getCuenta().getId()));
        }
        if (oGrupoCuentaEntity.getBalance() != null) {
            oGrupoCuentaEntityFromDatabase.setBalance(oBalanceService.get(oGrupoCuentaEntity.getBalance().getId()));
        }
        return oGrupoCuentaRepository.save(oGrupoCuentaEntityFromDatabase);
    }

    public Long deleteAll() {
        oGrupoCuentaRepository.deleteAll();
        return this.count();
    }

    public GrupocuentaEntity randomSelection() {
        return oGrupoCuentaRepository.findAll()
                .get(oRandomService.getRandomInt(0, (int) (oGrupoCuentaRepository.count() - 1)));
    }

}
