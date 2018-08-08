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
        List<Set<String>> allWords = wordSort.getArray();
        answers = allWords.get(((int) word.charAt(0)) - 65);
        for (int i = 1; i < word.length(); i++) {
            answers.retainAll(allWords.get(((int) word.charAt(i)) - 65));
        }


        Iterator<String> iterator = answers.iterator();
        Set<String> answers2=new HashSet<>();
        while (iterator.hasNext()) {
            String current = iterator.next();
            for(int i=0;i<word.length()-1;i++){
                if (current.indexOf(word.charAt(i)) > current.indexOf(word.charAt(i+1))) {
                    answers2.add(current);
                }

            }
        }
        answers.removeAll(answers2);
    }
}



