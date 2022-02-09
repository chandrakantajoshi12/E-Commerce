package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.GalleryRepository;
import engineer.chandrakanta.Gallery.Repository.WomenWearRepository;
import engineer.chandrakanta.Gallery.Service.GalleryService;
import engineer.chandrakanta.Gallery.Service.WomenWearService;
import engineer.chandrakanta.Gallery.entity.Gallery;
import engineer.chandrakanta.Gallery.entity.MenWear;
import engineer.chandrakanta.Gallery.entity.WomenWear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class GalleryController {
   @Autowired
    WomenWearService womenWearService;
   @Autowired
    WomenWearRepository womenWearRepository;
   @Autowired
    GalleryService galleryService;
   @Autowired
    GalleryRepository galleryRepository;


    @GetMapping("/women")
    public  String women(Model model){
        List<WomenWear> womenWears= womenWearService.showDetails();
        model.addAttribute("womenWears",womenWears);
        return  "women";
    }

    @GetMapping("/gallery")
    public String men(Model model){
        List<Gallery> galleries =galleryService.showsGallery();
        model.addAttribute("galleries",galleries);
        return "gallery";
    }
//    @GetMapping("/gallery")
//    public  String
}
