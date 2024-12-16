package net.ausiasmarch.contante.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import net.ausiasmarch.contante.entity.GrupotipoapunteEntity;

public interface GrupotipoapunteRepository extends JpaRepository<GrupotipoapunteEntity, Long> {


     @Modifying
     @Transactional
     @Query(value = "DELETE FROM grupotipoapunte g WHERE g.id_tipoapunte = :idTipoApunte AND g.id_balance = :idBalance", nativeQuery = true)
     void deleteRelation(Long idTipoApunte, Long idBalance);

}
