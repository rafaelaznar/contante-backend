package net.ausiasmarch.contante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.PeriodoEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.PeriodoRepository;

@Service
public class PeriodoService implements ServiceInterface<PeriodoEntity> {

    @Autowired
    PeriodoRepository oPeriodoRepository;

    @Autowired
    RandomService oRandomService;

    public Long randomCreate(Long cantidad) {
        this.create(new PeriodoEntity(2020, "ejercicio 2020", "ejercicio 2020", true));
        this.create(new PeriodoEntity(2021, "ejercicio 2021", "ejercicio 2021", true));
        this.create(new PeriodoEntity(2022, "ejercicio 2022", "ejercicio 2022", true));
        this.create(new PeriodoEntity(2023, "ejercicio 2023", "ejercicio 2023", true));
        this.create(new PeriodoEntity(2024, "ejercicio 2024", "ejercicio 2024", false));
        return oPeriodoRepository.count();
    }

    public Page<PeriodoEntity> getPage(Pageable oPageable, Optional<String> filter) {
        if (filter.isPresent()) {
            return oPeriodoRepository
                    .findByDescripcionContainingOrComentariosContaining(
                            filter.get(), filter.get(), oPageable);
        } else {
            return oPeriodoRepository.findAll(oPageable);
        }
    }

    public PeriodoEntity get(Long id) {
        return oPeriodoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo no encontrado"));

    }

    public Long count() {
        return oPeriodoRepository.count();
    }

    public Long delete(Long id) {
        oPeriodoRepository.deleteById(id);
        return 1L;
    }

    public PeriodoEntity create(PeriodoEntity oPeriodoEntity) {
        return oPeriodoRepository.save(oPeriodoEntity);
    }

    public PeriodoEntity update(PeriodoEntity oPeriodoEntity) {
        PeriodoEntity oPeriodoEntityFromDatabase = oPeriodoRepository.findById(oPeriodoEntity.getId())
                .orElseThrow(() -> new RuntimeException("Periodo no encontrado"));

        // Actualizar campos solo si el valor nuevo no es nulo
        if (oPeriodoEntity.getAnyo() != 0) { // asumiendo que 'anyo' no puede ser 0 en la actualización
            oPeriodoEntityFromDatabase.setAnyo(oPeriodoEntity.getAnyo());
        }
        if (oPeriodoEntity.getDescripcion() != null) {
            oPeriodoEntityFromDatabase.setDescripcion(oPeriodoEntity.getDescripcion());
        }
        if (oPeriodoEntity.getComentarios() != null) {
            oPeriodoEntityFromDatabase.setComentarios(oPeriodoEntity.getComentarios());
        }
        oPeriodoEntityFromDatabase.setCerrado(oPeriodoEntity.isCerrado()); // actualizar siempre ya que es boolean

        return oPeriodoRepository.save(oPeriodoEntityFromDatabase);
    }

    public Long deleteAll() {
        oPeriodoRepository.deleteAll();
        return this.count();
    }

    public PeriodoEntity randomSelection() {
        return oPeriodoRepository.findAll().get(oRandomService.getRandomInt(0, (int) (oPeriodoRepository.count() - 1)));
    }

}
