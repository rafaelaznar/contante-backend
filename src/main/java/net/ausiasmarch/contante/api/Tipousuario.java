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

import net.ausiasmarch.contante.entity.TipousuarioEntity;
import net.ausiasmarch.contante.service.TipousuarioService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tipousuario")
public class Tipousuario {

    @Autowired
    TipousuarioService oTipousuarioService;

    @GetMapping("")
    public ResponseEntity<Page<TipousuarioEntity>> getPage(
            Pageable oPageable,
            @RequestParam  Optional<String> filter) {
        return new ResponseEntity<Page<TipousuarioEntity>>(oTipousuarioService.getPage(oPageable, filter), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipousuarioEntity> getTipousuario(@PathVariable Long id) {
        return new ResponseEntity<TipousuarioEntity>(oTipousuarioService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oTipousuarioService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<Long>(oTipousuarioService.delete(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<TipousuarioEntity> create(@RequestBody TipousuarioEntity oTipousuarioEntity) {
        return new ResponseEntity<TipousuarioEntity>(oTipousuarioService.create(oTipousuarioEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TipousuarioEntity> update(@RequestBody TipousuarioEntity oTipousuarioEntity) {
        return new ResponseEntity<TipousuarioEntity>(oTipousuarioService.update(oTipousuarioEntity), HttpStatus.OK);
    }

    @PutMapping("/random/{cantidad}")
    public ResponseEntity<Long> create(@PathVariable Long cantidad) {
        return new ResponseEntity<Long>(oTipousuarioService.randomCreate(cantidad), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Long> deleteAll() {
        return new ResponseEntity<Long>(oTipousuarioService.deleteAll(), HttpStatus.OK);
    }

}