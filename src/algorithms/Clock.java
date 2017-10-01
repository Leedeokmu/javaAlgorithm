package algorithms;

public class Clock {

    private final int INF = 987654321;
    private String [] switches= {
            "###.............",
            "...#...#.#.#....",
            "....#.....#...##",
            "#...####........",
            "......###.#.#...",
            "#.#...........##",
            "...#..........##",
            "....##.#......##",
            ".#####..........",
            "...###...#...#.."
    };

    private int [] clocks;

    public Clock(int[] clocks) {
//        this.clocks = clocks;
            this.clocks = new int[]{12, 9, 3, 12, 6, 6, 9, 3, 12, 9, 12, 9, 12, 12, 6, 6};
        }

    public void push(int swt){
        for(int clock = 0 ;clock < clocks.length; clock++){
            if(switches[swt].charAt(clock) == '#'){
                clocks[clock] += 3;
                if(clocks[clock] == 15){
                    clocks[clock] = 3;
                }
            }
        }
    }

    public int areEveryClock12Count(int swt){
        if(swt == switches.length){
            return isAligned() ? 0 : INF;
        }
        int ret = INF;
        for(int cnt = 0; cnt < 4; cnt++){
            ret = Math.min(ret, cnt + areEveryClock12Count(swt+1));
            push(swt);
        }
        return ret;
    }

    public boolean isAligned() {
        boolean isAligned = true;
        for(int clock = 0 ; clock < clocks.length; clock++){
            if(clocks[clock] != 12){
                isAligned = false;
                break;
            }
        }
        return isAligned;
    }
}
