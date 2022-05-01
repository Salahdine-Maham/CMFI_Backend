package org.sd.cmfi.cmfi_backend.entities.stagiaires;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;




@ResponseStatus(HttpStatus.NOT_FOUND)
public class StagiaireNotFoundExeption extends RuntimeException {



    public StagiaireNotFoundExeption(String  message) {
        super(message);

    }



}
