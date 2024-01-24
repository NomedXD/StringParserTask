package project.string.process.restapi.controllers;

import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api")
public class StringController {
    @PostMapping("/parse")
    public ResponseEntity<Map<Character, Integer>> parseString(@NotBlank(message = "String param is blank") String stringToParse) {
        Map<Character, Integer> resultMap = new TreeMap<>();
        char[] charArray = stringToParse.toCharArray();
        Arrays.sort(charArray);
        for (Character character : charArray) {
            if (resultMap.containsKey(character)) {
                resultMap.put(character, resultMap.get(character) + 1);
            } else {
                resultMap.put(character, 1);
            }
        }
        return ResponseEntity.ok().body(resultMap);
    }
}
