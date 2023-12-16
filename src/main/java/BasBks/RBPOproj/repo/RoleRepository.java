package BasBks.RBPOproj.repo;


import BasBks.RBPOproj.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
