package MyProjectWebsiteData.WebDataProject.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class InventoryModel {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public InventoryModel(Integer id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public InventoryModel()
    {

    }
    @Override
    public String toString() {
        return "InventoryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Quantity=" + quantity +
                '}';
    }

    @Id
    Integer id;

    @Column
    String name;

    @Column
    Integer quantity;


}
