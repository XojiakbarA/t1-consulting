package com.example.t1consultingtask;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppService {
    public Map<Character, Integer> calcFrequencyOfChars(String string) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : string.toCharArray()) {
            int count = 0;
            if (map.containsKey(ch)) {
                count = map.get(ch);
            }
            map.put(ch, count + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
    }
}
