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

import net.ausiasmarch.contante.entity.GruposubcuentaEntity;
import net.ausiasmarch.contante.service.GruposubcuentaService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/gruposubcuenta")
public class Gruposubcuenta {
    
    @Autowired
    GruposubcuentaService oGrupoSubCuentaService;

    @GetMapping("")
    public ResponseEntity<Page<GruposubcuentaEntity>> getPage(
            Pageable oPageable,
            @RequestParam  Optional<String> filter) {
        return new ResponseEntity<Page<GruposubcuentaEntity>>(oGrupoSubCuentaService.getPage(oPageable, filter), HttpStatus.OK);
    }

     @GetMapping("/{id}")
    public ResponseEntity<GruposubcuentaEntity> getTipousuario(@PathVariable Long id) {
        return new ResponseEntity<GruposubcuentaEntity>(oGrupoSubCuentaService.get(id), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<Long>(oGrupoSubCuentaService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return new ResponseEntity<Long>(oGrupoSubCuentaService.delete(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<GruposubcuentaEntity> create(@RequestBody GruposubcuentaEntity oTipousuarioEntity) {
        return new ResponseEntity<GruposubcuentaEntity>(oGrupoSubCuentaService.create(oTipousuarioEntity), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GruposubcuentaEntity> update(@RequestBody GruposubcuentaEntity oTipousuarioEntity) {
        return new ResponseEntity<GruposubcuentaEntity>(oGrupoSubCuentaService.update(oTipousuarioEntity), HttpStatus.OK);
    }

    @PutMapping("/random/{cantidad}")
    public ResponseEntity<Long> create(@PathVariable Long cantidad) {
        return new ResponseEntity<Long>(oGrupoSubCuentaService.randomCreate(cantidad), HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Long> deleteAll() {
        return new ResponseEntity<Long>(oGrupoSubCuentaService.deleteAll(), HttpStatus.OK);
    }

}
