/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasapp.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tugasapp.model.loginmodel;

/**
 *
 * @author wardatumilah
 */
@Controller
public class logincontroller {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", req.getParameter("message"));
            return modelAndView;
        }
        return new ModelAndView();
    }

    /**
     *
     * @param emp
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("emp") loginmodel emp) {
        ModelAndView login = new ModelAndView("redirect:/login.htm");
        ModelAndView home = new ModelAndView("redirect:/home.htm");
        if (emp.getUsername().equalsIgnoreCase("admin") && emp.getPassword().equalsIgnoreCase("admin")) {
            return home;

        } else {
            login.addObject("message", "username atau password salah");
        }
        return login;
    }

}
