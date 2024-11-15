package net.ausiasmarch.contante.service;

import java.math.BigDecimal;
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
    private PeriodoRepository oPeriodoRepository;

    @Autowired
    private RandomService oRandomService;

    private int[] anyos = {
        2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027, 2028, 2029,
        2030, 2031, 2032, 2033, 2034, 2035, 2036, 2037, 2038, 2039
    };
    
    private String[] descripciones = {
        "Evento A", "Reunión de trabajo", "Conferencia de ciencia", "Curso de programación", "Taller de diseño",
        "Estudio de mercado", "Revisión de proyecto", "Exposición de arte", "Viaje de negocios", "Seminario de marketing",
        "Reunión con clientes", "Charla de emprendimiento", "Evaluación de desempeño", "Jornada de innovación", "Investigación académica",
        "Torneo deportivo", "Concurso de startups", "Análisis financiero", "Revisión técnica", "Evento cultural"
    };
    
    private String[] comentarios = {
        "Muy interesante y productivo.", "La reunión fue excelente.", "Gran oportunidad de aprender.", "Buen curso, pero se puede mejorar.", "El taller fue muy interactivo.",
        "Buena presentación, pero falta claridad.", "El evento estuvo bien organizado.", "Excelente exposición, pero faltó tiempo.", "Gran ambiente, pero podría ser más largo.", "Mejorar la logística del seminario.",
        "Satisfactorio, pero se podría profundizar más.", "Interesante pero largo.", "Buen balance entre teoría y práctica.", "Excelente organización y speakers.", "Muy enriquecedor.",
        "La jornada fue divertida, pero cansada.", "El concurso fue muy competitivo.", "Interesante pero muy técnico.", "Se pudo mejorar la dinámica.", "Muy buena experiencia, pero hay que ajustar tiempos."
    };
    
    private boolean[] cerrados = {
        true, false, true, false, true, true, false, false, true, false,
        true, false, true, true, false, false, true, false, true, false
    };
    



    public Long randomCreate(Long cantidad) {
        for (int i = 0; i < cantidad; i++) {
            PeriodoEntity oPeriodoEntity = new PeriodoEntity();
            oPeriodoEntity.setAnyo(anyos[oRandomService.getRandomInt(0, anyos.length - 1)]);
            oPeriodoEntity.setDescripcion(descripciones[oRandomService.getRandomInt(0, descripciones.length - 1)]);
            oPeriodoEntity.setComentarios(comentarios[oRandomService.getRandomInt(0, comentarios.length - 1)]);
            oPeriodoEntity.setCerrado(cerrados[oRandomService.getRandomInt(0, cerrados.length - 1)]);
            oPeriodoRepository.save(oPeriodoEntity);
        }
        return oPeriodoRepository.count();
    }

    public Page<PeriodoEntity> getPage(Pageable oPageable, Optional<String> filter) {
        if (filter.isPresent()) {
            return oPeriodoRepository.findByDescripcionContainingOrComentariosContaining(filter.get(), filter.get(), oPageable);
        } else {
            return oPeriodoRepository.findAll(oPageable);
        }
    }

    public PeriodoEntity get(Long id) {
        return oPeriodoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Periodo no encontrado"));
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
        PeriodoEntity oPeriodoEntityFromDatabase = oPeriodoRepository.findById(oPeriodoEntity.getId()).get();
        if (oPeriodoEntity.getAnyo() != 0) {
            oPeriodoEntityFromDatabase.setAnyo(oPeriodoEntity.getAnyo());
        }
        if (oPeriodoEntity.getDescripcion() != null) {
            oPeriodoEntityFromDatabase.setDescripcion(oPeriodoEntity.getDescripcion());
        }
        if (oPeriodoEntity.getComentarios() != null) {
            oPeriodoEntityFromDatabase.setComentarios(oPeriodoEntity.getComentarios());
        }
        return oPeriodoRepository.save(oPeriodoEntityFromDatabase);
    }

    public Long deleteAll() {
        oPeriodoRepository.deleteAll();
        return this.count();
    }
}
