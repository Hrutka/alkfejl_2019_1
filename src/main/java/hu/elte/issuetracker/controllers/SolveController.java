package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Puzzle;
import hu.elte.issuetracker.entities.Solve;
import hu.elte.issuetracker.repositories.SolveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("solves")
public class SolveController {

    @Autowired
    private SolveRepository solveRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Solve>> getAll() {
        return ResponseEntity.ok(solveRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solve> get(@PathVariable Integer id) {
        Optional<Solve> solve = solveRepository.findById(id);
        if (!solve.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(solve.get());
    }

    // TODO Ezt hogyan kell ellenőrizni? Hogy adjak be neki Sessiont?
    @PostMapping("")
    public ResponseEntity<Solve> post(@RequestBody Solve solve) {
        Solve newSolve = solveRepository.save(solve);
        return ResponseEntity.ok(newSolve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Solve> solve = solveRepository.findById(id);
        if (!solve.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        solveRepository.delete(solve.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solve> put(@PathVariable Integer id, @RequestBody Solve solve) {
        Optional<Solve> oldSolve = solveRepository.findById(id);
        if (!oldSolve.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        solve.setId(id);
        return ResponseEntity.ok(solveRepository.save(solve));
    }
}
