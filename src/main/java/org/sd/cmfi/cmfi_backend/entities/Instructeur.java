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
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Instructeur implements Serializable  {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id ;
     private String matricule ;
     private String nom ;
     private String grade ;
     private String email ;
     private String telephone ;
     private String unite ;
     private int id_abs ;
}
