package inventory_web_api.appController;


import inventory_web_api.appService.SalesService;
import inventory_web_api.exceptPackage.EmptySalesException;
import inventory_web_api.webInEntity.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {


    @Autowired
    SalesService salesService;

    @GetMapping("/all/sales")
    public ResponseEntity<List<Sales>>getAllSales()
    {
        List<Sales> salesList = salesService.getAllSales();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/all").build(salesList);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(headers).body(salesList);
    }
    @PostMapping("/add")
    public ResponseEntity<Sales> insertIntoDb(@RequestBody Sales sales)
    {
        Sales sale = salesService.addEachSale(sales);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/add").build(sale);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
       /// header.setContentType(MediaType.APPLICATION_JSON);
        header.setDate(Instant.now());
        return ResponseEntity.created(uri).headers(header).body(sale);
    }
    @GetMapping("/sale/{id}")
    public ResponseEntity<Sales> getIndividualSale(@PathVariable("id")Long id)
    {
         Sales sale = new Sales();
        Optional<Sales> optSale = Optional.ofNullable(salesService.getSales(id));
        if (optSale.isEmpty())
        {
             sale =  new EmptySalesException().get();
            return new ResponseEntity<Sales>(sale, HttpStatus.NOT_FOUND);
        }
        else{
            sale = optSale.get();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(sale);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(headers).body(sale);
    }
    @PutMapping("/update")
    public ResponseEntity<Sales> updateSalesRecord(@RequestBody Sales sales)
    {
        Sales sa = salesService.updateSales(sales);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/update").build(sa);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(header).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSalesEntity(@PathVariable("id") Long id)
    {
        salesService.deleteSalesReport(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/delete").build().toUri();
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok(" deletion Successul");
    }

}
