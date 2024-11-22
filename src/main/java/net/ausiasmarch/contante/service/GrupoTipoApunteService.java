package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupoTipoApunteEntity;

import net.ausiasmarch.contante.repository.GrupoTipoApunteRepository;

@Service
public class GrupoTipoApunteService implements ServiceInterface<GrupoTipoApunteEntity>{
    @Autowired
    GrupoTipoApunteRepository oGrupoTipoApunteRepository;

    @Autowired
    RandomService oRandomService;

    private String[] arrTitulos = {"Pepe", "Laura", "Ignacio", "Maria", "Lorenzo", "Carmen", "Rosa", "Paco", "Luis",
        "Ana", "Rafa", "Manolo", "Lucia", "Marta", "Sara", "Rocio"};

    private String[] arrDescripcion = {"Sancho", "Gomez", "Pérez", "Rodriguez", "Garcia", "Fernandez", "Lopez",
        "Martinez", "Sanchez", "Gonzalez", "Gimenez", "Feliu", "Gonzalez", "Hermoso", "Vidal", "Escriche"};

        // Datos de la columna orden
        private int[] arrorden = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

         // Datos de la columna id_asiento
    private long[] arrid_balance = { 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014,
        1015, 1016, 1017, 1018, 1019, 1020 };

         // Datos de la columna id_asiento
    private long[] arrid_tipoapunte = { 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009, 1010, 1011, 1012, 1013, 1014,
        1015, 1016, 1017, 1018, 1019, 1020 };
    

    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            GrupoTipoApunteEntity oGrupoTipoApunteEntity = new GrupoTipoApunteEntity();
            oGrupoTipoApunteEntity.setTitulo(arrTitulos[oRandomService.getRandomInt(0, arrTitulos.length - 1)]);
            oGrupoTipoApunteEntity.setDescripcion(arrDescripcion[oRandomService.getRandomInt(0, arrDescripcion.length - 1)]);
            oGrupoTipoApunteEntity.setOrden( (long) arrorden [oRandomService.getRandomInt(0, arrorden.length - 1)]);
            oGrupoTipoApunteEntity.setId_balance( arrid_balance [oRandomService.getRandomInt(0, arrid_balance.length - 1)]);
            oGrupoTipoApunteEntity.setId_tipoapunte(arrid_tipoapunte [oRandomService.getRandomInt(0, arrid_tipoapunte.length - 1)]);
            oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntity);
        }
        return oGrupoTipoApunteRepository.count();
    }

    public Page<GrupoTipoApunteEntity> getPage(Pageable oPageable, Optional<String> filter) {

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

    public GrupoTipoApunteEntity create(GrupoTipoApunteEntity oGrupoTipoApunteEntity) {
        return oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntity);
    }

    public GrupoTipoApunteEntity update(GrupoTipoApunteEntity oGrupoTipoApunteEntity) {
        GrupoTipoApunteEntity oGrupoTipoApunteEntityFromDatabase = oGrupoTipoApunteRepository.findById(oGrupoTipoApunteEntity.getId()).get();
        if (oGrupoTipoApunteEntity.getTitulo() != null) {
            oGrupoTipoApunteEntityFromDatabase.setTitulo(oGrupoTipoApunteEntity.getTitulo());
        }
        if (oGrupoTipoApunteEntity.getDescripcion() != null) {
            oGrupoTipoApunteEntityFromDatabase.setDescripcion(oGrupoTipoApunteEntity.getDescripcion());
        }
        if (oGrupoTipoApunteEntity.getOrden() != 0) {
            oGrupoTipoApunteEntityFromDatabase.setOrden(oGrupoTipoApunteEntityFromDatabase.getOrden());
    }
         if (oGrupoTipoApunteEntity.getId_balance() != 0) {
        oGrupoTipoApunteEntityFromDatabase.setId_balance(oGrupoTipoApunteEntityFromDatabase.getId_balance());
    }
        if (oGrupoTipoApunteEntity.getId_tipoapunte() != 0) {
    oGrupoTipoApunteEntityFromDatabase.setId_tipoapunte(oGrupoTipoApunteEntityFromDatabase.getId_tipoapunte());
    }

    return oGrupoTipoApunteRepository.save(oGrupoTipoApunteEntityFromDatabase);
}



    public Long deleteAll() {
        oGrupoTipoApunteRepository.deleteAll();
        return this.count();
    }

    @Override
    public GrupoTipoApunteEntity get(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Long count() {
        
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}
