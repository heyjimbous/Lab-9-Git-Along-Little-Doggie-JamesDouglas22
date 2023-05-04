import gitalong.*;
import java.util.*;

/**
* Name: James Douglas
* Date: 5/3/2023
* Description: Main class; tests the CoolCollection wrapper class and the iterators within it.
* Bugs: None known.
* Reflection: I found this lab to quite easy. I did have minor issues creating the inner
* classes, but my problems were resolved after a brief review of Generics.
*
* Main was easy to construct. I may have overcomplicated things slightly with the convenience methods I
* created, but I prefer there to be as little code as possible in the main method.
*/

class Main {
  public static void main(String[] args) {

    final String phrase = "never trust an atom, they make up everything";
    
    // Test the random iterator
    testIterator(true, phrase, "Random");

    // Test the well behaved iterator
    testIterator(false, phrase, "Well Behaved");

    System.out.printf("\n");

  }

  /**
  * Tests an iterator on a CoolCollection of Strings.
  * 
  * @param random boolean that determines if the CoolCollection should use a randomIterator
  * @param phrase String that contains the phrase to process
  * @param title String that contains a title for the output line
  */
  public static void testIterator(boolean random, String phrase, String title) {
    
    // Create a CoolCollection, adds words from phrase
    CoolCollection<String> stringCollection = new CoolCollection<String>(random);
    addPhrase(phrase, stringCollection);

    // Create an iterator, print words using iterator
    Iterator<String> itr = stringCollection.iterator();
    printUsingIterator(title, itr);
    
  }

  /**
  * Splits a phrase into words, then adds them to a collection.
  *
  * @param phrase String containing a phrase to split into words
  * @param collection CoolCollection to add words to
  */
  public static void addPhrase(String phrase, CoolCollection collection) {
    String[] splitPhrase = phrase.split(" ");
    for (int i = 0; i < splitPhrase.length; i++) {
      collection.add(splitPhrase[i]);
    }
  }

  /**
  * Prints a line of words in a manner that matches the sample output.
  *
  * @param title String containing a title for the line of output.
  * @param itr Iterator to use to iterate through the collection
  */
  public static void printUsingIterator(String title, Iterator itr) {
    
    // Add title
    System.out.printf("\n%s: ", title);

    // Loop through collection, print out words
    while (itr.hasNext()) {
      System.out.printf("%s ", itr.next());
    }
    System.out.printf("\n");
    
  }
}