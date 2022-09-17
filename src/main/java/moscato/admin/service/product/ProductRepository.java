package moscato.admin.service.product;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends DataTablesRepository<Product, Integer> {
    List<Product> findByCategoryId(int pid);

}
