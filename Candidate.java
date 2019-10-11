import java.util.ArrayList;

/**
* Represents the candidates for an empty cell in a Sudoku puzzle
*/
class Candidate {
  /**
  * Store candidates in corresponding data structure
  */
  ArrayList<Integer> candidates;

  /**
  * Counter points to candidate in data structure
  */
  int counter = -1;

  public Candidate() {
    candidates = new ArrayList<Integer>();
  }

  /**
  * Return candidate and increment counter to point to next candidate
  */
  public int getCandidate() {
    ++counter;
    if(counter >= candidates.size()) return -1;
    return candidates.get(counter);
  }

  /**
  * Function resets counter to point to first candidate
  */
  public boolean resetCounter() {
    counter = -1;
    return true;
  }

  /**
  * Function adds candidate to data stucture
  */
  public boolean addCandidate(final int t) {
    candidates.add(t);
    return true;
  }
}
