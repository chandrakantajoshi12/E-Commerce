package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.MenWearRepository;
import engineer.chandrakanta.Gallery.entity.Customer;
import engineer.chandrakanta.Gallery.entity.MenWear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenWearService {
    @Autowired
    private MenWearRepository menRepository;
     public MenWear createMenWear(MenWear menWear){
         return  menRepository.save(menWear);
     }


    public List<MenWear> showsProduct() {
         return menRepository.findAll();
    }
}
