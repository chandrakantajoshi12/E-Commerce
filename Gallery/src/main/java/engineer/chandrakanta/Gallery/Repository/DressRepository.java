package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.Dress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DressRepository extends JpaRepository<Dress, Long> {
}
