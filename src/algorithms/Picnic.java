package algorithms;

public class Picnic {
    private int numOfStudents;
    private boolean [] done;
    private boolean [][] couple;

    public Picnic(int numOfStudents, int numOfCouples, boolean [][] couple) {
//        this.numOfStudents = numOfStudents;
//        this.couple = couple;
//        done = new boolean[this.numOfStudents];
        this.numOfStudents = 6;
        int [][] couples = new int[][]{
                {0,1},
				{0,2},
				{1,2},
				{1,3},
				{1,4},
				{2,3},
				{2,4},
				{3,4},
				{3,5},
				{4,5}
        };

        for(int i = 0;i< numOfCouples; i++){
			couple[couples[i][0]][couples[i][1]] = true;
			couple[couples[i][1]][couples[i][0]] = true;
		}
    }

    public int areEveryoneCouple(){
        int nextMatch = -1;
        for(int i = 0;i < numOfStudents; i++){
            if(!done[i]){
                nextMatch = i;
                break;
            }
        }
        if(nextMatch == -1){
            return 1;
        }
        int ret = 0;
        for(int who = nextMatch +1; who < numOfStudents; who++){
            if(!done[who] && couple[nextMatch][who]){
                done[nextMatch]= done[who] = true;
                ret += areEveryoneCouple();
                done[nextMatch]  = done[who] = false;
            }
        }
        return ret;
    }

    public void printResult(){
        System.out.println("Amount of method to make whole people couple : " +  this.areEveryoneCouple());
    }
}
