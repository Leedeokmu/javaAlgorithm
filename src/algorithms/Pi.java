package algorithms;

public class Pi {
    private String N;
    final private int INF = 987654321;
    int cache[];

    public Pi(String N){
        this.N = N;
        cache = new int[10001];
        for(int i = 0 ;i< cache.length; i++){
            cache[i] = -1;
        }
    }

    public int memorize(int begin){
        if(begin == N.length()){
            return 0;
        }
        if(cache[begin] != -1){
            return cache[begin];
        }
        cache[begin] = INF;
        for(int len = 3; len <= 5; len++){
            if(begin + len <= N.length()){
                cache[begin] = Math.min(cache[begin], memorize(begin + len) +
                        classify(begin, begin + len - 1));
            }
        }
        return cache[begin];

    }

    private int classify(int begin, int end) {
        String M = N.substring(begin, end + 1);

        String tmp = "";
        for(int i = 0;i < M.length(); i++){
            tmp += M.charAt(0);
        }
        if(M == tmp){
            return 1;
        }
        boolean progressive = true;
        for(int i = 0; i < M.length() - 1; i++){
            if(M.charAt(i+1) - M.charAt(i) != M.charAt(1) - M.charAt(0)){
                progressive = false;
            }
        }
        if(progressive && Math.abs(M.charAt(1) - M.charAt(0)) == 1){
            return 2;
        }

        boolean alternating = true;
        for(int i = 0 ;i < M.length(); i++){
            if(M.charAt(i) != M.charAt(i%2)){
                alternating = false;
            }
        }
        if(alternating){
            return 4;
        }
        if(progressive){
            return 5;
        }
        return  10;
    }
}
