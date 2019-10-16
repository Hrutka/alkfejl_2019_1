package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Session;
import hu.elte.issuetracker.entities.Solve;
import hu.elte.issuetracker.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Session>> getAll() {
        return ResponseEntity.ok(sessionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> get(@PathVariable Integer id) {
        Optional<Session> session = sessionRepository.findById(id);
        if (!session.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(session.get());
    }


    // TODO Ezt hogyan kell ellenőrizni? Hogy adjak be neki Solveokat??
    @PostMapping("")
    public ResponseEntity<Session> post(@RequestBody Session session) {
        Session newSession  = sessionRepository.save(session);
        return ResponseEntity.ok(newSession);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Session> session = sessionRepository.findById(id);
        if (!session.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        sessionRepository.delete(session.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> put(@PathVariable Integer id, @RequestBody Session session) {
        Optional<Session> oldSession = sessionRepository.findById(id);
        if (!oldSession.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        session.setId(id);
        return ResponseEntity.ok(sessionRepository.save(session));
    }

}
