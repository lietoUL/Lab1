package guiex;

import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void test() {
        text tes = new text();
        String rel;
        rel = tes.queryBridgeWords("to","and");
        assertEquals("No bridge words from \"and\" to \"to\"!",rel);
    }
}
