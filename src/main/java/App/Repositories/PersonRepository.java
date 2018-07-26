package App.Repositories;

import App.Entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
