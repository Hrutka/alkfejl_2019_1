package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Solve;
import hu.elte.issuetracker.repositories.SolveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("solves")
public class SolveController {

    @Autowired
    private SolveRepository solveRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Solve>> getAll() {
        return ResponseEntity.ok(solveRepository.findAll());
    }

    //TODO: GET by id, DELETE, POST, PUT
}
