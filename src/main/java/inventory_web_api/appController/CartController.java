package inventory_web_api.appController;


import inventory_web_api.appDto.CartDto;
import inventory_web_api.appMapper.MapperEntityDto;
import inventory_web_api.appService.CartService;
import inventory_web_api.webInEntity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;


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
    @GetMapping("/cart/{id}")
    public ResponseEntity<CartDto> getSpecificCart(@PathVariable("id") Long id)
    {
        CartDto cartDto = mapperEntityDto.mapperCartToDto(cartService.getCart(id));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build(cartDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setDate(Instant.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.OK.value())).body(cartDto);
    }
    @GetMapping("/all/cart")
    public ResponseEntity<List<CartDto>>getListCart()
    {
        List<CartDto> cartDtoList = mapperEntityDto.ListCartToListCartDto(cartService.listOfCart());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/all/cart").build(cartDtoList);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.status(HttpStatus.OK).body(cartDtoList);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartInfo(@PathVariable("id") Long id)
    {
        cartService.deleteFromCart(id);
        return ResponseEntity.ok().build();
    }
}
