package algorithms;

import java.util.List;

public class FenceChopping {
    private List<Integer> heightList;
    public FenceChopping(List<Integer> heightList){
        this.heightList = heightList;
    }

    private  Integer getMaxFenceSize(Integer left, Integer right){
        if(left == right){
            return heightList.get(left);
        }
        Integer mid = (left + right)/2;

        Integer ret = Math.max(getMaxFenceSize(left, mid), getMaxFenceSize(mid+1, right));

        Integer low = mid;
        Integer high = mid + 1;
        Integer height = Math.min(heightList.get(low), heightList.get(high));

        ret = Math.max(ret, height * 2);

        while(left < low || high < right){
            if((high < right) && ((left == low)  || (heightList.get(low) < heightList.get(high)))){
                high++;
                height = Math.min(heightList.get(high), height);
            }else{
                low--;
                height = Math.min(heightList.get(low), height);
            }
            ret = Math.max(ret, (high - low + 1) * height);
        }
        return ret;
    }

    public void printResult(){
        System.out.println("Max Fence Size : " + getMaxFenceSize(0, heightList.size()-1));
    }
}
