package com.anya.directionProbSolver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anya.directionProbSolver.entities.Movement;
import com.anya.directionProbSolver.services.CoordinateService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoordinateController {

    @Autowired
    private CoordinateService coordinateService;

    private List<Movement> movements = new ArrayList<>();

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("movement", new Movement());
        model.addAttribute("movements", movements);
        return "movementForm";
    }

    @PostMapping("/addMovement")
    public String addMovement(@ModelAttribute Movement movement) {
        movements.add(movement);
        return "redirect:/";
    }

    @PostMapping("/calculate")
    public String calculate(Model model) {
        double distance = coordinateService.calculateDistance(movements);
        String direction = coordinateService.calculateDirection(movements);
        model.addAttribute("distance", distance);
        model.addAttribute("direction", direction);
        return "result";
    }

    @PostMapping("/reset")
    public String reset() {
        movements.clear();
        return "redirect:/";
    }
}