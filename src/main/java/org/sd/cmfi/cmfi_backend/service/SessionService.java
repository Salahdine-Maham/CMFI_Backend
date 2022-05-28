package org.sd.cmfi.cmfi_backend.service;

import org.sd.cmfi.cmfi_backend.dao.SessionRepository;
import org.sd.cmfi.cmfi_backend.entities.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/session")
public class SessionService {

    private final SessionRepository sessionRepository ;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    // Create a new Session
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Session session){
        return ResponseEntity.ok().body(sessionRepository.save(session));
    }
//.status(HttpStatus.CREATED)
//

    // Find a Session by Id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable (value = "id") Long id){
        Optional<Session> session = sessionRepository.findById(id);

        if(!session.isPresent()){
            return ResponseEntity.notFound().build();
        }
            return  ResponseEntity.ok(session);

    }




    // update a session
    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@RequestBody Session sessionDetail , @PathVariable(value = "id") Long id){

        Optional<Session> session = sessionRepository.findById(id);

        if( !session.isPresent()){
            return ResponseEntity.notFound().build();
        }

        session.get().setCode_ses(sessionDetail.getCode_ses());
        session.get().setLib_ses(sessionDetail.getLib_ses());
        session.get().setDate_debut(sessionDetail.getDate_debut());
        session.get().setDate_fin(sessionDetail.getDate_fin());

      return ResponseEntity.status(HttpStatus.CREATED).body(sessionRepository.save(session.get()));
    }

// delete a session
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable (value = "id") Long id){

        if( !sessionRepository.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        sessionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // read all sessions
    @GetMapping("/all")
    public ResponseEntity<List<Session>> readAll(){
        return  ResponseEntity.ok().body(sessionRepository.findAll());

    }

}


