package MyWebProject.MyWebProject.repositories;

import MyWebProject.MyWebProject.Models.InventoryModel;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryModel, Integer> {

}
