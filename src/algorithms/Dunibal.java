package algorithms;

public class Dunibal {
    private int [][] path;
    private int [] deg;
    private Double [][] cache;
    private int start;

    public Dunibal(int [][] path, int start){
        this.path = path;
        this.start = start;
        deg = new int[path.length];
        cache = new Double[51][101];
        for(int i = 0 ; i <deg.length; i++){
            deg[i] = 0;
        }
        for(int i = 0;i < cache.length; i++){

            for(int j = 0; j< cache[0].length; j++){
                cache[i][j] = -1.0;
            }
        }
        setDeg();
    }
    private void setDeg(){
        for(int i = 0 ;i < path.length; i++){
            for(int j = 0 ; j < path[i].length; j++){
                if(path[i][j] == 1){
                    deg[i]++;
                }
            }
        }
    }

    public Double search(int here, int days){
        if(days == 0){
            return here == start ? 1.0 : 0.0;
        }
        if(cache[here][days] >= -0.5){
            return cache[here][days];
        }

        cache[here][days] = 0.0;
        for(int there = 0; there < path.length; there++){
            if(path[here][there] == 1){
                cache[here][days] += search(there, days-1) / deg[there];
            }
        }
        return cache[here][days];
    }



}
