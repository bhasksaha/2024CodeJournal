import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TestICE {

    @Test(enabled = true)
    public void test1(){
        //    String ip="1+2+3-4";
        //o/p=the final answer=2
        String ip="1-2-3-4";
//        char[] arr=ip.toCharArray();
        int op=Integer.parseInt(String.valueOf(ip.charAt(0)));
        for(int i=0;i<ip.length();i++){
            if((ip.charAt(i)+"").equals("+")){
                op=op+Integer.parseInt(String.valueOf(ip.charAt(i+1)));
            }else if((ip.charAt(i)+"").equals("-")){
                op=op-Integer.parseInt(String.valueOf(ip.charAt(i+1)));
            }
        }
        System.out.println("The final op is : "+op);
    }

    @Test(enabled = false)
    public void test2(){
        HashMap<Integer,String> hm=new HashMap<>();
        hm.put(1,"Monday");
        hm.put(2,"Tuesday");
        hm.put(3,"Wednesday");

        for(Map.Entry<Integer,String> v:hm.entrySet()){
            System.out.println("The key is :"+v.getKey()+" The value is : "+v.getValue());
        }

        /*LinkedHashMap<Integer,String> hm1=new LinkedHashMap<>(hm);
        List<Map.Entry> li=hm.entrySet().stream().collect(Collectors.toList());*/
        Set<Integer> s=hm.keySet();
        ArrayList<Integer> al1=new ArrayList<>(s);
        Collections.reverse(al1);
        for(int v: al1){
            System.out.println("The key is : "+v+" the value is : "+hm.get(v));
        }
    }

    @Test(enabled = false)
    public void test3(){
        String ip="ddsdcssv";
        HashMap<Character,Integer> hm=new HashMap<>();
        char[] arr=ip.toCharArray();
        for(char v: arr){
            if(hm.containsKey(v)){
                hm.put(v,hm.get(v)+1);
            }else{
                hm.put(v,1);
            }
        }

        for(Map.Entry<Character,Integer> v:hm.entrySet()){
            System.out.println("The key is :"+v.getKey()+" The value is : "+v.getValue());
        }
    }

    public static void method() throws FileNotFoundException {

        FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");
        BufferedReader fileInput = new BufferedReader(file);


        throw new FileNotFoundException();

    }
}
