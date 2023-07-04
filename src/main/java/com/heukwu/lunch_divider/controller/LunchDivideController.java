package com.heukwu.lunch_divider.controller;

import com.heukwu.lunch_divider.dto.NameDto;
import com.heukwu.lunch_divider.model.Person;
import com.heukwu.lunch_divider.service.LunchDivideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showPeople")
    @ResponseBody
    public List<Person> show() {
        return lunchDivideService.getPeopleList();
    }

    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody NameDto name) {
        String message = "등록 완료: " + name.getName();

        try {
            lunchDivideService.addPerson(name.getName());
            return ResponseEntity.ok(message);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePerson(@RequestParam Long id) {
        System.out.println(id);
        lunchDivideService.deletePerson(id);
        return ResponseEntity.ok("삭제되었습니다.");
    }

    @PostMapping("/divide")
    @ResponseBody
    public List<List<String>> divideIntoGroups(@RequestParam int groupCount) {
        return lunchDivideService.divideIntoGroup(groupCount);
    }
}
