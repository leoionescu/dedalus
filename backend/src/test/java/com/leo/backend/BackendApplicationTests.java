package com.leo.backend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class BackendApplicationTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTextAnalyzerSimpleTextVowels() throws Exception {
        String type = "vowels";
        String text = "This is a sample text";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/text-analyzer")
                .param("type", type)
                .param("text", text))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String expected = "Letter 'A' appears 2 times\nLetter 'E' appears 2 times\nLetter 'I' appears 2 times\n";
        assertEquals(expected, responseContent);
    }

    @Test
    public void testTextAnalyzerSimpleTextConsonants() throws Exception {
        String type = "consonants";
        String text = "This is a sample text";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/text-analyzer")
                .param("type", type)
                .param("text", text))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String expected = "Letter 'H' appears 1 times\nLetter 'L' appears 1 times\nLetter 'M' appears 1 times\nLetter 'P' appears 1 times\nLetter 'S' appears 3 times\nLetter 'T' appears 3 times\nLetter 'X' appears 1 times\n";
        assertEquals(expected, responseContent);
    }

    @Test
    public void testTextAnalyzerHardTextVowels() throws Exception {
        String type = "vowels";
        String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/text-analyzer")
                .param("type", type)
                .param("text", text))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String expected = "Letter 'A' appears 103 times\n" +
                "Letter 'E' appears 125 times\n" +
                "Letter 'I' appears 71 times\n" +
                "Letter 'O' appears 95 times\n" +
                "Letter 'U' appears 68 times\n";
        assertEquals(expected, responseContent);
    }

    @Test
    public void testTextAnalyzerHardTextConsonants() throws Exception {
        String type = "consonants";
        String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/text-analyzer")
                .param("type", type)
                .param("text", text))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        String expected = "Letter 'B' appears 13 times\n" +
                "Letter 'C' appears 26 times\n" +
                "Letter 'D' appears 61 times\n" +
                "Letter 'G' appears 18 times\n" +
                "Letter 'J' appears 4 times\n" +
                "Letter 'K' appears 8 times\n" +
                "Letter 'L' appears 51 times\n" +
                "Letter 'M' appears 74 times\n" +
                "Letter 'N' appears 47 times\n" +
                "Letter 'P' appears 24 times\n" +
                "Letter 'Q' appears 5 times\n" +
                "Letter 'R' appears 73 times\n" +
                "Letter 'S' appears 83 times\n" +
                "Letter 'T' appears 111 times\n" +
                "Letter 'V' appears 14 times\n" +
                "Letter 'Y' appears 10 times\n";
        assertEquals(expected, responseContent);
    }
}

