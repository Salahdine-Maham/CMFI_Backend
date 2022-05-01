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


@Entity@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Type_note implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String lib_not;
}
