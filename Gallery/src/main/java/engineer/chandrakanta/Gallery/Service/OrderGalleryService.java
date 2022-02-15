package engineer.chandrakanta.Gallery.Service;


import engineer.chandrakanta.Gallery.Repository.OrderGalleryRepository;
import engineer.chandrakanta.Gallery.entity.OrderDress;
import engineer.chandrakanta.Gallery.entity.OrderGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderGalleryService {
    @Autowired
    OrderGalleryRepository orderGalleryRepository;
    public List<OrderGallery> orderGallery(String username){

        return orderGalleryRepository.findByCustomerUsername(username);
    }



    public OrderGallery addOrderGallery(OrderGallery orderGallery) {
        return  orderGalleryRepository.save(orderGallery);
    }

    public void remove(Long id) {
         orderGalleryRepository.deleteById(id);
    }

    public Boolean existByGalleryId(Long id) {
        return  orderGalleryRepository.existsByGalleryId(id);
    }

    public void removeByGalleryId(Long id) {
        orderGalleryRepository.deleteByGalleryId(id);
    }
}
