package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.WomenWearRepository;
import engineer.chandrakanta.Gallery.Service.WomenWearService;
import engineer.chandrakanta.Gallery.entity.Gallery;
import engineer.chandrakanta.Gallery.entity.WomenWear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GalleryController {
   @Autowired
    WomenWearService womenWearService;
   @Autowired
    WomenWearRepository womenWearRepository;



    @GetMapping("/women")
    public  String womenWear(Model model){
        List<WomenWear> womenWears= womenWearService.showDetails();
//        List<Gallery> galleries= galleryService.showsGallery();
        return  "women";
    }
}
