import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class WordFinder{


    private Set<String> answers;

    public WordFinder(String word, String fileName){
        findWords(word.toUpperCase(),fileName);
    }

    public Set<String> getAnswers(){
        return answers;
    }

    private void findWords(String word, String fileName) {
        WordSorter wordSort = new WordSorter(fileName);
        List<Set<String>> allWords=wordSort.getArray();
        answers=allWords.get(((int) word.charAt(0))-65);
        Set<String> s2=allWords.get(((int) word.charAt(1))-65);
        Set<String> s3=allWords.get(((int) word.charAt(2))-65);
        answers.retainAll(s2);
        answers.retainAll(s3);
    }
}



