class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] map;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        map = new int[m][n];

        for (int[] g : guards) {
            map[g[0]][g[1]] = 2;
        }

        for (int[] w : walls) {
            map[w[0]][w[1]] = 2;
        }

        for (int[] g : guards) {
            guardCells(m, n, g[0], g[1]);
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    private void guardCells(int m, int n, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            while (isValid(m, n, nx, ny) && map[nx][ny] < 2) {
                map[nx][ny] = 1;
                nx += dx[i];
                ny += dy[i];
            }
        }
    }

    private boolean isValid(int m, int n, int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }
}