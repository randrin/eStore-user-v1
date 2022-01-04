package com.eStore.bear.user.repository;

import com.eStore.bear.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    Optional<User> findByMobile(String mobile);
}
