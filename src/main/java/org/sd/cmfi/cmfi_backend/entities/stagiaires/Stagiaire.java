package org.sd.cmfi.cmfi_backend.entities.stagiaires;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sd.cmfi.cmfi_backend.entities.Session;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;


}
