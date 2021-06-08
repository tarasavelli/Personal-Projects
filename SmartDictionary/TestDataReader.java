import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestDataReader {
  
  public static void main(String[] args) throws FileNotFoundException, IOException {
    List<Word> allWords = DictionaryDataReader.readFile("/Users/teddyarasavelli/eclipse-workspace/Red Black Tree Project 2 CS400/FinalDictionary.txt");
    
    int i = 0;
    for(Word word : allWords) {
      if(i < 10)
        System.out.println(word.getOrigin());
      
      i++;
    }
    
    RedBlackTree<Word> testTree = new RedBlackTree<Word>();
    
    
    
    
    
  }

}
