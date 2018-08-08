import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class WordFinder{


    //will hold the output of the program - words with the three letters (from user input) in order
    private Set<String> answers;

    //constructor
    public WordFinder(String word, String fileName){
        findWords(word.toUpperCase(),fileName);
    }

    //getter
    public Set<String> getAnswers(){
        return answers;
    }


    private void findWords(String word, String fileName) {
        for (int i = 0; i < word.length(); i++) {
            word=word.toUpperCase();
            int temp =(int) word.charAt(i);
            if(temp<65 || temp>90 || word.length()>3){
                throw new IllegalArgumentException("invalid input");
            }
        }
        WordSorter wordSort = new WordSorter(fileName);
        List<Set<String>> allWords = wordSort.getArray();
        answers = allWords.get(((int) word.charAt(0)) - 65);
        //takes intersection of three sets to produce set of words with three letters in user input
        // (not in desired order yet)
        for (int i = 1; i < word.length(); i++) {
            answers.retainAll(allWords.get(((int) word.charAt(i)) - 65));
        }

        //iterates over set produced above to produce another set with words that
        // don't have the three letters in desired order
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

        //removes what's in set 2 from set 1 so that set 1 only has words with letters in desired order
        answers.removeAll(answers2);
    }
}



