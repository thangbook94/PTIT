package ptit.hdv.nhom8.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptit.hdv.nhom8.server.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
}
