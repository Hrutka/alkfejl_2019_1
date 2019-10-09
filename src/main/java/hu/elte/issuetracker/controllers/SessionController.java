package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Session;
import hu.elte.issuetracker.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Session>> getAll() {
        return ResponseEntity.ok(sessionRepository.findAll());
    }

    //TODO: GET by id, DELETE, POST, PUT
}
