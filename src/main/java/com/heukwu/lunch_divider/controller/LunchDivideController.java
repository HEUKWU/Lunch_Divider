package com.heukwu.lunch_divider.controller;

import com.heukwu.lunch_divider.model.Person;
import com.heukwu.lunch_divider.service.LunchDivideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LunchDivideController {
    private final LunchDivideService lunchDivideService;

    @Autowired
    public LunchDivideController(LunchDivideService lunchDivideService) {
        this.lunchDivideService = lunchDivideService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/divide")
    public String divideIntoGroups(@RequestParam(required = false) List<String> checkNames, @RequestParam int groupCount, Model model) {
        if (checkNames == null) {
            model.addAttribute("result", "체크된 인원이 없습니다.");
            return "index";
        }
        List<Person> people = lunchDivideService.getPeopleList(checkNames);
        String result = lunchDivideService.divideIntoGroup(people, groupCount);
        model.addAttribute("result", result);
        return "index";
    }
}
