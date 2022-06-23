package PoemPackage;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParseTesting {

    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        // message = "A different message";
        assertEquals(message, messageUtil.printMessage());
    }
}
