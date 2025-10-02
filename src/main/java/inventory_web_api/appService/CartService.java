package inventory_web_api.appService;


import inventory_web_api.appDto.CartDto;
import inventory_web_api.appException.CartNotFoundException;
import inventory_web_api.appMapper.MapperEntityDto;
import inventory_web_api.reposit.CartReposit;
import inventory_web_api.webInEntity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartReposit cartReposit;

    public List<Cart>listOfCart()
    {
        return cartReposit.findAll();
    }
    public Cart addToCart(CartDto carts)
    {
        Cart cart = new MapperEntityDto().mappingCartDtoToCart(carts);
        return cartReposit.save(cart);
    }

    public Cart getCart(Long id)
    {
        Optional<Cart> cartOptional = cartReposit.findById(id);
        if (cartOptional.isEmpty())
        {
            try {
                throw  new CartNotFoundException("No Value for cart Id");
            } catch (CartNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            return cartOptional.get();
        }
    }
    public void deleteFromCart(long id)
    {
        Cart cartOne = getCart(id);
        if (cartOne != null)
        {
            cartReposit.deleteById(id);
        }
    }

    public void updateCartInfo(CartDto cart)
    {
        Long id = cart.id();
        Cart carts = getCart(id);
        if (carts !=null)
        {
            carts.setItemsSet(cart.itemsSet());
            carts.setTotalExpenses(cart.totalExpenses());
            carts.setTotalItem(cart.totalItem());
            cartReposit.save(carts);
        }

    }
    //TODO A method that will implement multithreaded capability to be used to update cart items.
}
