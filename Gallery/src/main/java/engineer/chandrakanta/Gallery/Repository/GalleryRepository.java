package engineer.chandrakanta.Gallery.Repository;

import engineer.chandrakanta.Gallery.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
