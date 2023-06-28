package com.omkar.Usermanagement.Repository;

import com.omkar.Usermanagement.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

