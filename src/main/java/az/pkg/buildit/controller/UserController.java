package az.pkg.buildit.controller;

import az.pkg.buildit.entity.Role;
import az.pkg.buildit.entity.User;
import az.pkg.buildit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String root(HttpSession session){
        if (session.getAttribute("username") == null) return "login";
        else if (session.getAttribute("role").equals(Role.siteEngineer)) return "siteIndex";
        else if (session.getAttribute("role").equals(Role.worksEngineer)) return "worksIndex";
        else return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/auth")
    public String login(@RequestBody MultiValueMap<String,String> map, HttpSession session, Model model){
        if (session.getAttribute("username") == null || session.getAttribute("role") == null) {
            String un = map.getFirst("username");
            String pwd = map.getFirst("password");
            User user = service.findUserByUserName(un);
            if (user.getPassword().equals(pwd)) {
                session.setAttribute("username", un);
                session.setAttribute("role", user.getRole());
            }
            else {
                return "error";
            }
        }
        model.addAttribute("message", "logged in");
        if (session.getAttribute("role").equals(Role.siteEngineer)) return "siteIndex";
        else if (session.getAttribute("role").equals(Role.worksEngineer)) return "worksIndex";
        return "index";
    }
}
