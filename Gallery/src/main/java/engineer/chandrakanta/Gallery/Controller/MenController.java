package engineer.chandrakanta.Gallery.Controller;

import engineer.chandrakanta.Gallery.Repository.MenWearRepository;
import engineer.chandrakanta.Gallery.Service.MenWearService;
import engineer.chandrakanta.Gallery.entity.MenWear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenController {
    @Autowired
    MenWearService menWearService;
    @Autowired
    MenWearRepository menWearRepository;

    @GetMapping("/men")
    public String men(Model model){
      List<MenWear> menWears = menWearService.showsProduct();
      model.addAttribute("menWears",menWears);
      return "men";
    }

}
