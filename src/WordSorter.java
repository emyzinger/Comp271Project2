import java.io.*;
import java.util.*;

public class WordSorter {

    // make an array containing 26 sets
    private List<Set<String>> words = new ArrayList<>();
    Scanner dict = null;

    public WordSorter(String fileName){
        //will be called from WordFiner
        init();
        importDictionary(fileName);
    }

    private void init(){
        //makes the array have 26 elements
        for (int i = 0; i<26; i++){
            words.add(new HashSet<>());
        }
    }

    private void importDictionary(String fileName){
        //import the dictionary, then call next method
        // Code in this method taken from internet and edited
        //https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                line = line.toUpperCase();
                putWord(line);
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    private void putWord(String word){
        //go through word letter by letter and put it into the array ASCII - 65
        for(int i = 0; i < word.length(); i++ ){
           char letter =  word.charAt(i);
           int ascii = (int) letter;
           int index = ascii - 65;
           words.get(index).add(word);
        }
    }

    public List<Set<String>> getArray(){
        return words;
    }
}
