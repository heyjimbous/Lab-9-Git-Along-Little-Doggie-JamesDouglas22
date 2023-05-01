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
    CoolCollection<String> stringCollection = new CoolCollection<String>(true);
    stringCollection.add("never");
    stringCollection.add("trust");
    stringCollection.add("an");
    stringCollection.add("atom");
    stringCollection.add("they");
    stringCollection.add("make");
    stringCollection.add("up");
    stringCollection.add("everything");

    Iterator<String> itr = stringCollection.iterator();

    while (itr.hasNext()) {
      System.out.printf("%s ", itr.next());
    }
  }
}