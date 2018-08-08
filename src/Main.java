import java.io.*;
import java.util.*;

public class Main {

    public void main(){
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        WordFinder user=new WordFinder(word, "words_alpha.txt");
    }

}
