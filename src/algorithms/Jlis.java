package algorithms;

public class Jlis {
    private final long NEGINF = -987654321;
    private int [] A;
    private int [] B;
    private int [][] cache;

    public Jlis(int [] A, int [] B){
        this.A = A;
        this.B = B;
        cache = new int[101][101];
        clearCache();
    }

    private void clearCache(){
        for(int i = 0;i < cache.length; i++){
            for(int j = 0;j < cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
    }

    public int getJlis(int indexA, int indexB){
        if(cache[indexA+1][indexB+1] != -1){
            return cache[indexA+1][indexB+1];
        }

        cache[indexA+1][indexB+1] = 2;

        long a = indexA == -1 ? NEGINF : A[indexA];
        long b = indexB == -1 ? NEGINF : B[indexB];
        long maxElement = Math.max(a, b);

        for(int nextA = indexA + 1; nextA < A.length; nextA++){
            if(maxElement < A[nextA]){
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], getJlis(nextA, indexB) + 1);
            }
        }
        for(int nextB = indexB + 1; nextB < B.length; nextB++){
            if(maxElement < B[nextB]){
                cache[indexA+1][indexB+1] = Math.max(cache[indexA+1][indexB+1], getJlis(indexA, nextB) + 1);
            }
        }
        return cache[indexA+1][indexB+1];
    }

}
