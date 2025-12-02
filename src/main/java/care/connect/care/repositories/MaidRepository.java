package care.connect.care.repositories;


import care.connect.care.models.Maid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaidRepository extends JpaRepository<Maid, String> { }

