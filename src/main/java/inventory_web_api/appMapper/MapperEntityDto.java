package inventory_web_api.appMapper;

import inventory_web_api.appDto.CartDto;
import inventory_web_api.webInEntity.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperEntityDto {
    @Autowired
    ModelMapper modelMapper;

    public CartDto mapperCartToDto(Cart cart)
    {
        return modelMapper.map(cart, CartDto.class);
    }

    public Cart mappingCartDtoToCart(CartDto cartDto)
    {
        return modelMapper.map(cartDto, Cart.class);
    }
    public List<Cart> ListCartDtoToListCart(List<CartDto>cartDto)
    {
        return cartDto.stream().map(
                e -> modelMapper.map(e, Cart.class)).toList();
    }
    public List<CartDto>ListCartToListCartDto(List<Cart>carts)
    {
        return carts.stream()
                .map(e -> modelMapper.map(e, CartDto.class))
                .toList();
    }

}
