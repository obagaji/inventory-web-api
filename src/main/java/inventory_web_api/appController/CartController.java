package inventory_web_api.appController;


import inventory_web_api.appDto.CartDto;
import inventory_web_api.appMapper.MapperEntityDto;
import inventory_web_api.appService.CartService;
import inventory_web_api.webInEntity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    MapperEntityDto mapperEntityDto;

    @PostMapping("/add")
    public ResponseEntity<Cart> saveEntityCart(@RequestBody CartDto cartDto)
    {
       Cart cart =cartService.addToCart(cartDto);
        URI url = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/add").build(cart);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(url);
        return ResponseEntity.accepted()
                .contentType(MediaType.APPLICATION_JSON)
                .headers(httpHeaders).body(cart);
    }
    @GetMapping("/cart")
    public ResponseEntity<CartDto> getSpecificCart(@PathVariable("id") Long id)
    {
        CartDto cartDto = mapperEntityDto.mapperCartToDto(cartService.getCart(id));
    }
}
