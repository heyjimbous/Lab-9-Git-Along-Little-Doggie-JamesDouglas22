import gitalong.*;
import java.util.*;
/**
*
* Name: James Douglas
* Date: 4/28/2023
* Description: Main class!
* Bugs: (if none write none known)
* Reflection: How did you find this lab? Too easy? Too hard? 
*
*/

class Main {
  public static void main(String[] args) {

    final String phrase = "never trust an atom, they make up everything";
    
    // Test the random iterator
    testIterator(true, phrase, "Random");

    // Test the well behaved iterator
    //testIterator(false, phrase, "Well Behaved");

  }

  // Tests an iterator on a CoolCollection of Strings.
  public static void testIterator(boolean random, String phrase, String title) {
    
    // Create a CoolCollection, adds words from phrase
    CoolCollection<String> stringCollection = new CoolCollection<String>(random);
    addPhrase(phrase, stringCollection);

    // Create an iterator, print words using iterator
    Iterator<String> itr = stringCollection.iterator();
    printUsingIterator(title, itr);
    
  }

  // Splits a phrase into words, then adds them to a collection.
  public static void addPhrase(String phrase, CoolCollection col) {
    String[] splitPhrase = phrase.split(" ");
    for (int i = 0; i < splitPhrase.length; i++) {
      col.add(splitPhrase[i]);
    }
  }

  // Prints words in a manner that matches the sample output.
  public static void printUsingIterator(String title, Iterator itr) {
    
    // Add title
    System.out.printf("\n%s: ", title);

    // Loop through collection, print out words
    while (itr.hasNext()) {
      System.out.printf("%s ", itr.next());
    }
    System.out.printf("%s ", itr.next());
    System.out.printf("\n");
    
  }
}