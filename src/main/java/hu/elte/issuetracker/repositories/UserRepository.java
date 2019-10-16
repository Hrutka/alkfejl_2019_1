package hu.elte.issuetracker.repositories;

import hu.elte.issuetracker.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
