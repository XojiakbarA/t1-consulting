package com.example.t1consultingtask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class AppServiceTest {
    @Autowired
    private AppService appService;

    @Test
    public void calcFrequencyOfCharsTestWithSameCount() throws Exception {
        String string = "daaabbc";
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 3);
        map.put('b', 2);
        map.put('c', 1);
        map.put('d', 1);

        assertEquals(map, appService.calcFrequencyOfChars(string));
    }

    @Test
    public void calcFrequencyOfCharsTestWithDiffCount() throws Exception {
        String string = "ddddddaaabbc";
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('d', 6);
        map.put('a', 3);
        map.put('b', 2);
        map.put('c', 1);

        assertEquals(map, appService.calcFrequencyOfChars(string));
    }
}
