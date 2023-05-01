package gitalong;

public class CoolCollection<E> {
  private ArrayList<E> pieces;
  private boolean iterateRandomly;

  public CoolCollection(boolean iterateRandomly) {
    
  }

  // Add an element to the collection
  public boolean add(E element) {
    return pieces.add(element);
  }


  
}