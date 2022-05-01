package org.sd.cmfi.cmfi_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity@Data@AllArgsConstructor@NoArgsConstructor
public class Obtien implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long note ;
    private String matricule_sta;
    private String code_mat ;
    private String type_not;
}
