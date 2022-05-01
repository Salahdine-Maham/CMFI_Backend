package org.sd.cmfi.cmfi_backend;

import org.sd.cmfi.cmfi_backend.dao.StagiaireRepository;
import org.sd.cmfi.cmfi_backend.entities.stagiaires.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CmfiBackendApplication implements CommandLineRunner {

    @Autowired
    private StagiaireRepository stagiareRepository ;

    public static void main(String[] args) {
        SpringApplication.run(CmfiBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stagiareRepository.save(new Stagiaire(1,"salah","cne","112360","sd@gmail.com","41721042","socogime","bcs",12) );
        stagiareRepository.save(new Stagiaire(2,"houda","cne","112360","sd@gmail.com","41721042","socogime","bcs",12) );
        stagiareRepository.save(new Stagiaire(3,"sehle","cne","112360","sd@gmail.com","41721042","socogime","bcs",12) );

        stagiareRepository.findAll().forEach(stagiaire -> {
            System.out.println(stagiaire.toString());
        });
    }
}
