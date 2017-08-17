package algorithms;

public class Boggle {
    private final int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    private final int dy[] = {-1,  0,  1,-1, 1, -1,0, 1};
    private final int xSize = 5;
    private final int ySize = 5;
    private char [][] board;

    public Boggle(char [][] board) {
//        this.board = board;
        this.board = new char[][]{
                {'u', 'r', 'l', 'p', 'm'},
                {'x', 'p', 'r', 'e', 't'},
                {'g', 'i', 'a', 'e', 't'},
                {'x', 't', 'n', 'z', 'y'},
                {'x', 'o', 'q', 'r', 's'}
        };
    }

    public boolean hasWord(int x, int y, String word){
        if(!isRange(x,y)){
            return false;
        }

        if(board[y][x] != word.charAt(0)){
            return false;
        }

        if(word.length() == 1){
            return true;
        }

        for(int direction = 0; direction  < 8; direction++){
            int nextX = x + dx[direction], nextY = y + dx[direction];
            if(hasWord(nextX, nextY, word.substring(1))){
                return true;
            }
        }
        return false;
    }
    public void print(){
        System.out.println("girl : " + this.hasWord(0, 2, "girl"));
        System.out.println("repeat : " + this.hasWord(2, 1, "repeat"));
        System.out.println("sion : " + this.hasWord(1,1,"sion"));

    }

    private boolean isRange(int x, int y) {
        if((x >= xSize) || ( y  >= ySize ) || (x  < 0) || (y < 0)){
            return false;
        }
        return true;
    }
}
