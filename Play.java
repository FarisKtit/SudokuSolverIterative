class Play {
  public static void main(final String[] args) {
    final int[][] input1 = new int[9][9];
    input1[0][0] = 6;
    input1[0][1] = 5;
    input1[0][2] = 9;
    input1[0][4] = 1;
    input1[0][6] = 2;
    input1[0][7] = 8;

    input1[1][0] = 1;
    input1[1][4] = 5;
    input1[1][7] = 3;

    input1[2][0] = 2;
    input1[2][3] = 8;
    input1[2][7] = 1;

    input1[3][3] = 1;
    input1[3][4] = 3;
    input1[3][5] = 5;
    input1[3][7] = 7;

    input1[4][0] = 8;
    input1[4][3] = 9;
    input1[4][8] = 2;

    input1[5][2] = 3;
    input1[5][4] = 7;
    input1[5][5] = 8;
    input1[5][6] = 6;
    input1[5][7] = 4;

    input1[6][0] = 3;
    input1[6][2] = 2;
    input1[6][5] = 9;
    input1[6][8] = 4;

    input1[7][5] = 1;
    input1[7][6] = 8;

    input1[8][2] = 8;
    input1[8][3] = 7;
    input1[8][4] = 6;

    final int[][] input = {
      {0, 6, 0, 0, 7, 2, 0, 0, 1},
      {8, 0, 0, 1, 3, 6, 5, 0, 0},
      {0, 0, 3, 4, 0, 0, 0, 0, 0},
      {2, 0, 0, 6, 5, 0, 0, 3, 0},
      {0, 0, 6, 0, 0, 7, 0, 1, 0},
      {0, 0, 0, 2, 0, 0, 8, 6, 4},
      {9, 0, 7, 0, 8, 4, 0, 0, 0},
      {0, 0, 8, 0, 0, 9, 0, 7, 0},
      {0, 0, 0, 7, 2, 1, 0, 8, 3}
    };

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

    final int[][] veryHard = {
      {0, 0, 2, 0, 0, 0, 1, 0, 0},
      {0, 9, 0, 5, 0, 3, 0, 6, 0},
      {5, 0, 0, 0, 0, 0, 0, 0, 2},
      {0, 3, 0, 2, 0, 4, 0, 1, 0},
      {0, 0, 0, 0, 6, 0, 0, 0, 0},
      {0, 4, 0, 1, 0, 8, 0, 9, 0},
      {4, 0, 0, 0, 0, 0, 0, 0, 7},
      {0, 5, 0, 8, 0, 6, 0, 3, 0},
      {0, 0, 9, 0, 0, 0, 4, 0, 0}
    };

    long startTime = System.nanoTime();
    Sudoku.computeResults(veryHard);
    long endTime = System.nanoTime();
    long duration = ((endTime - startTime)/ 1000000);  //divide by 1000000 to get milliseconds.

    for(int i = 0; i < veryHard.length; ++i) {
      for(int j = 0; j < veryHard[i].length; ++j) {
        System.out.print(veryHard[i][j] + ",");
      }
      System.out.println();
    }

    System.out.println("Duration: " + duration + "ms");

  }
}
