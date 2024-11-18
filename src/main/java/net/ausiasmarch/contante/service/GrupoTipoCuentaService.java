package net.ausiasmarch.contante.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.contante.entity.GrupoTipoCuentaEntity;
import net.ausiasmarch.contante.exception.ResourceNotFoundException;
import net.ausiasmarch.contante.repository.GrupoTipoCuentaRepository;
import net.ausiasmarch.contante.repository.TipoCuentaRepository;

@Service
public class GrupoTipoCuentaService implements ServiceInterface<GrupoTipoCuentaEntity> {

    @Autowired
    private GrupoTipoCuentaRepository oGrupoTipoCuentaRepository;

    /* 
    @Autowired
    private RandomService oRandomService;

    private String[] arrDescripcion = {
            "Compra de materiales", "Venta de producto", "Gasto de oficina", "Servicio prestado", "Compra de activos",
            "Ingreso por consultoría", "Compra de licencias", "Reembolso de gastos", "Publicidad en redes",
            "Venta de servicios",
            "Mantenimiento de equipo", "Cobro por formación", "Adquisición de suministros", "Ingresos de eventos",
            "Gastos de viaje", "Facturación de servicios", "Alquiler de oficina", "Ingreso por publicidad",
            "Servicios externos",
            "Venta de activos"
    };

    // Datos de la columna credito o debito entre 0 y 1
    private Long[] arrCreditoOdebito = {
            0L, 1L
    };

    // Datos de la columna real o nominal
    private Long[] arrRealOnominal = {
        0L, 1L
    };

    // Datos de la columna comentarios
    private String[] arrComentarios = {
            "Pago con transferencia", "Ingreso en efectivo", "Compra de papelería", "Cobro a cliente",
            "Equipo de computo",
            "Proyecto ABC", "Software anual", "Viaje de negocios", "Campaña en redes", "Contrato mensual",
            "Reparación de PC", "Curso de verano", "Compra de tinta", "Charla en empresa", "Hotel y transporte",
            "Soporte técnico", "Pago mensual", "Banner web", "Asesoría fiscal", "Mobiliario antiguo"
    };

*/

    public Long randomCreate(Long cantidad){
        return 1L;
    }
    

    public Page<GrupoTipoCuentaEntity> getPage(Pageable oPageable, Optional<String> filter) {
        if (filter.isPresent()) {
            return oGrupoTipoCuentaRepository
                    .findByTituloContainingOrDescripcionContainingOrOrdenContainingOrIdTipoCuentaContainingIdBalanceContaining(
                            filter.get(), filter.get(),filter.get(),filter.get(),filter.get(), oPageable);
        } else {
            return oGrupoTipoCuentaRepository.findAll(oPageable);
        }
    }

    public GrupoTipoCuentaEntity get(Long id) {
        return oGrupoTipoCuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apunte no encontrado"));
    }

    public Long count() {
        return oGrupoTipoCuentaRepository.count();
    }

    public Long delete(Long id) {
        oGrupoTipoCuentaRepository.deleteById(id);
        return 1L;
    }

    public GrupoTipoCuentaEntity create(GrupoTipoCuentaEntity oGrupoTipoCuentaEntity) {
        return oGrupoTipoCuentaRepository.save(oGrupoTipoCuentaEntity);
    }

    public GrupoTipoCuentaEntity update(GrupoTipoCuentaEntity oGrupoTipoCuentaEntity) {
        GrupoTipoCuentaEntity oGrupoTipoCuentaEntityFromDatabase = oGrupoTipoCuentaRepository.findById(oGrupoTipoCuentaEntity.getId()).get();
        if (oGrupoTipoCuentaEntity.getTitulo() != null) {
            oGrupoTipoCuentaEntityFromDatabase.setTitulo(oGrupoTipoCuentaEntity.getTitulo());
        }
        if (oGrupoTipoCuentaEntity.getDescripcion() != null) {
            oGrupoTipoCuentaEntityFromDatabase.setDescripcion(oGrupoTipoCuentaEntity.getDescripcion());
        }
        if (oGrupoTipoCuentaEntity.getOrden() != null) {
            oGrupoTipoCuentaEntityFromDatabase.setOrden(oGrupoTipoCuentaEntity.getOrden());
        }
        if (oGrupoTipoCuentaEntity.getIdTipoCuenta() != null) {
            oGrupoTipoCuentaEntityFromDatabase.setIdTipoCuenta(oGrupoTipoCuentaEntity.getIdTipoCuenta());
        }
        if (oGrupoTipoCuentaEntity.getIdBalance() != null) {
            oGrupoTipoCuentaEntityFromDatabase.setIdBalance(oGrupoTipoCuentaEntity.getIdBalance());
        }
        return oGrupoTipoCuentaRepository.save(oGrupoTipoCuentaEntityFromDatabase);
    }

    public Long deleteAll() {
        oGrupoTipoCuentaRepository.deleteAll();
        return this.count();
    }

}
