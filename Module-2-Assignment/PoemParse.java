// Write a text analyzer that reads a file and outputs statistics about that
// file.

// It should output the word frequencies of all words in the file, sorted by the
// most frequently used word.

// The output should be a set of pairs, each pair containing a word and how many
// times it occurred in the file.

import java.io.*;
import java.util.*;

class PoemParse {

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

    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> wordMap = new HashMap<>();
        String text;

        try {
            File poemFile = new File("poem.txt");
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
            Map<String, Integer> sortedMap = mapSort(wordMap);

            // Prints out the map keys and their frequency
            int counter = 0;
            for (Map.Entry<String, Integer> w : sortedMap.entrySet()) {
                System.out.println("Key: " + w.getKey() + " :: Value: " + w.getValue());
                counter++;
                if (counter == 20)
                    System.out.println("---^ 20th String ^---");
            }

            poemBuffer.close();
        } catch (Exception e) {
            System.out.println("Something isn't groovy");
            e.printStackTrace();
        }

    }
}
