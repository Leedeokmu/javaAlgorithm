import algorithms.Dunibal;
import algorithms.Quantization;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [][] path = {
                {0,1,1,1,0},
                {1,0,0,0,1},
                {1,0,0,0,0},
                {1,0,0,0,0},
                {0,1,0,0,0},
        };

        Dunibal dunibal = new Dunibal(path, 0);

        System.out.println(dunibal.search(0, 2));




    }
}


