package WordOccurrences;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Test;

public class ParserTestCases {

    public static HashMap<String, Integer> mapGen() {
        HashMap<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("lemon", 2);
        testMap.put("argyle", 60);
        testMap.put("goose", 15);
        testMap.put("water", 5);
        testMap.put("jester", 10);

        return testMap;
    }

    @Test
    public void mapSort_ReturnsValidHashMap() throws Exception {
        var testMap = new HashMap<String, Integer>(mapGen());
        assertNotNull(PoemParse_Sorter.mapSort(testMap));
    }

    @Test
    public void mapToString_FormatsString() throws Exception {
        var testMap = new HashMap<String, Integer>(mapGen());
        assertNotNull(PoemParse_Sorter.mapToString(testMap));
    }

}
