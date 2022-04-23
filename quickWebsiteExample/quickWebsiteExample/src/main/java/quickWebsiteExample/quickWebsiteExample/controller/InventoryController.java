package MyProjectWebsiteData.WebDataProject.controller;

import MyProjectWebsiteData.WebDataProject.Models.InventoryModel;
import MyProjectWebsiteData.WebDataProject.repositories.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class InventoryController {

    public final InventoryRepo repo;
    @Autowired
    public InventoryController(InventoryRepo Repo)
    {
        repo = Repo;
    }

    @ResponseBody
    @RequestMapping("/viewall")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String viewAll()
    {
        String result = "";
        try
        {
             result = "[\n";
            List<InventoryModel> list = repo.findAll();
            for (InventoryModel i : list){
                result += i.toString();
            }
            result += "]\n";
            return result;
        }
        catch (Exception exc)
        {
            System.out.println("Exception: "+ exc.getMessage());
            exc.printStackTrace();
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/viewone")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String ViewById(@RequestParam(name = "id", defaultValue = "1") Integer id)
    {
        try
        {
            return repo.findById(id).toString();
        }
        catch(Exception exc)
        {
            System.out.println("Exception: "+ exc.getMessage());
            exc.printStackTrace();
        }
        return null;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
            public String AddItem(@RequestParam(value = "id", defaultValue = "100") Integer id,
                                  @RequestParam(value = "name", defaultValue = "item") String name,
                                  @RequestParam(value = "quantity", defaultValue = "10") Integer quantity)
    {
        try
        {
            if (id != null && name != null && quantity != null)
            {
                InventoryModel inv =  new InventoryModel(id, name, quantity);
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
