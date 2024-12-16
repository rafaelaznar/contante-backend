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

    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupotipoapunteEntity oGrupoTipoApunteEntity = new GrupotipoapunteEntity();
            oGrupoTipoApunteEntity.setBalance(oBalanceService.randomSelection());
            oGrupoTipoApunteEntity.setTipoapunte(oTipoApunteService.randomSelection());
            oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntity);
        }
        return oGrupoTipoApunteRepository.count();
    }

    public Page<GrupotipoapunteEntity> getPage(Pageable oPageable, Optional<String> filter) {

        return oGrupoTipoApunteRepository.findAll(oPageable);

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
        if (oGrupoTipoApunteEntity.getBalance() != null) {
            oGrupoTipoApunteEntityFromDatabase
                    .setBalance(oBalanceService.get(oGrupoTipoApunteEntity.getBalance().getId()));
        }
        if (oGrupoTipoApunteEntity.getTipoapunte() != null) {
            oGrupoTipoApunteEntityFromDatabase
                    .setTipoapunte(oTipoApunteService.get(oGrupoTipoApunteEntity.getTipoapunte().getId()));
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

    public Long count() {
        return oGrupoTipoApunteRepository.count();
    }

    @Override
    public GrupotipoapunteEntity randomSelection() {
        return oGrupoTipoApunteRepository.findAll()
                .get(oRandomService.getRandomInt(0, (int) (oGrupoTipoApunteRepository.count() - 1)));

    }

    public long deleteRelation(Long idTipoApunte, Long idBalance) {
        oGrupoTipoApunteRepository.deleteRelation(idTipoApunte, idBalance);
        return this.count();
    }

    public long addRelation(Long idTipoApunte, Long idBalance) {
        GrupotipoapunteEntity grupotipoapunte = new GrupotipoapunteEntity();
        grupotipoapunte.setBalance(oBalanceService.get(idBalance));
        grupotipoapunte.setTipoapunte(oTipoApunteService.get(idTipoApunte));
        oGrupoTipoApunteRepository.save(grupotipoapunte);

        return this.count();
    }

}
