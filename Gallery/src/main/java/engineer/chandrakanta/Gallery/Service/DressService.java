package engineer.chandrakanta.Gallery.Service;

import engineer.chandrakanta.Gallery.Repository.DressRepository;
import engineer.chandrakanta.Gallery.entity.Dress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DressService {
    @Autowired
    DressRepository dressRepository;
    public  Dress createDress(Dress dress){
      return dressRepository.save(dress);
  }
}
