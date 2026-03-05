package com.oneeleven.developertask.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class SortStringController {

    @PostMapping("/sort-string")
    public Map<String, Object> sortString(@RequestBody Map<String, String> requestData) {
        String userInput = requestData.get("data");

        if (userInput == null || userInput.trim().length() == 0) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Please provide a valid string.");
            return errorResponse;
        }

       
        char[] letters = userInput.toCharArray();

        // Sort characters alphabetically
        Arrays.sort(letters);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            result.add(String.valueOf(letters[i]));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("word", result);

        return response;
    }
}
