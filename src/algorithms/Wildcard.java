package algorithms;
import java.util.List;

public class Wildcard {
    private String pattern;
    private String match;
    private int [][] cache;
    private List<String> matches;

    public Wildcard(String pattern, List<String> matches){
        this.pattern = pattern;
        this.matches = matches;
        cache = new int[100][100];
        clearCache();
    }


    private void clearCache(){
        for(int i = 0;i < cache.length; i++){
            for(int j = 0;j < cache[0].length; j++){
                cache[i][j] = -1;
            }
        }
    }

    public void runMatch(){
        for(int i = 0; i < matches.size(); i++){
            match = matches.get(i);
            if(match(0, 0) == 1){
                System.out.println(match);
            }
            clearCache();
        }
    }
    public int match(int pPos, int mPos){
        if(cache[pPos][mPos] != -1){
            return cache[pPos][mPos];
        }

        if(pPos < pattern.length() && mPos < match.length() &&
                (pattern.charAt(pPos) == '?' || pattern.charAt(pPos) == match.charAt(mPos))){
            return cache[pPos][mPos] = match(pPos + 1, mPos + 1);
        }

        if(pPos == pattern.length()){
            return cache[pPos][mPos] = ((mPos == match.length()) ? 1 : 0);
        }

        if(pattern.charAt(pPos) == '*'){
            if(match(pPos +1, mPos) == 1 ||
                    (mPos < match.length() && match(pPos, mPos + 1) == 1)){
                return cache[pPos][mPos] = 1;
            }
        }

        return cache[pPos][mPos] = 0;
    }



}


