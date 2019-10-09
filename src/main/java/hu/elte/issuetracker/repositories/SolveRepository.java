package hu.elte.issuetracker.repositories;

import hu.elte.issuetracker.entities.Solve;
import org.springframework.data.repository.CrudRepository;

public interface SolveRepository  extends CrudRepository<Solve, Integer> {

}
