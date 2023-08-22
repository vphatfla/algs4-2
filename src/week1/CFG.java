package week1;

import java.util.Stack;

public class CFG {
    static int ROW = 3;
    static int COL = 3;

    // Initialize direction vectors
    static int[] dRow = { 0, 1, 0, -1 };
    static int[] dCol = { -1, 0, 1, 0 };

    static class coordinations {
        public int rowCoor;
        public int colCoor;

        public coordinations(int rowCoor, int colCoor) {
            this.rowCoor =rowCoor;
            this.colCoor = colCoor;
        }
    }

    static Boolean isValid(Boolean[][] visited, int row, int col) {
        // If cell is out of bounds
        if (row < 0 || col < 0 ||
                row >= ROW || col >= COL)
            return false;

        // if already visited
        if (visited[row][col]) return  false;

        // otherwise, visit it
        return true;
    }

    // dfs
    static void DFS(int row, int col, int[][] grid, Boolean[][] visited) {
        // init stack
        Stack<coordinations> st = new Stack<>();

        // put in stack new coor as the input
        st.push(new coordinations(row, col));

        while (!st.isEmpty())
        {
            // pop the top of stack
            coordinations currCoor = st.pop();

            int currRow = currCoor.rowCoor;
            int currCol = currCoor.colCoor;

            // mark as visited
            visited[currRow][currCol] = true;
            // ... more
        }
    }
}
