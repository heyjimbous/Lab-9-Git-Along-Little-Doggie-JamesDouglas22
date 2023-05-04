package gitalong;

import java.util.ArrayList;
import java.util.*;

/**
* Name: James Douglas
* Date: 5/3/2023
* Description: CoolCollection class; a wrapper class for ArrayList that contains two
* inner class iterators.
* Bugs: None known.
* Reflection: I found this lab to quite easy. I did have minor issues creating the inner
* classes, but my problems were resolved after a brief review of Generics.
*
* The CoolCollection wrapper class was surprisingly easy to construct. I would have struggled 
* more if there was no UML diagram provided, but I'm definitely not complaining.
*/

public class CoolCollection<E> implements Iterable<E> {
  private ArrayList<E> pieces;
  private boolean iterateRandomly;

  /**
  * Constructor for CoolCollection
  * 
  * @param iterateRandomly boolean that determines whether a RandomIterator should be used
  */
  public CoolCollection(boolean iterateRandomly) {
    this.iterateRandomly = iterateRandomly;
    pieces = new ArrayList<E>();
  }

  /**
  * Adds an element to the collection.
  *
  * @param element item of type E to add to the collection
  * @return boolean that is set to true if the item was
  * successfully added, or false if not.
  */
  public boolean add(E element) {
    return pieces.add(element);
  }

  /**
  * Add an element to the collection at a specified index.
  *
  * @param pos int that contains the index to place the item
  * @param element item of type E to add to the collection
  */
  public void add(int pos, E element) {
    pieces.add(pos, element);
  }

  /**
  * Removes an element from the collection.
  *
  * @param element item of type E to remove from the collection
  */
  public void remove(E element) {
    pieces.remove(element);
  }

  /**
  * Remove element from collection at a specified index.
  *
  * @param pos int that contains the index to remove the item
  * @return item of type E that was removed from the collection
  */
  public E remove(int pos) {
    return pieces.remove(pos);
  }

  /**
  * Returns either a RandomIterator or a WellBehavedIterator, 
  * depending on iterateRandomly's value.
  *
  * @return Iterator of type E; either a RandomIterator or WellBehavedIterator
  */
  public Iterator<E> iterator() {
    if (iterateRandomly) {
      return new RandomIterator(1234567);
    } else {
      return new WellBehavedIterator();
    }
  }

  /**
  * Returns the size of the collection.
  *
  * @return int that contains the size of the collection.
  */
  public int size() {
    return pieces.size();
  }

  /**
  * Description: An iterator that visits elements randomly.
  * Reflection: This was a simple class to implement. Once I figured out
  * how to store previously generated integers, I faced next to no issues.
  */
  public class RandomIterator implements Iterator<E> {
    Random rand = new Random();
    ArrayList<Integer> generatedInts = new ArrayList<Integer>();

    /**
    * Constructor for RandomIterator
    * 
    * @param seed int that contains a seed for the Random object.
    */
    public RandomIterator(int seed) {
      rand.setSeed(seed);
    }

    /**
    * Visits the next element, and returns that element.
    * Returns null if no next element exists. 
    *
    * @return element of type E
    */
    public E next() {
      
      // Generates a random integer
      int currentInt = rand.nextInt(pieces.size());

      // Generates a new random integer if last integer has been used before
      if (hasNext()) {
        while (generatedInts.contains(currentInt)) {
          currentInt = rand.nextInt(pieces.size());
        }
      } else {
        return null;
      }

      // Add record of int
      generatedInts.add(currentInt);
      
      // Return the item
      return pieces.get(currentInt);
    }

    /**
    * Returns true if the next element can be accessed, 
    * otherwise returns false.
    *
    * @return boolean that represents if the element can be accessed.
    */
    public boolean hasNext() {
      return generatedInts.size() < pieces.size();
    }

  }

  /**
  * Description: An iterator that visits elements in order.
  * Reflection: I found this class to be simple to implement as well, 
  * even simpler than RandomIterator. Creating a cursor to track the next
  * element was a breeze. Honestly, I'm a bit worried about how confident
  * I am in this lab in general; it doesn't feel right.
  */
  public class WellBehavedIterator implements Iterator<E> {
    
    // Keeps track of the next index
    int cursor;

    /**
    * Constructor for WellBehavedIterator
    */
    public WellBehavedIterator() {
      cursor = 0;
    }

    /**
    * Visits the next element, and returns that element.
    * Returns null if no next element exists. 
    *
    * @return element of type E
    */
    public E next() {
      
      try {

        // Get the item at cursor, increment cursor
        E item = pieces.get(cursor);
        cursor++;
        
        return item;
        
      } catch (IndexOutOfBoundsException ioobe) {

        // piece.get(cursor) has failed, return null
        return null;
        
      }
      
    }

    /**
    * Returns true if the next element can be accessed, 
    * otherwise returns false.
    *
    * @return boolean that represents if the element can be accessed.
    */
    public boolean hasNext() {
      return cursor < pieces.size();
    }
    
  }

  
}