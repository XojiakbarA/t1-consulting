package com.example.t1consultingtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class AppControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void contextLoads() throws Exception {

    }

    @Test
    public void getFrequencyOfCharsTestWithSameCount() throws Exception {
        String string = "daaabbc";
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('a', 3);
        map.put('b', 2);
        map.put('c', 1);
        map.put('d', 1);

        String resMap = objectMapper.writeValueAsString(map);

        ResultActions res = mockMvc.perform(get("/frequency/" + string)).andDo(print());

        res.andExpect(status().isOk())
                .andExpect(content().string(resMap))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void getFrequencyOfCharsTestWithDiffCount() throws Exception {
        String string = "ddddddaaabbc";
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('d', 6);
        map.put('a', 3);
        map.put('b', 2);
        map.put('c', 1);

        String resMap = objectMapper.writeValueAsString(map);

        ResultActions res = mockMvc.perform(get("/frequency/" + string)).andDo(print());

        res.andExpect(status().isOk())
                .andExpect(content().string(resMap))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }
}
