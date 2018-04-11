package com.techelevator.controller;

import com.techelevator.model.PotholeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PotHoleController {

    @Autowired
    PotholeDAO potholeDAO;

    @RequestMapping(path = "/potholes/allPotholes", method = RequestMethod.GET)
    public String showAllPotholes(Model model) {
        model.addAttribute("allPotholes", potholeDAO.getListOfPotholesOrderByDate());


        return "/potholes/allPotholes";
    }

    @RequestMapping(path = "/potholes/report", method = RequestMethod.GET)
    public String showReport(Model model) {

        return "/potholes/report";
    }

}
