package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Puzzle;
import hu.elte.issuetracker.repositories.PuzzleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("puzzles")
public class PuzzleController {

    @Autowired
    private PuzzleRepository puzzleRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Puzzle>> getAll() {
        return ResponseEntity.ok(puzzleRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puzzle> get(@PathVariable Integer id) {
        Optional<Puzzle> puzzle = puzzleRepository.findById(id);
        if (!puzzle.isPresent())
        {
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(puzzle.get());
    }

    @PostMapping("")
    public ResponseEntity<Puzzle> post(@RequestBody Puzzle puzzle) {
        //TODO: do not insert if name already exists
        Puzzle newPuzzle = puzzleRepository.save(puzzle);
        return ResponseEntity.ok(newPuzzle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Puzzle> puzzle = puzzleRepository.findById(id);
        if (!puzzle.isPresent())
        {
            ResponseEntity.notFound();
        }

        puzzleRepository.delete(puzzle.get());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puzzle> put(@PathVariable Integer id, @RequestBody Puzzle foo) {
        Optional<Puzzle> oldPuzzle = puzzleRepository.findById(id);
        if (!oldPuzzle.isPresent())
        {
            ResponseEntity.notFound();
        }

        foo.setId(id);
        return ResponseEntity.ok(puzzleRepository.save(foo));
    }
}
