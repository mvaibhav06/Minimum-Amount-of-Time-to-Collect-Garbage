import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinTime {
    public static int garbageCollection(String[] garbage, int[] travel) {
        Map<Integer,Integer> temp1 = new LinkedHashMap<>();
        Map<Integer,Integer> temp2 = new LinkedHashMap<>();
        Map<Integer,Integer> temp3 = new LinkedHashMap<>();

        for(int i=0; i<garbage.length; i++){
            String s = garbage[i];

            for(int j=0; j<s.length(); j++){
                char ch = s.charAt(j);
                if(ch == 'M'){
                    if(temp1.containsKey(i)){
                        temp1.put(i, temp1.get(i)+1);
                    }else{
                        temp1.put(i,1);
                    }
                }else if(ch == 'P'){
                    if(temp2.containsKey(i)){
                        temp2.put(i, temp2.get(i)+1);
                    }else{
                        temp2.put(i,1);
                    }
                }else{
                    if(temp3.containsKey(i)){
                        temp3.put(i, temp3.get(i)+1);
                    }else{
                        temp3.put(i,1);
                    }
                }
            }
        }

        int count = 0;
        int current = 0;
        for(int i: temp1.keySet()){

            for(int j=current; j<i; j++){
                count += travel[j];
            }
            current = i;
            count += temp1.get(i);
        }
        current = 0;
        for(int i: temp2.keySet()){

            for(int j=current; j<i; j++){
                count += travel[j];
            }
            current = i;
            count += temp2.get(i);
        }

        current = 0;
        for(int i: temp3.keySet()){

            for(int j=current; j<i; j++){
                count += travel[j];
            }
            current = i;
            count += temp3.get(i);
        }
        return count;
    }

    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(garbageCollection(garbage,travel));
    }
}
