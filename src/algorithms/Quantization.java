package algorithms;

import java.util.Comparator;
import java.util.List;

public class Quantization {
    final static private int INF = 987654321;
    private List<Integer> A;
    private int [] pSum;
    private int [] pSqSum;
    private int size;
    private int [][] cache;

    public Quantization(List<Integer> A, int size){
        this.A = A;
        this.size = size;
        pSum = new int[A.size()];
        pSqSum = new int[A.size()];
        cache = new int[101][11];
        precalc();
    }

    private void precalc(){
        A.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        pSum[0] = A.get(0);
        pSqSum[0] = A.get(0) * A.get(0);
        for(int i= 1; i < A.size(); i++){
            pSum[i] = pSum[i-1] + A.get(i);
            pSqSum[i] = pSqSum[i-1] + A.get(i) * A.get(i);
        }
    }

    private int minError(int lo, int hi){
        int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo-1]);
        int sqSum = pSqSum[hi] - (lo == 0 ? 0 : pSqSum[lo-1]);
        // 점화식 -> 반올림
        int m = (int)(0.5 + (double)sum / (hi - lo + 1));
        int ret = sqSum - 2 * m * sum + m * m * (hi - lo + 1);
        return ret;
    }

    public int quantize(int from, int parts){
        if(from == A.size()){
            return 0;
        }

        if(parts == 0){
            return INF;
        }

        if(cache[from][parts] != -1){
            return cache[from][parts];
        }

        cache[from][parts] = INF;

        for(int partSize = 1; partSize + from <= A.size(); partSize++){
            cache[from][parts] = Math.min(cache[from][parts], minError(from, from + partSize - 1) +
                quantize(from + partSize, parts-1));
        }
        return cache[from][parts];
    }


}
