import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            
                if (j < N - 1) {
                    swap(board, i, j, i, j + 1);
                    answer = Math.max(answer, calculateMax(board, N));
                    swap(board, i, j, i, j + 1);  
                }
                
                if (i < N - 1) {
                    swap(board, i, j, i + 1, j);
                    answer = Math.max(answer, calculateMax(board, N));
                    swap(board, i, j, i + 1, j);  
                }
            }
        }

        System.out.println(answer);
    }

    private static int calculateMax(char[][] board, int N) {
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            int countRow = 1;
            int countCol = 1;

            for (int j = 1; j < N; j++) {
                if (board[i][j - 1] == board[i][j]) {
                    countRow++;
                } else {
                    maxLen = Math.max(maxLen, countRow);
                    countRow = 1;
                }
                
                if (board[j - 1][i] == board[j][i]) {
                    countCol++;
                } else {
                    maxLen = Math.max(maxLen, countCol);
                    countCol = 1;
                }
            }
            maxLen = Math.max(maxLen, countRow);
            maxLen = Math.max(maxLen, countCol);
        }

        return maxLen;
    }
    
    private static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}