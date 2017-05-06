package roomate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import roomate.model.Profile;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String> {

    Optional<Profile> findFirstByFirstNameAndLastNameAndAge(String firstName, String lastName, Integer age);

}
