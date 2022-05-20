// Write a text analyzer that reads a file and outputs statistics about that
// file.

// It should output the word frequencies of all words in the file, sorted by the
// most frequently used word.

// The output should be a set of pairs, each pair containing a word and how many
// times it occurred in the file.

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class PoemParse {

    public static void main(String[] args) throws Exception {

        // I was using an array list originally because I don't often
        // work with hashmaps, or java in general, but was suggested it
        // Hashmap seems like the perfect solution for the set of pairs
        // output, key value style
        HashMap<String, Integer> wordMap = new HashMap<>();
        String text;

        try {

            // The scanner did not want to print the file but DID take in the file
            // so I used a buffered reader, which seems to work better,
            // because I suck at troubleshooting
            File poemFile = new File("testFile.txt");
            BufferedReader poemBuffer = new BufferedReader(new FileReader(poemFile));

            // This loop would populate the hashmap if I knew how to code
            while ((text = poemBuffer.readLine()) != null) {
                String[] textArr = text.split("(\\W+\\s+)");

                for (String w : textArr) {
                    if (wordMap.containsKey(w)) {
                        wordMap.put(w, wordMap.get(w) + 1);
                    } else {
                        wordMap.put(w, wordMap.get(w));
                    }

                }
            }

            for (Map.Entry<String, Integer> w : wordMap.entrySet()) {
                System.out.println(w.getKey() + " " + w.getValue());
            }

            poemBuffer.close();
        } catch (Exception e) {
            System.out.println("Something isn't groovy");
            e.printStackTrace();
        }
    }
}