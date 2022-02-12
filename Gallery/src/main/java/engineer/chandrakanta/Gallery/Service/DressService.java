package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.DressRepository;
import engineer.chandrakanta.Gallery.entity.Dress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {
    @Autowired
    DressRepository dressRepository;
    public  Dress createDress(Dress dress){
      return dressRepository.save(dress);
  }

    public List<Dress> findByDressType(String dressType) {
        return  dressRepository.findByDressType(dressType);
    }

    public  Dress getById(Long id){
        return  dressRepository.getById(id);
    }
    public  List<Dress> allDress(){
        return  dressRepository.findAll();
    }
}
