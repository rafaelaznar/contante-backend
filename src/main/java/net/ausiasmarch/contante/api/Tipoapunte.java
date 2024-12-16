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

import net.ausiasmarch.contante.entity.TipoapunteEntity;
import net.ausiasmarch.contante.service.TipoapunteService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/tipoapunte")
public class Tipoapunte {
    @Autowired
    TipoapunteService oTipoApunteService;

    @GetMapping("")
    public ResponseEntity<Page<TipoapunteEntity>> getPage(
            Pageable oPageable,
            @RequestParam Optional<String> filter) {
        return new ResponseEntity<Page<TipoapunteEntity>>(oTipoApunteService.getPage(oPageable, filter), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoapunteEntity> getTipoApunte(@PathVariable Long id) {
        return new ResponseEntity<TipoapunteEntity>(oTipoApunteService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oTipoApunteService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<Long>(oTipoApunteService.delete(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<TipoapunteEntity> create(@RequestBody TipoapunteEntity oTipoApunteEntity) {
        return new ResponseEntity<TipoapunteEntity>(oTipoApunteService.create(oTipoApunteEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TipoapunteEntity> update(@RequestBody TipoapunteEntity oTipoApunteEntity) {
        return new ResponseEntity<TipoapunteEntity>(oTipoApunteService.update(oTipoApunteEntity), HttpStatus.OK);
    }

    @PutMapping("/random/{cantidad}")
    public ResponseEntity<Long> create(@PathVariable Long cantidad) {
        return new ResponseEntity<Long>(oTipoApunteService.randomCreate(cantidad), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Long> deleteAll() {
        return new ResponseEntity<Long>(oTipoApunteService.deleteAll(), HttpStatus.OK);
    }

    @GetMapping("/xbalance/{idBalance}")
    public ResponseEntity<Page<TipoapunteEntity>>getXBalance(@PathVariable Long idBalance, Pageable oPageable) {
        return new ResponseEntity<Page<TipoapunteEntity>>(oTipoApunteService.getXBalance(idBalance, oPageable), HttpStatus.OK);
    }

    @GetMapping("/restxbalance/{idBalance}")
    public ResponseEntity<Page<TipoapunteEntity>>getRestXBalance(@PathVariable Long idBalance, Pageable oPageable) {
        return new ResponseEntity<Page<TipoapunteEntity>>(oTipoApunteService.getRestXBalance(idBalance, oPageable), HttpStatus.OK);
    }

}
