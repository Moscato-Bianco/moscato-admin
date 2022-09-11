package moscato.admin.controller.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboard/*")
public class DashBoardController {

    @RequestMapping(value = "/index")
    public String dashboard(ModelMap model) {
        model.put("preInfo", "test");
        return "view/dashboard/index";
    }
}
