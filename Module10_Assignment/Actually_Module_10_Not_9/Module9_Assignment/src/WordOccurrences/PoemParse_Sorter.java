package WordOccurrences;

import java.io.*;
import java.util.*;

/**
 * Sorts txt file word contents then prints the strings and their frequencies
 * 
 * @author Daniel Reecy
 * @version Module 9
 */
public class PoemParse_Sorter {

    /**
     * sorts a given hashMap in descending order
     * does not alter input map
     * 
     * @param map the map to sort
     * @return sorted hashmap
     */
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
     * Takes in a HashMap and returns the contents as a String with formatting.
     * 
     * @param inMap HashMap with contents to be converted to a formatted string.
     * @return The contents of a HashMap converted to a formatted String.
     */
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

    /**
     * Regex to remove punctuation, whitespace, and numbers. Characters only.
     * 
     * @param stringToSplit
     * @return Only String characters. No punctuation or numbers.
     */
    public static String[] stringSplitter(String stringToSplit) {
        String[] textArr = stringToSplit.split("[\\W\\s\\d*]+");
        return textArr;
    }

    /**
     * Populated a HashMap with all the Strings in a String[] array.
     * String = key.
     * Frequency of occurence = value.
     * 
     * @deprecated This method will not be used in the Module 10 database
     *             implementation
     * @param wordMap Empty HashMap that will contain the file contents
     * @param text    File String contents, Strings only.
     * @return Populated HashMap containing file contents, Strings only.
     */
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

    /**
     * Parses a txt file for all Strings. Initialized the parsed contents to a
     * HashMap with String:Frequency pairs.
     * 
     * @param path File path for a txt file containing text to be parsed
     * @return A HashMap containing all the Strings in the file, organized
     *         descending by frequency.
     * @throws FileNotFoundException
     */
    /*
     * public static HashMap<String, Integer> poemSorter(String path) {
     * // this map will contain the words in the text and their frequency of
     * occurence
     * HashMap<String, Integer> wordMap = new HashMap<>();
     * String text;
     * String filePath = path;
     * 
     * try {
     * File poemFile = new File(filePath);
     * BufferedReader poemBuffer = new BufferedReader(new FileReader(poemFile));
     * String[] line = null;
     * // Populating the hashmap with the line Strings and their frequency
     * while ((text = poemBuffer.readLine()) != null) {
     * // old version: uses a hashmap
     * // wordMap.putAll(splitStringToMap(wordMap, text));
     * 
     * // new version: uses a database
     * line = stringSplitter(text);
     * for (String w : line)
     * database_controller.insertWord(w);
     * 
     * }
     * // wordMap.remove("");
     * poemBuffer.close();
     * 
     * } catch (FileNotFoundException e) {
     * System.out.println("Exception found: File not found");
     * System.out.println("Please enter a valid file path");
     * e.printStackTrace();
     * } catch (Exception e) {
     * System.out.println("Exception found: See your doctor.");
     * e.printStackTrace();
     * }
     * return wordMap;
     * }
     */

    // copy to edit of ^above^ method
    /**
     * inserts the file contents into the database as Strings
     * frequency increments on duplicate keys
     * 
     * @param path poem file path
     */
    public static void poemSorter(String path) {
        // this map will contain the words in the text and their frequency of occurence
        String text;
        String filePath = path;

        try {
            File poemFile = new File(filePath);
            BufferedReader poemBuffer = new BufferedReader(new FileReader(poemFile));
            String[] line = null;

            // Populating the hashmap with the line Strings and their frequency
            while ((text = poemBuffer.readLine()) != null) {
                line = stringSplitter(text);
                for (String w : line)
                    database_controller.insertWord(w);

            }

            poemBuffer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Exception found: File not found");
            System.out.println("Please enter a valid file path");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception found: See your doctor.");
            e.printStackTrace();
        }
    }

}
