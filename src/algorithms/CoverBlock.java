package algorithms;

public class CoverBlock {
    private int [][][] block = {
            {{0,0}, {1,0}, {1,1}},
            {{0,0}, {1,0}, {0,1}},
            {{0,0}, {0,1}, {1,1}},
            {{0,0}, {0,1}, {-1,1}}
    };

    private int [][] board;

    public CoverBlock(int [][] board){
//        this.board = board;
        this.board = new int[][]{
                {0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
        };
    }

    public int cover(){
        int x = -1, y = -1;
        for(int i = 0 ;i < board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                if(board[i][j] == 0){
                    y = i;
                    x = j;
                    break;
                }
            }
            if(y != -1){
                break;
            }
        }
        if(y == -1) {
            return 1;
        }
        
        int ret = 0 ;
        for(int type = 0;type < 4; type++){
            if(set(x,y,type,1)){
                ret += cover();
            }
            set(x,y,type,-1);
        }
        return ret;
    }

    private boolean set(int x, int y, int type, int i) {
        boolean ok = true;
        for(int piece = 0; piece < 3; piece++){
            int bx = x + block[type][piece][0];
            int by = y + block[type][piece][1];

            if(by < 0 || by >= board.length || bx < 0 || bx >= block[0].length) {
                ok = false;
            }else if((board[by][bx] += i) > 1) {
                ok = false;
            }
        }
        return ok;
    }
}
