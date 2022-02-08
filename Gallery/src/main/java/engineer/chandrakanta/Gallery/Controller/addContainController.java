package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.GalleryRepository;
import engineer.chandrakanta.Gallery.Repository.MenWearRepository;
import engineer.chandrakanta.Gallery.Repository.WomenWearRepository;
import engineer.chandrakanta.Gallery.Service.GalleryService;
import engineer.chandrakanta.Gallery.Service.MenWearService;
import engineer.chandrakanta.Gallery.Service.WomenWearService;
import engineer.chandrakanta.Gallery.entity.Customer;
import engineer.chandrakanta.Gallery.entity.Gallery;
import engineer.chandrakanta.Gallery.entity.MenWear;
import engineer.chandrakanta.Gallery.entity.WomenWear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class addContainController {
    @Autowired
    MenWearService menWearService;
    @Autowired
    MenWearRepository menWearRepository;
    @Autowired
    WomenWearService womenWearService;
    @Autowired
    WomenWearRepository womenWearRepository;
    @Autowired
    GalleryService galleryService;
    @Autowired
    GalleryRepository galleryRepository;

    @GetMapping("/addGallery")
    public String addGallery(){
        return "addGallery";
    }


    @GetMapping("/addContain")
    public String addContain(){
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
        if (dressType.equals("menWear")) {
            MenWear menWear = new MenWear(id, brand, dressName, cost, snapShot ,dressType);
            menWearService.createMenWear(menWear);
            model.addAttribute("message", "add");
            return "addContain";
        }
        if (dressType.equals("womenWear")) {
            WomenWear womenWear = new WomenWear(id, brand, dressName, cost, snapShot ,dressType);
            womenWearService.createWomenWear(womenWear);
        }
        return "addContain";
    }

   @PostMapping("/addGallery")
   public  String addGallery(HttpServletRequest request , Model model){
        Long id = Long.parseLong(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String name =request.getParameter("name");
        Double cost =Double.parseDouble(request.getParameter("cost"));
        String photo = request.getParameter("photo");
        Gallery gallery = new Gallery(id,brand,name,cost,photo);
        galleryService.createGallery(gallery);
        model.addAttribute("message","Gallery Added");
        return "addGallery";
   }
   @GetMapping("/menWearTable")
    public  String menWearTable(Model model){
        List<MenWear> menWears = menWearService.showsProduct();
        model.addAttribute("menWears",menWears);
        return "menWearTable";
   }
   @GetMapping("/galleryTable")
    public  String galleryTable(Model model){
        List<Gallery> galleries= galleryService.showsGallery();
        model .addAttribute("galleries",galleries);
        return "galleryTable";
   }

}