package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.DressRepository;
import engineer.chandrakanta.Gallery.Repository.GalleryRepository;

import engineer.chandrakanta.Gallery.Service.DressService;
import engineer.chandrakanta.Gallery.Service.GalleryService;
import engineer.chandrakanta.Gallery.entity.Dress;
import engineer.chandrakanta.Gallery.entity.Gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class addContainController {
    @Autowired
    GalleryService galleryService;
    @Autowired
    GalleryRepository galleryRepository;
    @Autowired
    DressService dressService;
    @Autowired
    DressRepository dressRepository;

    @GetMapping("/addGallery")
    public String addGallery() {
        return "addGallery";
    }


    @GetMapping("/addContain")
    public String addContain() {
        return "addContain";
    }

    @PostMapping("/addContain")
    public String addContain(HttpServletRequest request, Model model) {
        Long id = Long.parseLong(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String dressName = request.getParameter("dressName");
        Double cost = Double.parseDouble(request.getParameter("cost"));
        String snapShot = request.getParameter("snapShot");
        String dressType = request.getParameter("dressType");
        Dress dress;
        if (dressType.equals("menWear")) {
            dress = new Dress(id, brand, dressName, cost, snapShot, dressType);
            dressService.createDress(dress);
            model.addAttribute("message", "add");
            return "addContain";
        }
        if (dressType.equals("womenWear")) {
            dress = new Dress(id, brand, dressName, cost, snapShot, dressType);
            dressService.createDress(dress);
        }
        return "addContain";
    }


    @PostMapping("/addGallery")
    public String addGallery(HttpServletRequest request, Model model) {
        Long id = Long.parseLong(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String name = request.getParameter("name");
        Double cost = Double.parseDouble(request.getParameter("cost"));
        String photo = request.getParameter("photo");
        Gallery gallery = new Gallery(id, brand, name, cost, photo);
        galleryService.createGallery(gallery);
        model.addAttribute("message", "Gallery Added");
        return "addGallery";
    }


        @GetMapping("/galleryTable")
        public String galleryTable (Model model) {
            List<Gallery> galleries = galleryService.showsGallery();
            model.addAttribute("galleries", galleries);
            return "galleryTable";
        }
}
