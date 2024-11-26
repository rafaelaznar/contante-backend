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
import net.ausiasmarch.contante.entity.GrupotipoasientoEntity;
import net.ausiasmarch.contante.service.GrupotipoasientoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/grupotipoasiento")
public class Grupotipoasiento {

    @Autowired
    GrupotipoasientoService oGrupoTipoasientoService;

    @GetMapping("")
    public ResponseEntity<Page<GrupotipoasientoEntity>> getPage(
            Pageable oPageable,
            @RequestParam Optional<String> filter) {
        return new ResponseEntity<Page<GrupotipoasientoEntity>>(oGrupoTipoasientoService.getPage(oPageable, filter),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupotipoasientoEntity> getGrupoTipoAsiento(@PathVariable Long id) {
        return new ResponseEntity<GrupotipoasientoEntity>(oGrupoTipoasientoService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oGrupoTipoasientoService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<Long>(oGrupoTipoasientoService.delete(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<GrupotipoasientoEntity> create(@RequestBody GrupotipoasientoEntity oGrupoTipoAsientoEntity) {
        return new ResponseEntity<GrupotipoasientoEntity>(oGrupoTipoasientoService.create(oGrupoTipoAsientoEntity),
                HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GrupotipoasientoEntity> update(@RequestBody GrupotipoasientoEntity oGrupoTipoAsientoEntity) {
        return new ResponseEntity<GrupotipoasientoEntity>(oGrupoTipoasientoService.update(oGrupoTipoAsientoEntity),
                HttpStatus.OK);
    }

    @PutMapping("/random/{cantidad}")
    public ResponseEntity<Long> create(@PathVariable Long cantidad) {
        return new ResponseEntity<Long>(oGrupoTipoasientoService.randomCreate(cantidad), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Long> deleteAll() {
        return new ResponseEntity<Long>(oGrupoTipoasientoService.deleteAll(), HttpStatus.OK);
    }

}
