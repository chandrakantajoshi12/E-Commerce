package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.Dress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DressRepository extends JpaRepository<Dress, Long> {
    public List<Dress> findByDressType(String dressType);
}
