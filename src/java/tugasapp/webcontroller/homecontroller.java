/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasapp.webcontroller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tugasapp.dao.tugasdao;
import tugasapp.dao.tugasdaoperoses;
import tugasapp.model.uangkas;

/**
 *
 * @author wardatumilah
 */
@Controller
public class homecontroller {

    tugasdao kasdao = null;

    public homecontroller() {
        kasdao = new tugasdaoperoses();
    }

    private ModelAndView listuangkas(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<uangkas> theList = kasdao.get();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listKas", theList);
        return modelAndView;
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        return listuangkas(req, res);

    }
}
