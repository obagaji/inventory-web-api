package inventory_web_api.appController;

import inventory_web_api.appService.ItemsService;
import inventory_web_api.webInEntity.Customers;
import inventory_web_api.webInEntity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    ItemsService itemsService;

    @GetMapping("/item/{id}")
    public ResponseEntity<Items>getCustomerInfo(@PathVariable("id") Long id)
    {
        Items find = itemsService.getIndividualitem(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(find);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(header).body(find);
    }
    @GetMapping("/all/item")
    public ResponseEntity<List<Items>>getAllItems()
    {
        List<Items>allItems = itemsService.getAllItems();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(allItems);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(header).body(allItems);
    }
    @PostMapping("/send/item")
    public ResponseEntity<Items> addIndividualItem(@RequestBody Items items)
    {
        Items its = itemsService.saveItems(items);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/send/item").build(its);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(header).body(its);
    }
    @DeleteMapping("/item/remove/{id}")
    public ResponseEntity<Void>removeItem(@PathVariable("id") Long id)
    {
        itemsService.deleteItems(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }



}
