package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.GalleryRepository;
import engineer.chandrakanta.Gallery.entity.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;
    public Gallery createGallery(Gallery gallery){
        return  galleryRepository.save(gallery);
    }

    public List<Gallery> showsGallery() {
        return galleryRepository.findAll();
    }

    public Gallery getById(Long id) {
        return  galleryRepository.getById(id);
    }
}
