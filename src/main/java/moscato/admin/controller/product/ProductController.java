package moscato.admin.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {

    @RequestMapping(value = "/index")
    public String product(ModelMap model) {
        // TODO: 카테고리 목록 selectBox item

        return "view/product/index";
    }
}
