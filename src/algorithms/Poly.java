package algorithms;

public class Poly {
    final static private int MOD = 1000000000;
    private int N;
    private int [][] cache;

    public Poly(int N){
        this.N = N;
        cache = new int[N+1][N+1];
        for(int i = 0 ;i < cache.length; i++){
            for(int  j = 0 ;j < cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
    }

    public int poly(int n, int first){
        if(n == first){
            return 1;
        }
        if(cache[n][first] != -1){
            return cache[n][first];
        }

        cache[n][first] = 0;

        for(int second = 1; second <= n-first; second++){
            int add = second + first -1;
            add *= poly(n - first, second);
            add %= MOD;
            cache[n][first] += add;
            cache[n][first] %= MOD;
        }
        return cache[n][first];
    }

}
