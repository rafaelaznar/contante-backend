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

import net.ausiasmarch.contante.entity.GrupoTipoApunteEntity;
import net.ausiasmarch.contante.service.GrupoTipoApunteService;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/grupotipoapunte")
public class GrupoTipoApunte {

   @Autowired
   GrupoTipoApunteService oGrupoTipoApunteService;

    @GetMapping("")
    public ResponseEntity<Page<GrupoTipoApunteEntity>> getPage(
            Pageable oPageable,
            @RequestParam  Optional<String> filter) {
        return new ResponseEntity<Page<GrupoTipoApunteEntity>>(oGrupoTipoApunteService.getPage(oPageable, filter), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoTipoApunteEntity> getGrupoTipoApunte(@PathVariable Long id) {
        return new ResponseEntity<GrupoTipoApunteEntity>(oGrupoTipoApunteService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oGrupoTipoApunteService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<Long>(oGrupoTipoApunteService.delete(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<GrupoTipoApunteEntity> create(@RequestBody GrupoTipoApunteEntity oGrupoTipoApunteEntity) {
        return new ResponseEntity<GrupoTipoApunteEntity>(oGrupoTipoApunteService.create(oGrupoTipoApunteEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GrupoTipoApunteEntity> update(@RequestBody GrupoTipoApunteEntity oGrupoTipoApunteEntity) {
        return new ResponseEntity<GrupoTipoApunteEntity>(oGrupoTipoApunteService.update(oGrupoTipoApunteEntity), HttpStatus.OK);
    }

    @PutMapping("/random/{cantidad}")
    public ResponseEntity<Long> create(@PathVariable Long cantidad) {
        return new ResponseEntity<Long>(oGrupoTipoApunteService.randomCreate(cantidad), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Long> deleteAll() {
        return new ResponseEntity<Long>(oGrupoTipoApunteService.deleteAll(), HttpStatus.OK);
    }

}
