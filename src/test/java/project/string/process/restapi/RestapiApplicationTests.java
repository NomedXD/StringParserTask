package project.string.process.restapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import project.string.process.restapi.controllers.StringController;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestapiApplicationTests {
    private final StringController controller;
    private final ResponseEntity<Map<Character, Integer>> test1Expected;
    private final ResponseEntity<Map<Character, Integer>> test2Expected;

    @Autowired
    public RestapiApplicationTests(StringController controller) {
        this.controller = controller;
        test1Expected = ResponseEntity.ok().body(Map.ofEntries(Map.entry('a', 5), Map.entry('c', 4), Map.entry('b', 1)));
        test2Expected = ResponseEntity.ok().body(Map.ofEntries(Map.entry('H', 1), Map.entry('e', 1), Map.entry('l', 2), Map.entry('o', 1)));
    }

    @Test
    void contextLoads() {
    }

    @Test
        // Valid
    void test1() {
        Assertions.assertEquals(test1Expected.getBody(), controller.parseString("aaaaabcccc").getBody());
    }

    @Test
        // Valid
    void test2() {
        Assertions.assertEquals(test2Expected.getBody(), controller.parseString("Hello").getBody());
    }


}
