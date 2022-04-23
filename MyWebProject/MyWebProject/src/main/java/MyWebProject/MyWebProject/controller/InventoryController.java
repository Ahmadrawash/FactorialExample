package MyWebProject.MyWebProject.controller;

import MyWebProject.MyWebProject.Models.InventoryModel;
import MyWebProject.MyWebProject.repositories.InventoryRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class InventoryController {

    public final InventoryRepo repo;
    private final ObjectMapper mapper;


    @Autowired
    public InventoryController(InventoryRepo Repo, ObjectMapper mapper)
    {
        repo = Repo;
        this.mapper = mapper;
    }


    //    @ResponseBody
//    @RequestMapping(value = "/viewall",
//            method=RequestMethod.POST,
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(value = "/viewall")
    public List<InventoryModel> viewAll()
    {
        //String result = "";
        List<InventoryModel> listall = new ArrayList<>();
        try
        {
             //result = "[\n";
            List<InventoryModel> list = repo.findAll();
            for (InventoryModel i : list){
                //result += i.toString();
                listall.add(i);
            }
            //result += "]\n";
            return listall;
        }
        catch (Exception exc)
        {
            System.out.println("Exception: "+ exc.getMessage());
            exc.printStackTrace();
        }
        return null;

    }

//    @ResponseBody
//    @RequestMapping(value = "/viewone",
//            method=RequestMethod.GET,
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @ResponseStatus(HttpStatus.ACCEPTED)

    //@GetMapping(value = "/viewone")

    @GetMapping("/viewone")
    public ResponseEntity<String> ViewById(@RequestHeader(name = "userId") Integer userIdy)
    {
        try
        {
           //Optional<InventoryModel> inventory = repo.findById(userIdy);
            System.out.println(userIdy);
            return ResponseEntity.ok().body(mapper.writeValueAsString(repo.findById(userIdy)));
        }
        catch(Exception exc)
        {
            System.out.println("Exception: "+ exc.getMessage());
            exc.printStackTrace();
        }
        return null;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    //consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    //            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    //public ResponseEntity<String> RegisterNewUser(@RequestBody UserModel newUser) {
    @RequestMapping(
            value = "/insert",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String AddItem(@RequestBody InventoryModel newinventory)
    {
        try
        {
            if (newinventory.getId() != null && newinventory.getName() != null && newinventory.getQuantity() != null)
            {
                System.out.println("adding item: " + newinventory.getId() + ", " + newinventory.getName() + ", " + newinventory.getQuantity());
                InventoryModel inv =  new InventoryModel(newinventory.getId() , newinventory.getName(), newinventory.getQuantity());
                repo.save(inv);
                return "item has been inserted successfully";
            }
        }
        catch(Exception exc)
        {
            System.out.println("Exception: " + exc.getMessage());
            exc.printStackTrace();;
        }
        return "error when attempted to insert a new inventory item";
    }


}
