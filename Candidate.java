import java.util.ArrayList;

class Candidate {
  ArrayList<Integer> candidates;
  int counter = -1;

  public Candidate() {
    candidates = new ArrayList<Integer>();
  }

  public int getCandidate() {
    ++counter;
    if(counter >= candidates.size()) return -1;
    return candidates.get(counter);
  }

  public boolean resetCounter() {
    counter = -1;
    return true;
  }

  public boolean addCandidate(final int t) {
    candidates.add(t);
    return true;
  }
}
