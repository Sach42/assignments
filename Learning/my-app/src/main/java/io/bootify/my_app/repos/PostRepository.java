package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Post;
import io.bootify.my_app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

    Post findFirstByPostowner(User user);

}
