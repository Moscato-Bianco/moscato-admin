package moscato.admin.service.category;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(int pid) {
        return categoryRepository.findByPid(pid);
    }

    public List<Category> getCategoriesByLevel(int level) { return categoryRepository.findByLevel(level);}

}
