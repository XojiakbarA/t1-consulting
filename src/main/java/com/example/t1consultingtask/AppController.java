package com.example.t1consultingtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class AppController {
    @Autowired
    private AppService appService;

    @GetMapping("/frequency/{string}")
    public Map<Character, Integer> getFrequencyOfChars(@PathVariable String string) {
        return appService.calcFrequencyOfChars(string);
    }
}
