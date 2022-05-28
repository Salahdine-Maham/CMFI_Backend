package org.sd.cmfi.cmfi_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sd.cmfi.cmfi_backend.entities.stagiaires.Stagiaire;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class Session implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String code_ses;
    private String lib_ses;
    private Date date_debut;
    private Date date_fin;



}
