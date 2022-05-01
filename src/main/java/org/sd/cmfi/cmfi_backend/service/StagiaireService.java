package org.sd.cmfi.cmfi_backend.service;

import org.sd.cmfi.cmfi_backend.dao.StagiaireRepository;
import org.sd.cmfi.cmfi_backend.entities.stagiaires.Stagiaire;
import org.sd.cmfi.cmfi_backend.entities.stagiaires.StagiaireNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StagiaireService {

    @Autowired
    private StagiaireRepository stagiaireRepository ;


    // this methode is to gett the liste of Stagiaire all of them
    @GetMapping(path = "/stagiaires")
    public List<Stagiaire> listeStagiaire() {
       return stagiaireRepository.findAll();
    }

    // this methode to find one stagiaire by his id
    @GetMapping(path = "stagiaire/{id}")
    public Optional<Stagiaire> findStagiaireById(@PathVariable long id ){
     Optional<Stagiaire> s = stagiaireRepository.findById(id);

     // we make a verification on the user if it's founded or not
      if(s.isEmpty())
          throw new StagiaireNotFoundExeption("Not found  id :"+ id);

        return s;

    }




    @PostMapping(path= "/stagiaire")
    public ResponseEntity<Object> createStagiaire(@RequestBody Stagiaire stagiaire){
       Stagiaire newStagiaire = stagiaireRepository.save(stagiaire);


       // this variable location is the URI to the new Stagiaire created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newStagiaire.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
