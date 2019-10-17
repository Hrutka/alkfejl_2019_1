package hu.elte.issuetracker.repositories;

import hu.elte.issuetracker.entities.Puzzle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PuzzleRepository extends CrudRepository<Puzzle, Integer> {
    Optional<Puzzle> findByName(String name);
}
