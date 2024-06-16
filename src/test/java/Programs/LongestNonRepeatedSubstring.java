package Programs;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatedSubstring {

    @Test
    public void test(){

        String ip="bcaaeftyu";
        int i=0;int j=0;
        int maxLength=0;
        Set<Character> hs=new HashSet<>();
        while(j<ip.length()){
            if(hs.contains(ip.charAt(j))) {
                    hs.remove(ip.charAt(i));
                    i++;
            }else{
                hs.add(ip.charAt(j));
                if(maxLength<hs.size()){
                    maxLength=hs.size();
                }
                j++;
            }
        }
        System.out.println("the length of longest non repeating substring is "+maxLength);
    }
}
