package moscato.admin.controller.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    /**
     * 로그인
     * @return
     */
    @GetMapping("/login")
    public String index() {
        return "view/login";
    }

    /**
     * 로그인 실패
     * @param request
     * @param response
     * @param model
     * @return
     */
    @PostMapping("/login/error")
    public String LoginError(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

        model.put("error", request.getAttribute("error"));
        model.put("error_message", request.getAttribute("error_msg"));
        return "view/login";
    }

    /**
     * 로그아웃
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

}
