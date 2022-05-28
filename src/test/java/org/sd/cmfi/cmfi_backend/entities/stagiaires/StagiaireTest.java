package org.sd.cmfi.cmfi_backend.entities.stagiaires;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class StagiaireTest {



    private Stagiaire stagiaire;


 @BeforeEach
 public void  setUp() throws  Exception{
     stagiaire  = new Stagiaire();
 }
//    @Test
//    void getId()  throws Exception {
//      long idStagiaire = 4L;
//      stagiaire.;
//
//      assertEquals(idStagiaire,stagiaire.getId());
//
//    }

    @Test
    void getNom() throws  Exception {
     // given
     String name = "Salah";
     stagiaire.setNom(name);
    // When


//    Then
     assertEquals(name,stagiaire.getNom());
    }
//
//    @Test
//    void getGrade() throws  Exception{
//     String grade ="Cne";
//     stagiaire.setGrade(grade);
//     assertEquals(grade, stagiaire.getGrade());
//    }
}
