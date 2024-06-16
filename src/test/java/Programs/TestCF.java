package Programs;

import org.testng.annotations.Test;

public class TestCF {
    /*String Input = "-1,4,3,-4,-3,5,1,2,-2"
String Output= -1,-4,-3,-2,4,3,5,1,2*/

    @Test
    public void test1(){
        String Input = "-1,4,3,-4,-3,5,1,2,-2";
        String  arr[]=Input.split(",");
        String output1="";
        String output2="";
        for(String v:arr){
            int value=Integer.parseInt(v);
            if(value<0){
                output1=output1+v;
            }else{
                output2=output2+v;
            }

        }
        System.out.println("The output is :"+output1+output2);
    }
    //element.IsDi,is
}
