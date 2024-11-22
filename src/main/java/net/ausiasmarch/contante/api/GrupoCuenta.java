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

import net.ausiasmarch.contante.entity.GrupoCuentaEntity;
import net.ausiasmarch.contante.service.GrupoCuentaService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/grupocuenta")
public class GrupoCuenta {

    @Autowired
    GrupoCuentaService oGrupoCuentaService;

    @GetMapping("")
    public ResponseEntity<Page<GrupoCuentaEntity>> getPage(
            Pageable oPageable,
            @RequestParam Optional<String> filter) {
        return new ResponseEntity<Page<GrupoCuentaEntity>>(oGrupoCuentaService.getPage(oPageable, filter),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoCuentaEntity> getGrupoCuenta(@PathVariable Long id) {
        return new ResponseEntity<GrupoCuentaEntity>(oGrupoCuentaService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oGrupoCuentaService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<Long>(oGrupoCuentaService.delete(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<GrupoCuentaEntity> create(@RequestBody GrupoCuentaEntity oGrupoCuentaEntity) {
        return new ResponseEntity<GrupoCuentaEntity>(oGrupoCuentaService.create(oGrupoCuentaEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GrupoCuentaEntity> update(@RequestBody GrupoCuentaEntity oGrupoCuentaEntity) {
        return new ResponseEntity<GrupoCuentaEntity>(oGrupoCuentaService.update(oGrupoCuentaEntity), HttpStatus.OK);
    }

    @PutMapping("/random/{cantidad}")
    public ResponseEntity<Long> create(@PathVariable Long cantidad) {
        return new ResponseEntity<Long>(oGrupoCuentaService.randomCreate(cantidad), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Long> deleteAll() {
        return new ResponseEntity<Long>(oGrupoCuentaService.deleteAll(), HttpStatus.OK);
    }

}
