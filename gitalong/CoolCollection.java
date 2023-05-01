package gitalong;

import java.util.ArrayList;
import java.util.*;

public class CoolCollection<E> {
  private ArrayList<E> pieces;
  private boolean iterateRandomly;

  public CoolCollection(boolean iterateRandomly) {
    this.iterateRandomly = iterateRandomly;
  }

  // Add an element to the collection
  public boolean add(E element) {
    return pieces.add(element);
  }

  // Add an element to the collection at a specified index
  public void add(int pos, E element) {
    pieces.add(pos, element);
  }

  // Removes an element from the collection
  public void remove(E element) {
    pieces.remove(element);
  }

  // Remove element from collection at a specified index
  public E remove(int pos) {
    return pieces.remove(pos);
  }

  // Returns Random or WellBehavedIterator, depending on
  // IterateRandomly
  public Iterator<E> iterator() {
    if (iterateRandomly) {
      RandomIterator itr = new RandomIterator(12345);
      return itr;
    } else {
      WellBehavedIterator itr = new WellBehavedIterator();
      return itr;
    }
  }

  // Returns the size of the collection
  public int size() {
    return pieces.size();
  }

  // Inner classes
  public class RandomIterator implements Iterator<E> {
    Random rand = new Random();
    ArrayList<Integer> generatedInts = new ArrayList<Integer>();

    public RandomIterator(int seed) {
      rand.setSeed(seed);
    }

    // Returns the next element.
    public E next() {
      
      // Generates a random integer
      int currentInt = rand.nextInt(pieces.size() - 1);

      // Generates a new random integer if last integer has been used before
      while (generatedInts.contains(currentInt)) {
        currentInt = rand.nextInt(pieces.size() - 1);
      }
      generatedInts.add(currentInt); // Add integer to generated list

      // Return the item
      return pieces.get(currentInt);
    }

    // Returns true if another element can be returned, else false.
    public boolean hasNext() {
      return generatedInts.size() < pieces.size();
    }

  }

  // An iterator that visits elements in order.
  public class WellBehavedIterator implements Iterator<E> {
    
    // Keeps track of the next index
    int nextIndex;
    
    public WellBehavedIterator() {
      nextIndex = 0;
    }

    public E next() {
      E item = pieces.get(nextIndex);
      nextIndex++;
      return item;
    }

    public boolean hasNext() {
      return nextIndex >= pieces.size();
    }
    
  }

  
}