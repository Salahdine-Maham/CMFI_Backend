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
import java.util.Date;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Seance implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private  String code_sea;
    private String lib_sea;
    private Date date_sea;
    private String code_mat;
    private String code_sal;
    private String code_emp;

}
