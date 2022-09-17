package moscato.admin.controller.category;

import moscato.admin.service.category.Category;
import moscato.admin.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.html.parser.Parser;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/category/*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="/list")
    public @ResponseBody List<Category> getCategoryList(@RequestParam Map<String, Object> param){

        return categoryService.getCategoriesByLevel(Integer.parseInt(String.valueOf(param.get("level"))));
    }


}
