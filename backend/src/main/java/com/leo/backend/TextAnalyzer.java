package com.leo.backend;

import java.util.HashMap;
import java.util.Locale;

public class TextAnalyzer {
    private String type;
    private String text;
    private String result = "";

    public TextAnalyzer(String type, String text) {
        this.type = type;
        this.text = text;
        System.out.println("text length: " + text.length());
    }

    public String analyzeText() {
        long startTime = System.nanoTime();
        int[] frequencyArray = new int[26];
        String result = "";
        char[] chars = text.toCharArray();

        // create frequency array
        for(int i = 0; i < chars.length; i++) {
            int value = chars[i] - 'A';
            if(value >= 32) value -= 32;
            if(value >= 0 && value <= 31) frequencyArray[value]++;
        }

        // create result from frequency array
        for(int i = 0; i < 26; i++) {
            if(type.equals("vowels")) {
                if(i == 0 || i == 'E' - 'A' || i == 'I' - 'A' || i == 'O' - 'A' || i == 'U' - 'A') {
                    if(frequencyArray[i] > 0)
                        result = result.concat("Letter '" + (char)('A' + i ) + "' appears " + frequencyArray[i] + " times\n");
                }
            } else if(type.equals("consonants")) {
                if (i != 0 && i != 'E' - 'A' && i != 'I' - 'A' && i != 'O' - 'A' && i != 'U' - 'A') {
                    if(frequencyArray[i] > 0)
                        result = result.concat("Letter '" + (char)('A' + i) + "' appears " + frequencyArray[i] + " times\n");
                }
            }
        }
        long stopTime = System.nanoTime();

        // info
        System.out.println(result);
        System.out.println("Time new: " + (stopTime - startTime) / 1000000);
        System.out.println("-------------------------------------------");
        // info

        return result;
    }


    public String analyzeTextOld() {
        long startTime = System.nanoTime();
        String input = "";
        int numA = 0;
        int numE = 0;
        int numI = 0;
        int numO = 0;
        int numU = 0;
        if (type.equals("vowels")) {
            input = text;
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
//                System.out.println(chars[i]);
                if (chars[i] == 'a' || chars[i] == 'A')
                    numA++;
                if (chars[i] == 'e' || chars[i] == 'E')
                    numE++;
                if (chars[i] == 'i' || chars[i] == 'I')
                    numI++;
                if (chars[i] == 'o' || chars[i] == 'O')
                    numO++;
                if (chars[i] == 'u' || chars[i] == 'U')
                    numU++;
            }
            result = result.concat("Letter 'A' appears " + numA + " times\n");
            result = result.concat("Letter 'E' appears " + numE + " timen\n");
            result = result.concat("Letter 'I' appears " + numI + " times\n");
            result = result.concat("Letter 'O' appears " + numO + " times\n");
            result = result.concat("Letter 'U' appears " + numU + " times\n");
        } else if (type.equals("consonants")) {
            input = text;
            HashMap<String, Integer> consonants = new HashMap<>();
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 'a'
                        && chars[i] != 'A'
                        && chars[i] != 'e'
                        && chars[i] != 'E'
                        && chars[i] != 'i'
                        && chars[i] != 'I'
                        && chars[i] != 'o'
                        && chars[i] != 'O'
                        && chars[i] != 'u'
                        && chars[i] != 'U'
                ) {
                    String stringCharacter = String.valueOf(chars[i]).toUpperCase();
                    if (consonants.containsKey(stringCharacter)) {
                        Integer num = consonants.get(stringCharacter);
                        num++;
                        consonants.put(stringCharacter, num);
                    } else {
                        consonants.put(stringCharacter, 1);
                    }
                }
            }
            consonants.entrySet().forEach(entrySet -> {
                result = result.concat("Letter '" + entrySet.getKey() + "' appears " + entrySet.getValue() + " times\n");
            });
        }
        long stopTime = System.nanoTime();
        System.out.println(result);
        System.out.println("Time old: " + (stopTime - startTime) / 1000000);
        System.out.println("-------------------------------------------");
        return result;
    }
}
