package net.ausiasmarch.contante.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.ausiasmarch.contante.entity.GrupoTipoAsientoEntity;
import net.ausiasmarch.contante.service.GrupoTipoAsientoService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/grupotipoasiento")
public class GrupoTipoasiento {

    @Autowired
    GrupoTipoAsientoService oGrupoTipoAsientoService;
 @GetMapping("")
        public ResponseEntity<Page<GrupoTipoAsientoEntity>> getPage(
                Pageable oPageable,
                @RequestParam  Optional<String> filter) {
            return new ResponseEntity<Page<GrupoTipoAsientoEntity>>(oGrupoTipoAsientoService.getPage(oPageable, filter), HttpStatus.OK);
        }

 @GetMapping("/{id}")
        public ResponseEntity<GrupoTipoAsientoEntity> getGrupoTipoAsiento(@PathVariable Long id) {
            return new ResponseEntity<GrupoTipoAsientoEntity>(oGrupoTipoAsientoService.get(id), HttpStatus.OK);
        }

 @GetMapping("/count")
        public ResponseEntity<Long> count() {
            return new ResponseEntity<Long>(oGrupoTipoAsientoService.count(), HttpStatus.OK);
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<Long> delete(@PathVariable Long id) {
            return new ResponseEntity<Long>(oGrupoTipoAsientoService.delete(id), HttpStatus.OK);
        }
    
        @PutMapping("")
        public ResponseEntity<GrupoTipoAsientoEntity> create(@RequestBody GrupoTipoAsientoEntity oGrupoTipoAsientoEntity) {
            return new ResponseEntity<GrupoTipoAsientoEntity>(oGrupoTipoAsientoService.create(oGrupoTipoAsientoEntity), HttpStatus.OK);
        }
    
        @PostMapping("")
        public ResponseEntity<GrupoTipoAsientoEntity> update(@RequestBody GrupoTipoAsientoEntity oGrupoTipoAsientoEntity) {
            return new ResponseEntity<GrupoTipoAsientoEntity>(oGrupoTipoAsientoService.update(oGrupoTipoAsientoEntity), HttpStatus.OK);
        }
    
    
        @PutMapping("/random/{cantidad}")
        public ResponseEntity<Long> create(@PathVariable Long cantidad) {
            return new ResponseEntity<Long>(oGrupoTipoAsientoService.randomCreate(cantidad), HttpStatus.OK);
        }
        @DeleteMapping("/all")
        public ResponseEntity<Long> deleteAll() {
            return new ResponseEntity<Long>(oGrupoTipoAsientoService.deleteAll(), HttpStatus.OK);
        }


    
    
}
