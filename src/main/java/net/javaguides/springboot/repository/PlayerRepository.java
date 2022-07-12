package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.PlayerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PlayerDetails, Long> {
    // all crud database methods
}


