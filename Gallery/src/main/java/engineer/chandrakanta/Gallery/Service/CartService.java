//package engineer.chandrakanta.Gallery.Service;
//
//import engineer.chandrakanta.Gallery.Repository.CartRepository;
//import engineer.chandrakanta.Gallery.entity.Cart;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CartService {
//  @Autowired
//    CartRepository cartRepository;
//
//  public Cart addToCart(Cart cart){
//      return cartRepository.save(cart);
//  }
//
// public List<Cart> myCart(String username){
//
//      return cartRepository.findByCustomerUsername(username);
//  }
//   public  void remove(Long id){
//      cartRepository.deleteById(id);
//   }
//
//
//
//}
