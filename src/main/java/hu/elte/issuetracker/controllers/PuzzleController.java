package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Puzzle;
import hu.elte.issuetracker.entities.Session;
import hu.elte.issuetracker.repositories.PuzzleRepository;
import hu.elte.issuetracker.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.Optional;

@RestController
@RequestMapping("puzzles")
public class PuzzleController {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Puzzle>> getAll() {
        return ResponseEntity.ok(puzzleRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puzzle> get(@PathVariable Integer id) {
        Optional<Puzzle> puzzle = puzzleRepository.findById(id);
        if (!puzzle.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(puzzle.get());
    }

    @PostMapping("")
    public ResponseEntity<Puzzle> post(@RequestBody Puzzle puzzle) {
        Optional<Puzzle> puzzleWithName = puzzleRepository.findByName(puzzle.getName());
        if(puzzleWithName.isPresent()){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        Puzzle newPuzzle = puzzleRepository.save(puzzle);
        return ResponseEntity.ok(newPuzzle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Puzzle> puzzle = puzzleRepository.findById(id);
        if (!puzzle.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        puzzleRepository.delete(puzzle.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puzzle> put(@PathVariable Integer id, @RequestBody Puzzle puzzle) {
        // TODO ha PUT-al probalsz meg adatoakt duplikalni akkor kapsz egy 500-ast
        Optional<Puzzle> oldPuzzle = puzzleRepository.findById(id);
        if (!oldPuzzle.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        puzzle.setId(id);
        return ResponseEntity.ok(puzzleRepository.save(puzzle));
    }

    @GetMapping("/{id}/sessions")
    public ResponseEntity getSessions(@PathVariable Integer id) {
        Optional<Puzzle> oPuzzle = puzzleRepository.findById(id);
        if (oPuzzle.isPresent()) {
            return ResponseEntity.ok(oPuzzle.get().getSessions());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{puzzleId}/sessions/{sessionId}")
    public ResponseEntity insertSolve(@PathVariable Integer puzzleId, @PathVariable Integer sessionId) {
        Optional<Puzzle> oPuzzle = puzzleRepository.findById(puzzleId);
        Optional<Session> oSession = sessionRepository.findById(sessionId);
        if (oPuzzle.isPresent() && oSession.isPresent()) {
            Puzzle puzzle = oPuzzle.get();
            Session session = oSession.get();
            session.setPuzzle(puzzle);
            return ResponseEntity.ok(sessionRepository.save(session));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
