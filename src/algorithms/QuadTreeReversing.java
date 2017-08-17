package algorithms;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class QuadTreeReversing {
    private List<Character> inputString;
    private ListIterator<Character> listIterator;


    public QuadTreeReversing(List<Character> inputString){
        this.inputString = inputString;
        listIterator = this.inputString.listIterator();
    }

    public String reversing(){
        Character tmpStr = listIterator.next();
        if(tmpStr.equals('b') || tmpStr.equals('w')){
            return new String(tmpStr.toString());
        }
        String upperLeft = reversing();
        String upperRight = reversing();
        String lowerLeft = reversing();
        String lowerRight = reversing();

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }
}
