import algorithms.FenceChopping;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> heightList = new ArrayList<>();

        heightList.add(7);
        heightList.add(1);
        heightList.add(5);
        heightList.add(9);
        heightList.add(6);
        heightList.add(7);
        heightList.add(3);

        FenceChopping fence = new FenceChopping(heightList);
        fence.printResult();
    }
}
