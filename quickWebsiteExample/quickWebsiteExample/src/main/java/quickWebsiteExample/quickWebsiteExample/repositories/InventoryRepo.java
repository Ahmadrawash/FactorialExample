package MyProjectWebsiteData.WebDataProject.repositories;

import MyProjectWebsiteData.WebDataProject.Models.InventoryModel;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryModel, Integer> {

}
