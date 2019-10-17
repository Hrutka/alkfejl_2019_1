package hu.elte.issuetracker.repositories;

import hu.elte.issuetracker.entities.Solve;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SolveRepository  extends CrudRepository<Solve, Integer> {
}