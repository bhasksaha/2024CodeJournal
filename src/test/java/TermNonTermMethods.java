import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TermNonTermMethods {

    //Non-Terminal methods(they return stream of objs) :filter,map,flatmap,distinct,limit
    //Terminal methods :collect,count,min,max,foreach,toArray

    //Summary of streams: Java Streams Part 5 :SDET QA youtube channel

    @Test
    public void nonTermMethods(){
        List<String> vechicles= Arrays.asList("car","bike","cycle","truck","car","bike");

        //distinct
        List<String> distinctVechicles=vechicles.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctVechicles);

        //count
        long count=vechicles.stream().distinct().count();
        System.out.println(count);

        //limit
        List<String> limitVechicles=vechicles.stream().limit(3).collect(Collectors.toList());
        System.out.println("Limited vechicles "+limitVechicles);
    }

    @Test
    public void termMethods(){
        List<Integer> numList=Arrays.asList(1,2,3,4,5,6,7);

        //count
        long filteredCOunt=numList.stream().filter(num->num%2 ==0).count();
        System.out.println(filteredCOunt);

        //min
        Optional<Integer> min=numList.stream().min((val1, val2)->{
            return val1.compareTo(val2);
        });
        System.out.println(min.get());

        //max
        Optional<Integer> max=numList.stream().min((val1, val2)->{
            return val1.compareTo(val2);
        });
        System.out.println(max.get());

        //toArray
        List<String> stringList=Arrays.asList("A","B","1","D","E");
        Object arr[]=stringList.stream().toArray();
        for(Object v:arr){
            System.out.println(v);
        }
        StringBuffer sb=new StringBuffer();
    }

}
