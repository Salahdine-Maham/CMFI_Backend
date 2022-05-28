package org.sd.cmfi.cmfi_backend.dao;

import org.sd.cmfi.cmfi_backend.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
