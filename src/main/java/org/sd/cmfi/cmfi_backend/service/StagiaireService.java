package org.sd.cmfi.cmfi_backend.service;

import org.sd.cmfi.cmfi_backend.dao.StagiaireRepository;
import org.sd.cmfi.cmfi_backend.entities.stagiaires.Stagiaire;
import org.sd.cmfi.cmfi_backend.entities.stagiaires.StagiaireNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class StagiaireService {


    private final  StagiaireRepository stagiaireRepository ;


    public StagiaireService(StagiaireRepository stagiaireRepository) {
        this.stagiaireRepository = stagiaireRepository;

    }


    // this methode is to get the liste of Stagiaire all of them
    @GetMapping(path = "/stagiaires")
    public List<Stagiaire> listeStagiaire() {
       return stagiaireRepository.findAll();
    }

    // this methode to find one stagiaire by his id
    @GetMapping(path = "stagiaire/{id}")
    public Optional<Stagiaire> findStagiaireById(@PathVariable(value="id") long id ){
     Optional<Stagiaire> s = stagiaireRepository.findById(id);

     // we make a verification on the user if it's founded or not
      if(s.isEmpty())
          throw new StagiaireNotFoundExeption("Not found  id :"+ id);

        return s;

    }

    @PutMapping(path = "stagiaire/{id}")
    public ResponseEntity<?> updateStagiaire( @RequestBody Stagiaire stagiaireDetail , @PathVariable(value= "id") Long id){
        Optional<Stagiaire> stagiaire = stagiaireRepository.findById(id) ;
        if ( !stagiaire.isPresent()){
            return  ResponseEntity.notFound().build();
        }
        stagiaire.get().setAdresse(stagiaireDetail.getAdresse());
        stagiaire.get().setEmail(stagiaireDetail.getEmail());
        stagiaire.get().setGrade(stagiaireDetail.getGrade());
        stagiaire.get().setMatricule(stagiaireDetail.getMatricule());
        stagiaire.get().setNom(stagiaireDetail.getNom());
        stagiaire.get().setUnite(stagiaireDetail.getUnite());

        return ResponseEntity.status(HttpStatus.CREATED).body(stagiaireRepository.save(stagiaire.get()));
    }




    @PostMapping(path= "/stagiaire")
    public ResponseEntity<Object> createStagiaire(@RequestBody Stagiaire stagiaire){
       Stagiaire newStagiaire = stagiaireRepository.save(stagiaire);


       // this variable location is the URI to the new Stagiaire created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newStagiaire.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
