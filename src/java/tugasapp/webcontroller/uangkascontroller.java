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
import tugasapp.dao.tugasdao;
import tugasapp.dao.tugasdaoperoses;
import tugasapp.model.uangkas;

/**
 *
 * @author wardatumilah
 */
@Controller
public class uangkascontroller {

    tugasdao kasdao = null;

    public uangkascontroller() {
        kasdao = new tugasdaoperoses();
    }

    @RequestMapping(value = "/uangkas-form")
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {
        String action = req.getParameter("action");
        ModelAndView modelAndView;
        if (action == null) {
            action = "ADD";
        }
        switch (action) {
            case "edit":
                modelAndView = edituangkas(req, res);
                break;
            case "delete":
                modelAndView = deleteuangkas(req, res);
                break;
            default:
                modelAndView = adduangkas(req, res);
                break;
        }
        return modelAndView;

    }

    @RequestMapping(value = "/uangkas-form", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("kas") uangkas kas) {
        ModelAndView modelAndView = new ModelAndView("redirect:/uangkas-form.htm");
        if (kas.getId() != 0) {
            if (kasdao.update(kas)) {
                return new ModelAndView("redirect:/home.htm");
            } else {
                modelAndView.addObject("message", "error save");
            }
        } else {
            if (kasdao.save(kas)) {
                return new ModelAndView("redirect:/home.htm");
            } else {
                modelAndView.addObject("message", "Error save");
            }
            return modelAndView;
        }
        return null;

    }

    private ModelAndView edituangkas(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        uangkas mah = kasdao.getSinggle(Integer.parseInt(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("kas", mah);
        return modelAndView;
    }

    private ModelAndView adduangkas(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", req.getParameter("message"));
            return modelAndView;
        }
        return new ModelAndView();
    }

    private ModelAndView deleteuangkas(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        if (kasdao.delete(Integer.parseInt(id))) {
            return new ModelAndView("redirect:/home.htm");
        } else {
            req.setAttribute("mesage", "gagal delete");
            return adduangkas(req, res);
        }
    }
}
