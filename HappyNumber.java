import javax.swing.*;
import java.util.*;

public class Solution {
    Set<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if(set.contains(n)) return false;
        set.add(n);
        List<Integer> list = new ArrayList<Integer>();
        while(n != 0) {
            int digit = n % 10;
            list.add(digit);
            n = n / 10;
        }
        long powSum = 0;
        for(int i = 0; i < list.size(); i++){
            powSum += list.get(i) * list.get(i);
        }
        if(powSum == 1){
            return true;
        }else{
            isHappy(powSum);
        }
    }
}
