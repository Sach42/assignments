package io.bootify.testing.repos;

import io.bootify.testing.domain.Post;
import io.bootify.testing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

    Post findFirstByUser(User user);

}
