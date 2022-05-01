package org.sd.cmfi.cmfi_backend.entities;

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
@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class Session implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String code_ses;
    private String lib_ses;
    private String matricule_sta;
}
