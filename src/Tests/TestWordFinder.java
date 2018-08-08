import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestWordFinder {

    WordFinder fixture;

    @Before
    public void setUp() {
        fixture = new WordFinder("cab","testWords2.txt");
    }

    @After
    public void tearDown() {
        fixture = null;
    }

    @Test
    public void findWords(){
        Set<String> actualAnswer=fixture.getAnswers();
        Set<String> expectedAnswer=new HashSet<>();
        expectedAnswer.add("CAB");
        expectedAnswer.add("CABIN");
        expectedAnswer.add("SCAB");
        expectedAnswer.add("CRAB");
        assertEquals(expectedAnswer,actualAnswer);

    }
}
