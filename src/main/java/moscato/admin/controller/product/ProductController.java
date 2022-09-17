package moscato.admin.controller.product;

import moscato.admin.service.product.Product;
import moscato.admin.service.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {

    @RequestMapping(value = "/index")
    public String product(ModelMap model) {
        // TODO: 카테고리 목록 selectBox item
        return "view/product/index";
    }


}
