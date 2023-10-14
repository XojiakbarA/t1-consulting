package com.example.t1consultingtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class AppController {
    @Autowired
    private AppService appService;

    @GetMapping("/frequency/{string}")
    @ResponseStatus(HttpStatus.OK)
    public Map<Character, Integer> getFrequencyOfChars(@PathVariable String string) {
        return appService.calcFrequencyOfChars(string);
    }
}
