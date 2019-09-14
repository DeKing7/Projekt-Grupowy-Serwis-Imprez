package pl.honestit.spring.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.honestit.spring.demo.model.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}