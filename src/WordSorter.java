public class WordSorter {

    // make an array containing 26 sets
    private words = new array[];
    Scanner dict = null;

    private void importDictionary(){
        //import the dictionary, then call next method
        try
        {
            dict = new Scanner (new File (words_alpha.txt));
        }
        catch(FileNotFoundException e)
        {
            System.out.println ("Error opening the file " +
                    words_alpha.txt );
            System.exit (0);
        }
        dict.close ();
        getWord();//the document to read. each word is on a new line
    }

    private void getWord (){
        //go though dictionary putting words into the array
        //call method that goes though word and puts it into the array
        while (dict.hasNextLine){
            word = dict.nextLine.parseString();
            putWord(word);
        }
    }

    private void putWord(String word){
        //go through word letter by letter and put it into the array ASCII - 65 i think
        for(i = 0; i < word; i++ ){

        }
    }

    public array getArray{
        return words;
    }
}
