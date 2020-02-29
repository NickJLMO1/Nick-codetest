import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFinderTest {


    List<String> customizeWords = Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man go","mango");
    List<String>  words = Arrays.asList("i", "like", "sam", "sung","samsung", "mobile","ice","cream" ,"man go");
    Dictionary d = new Dictionary();


    WordFinder wf = new WordFinder();


    @BeforeEach
    void setUp() {
        d.setCustomizeWords(customizeWords);
        d.setWords(words);
    }

    @AfterEach
    void tearDown() {
        System.out.println("===========Finish Test==================");
    }

    @Test
    void findWords() {
        String input = "ilikesamsungmobile";
        //Stage 1

        d.setMode(1);
        List<String>  result = wf.findWords(input,d);
        String stage1Result1 = "i like sam sung mobile";
        String stage1Result2 = "i like samsung mobile";
        HashMap<String,String> resultHs = new HashMap<String, String>();
        resultHs.put(stage1Result1, stage1Result1);
        resultHs.put(stage1Result2,stage1Result2);
        for(String s : result){
            assertTrue(resultHs.containsKey(s.trim()));
        }

        //Stage 2
        d.setMode(2);
        result = wf.findWords(input,d);
        String stage2Result1 = "i like sam sung mobile";
        resultHs = new HashMap<String, String>();
        resultHs.put(stage2Result1, stage2Result1);
        for(String s : result){
            assertTrue(resultHs.containsKey(s.trim()));
        }

        //Stage3
        d.setMode(3);
        input = "ilikeicecreamandgo";
        result = wf.findWords(input,d);
        String stage3Result1 = input+" is not a valid sentence!";
        resultHs = new HashMap<String, String>();
        resultHs.put(stage3Result1, stage3Result1);
        for(String s : result){
            assertTrue(resultHs.containsKey(s.trim()));
        }
    }
}