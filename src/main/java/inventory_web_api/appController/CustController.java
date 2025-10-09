package inventory_web_api.appController;

import inventory_web_api.appService.CustomerService;
import inventory_web_api.webInEntity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/retrieve/all")
    public ResponseEntity<List<Customers>> getAllCutomers()
    {
        List<Customers> listCust = customerService.getAllCustomer();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/retrieve/all").build(listCust);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().headers(header).body(listCust);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customers> getIndividualCust(@PathVariable("id")Long id)
    {
        Customers customers=new Customers();
        Long ids = id;
        if (ids != null)
        {
            customers = customerService.findOneCustomer(ids);
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build(customers);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return ResponseEntity.ok().headers(headers).body(customers);
    }
    @PostMapping("/save/customer")
    public ResponseEntity<Customers>saveCustomerEntity(@RequestBody Customers cust)
    {
        Customers save = customerService.saveCustomer(cust);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/save/customer/{id}").build(save);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(uri);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).headers(header).body(save);
    }
}
