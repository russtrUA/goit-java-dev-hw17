package ua.goit.hw17security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.hw17security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
