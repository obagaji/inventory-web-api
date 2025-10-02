package inventory_web_api.appController;


import inventory_web_api.appService.SalesService;
import inventory_web_api.webInEntity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SalesController {


    @Autowired
    SalesService salesService;

    @GetMapping("/all")
    public ResponseEntity<List<Sales>>getAllSales()
    {
        List<Sales> salesList = salesService.getAllSales();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/all").build(salesList);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(headers).body(salesList);
    }

}
