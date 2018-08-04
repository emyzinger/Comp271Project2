import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestWordSorted {

    WordSorter fixture;

    @Before
    public void setUp() {
        fixture = new WordSorter("testWords.txt");
    }

    @After
    public void tearDown() {
        fixture = null;
    }

    @Test
    public void testGetArray(){
        List<Set<String>> list = fixture.getArray();
        List<Set<String>> listExpected = new ArrayList<>();
        for (int i = 0; i<26; i++){
            listExpected.add(new HashSet<>());
        }
        listExpected.get('H'-65).add("HI");
        listExpected.get('I'-65).add("HI");
        listExpected.get('H'-65).add("HOW");
        listExpected.get('O'-65).add("HOW");
        listExpected.get('W'-65).add("HOW");
        listExpected.get('A'-65).add("ARE");
        listExpected.get('R'-65).add("ARE");
        listExpected.get('E'-65).add("ARE");
        listExpected.get('U'-65).add("U");

        assertEquals(listExpected, list);
    }


}
