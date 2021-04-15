import java.util.*;
class Frog_And_Toad_Solution_Generator {
    public static void main(String args[]) {
        //replace the array with the corresponding positions on the board
        char[] inp = {'F','F','F','x','x','x','T','T','T'};
        //replace 'T' below with whoever goes first
        char c = solve(inp, 'T');
        System.out.println(c);
    }
    public static char solve(char[] pos, char turn)    {
        char result = turn == 'F' ? 'T' : 'F';
        if(turn == 'F')  {
            for(int i = 0; i < pos.length; i++) {
                if(pos[i] == turn) {
                    if(i + 1 < pos.length && pos[i + 1] == 'x') {
                        char[] newArr = Arrays.copyOf(pos, pos.length);
                        newArr[i] = 'x';
                        newArr[i + 1] = turn;
                        char res = solve(newArr, 'T');
                        if(res == turn) {
                            result = turn;
                        }
                    }
                    else if(i + 2 < pos.length && pos[i + 1] != turn && pos[i + 2] == 'x')  {
                        char[] newArr = Arrays.copyOf(pos, pos.length);
                        newArr[i] = 'x';
                        newArr[i + 2] = turn;
                        char res = solve(newArr, 'T');
                        if(res == turn) {
                            result = turn;
                        }
                    }
                }
            }
        }
        else if(turn == 'T')  {
            for(int i = pos.length - 1; i >= 0; i--) {
                if(pos[i] == turn) {
                    if(i - 1 >= 0 && pos[i - 1] == 'x') {
                        char[] newArr = Arrays.copyOf(pos, pos.length);
                        newArr[i] = 'x';
                        newArr[i - 1] = turn;
                        char res = solve(newArr, 'F');
                        if(res == turn) {
                            result = turn;
                        }
                    }
                    else if(i - 2 >= 0 && pos[i - 1] != turn && pos[i - 2] == 'x')  {
                        char[] newArr = Arrays.copyOf(pos, pos.length);
                        newArr[i] = 'x';
                        newArr[i - 2] = turn;
                        char res = solve(newArr, 'F');
                        if(res == turn) {
                            result = turn;
                        }
                    }
                }
            }
        }
        return result;
    }
}