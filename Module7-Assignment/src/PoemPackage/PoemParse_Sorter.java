
package PoemPackage;

import java.io.*;
import java.util.*;

public class PoemParse_Sorter {

    // Method takes in a HashMap, sorts it to a new HashMap,
    // then returns that sorted map
    // TEST HERE
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

    /*
     * Return method
     * to take in a txt file, then return a String filled
     * with the contents of a sorted HashMap containing each
     * individual word in the file and their frequencies
     * !--> call this method inside the controller <--!
     */
    public static String fileFreqSort(String path) throws Exception {

        // this map will contain the words in the text and their frequency of occurence
        // word frequency is counted at the same time as the word is added to the map
        HashMap<String, Integer> wordMap = new HashMap<>();
        String text;

        // file path containing the txt file (poem) to be sorted
        // should be called from the controller class
        String filePath = path;

        // TEST HERE
        // use different types of input and input sizes
        // use an empty file and use a wrong file path
        try {
            File poemFile = new File(filePath);

            BufferedReader poemBuffer = new BufferedReader(new FileReader(poemFile));

            // Populating the hashmap with the line Strings and their frequency
            while ((text = poemBuffer.readLine()) != null) {

                // TEST HERE POSSIBLY
                String[] textArr = text.split("[\\W\\s]+");
                for (String w : textArr) {
                    if (wordMap.containsKey(w)) {
                        wordMap.put(w, wordMap.get(w) + 1);
                    } else
                        wordMap.put(w, 1);
                }
            }

            wordMap.remove("");
            poemBuffer.close();
        } catch (Exception e) { // add additional catch blocks for different exceptions in testing. Update
                                // message.
            System.out.println("Something isn't groovy");
            e.printStackTrace();
        }
        // end try catch

        // converting the contents of the sorted map to a StringBuilder
        // to then return that StringBuilder as a String.
        // Probably a much easier way to do this but NO.
        Map<String, Integer> sortedMap = mapSort(wordMap);
        StringBuilder mapAsString = new StringBuilder();

        // TEST HERE POSSIBLY
        for (String key : sortedMap.keySet()) {
            mapAsString.append(key);
            mapAsString.append(" = ");
            mapAsString.append(sortedMap.get(key));
            mapAsString.append("\n");
        }

        return mapAsString.toString();
    }
}
