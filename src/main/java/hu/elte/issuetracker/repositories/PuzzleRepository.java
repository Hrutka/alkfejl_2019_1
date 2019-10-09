package hu.elte.issuetracker.repositories;

import hu.elte.issuetracker.entities.Puzzle;
import org.springframework.data.repository.CrudRepository;

public interface PuzzleRepository extends CrudRepository<Puzzle, Integer> {
    Puzzle findByName(String name);
}
