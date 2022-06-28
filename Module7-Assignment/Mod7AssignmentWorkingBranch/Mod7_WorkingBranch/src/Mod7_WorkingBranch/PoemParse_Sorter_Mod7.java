package Mod7_WorkingBranch;

import java.io.*;
import java.util.*;

public class PoemParse_Sorter_Mod7 {

    // HashMap sorter method - input HashMap, output organized HashMap
    public static HashMap<String, Integer> mapSort(HashMap<String, Integer> map) {

        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> firstMap, Map.Entry<String, Integer> secondMap) {
                return (secondMap.getValue()).compareTo(firstMap.getValue());
            }
        });

        HashMap<String, Integer> populateMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : mapList) {
            populateMap.put(entry.getKey(), entry.getValue());
        }

        return populateMap;
    }

    // String freq and organizer method
    public static String mapToString(Map<String, Integer> inMap) {

        StringBuilder inBuilder = new StringBuilder();
        for (String key : inMap.keySet()) {
            inBuilder.append(key);
            inBuilder.append(" = ");
            inBuilder.append(inMap.get(key));
            inBuilder.append("\n");
        }

        return inBuilder.toString();
    }

    public static String[] stringSplitter(String stringToSplit) {
        String[] textArr = stringToSplit.split("[\\W\\s\\d*]+");
        return textArr;
    }

    public static HashMap<String, Integer> splitStringToMap(HashMap<String, Integer> wordMap, String text) {
        String[] textArr = stringSplitter(text);
        for (String w : textArr) {
            if (wordMap.containsKey(w)) {
                wordMap.put(w, wordMap.get(w) + 1);
            } else {
                wordMap.put(w, 1);
            }

        }

        return wordMap;
    }

    // Method to parse a txt file and populate a HashMap with its String contents
    public static HashMap<String, Integer> poemSorter(String path) {
        // this map will contain the words in the text and their frequency of occurence
        HashMap<String, Integer> wordMap = new HashMap<>();
        String text;
        String filePath = path;

        try {
            File poemFile = new File(filePath);
            BufferedReader poemBuffer = new BufferedReader(new FileReader(poemFile));

            // Populating the hashmap with the line Strings and their frequency
            while ((text = poemBuffer.readLine()) != null) {
                wordMap.putAll(splitStringToMap(wordMap, text));
            }
            wordMap.remove("");
            poemBuffer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Exception found: File not found");
            System.out.println("Please enter a valid file path");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception found: See your doctor.");
            e.printStackTrace();
        }
        return wordMap;
    }

    public static void main(String[] args) {

    }

}
