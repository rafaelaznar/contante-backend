package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupotipoapunteEntity;

import net.ausiasmarch.contante.repository.GrupotipoapunteRepository;

@Service
public class GrupotipoapunteService implements ServiceInterface<GrupotipoapunteEntity> {
    @Autowired
    GrupotipoapunteRepository oGrupoTipoApunteRepository;

    @Autowired
    RandomService oRandomService;

    @Autowired
    BalanceService oBalanceService;

    @Autowired
    TipoapunteService oTipoApunteService;

    private String[] arrTitulos = { "Pepe", "Laura", "Ignacio", "Maria", "Lorenzo", "Carmen", "Rosa", "Paco", "Luis",
            "Ana", "Rafa", "Manolo", "Lucia", "Marta", "Sara", "Rocio" };

    private String[] arrDescripcion = { "Sancho", "Gomez", "Pérez", "Rodriguez", "Garcia", "Fernandez", "Lopez",
            "Martinez", "Sanchez", "Gonzalez", "Gimenez", "Feliu", "Gonzalez", "Hermoso", "Vidal", "Escriche" };

    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupotipoapunteEntity oGrupoTipoApunteEntity = new GrupotipoapunteEntity();
            oGrupoTipoApunteEntity.setTitulo(arrTitulos[oRandomService.getRandomInt(0, arrTitulos.length - 1)]);
            oGrupoTipoApunteEntity
                    .setDescripcion(arrDescripcion[oRandomService.getRandomInt(0, arrDescripcion.length - 1)]);
            oGrupoTipoApunteEntity.setOrden(oRandomService.getRandomInt(0, 100));
            oGrupoTipoApunteEntity.setBalance(oBalanceService.randomSelection());
            oGrupoTipoApunteEntity.setTipoapunte(oTipoApunteService.randomSelection());    
            oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntity);
        }
        return oGrupoTipoApunteRepository.count();
    }

    public Page<GrupotipoapunteEntity> getPage(Pageable oPageable, Optional<String> filter) {

        if (filter.isPresent()) {
            return oGrupoTipoApunteRepository
                    .findByTituloContainingOrDescripcionContaining(
                            filter.get(), filter.get(), oPageable);
        } else {
            return oGrupoTipoApunteRepository.findAll(oPageable);
        }

    }

    public Long delete(Long id) {
        oGrupoTipoApunteRepository.deleteById(id);
        return 1L;
    }

    public GrupotipoapunteEntity create(GrupotipoapunteEntity oGrupoTipoApunteEntity) {
        return oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntity);
    }

    public GrupotipoapunteEntity update(GrupotipoapunteEntity oGrupoTipoApunteEntity) {
        GrupotipoapunteEntity oGrupoTipoApunteEntityFromDatabase = oGrupoTipoApunteRepository
                .findById(oGrupoTipoApunteEntity.getId()).get();
        if (oGrupoTipoApunteEntity.getTitulo() != null) {
            oGrupoTipoApunteEntityFromDatabase.setTitulo(oGrupoTipoApunteEntity.getTitulo());
        }
        if (oGrupoTipoApunteEntity.getDescripcion() != null) {
            oGrupoTipoApunteEntityFromDatabase.setDescripcion(oGrupoTipoApunteEntity.getDescripcion());
        }
        if (oGrupoTipoApunteEntity.getOrden() != 0) {
            oGrupoTipoApunteEntityFromDatabase.setOrden(oGrupoTipoApunteEntityFromDatabase.getOrden());
        }
        if (oGrupoTipoApunteEntity.getBalance() != null) {
            oGrupoTipoApunteEntityFromDatabase.setBalance(oBalanceService.get(oGrupoTipoApunteEntity.getBalance().getId()));
        }
        if (oGrupoTipoApunteEntity.getTipoapunte() != null) {
            oGrupoTipoApunteEntityFromDatabase.setTipoapunte(oTipoApunteService.get(oGrupoTipoApunteEntity.getTipoapunte().getId()));
        }
        return oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntityFromDatabase);
    }

    public Long deleteAll() {
        oGrupoTipoApunteRepository.deleteAll();
        return this.count();
    }

    @Override
    public GrupotipoapunteEntity get(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Long count() {

        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public GrupotipoapunteEntity randomSelection() {
        return oGrupoTipoApunteRepository.findAll()
                .get(oRandomService.getRandomInt(0, (int) (oGrupoTipoApunteRepository.count() - 1)));
     
    }

}
