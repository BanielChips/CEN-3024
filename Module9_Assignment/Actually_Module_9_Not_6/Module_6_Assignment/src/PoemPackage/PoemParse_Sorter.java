
package PoemPackage;

import java.io.*;
import java.util.*;

/**
 * Logic class to handle the parse, sort, and print.
 * Launch file is PoemParseFX.java.
 * 
 * @author Daniel Reecy
 * @version 4 - Module 9
 */
public class PoemParse_Sorter {
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

    /**
     * Takes in a specified file path of a txt file,
     * parses the file contents for String characters
     * only. The parse output is organized and then
     * formatted. Returns the file contents as a String.
     * 
     * @param path File path of poem txt.
     * @return String contents of file.
     *         Contents are sorted and printed descending
     *         in order of frequency of occurrence
     * @throws Exception
     */
    public static String fileFreqSort(String path) throws Exception {

        // this map will contain the words in the text and their frequency of occurence
        HashMap<String, Integer> wordMap = new HashMap<>();
        String text;

        // file path containing the txt file (poem) to be sorted
        // should be called from the controller class
        String filePath = path;

        try {
            File poemFile = new File(filePath);
            BufferedReader poemBuffer = new BufferedReader(new FileReader(poemFile));

            // Populating the hashmap with the line Strings and their frequency
            while ((text = poemBuffer.readLine()) != null) {

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
        } catch (Exception e) {
            System.out.println("Something isn't groovy");
            e.printStackTrace();
        }

        // converting the contents of the sorted map to StringBuilder for return call.
        Map<String, Integer> sortedMap = mapSort(wordMap);
        StringBuilder mapAsString = new StringBuilder();
        for (String key : sortedMap.keySet()) {
            mapAsString.append(key);
            mapAsString.append(" = ");
            mapAsString.append(sortedMap.get(key));
            mapAsString.append("\n");
        }

        return mapAsString.toString();
    }
}
