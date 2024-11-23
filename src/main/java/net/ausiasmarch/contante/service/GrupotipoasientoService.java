package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupotipoasientoEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.GrupotipoasientoRepository;

@Service
public class GrupotipoasientoService implements ServiceInterface<GrupotipoasientoEntity> {

    @Autowired
    GrupotipoasientoRepository oGrupoTipoAsientoRepository;

    @Autowired
    RandomService oRandomService;

    @Autowired
    TipoasientoService oTipoasientoService;

    @Autowired
    BalanceService oBalanceService;

    String[] arrTitulos = { "Titulo 1", "Titulo 2", "Titulo 3", "Titulo 4", "Titulo 5", "Titulo 6", "Titulo 7",
            "Titulo 8", "Titulo 9", "Titulo 10" };
    
    String[] arrDescripcion = { "Descripcion 1", "Descripcion 2", "Descripcion 3", "Descripcion 4", "Descripcion 5", "Descripcion 6", "Descripcion 7",
            "Descripcion 8", "Descripcion 9", "Descripcion 10" };

    @Override
    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupotipoasientoEntity oGrupoTipoAsientoEntity = new GrupotipoasientoEntity();
            oGrupoTipoAsientoEntity
                    .setTitulo(arrTitulos[oRandomService.getRandomInt(0, arrTitulos.length - 1)]);
            oGrupoTipoAsientoEntity.setDescripcion(arrDescripcion[oRandomService.getRandomInt(0, arrDescripcion.length - 1)]);
            oGrupoTipoAsientoEntity.setOrden(i);
            oGrupoTipoAsientoEntity.setTipoasiento(oTipoasientoService.randomSelection());
            oGrupoTipoAsientoEntity.setBalance(oBalanceService.randomSelection());
            oGrupoTipoAsientoRepository.save(oGrupoTipoAsientoEntity);
        }
        return oGrupoTipoAsientoRepository.count();
    }

    public Page<GrupotipoasientoEntity> getPage(Pageable oPageable, Optional<String> filter) {
        if (filter.isPresent()) {
            return oGrupoTipoAsientoRepository.findByTituloContainingOrDescripcionContaining(
                            filter.get(), filter.get(), oPageable);
        } else {
            return oGrupoTipoAsientoRepository.findAll(oPageable);
        }
    }


    public GrupotipoasientoEntity get(Long id) {
        return oGrupoTipoAsientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grupo de Tipo de Asiento no encontrado"));
    }

    public Long count() {
        return oGrupoTipoAsientoRepository.count();
    }

    public Long delete(Long id) {
        oGrupoTipoAsientoRepository.deleteById(id);
        return 1L;
    }

    public GrupotipoasientoEntity create(GrupotipoasientoEntity oGrupoTipoAsientoEntity) {
        return oGrupoTipoAsientoRepository.save(oGrupoTipoAsientoEntity);
    }

    public GrupotipoasientoEntity update(GrupotipoasientoEntity oGrupoTipoAsientoEntity) {
        GrupotipoasientoEntity oGrupoTipoAsientoEntityFromDatabase = oGrupoTipoAsientoRepository.findById(oGrupoTipoAsientoEntity.getId()).get();
        if (oGrupoTipoAsientoEntity.getTitulo() != null) {
            oGrupoTipoAsientoEntityFromDatabase.setTitulo(oGrupoTipoAsientoEntity.getTitulo());
        }
        if (oGrupoTipoAsientoEntity.getDescripcion() != null) {
            oGrupoTipoAsientoEntityFromDatabase.setDescripcion(oGrupoTipoAsientoEntity.getDescripcion());
        }
        if (oGrupoTipoAsientoEntity.getOrden() != 0) {
            oGrupoTipoAsientoEntityFromDatabase.setOrden(oGrupoTipoAsientoEntity.getOrden());
        }
       // if (oGrupoTipoAsientoEntity.getId_tipoasiento() != 0) {
      //      oGrupoTipoAsientoEntityFromDatabase.setId_tipoasiento(oGrupoTipoAsientoEntity.getId_tipoasiento());
      //  }
      //  if (oGrupoTipoAsientoEntity.getId_balance() != 0) {
//            oGrupoTipoAsientoEntityFromDatabase.setId_balance(oGrupoTipoAsientoEntity.getId_balance());
     //   }
       
        return oGrupoTipoAsientoRepository.save(oGrupoTipoAsientoEntityFromDatabase);
    }

    public Long deleteAll() {
        oGrupoTipoAsientoRepository.deleteAll();
        return this.count();
    }

    @Override
    public GrupotipoasientoEntity randomSelection() {
        return oGrupoTipoAsientoRepository.findAll()
                .get(oRandomService.getRandomInt(0, (int) (oGrupoTipoAsientoRepository.count() - 1)));
    }    

}
