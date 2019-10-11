import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
* Represents the Sudoku solver
* Fills in empty cells in a Sudoku puzzle
*/
class Sudoku {

  public static void main(final String[] args) {

    /**
    * First puzzle, zeros represent empty cells
    */
    final int[][] map = {
      {4, 0, 5, 8, 7, 0, 3, 9, 1},
      {8, 9, 2, 1, 0, 6, 5, 4, 7},
      {0, 1, 0, 4, 0, 5, 6, 0, 8},
      {0, 4, 1, 6, 5, 8, 0, 3, 9},
      {3, 0, 6, 0, 4, 0, 2, 1, 0},
      {5, 7, 9, 2, 1, 3, 8, 6, 0},
      {9, 0, 7, 0, 8, 4, 0, 5, 6},
      {1, 3, 0, 5, 0, 9, 4, 7, 2},
      {0, 0, 4, 0, 2, 1, 0, 8, 3}
    };

    /**
    * Puzzle of medium diffculty
    */
    final int[][] medium = {
      {6, 5, 9, 0, 1, 0, 2, 8, 0},
      {1, 0, 0, 0, 5, 0, 0, 3, 0},
      {2, 0, 0, 8, 0, 0, 0, 1, 0},
      {0, 0, 0, 1, 3, 5, 0, 7, 0},
      {8, 0, 0, 9, 0, 0, 0, 0, 2},
      {0, 0, 3, 0, 7, 8, 6, 4, 0},
      {3, 0, 2, 0, 0, 9, 0, 0, 4},
      {0, 0, 0, 0, 0, 1, 8, 0, 0},
      {0, 0, 8, 7, 6, 0, 0, 0, 0}
    };

    /**
    * Answer for puzzle of medium diffculty
    */
    final int[][] mediumAnswer = {
      {6, 5, 9, 3, 1, 4, 2, 8, 7},
      {1, 8, 7, 6, 5, 2, 4, 3, 9},
      {2, 3, 4, 8, 9, 7, 5, 1, 6},
      {4, 2, 6, 1, 3, 5, 9, 7, 8},
      {8, 7, 1, 9, 4, 6, 3, 5, 2},
      {5, 9, 3, 2, 7, 8, 6, 4, 1},
      {3, 1, 2, 5, 8, 9, 7, 6, 4},
      {7, 6, 5, 4, 2, 1, 8, 9, 3},
      {9, 4, 8, 7, 6, 3, 1, 2, 5}
    };

    /**
    * Compute the results for the puzzle of medium difficulty
    * Then assert its correctness against answer
    */
    computeResults(medium);
    for(int i = 0; i < medium.length; ++i) {
      for(int j = 0; j < medium[i].length; ++j) {
        assert(medium[i][j] == mediumAnswer[i][j]);
      }
    }

    /**
    * Puzzle of hard diffculty
    */
    final int[][] hard = {
      {0, 0, 0, 0, 0, 0, 0, 0, 2},
      {0, 0, 0, 0, 0, 0, 9, 4, 0},
      {0, 0, 3, 0, 0, 0, 0, 0, 5},
      {0, 9, 2, 3, 0, 5, 0, 7, 4},
      {8, 4, 0, 0, 0, 0, 0, 0, 0},
      {0, 6, 7, 0, 9, 8, 0, 0, 0},
      {0, 0, 0, 7, 0, 6, 0, 0, 0},
      {0, 0, 0, 9, 0, 0, 0, 2, 0},
      {4, 0, 8, 5, 0, 0, 3, 6, 0}
    };

    /**
    * Answer for puzzle of hard diffculty
    */
    final int[][] hardAnswer = {
      {6, 8, 4, 1, 5, 9, 7, 3, 2},
      {7, 5, 1, 8, 3, 2, 9, 4, 6},
      {9, 2, 3, 6, 7, 4, 1, 8, 5},
      {1, 9, 2, 3, 6, 5, 8, 7, 4},
      {8, 4, 5, 2, 1, 7, 6, 9, 3},
      {3, 6, 7, 4, 9, 8, 2, 5, 1},
      {2, 3, 9, 7, 4, 6, 5, 1, 8},
      {5, 1, 6, 9, 8, 3, 4, 2, 7},
      {4, 7, 8, 5, 2, 1, 3, 6, 9}
    };

    /**
    * Compute the results for the puzzle of hard difficulty
    * Then assert its correctness against answer
    */
    computeResults(hard);
    for(int i = 0; i < hard.length; ++i) {
      for(int j = 0; j < hard[i].length; ++j) {
        assert(hard[i][j] == hardAnswer[i][j]);
      }
    }

    /**
    * Assert functions existsInGrid, existsInRow & existsInColumn are correct
    */

    //Test cases for grid 1
    for(int i = 0; i < 3; ++i) {
      for(int j = 0; j < 3; ++j) {
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 9, map) == true);
        assert(existsInGrid(i, j, 2, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 3, map) == false);
        assert(existsInGrid(i, j, 6, map) == false);
        assert(existsInGrid(i, j, 7, map) == false);
      }
    }

    //Test cases for grid 4
    for(int i = 3; i < 6; ++i) {
      for(int j = 0; j < 3; ++j) {
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 3, map) == true);
        assert(existsInGrid(i, j, 6, map) == true);
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 7, map) == true);
        assert(existsInGrid(i, j, 9, map) == true);
        assert(existsInGrid(i, j, 2, map) == false);
        assert(existsInGrid(i, j, 8, map) == false);
      }
    }

    //Test cases for grid 7
    for(int i = 6; i < 9; ++i) {
      for(int j = 0; j < 3; ++j) {
        assert(existsInGrid(i, j, 9, map) == true);
        assert(existsInGrid(i, j, 7, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 3, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 2, map) == false);
        assert(existsInGrid(i, j, 5, map) == false);
        assert(existsInGrid(i, j, 6, map) == false);
        assert(existsInGrid(i, j, 8, map) == false);
      }
    }

    //Test cases for grid 2
    for(int i = 0; i < 3; ++i) {
      for(int j = 3; j < 6; ++j) {
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 7, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 6, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 2, map) == false);
        assert(existsInGrid(i, j, 3, map) == false);
        assert(existsInGrid(i, j, 9, map) == false);
      }
    }

    //Test cases for grid 5
    for(int i = 3; i < 6; ++i) {
      for(int j = 3; j < 6; ++j) {
        assert(existsInGrid(i, j, 6, map) == true);
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 2, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 3, map) == true);
        assert(existsInGrid(i, j, 7, map) == false);
        assert(existsInGrid(i, j, 9, map) == false);
      }
    }

    //Test cases for grid 8
    for(int i = 6; i < 9; ++i) {
      for(int j = 3; j < 6; ++j) {
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 9, map) == true);
        assert(existsInGrid(i, j, 2, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 3, map) == false);
        assert(existsInGrid(i, j, 6, map) == false);
        assert(existsInGrid(i, j, 7, map) == false);
      }
    }

    //Test cases for grid 3
    for(int i = 0; i < 3; ++i) {
      for(int j = 6; j < 9; ++j) {
        assert(existsInGrid(i, j, 3, map) == true);
        assert(existsInGrid(i, j, 9, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 7, map) == true);
        assert(existsInGrid(i, j, 6, map) == true);
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 2, map) == false);
      }
    }

    //Test cases for grid 6
    for(int i = 3; i < 6; ++i) {
      for(int j = 6; j < 9; ++j) {
        assert(existsInGrid(i, j, 3, map) == true);
        assert(existsInGrid(i, j, 9, map) == true);
        assert(existsInGrid(i, j, 2, map) == true);
        assert(existsInGrid(i, j, 1, map) == true);
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 6, map) == true);
        assert(existsInGrid(i, j, 4, map) == false);
        assert(existsInGrid(i, j, 5, map) == false);
        assert(existsInGrid(i, j, 7, map) == false);
      }
    }

    //Test cases for grid 9
    for(int i = 6; i < 9; ++i) {
      for(int j = 6; j < 9; ++j) {
        assert(existsInGrid(i, j, 5, map) == true);
        assert(existsInGrid(i, j, 6, map) == true);
        assert(existsInGrid(i, j, 4, map) == true);
        assert(existsInGrid(i, j, 7, map) == true);
        assert(existsInGrid(i, j, 2, map) == true);
        assert(existsInGrid(i, j, 8, map) == true);
        assert(existsInGrid(i, j, 3, map) == true);
        assert(existsInGrid(i, j, 1, map) == false);
        assert(existsInGrid(i, j, 9, map) == false);
      }
    }


    assert(existsInRow(0, 4, map) == true);
    assert(existsInRow(0, 5, map) == true);
    assert(existsInRow(0, 8, map) == true);
    assert(existsInRow(0, 7, map) == true);
    assert(existsInRow(0, 3, map) == true);
    assert(existsInRow(0, 9, map) == true);
    assert(existsInRow(0, 1, map) == true);
    assert(existsInRow(0, 2, map) == false);
    assert(existsInRow(0, 6, map) == false);

    assert(existsInRow(1, 8, map) == true);
    assert(existsInRow(1, 9, map) == true);
    assert(existsInRow(1, 2, map) == true);
    assert(existsInRow(1, 1, map) == true);
    assert(existsInRow(1, 6, map) == true);
    assert(existsInRow(1, 5, map) == true);
    assert(existsInRow(1, 4, map) == true);
    assert(existsInRow(1, 7, map) == true);
    assert(existsInRow(1, 3, map) == false);

    assert(existsInColumn(0, 4, map) == true);
    assert(existsInColumn(0, 8, map) == true);
    assert(existsInColumn(0, 3, map) == true);
    assert(existsInColumn(0, 5, map) == true);
    assert(existsInColumn(0, 9, map) == true);
    assert(existsInColumn(0, 1, map) == true);
    assert(existsInColumn(0, 2, map) == false);
    assert(existsInColumn(0, 6, map) == false);
    assert(existsInColumn(0, 7, map) == false);

    assert(existsInColumn(8, 1, map) == true);
    assert(existsInColumn(8, 7, map) == true);
    assert(existsInColumn(8, 8, map) == true);
    assert(existsInColumn(8, 9, map) == true);
    assert(existsInColumn(8, 6, map) == true);
    assert(existsInColumn(8, 2, map) == true);
    assert(existsInColumn(8, 3, map) == true);
    assert(existsInColumn(8, 4, map) == false);
    assert(existsInColumn(8, 5, map) == false);

  }

  /**
  * Function checks if a number exists in a sub grid
  */
  public static boolean existsInGrid(final int i, final int j, final int p, final int[][] A) {
      if(i >= 0 && i <= 2) {
        if(j >= 0 && j <= 2) {
          if((A[0][0] == p) || (A[0][1] == p) || (A[0][2] == p) || (A[1][0] == p) || (A[1][1] == p) || (A[1][2] == p) || (A[2][0] == p) || (A[2][1] == p) || (A[2][2] == p)) {
            return true;
          }
          return false;
        } else if(j >= 3 && j <= 5) {
          if((A[0][3] == p) || (A[0][4] == p) || (A[0][5] == p) || (A[1][3] == p) || (A[1][4] == p) || (A[1][5] == p) || (A[2][3] == p) || (A[2][4] == p) || (A[2][5] == p)) {
            return true;
          }
          return false;
        } else {
          if((A[0][6] == p) || (A[0][7] == p) || (A[0][8] == p) || (A[1][6] == p) || (A[1][7] == p) || (A[1][8] == p) || (A[2][6] == p) || (A[2][7] == p) || (A[2][8] == p)) {
            return true;
          }
          return false;
        }
      } else if(i >= 3 && i <= 5) {
        if(j >= 0 && j <= 2) {
          if((A[3][0] == p) || (A[3][1] == p) || (A[3][2] == p) || (A[4][0] == p) || (A[4][1] == p) || (A[4][2] == p) || (A[5][0] == p) || (A[5][1] == p) || (A[5][2] == p)) {
            return true;
          }
          return false;
        } else if(j >= 3 && j <= 5) {
          if((A[3][3] == p) || (A[3][4] == p) || (A[3][5] == p) || (A[4][3] == p) || (A[4][4] == p) || (A[4][5] == p) || (A[5][3] == p) || (A[5][4] == p) || (A[5][5] == p)) {
            return true;
          }
          return false;
        } else {
          if((A[3][6] == p) || (A[3][7] == p) || (A[3][8] == p) || (A[4][6] == p) || (A[4][7] == p) || (A[4][8] == p) || (A[5][6] == p) || (A[5][7] == p) || (A[5][8] == p)) {
            return true;
          }
          return false;
        }
      } else {
        if(j >= 0 && j <= 2) {
          if((A[6][0] == p) || (A[6][1] == p) || (A[6][2] == p) || (A[7][0] == p) || (A[7][1] == p) || (A[7][2] == p) || (A[8][0] == p) || (A[8][1] == p) || (A[8][2] == p)) {
            return true;
          }
          return false;
        } else if(j >= 3 && j <= 5) {
          if((A[6][3] == p) || (A[6][4] == p) || (A[6][5] == p) || (A[7][3] == p) || (A[7][4] == p) || (A[7][5] == p) || (A[8][3] == p) || (A[8][4] == p) || (A[8][5] == p)) {
            return true;
          }
          return false;
        } else {
          if((A[6][6] == p) || (A[6][7] == p) || (A[6][8] == p) || (A[7][6] == p) || (A[7][7] == p) || (A[7][8] == p) || (A[8][6] == p) || (A[8][7] == p) || (A[8][8] == p)) {
            return true;
          }
          return false;
        }
    }
  }

  /**
  * Function checks if a number exists in a row in the grid
  */
  public static boolean existsInRow(final int i, final int p, final int[][] A) {
    for(int b = 0; b < A[i].length; ++b) {
      if(A[i][b] == p) return true;
    }
    return false;
  }

  /**
  * Function checks if a number exists in a column in the grid
  */
  public static boolean existsInColumn(final int j, final int p, final int[][] A) {
    for(int b = 0; b < A.length; ++b) {
      if(A[b][j] == p) return true;
    }
    return false;
  }

  /**
  * Function computes and updates the empty cells in the grid
  */
  public static void computeResults(final int[][] input) {
    final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    //Flag to exit while loop
    boolean solved = false;
    //Data structure to store candidate numbers in a Candidate object for each empty cell
    ArrayList<Candidate> Candids = new ArrayList<Candidate>();
    //Data struture to store indexes of empty cells on grid
    //There exists a 1-1 mapping between the Candids & emptyCells data structures where
    //each empty cell has a set of corresponding candidate numbers
    ArrayList<String> emptyCells = new ArrayList<String>();

    //Keep looping until all empty cells are occupied
    while(!solved) {
      //Find each empty cell and store potential candidate numbers that could fill that cell
      //If only one candidate exists, update the cell with that candidate
      for(int i = 0; i < input.length; ++i) {
        for(int j = 0; j < input[i].length; ++j) {
          if(input[i][j] == 0) {
            int c = 0;
            int t = 0;
            //Find candidates
            for(int s = 0; s < numbers.length; ++s) {
              if((!existsInGrid(i, j, numbers[s], input)) && (!existsInRow(i, numbers[s], input)) && (!existsInColumn(j, numbers[s], input))) {
                c++;
                t = numbers[s];
              }
            }
            //Update if only one candidate exists
            if(c == 1) input[i][j] = t;
            else {
              String str = i + ":" + j;
              emptyCells.add(str);
              Candidate C = new Candidate();
              //More than one candidate in the empty cell is stored in a corresponding candidate object
              for(int f = 0; f < numbers.length; ++f) {
                if((!existsInGrid(i, j, numbers[f], input)) && (!existsInRow(i, numbers[f], input)) && (!existsInColumn(j, numbers[f], input))) {
                  C.addCandidate(numbers[f]);
                }
              }
              Candids.add(C);
            }
          }
        }
      }
      //Keep backtracking until all empty cells are occupied
      int pointer = 0;
      while(true) {
        if((pointer >= emptyCells.size()) || (pointer < 0)) break;
        //On each iteration work on a new empty cell
        String s = emptyCells.get(pointer);
        String[] splitString = s.split(":");
        //Extract cell co-ordinates
        int i = Integer.parseInt(splitString[0]);
        int j = Integer.parseInt(splitString[1]);
        Candidate CA = Candids.get(pointer);
        //Get corresponding candidates
        while(true) {
          //Iterate until one candidate conforms to sudoku constraints
          int num = CA.getCandidate();
          //When num is negative, pointer has iterated over all candidates, start again
          if(num == -1) {
            CA.resetCounter();
            input[i][j] = 0;
            --pointer;
            break;
          }
          //Check if candidate conforms to Sudoku constraints, if so break to move onto next empty cell
          if((!existsInGrid(i, j, num, input)) && (!existsInRow(i, num, input)) && (!existsInColumn(j, num, input))) {
            input[i][j] = num;
            ++pointer;
            break;
          }
        }
      }
      solved = true;
      //Check if empty cells still exist
      for(int i = 0; i < input.length; ++i) {
        for(int j = 0; j < input[i].length; ++j) {
          if(input[i][j] == 0) {
            solved = false;
            System.err.println("[Sudoku] : Error, infinite loop, exit program");
            System.exit(1);
          }
        }
      }
    }
  }
}
