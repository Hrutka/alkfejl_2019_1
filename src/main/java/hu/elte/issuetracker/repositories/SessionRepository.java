package hu.elte.issuetracker.repositories;

import hu.elte.issuetracker.entities.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer> {
}
