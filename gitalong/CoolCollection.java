package gitalong;

import java.util.ArrayList;

public class CoolCollection<E> {
  private ArrayList<E> pieces;
  private boolean iterateRandomly;

  public CoolCollection(boolean iterateRandomly) {
    
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


  
}