package dictionary;

import org.junit.Test;
import static org.junit.Assert.*;

public class TreeTest {
    
    @Test
    public void testInsert() {
        Tree tree = new Tree();
        tree.insert("dog", "perro");
        assertEquals("perro", tree.search("dog"));
    }
    
    @Test
    public void testSearch() {
        Tree tree = new Tree();
        tree.insert("dog", "perro");
        assertEquals("perro", tree.search("dog"));
        assertEquals(null, tree.search("cat"));
    }
}