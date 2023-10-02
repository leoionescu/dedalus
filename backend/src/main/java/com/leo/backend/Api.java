package com.leo.backend;

import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

@RestController
@RequestMapping("/api")
public class Api {

    @GetMapping("/text-analyzer")
    public String getTextAnalyserResult(@RequestParam String type, @RequestParam String text) {
        TextAnalyzer input = new TextAnalyzer(type, text);
//        input.analyzeTextOld();
        return input.analyzeText();
    }
}
