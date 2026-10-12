import java.util.ArrayDeque;
import java.util.Deque;

public class P0200NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length, islands = 0;
        for (int r = 0; r < rows; r++) for (int c = 0; c < cols; c++) {
            if (grid[r][c] != '1') continue;
            islands++;
            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{r, c});
            grid[r][c] = '0';
            while (!stack.isEmpty()) {
                int[] cell = stack.pop();
                int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
                for (int[] d : directions) {
                    int nr = cell[0] + d[0], nc = cell[1] + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1') {
                        grid[nr][nc] = '0';
                        stack.push(new int[]{nr, nc});
                    }
                }
            }
        }
        return islands;
    }
}
