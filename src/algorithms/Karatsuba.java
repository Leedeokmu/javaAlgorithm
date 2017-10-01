package algorithms;

import java.util.ArrayList;

public class Karatsuba {
    public ArrayList<Integer> getResult(ArrayList<Integer> a, ArrayList<Integer> b){
        int an = a.size(), bn = b.size();

        if(an < bn ) {
            return getResult(b,a);
        }

        if(an == 0 || bn == 0 ){
            return new ArrayList<>();
        }

        if(an <= 50) {
            return multiply(a,b);
        }

        int half = an / 2;

        ArrayList<Integer> a0 = new ArrayList<>(a.subList(0, half));
        ArrayList<Integer> a1 = new ArrayList<>(a.subList(half, a.size()-1));

        ArrayList<Integer> b0 = new ArrayList<>(b.subList(0, Math.min(half, b.size()-1)));
        ArrayList<Integer> b1 = new ArrayList<>(b.subList(Math.min(half, b.size()-1), b.size() -1));

        ArrayList<Integer> z0 = getResult(a0, b0);

        ArrayList<Integer> z2 = getResult(a1, b1);
        addTo(a0, a1, 0);
        addTo(b0, b1, 0);
        ArrayList<Integer> z1 = getResult(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);

        ArrayList<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half + half);

        return ret;
    }

    private void normalize(ArrayList<Integer> tmp){
        tmp.add(0);

        for(int i = 0 ;i < tmp.size()-1; i++){
            if(tmp.get(i) < 0){
                int borrow = (Math.abs(i) + 9) / 10;
                tmp.set(i+1, tmp.get(i+1) - borrow);
                tmp.set(i, tmp.get(i) + borrow * 10);
            }else{
                tmp.set(i+1, tmp.get(i+1) + (tmp.get(i) / 10));
                tmp.set(i, tmp.get(i) % 10);
            }
        }

        while(tmp.size() > 1 && tmp.get(tmp.size()-1)  == 0){
            tmp.remove(tmp.size()-1);
        }
    }
    private ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i < a.size() + b.size() + 1; i++){
            result.add(0);
        }
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                result.set(i + j, result.get(i + j) + (a.get(i) * b.get(j)));
            }
        }
        normalize(result);
        return result;
    }

    private void addTo(ArrayList<Integer> a, ArrayList<Integer> b, int k){
        int needCapacity = (b.size() + k + 1) - a.size();
        if(needCapacity > 0){
            for(int i = 0 ;i < needCapacity; i++){
                a.add(0);
            }
        }

        for(int i = 0; i < b.size(); i++){
            a.set(i+k, a.get(i+k) + b.get(i));
        }
        normalize(a);
    }
    private void subFrom(ArrayList<Integer> a, ArrayList<Integer> b){
        for(int i = 0; i < b.size(); i++){
            a.set(i, a.get(i) - b.get(i));
        }
        normalize(a);
    }
}
