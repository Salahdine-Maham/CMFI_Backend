package org.sd.cmfi.cmfi_backend.entities.stagiaires;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Stagiaire implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom ;
    private String grade ;
    private String matricule ;
    private String email ;
    private String telephone ;
    private String adresse ;
    private String unite ;
    private long id_abs ;


}
