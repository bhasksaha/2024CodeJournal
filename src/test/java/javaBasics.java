import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class javaBasics {

    /*Collections: It defines several classes and interfaces which can be used to represent a grp of
    individual objs as an single entity
    1.Growable in size
    2.Heterogenous objs
    3.Standard underlying DS*/

    @Test(enabled = false)
    public void ArrList(){
        ArrayList<String> al=new ArrayList<>();
        al.add("Bhaskar");
        al.add("Divya");
        al.add(null);
        al.add("Bhaskar");
        al.add("Dida");

        /*
        * Properties:1.Maintains order
        * 2.Allows duplicates
        * 3.Allows NULL values
        * 4.Diff bet arrayList and linkedList: a.objs are not stored in consecutive mem locan in LL
        * b.LL is better when lot of insertion and deletion operation in middle
        * c.AL is better when lot retrieval operations (as it implements RandomAccess interface)
        * d.AL data struc: growable array   | LL : Double linked list
        * */

        System.out.println("Iterating The elements of the arraylist using for loop");
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i));
        }

        System.out.println("Iterating The elements of arraylis using using enhanced for loop");
        for (String v: al){
            System.out.println(v);
        }

        System.out.println("Iterating using itearator");
        Iterator<String> it=al.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("Iterating list in reverse order");
        ListIterator<String> lt=al.listIterator();
        while(lt.hasPrevious()) {
            System.out.println(lt.previous());;
        }

        System.out.println("Iterating arrayList using foreach");
        al.forEach(c->{
            System.out.println(c);
        });
    }

    @Test(enabled = false)
    public void set(){
        Set<String> hs=new HashSet<>();
        hs.add("Bhaskar");
        hs.add("Divya");
        hs.add(null);
        hs.add("Bhaskar");
        hs.add("Dida");

        /*Properties:1.HashSet does nt maintain order
        * 2.LindedHashset maintains order
        * 3.Duplicates are not allowed
        * 4.NULL value is allowed
        * 5.Diff between hashset & linkedHashset & TreeSet
        *insertion order: N           Y              N
        * 6.TreeSet keeps objects in natural sorted order with no NULL values allowed
        */
        System.out.println("Iterating set using iterator");
        Iterator<String> it=hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("Iterating set using enhanced for");
        for(String v: hs){
            System.out.println(v);
        }

        System.out.println("Iterating set using foreach");
        hs.forEach(c->{
            System.out.println(c);
        });

    }

    @Test(enabled = false)
    public void map(){

        /*
        * Properties: 1.Map has unique key and value
        * 2.Hashmap does not maintains order wih NULL key and values allowed
        * 3.LinkedMap maintains order wih NULL key and values allowed
        * 4.TreeMap maintains natural sorted order of keys with NO NULL key but NULL values are allowed
        * */
        HashMap<String,Integer> hm=new HashMap();
        hm.put("Sunday",1);
        hm.put("Monday",2);
        hm.put("Tuesday",3);
        hm.put("Wednesday",4);

        System.out.println("Iterating map using Iterator");
        Iterator<Map.Entry<String,Integer>> it=hm.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> entry=it.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("Iterating map using enhanced for loop");
        for(Map.Entry<String,Integer> v :hm.entrySet()){
            System.out.println("key : "+v.getKey()+" value : "+v.getValue());
        }

        System.out.println("Iterating map using foreach loop");
        hm.forEach((k, v)->{
            System.out.println("key : "+k+" value : "+v);
        });

    }

    /*Streams: ntroduced in Java 8, Stream API is used to process collections of objects. A stream in Java is
    a sequence of objects that supports various methods which can be pipelined to produce the desired result.
    Various operations that can be performed:
    1.Filter
    2.Mapping
    3.Collecting into other collection
    4.Iteration*/

    @Test
    public void streamsFilter1(){
        List<Integer> li1=Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> li2=new ArrayList<>();

        //collect elements which can be divide by 2
        li2=li1.stream().filter(c->c%2==0).collect(Collectors.toList());
        System.out.println(li2);

        //iterating over the filtered collection
        li1.stream().filter(c->c%2==0).forEach(System.out::println);
    }

    @Test
    public void streamsFilter2(){
        List<String> li1=Arrays.asList("Bhaskar","Divya","Arati","Ram","Om");
        List<String> li2=new ArrayList<>();

        li2=li1.stream().filter(c->c.length()>5 && c.length()<7).collect(Collectors.toList());
        System.out.println(li2);

        li1.stream().filter(c->c.length()>5 && c.length()<7).forEach(c-> System.out.println(c));


    }


    //The Java Stream map() method is used to return a new stream of objects.
    @Test
    public void streamsMap1(){
        List<String> li1=Arrays.asList("Bhaskar","Divya","Arati","Dida");
        List<String> li2=new ArrayList<>();

        //converting string objs to upper case
        li2=li1.stream().map(c->c.toUpperCase()).collect(Collectors.toList());
        System.out.println(li2);

        //iterating the ap
        li1.stream().map(c->c.toUpperCase()).forEach(c-> System.out.println());
    }

    @Test
    public void streamsMap2(){
        List<Integer> li1=Arrays.asList(2,3,4,5);
        List<Integer> li2=new ArrayList<>();

        //collecting objs from map in list
        li2=li1.stream().map(c->c*2).collect(Collectors.toList());
        System.out.println(li2);

        //iteratiing objs in map stream
        li1.stream().map(c->c*2).forEach(System.out::println);

    }

    /*The flatMap() method in Java 8 streams is a powerful tool that can be used to flatten a stream of streams
    into a single stream. This can be useful for a variety of tasks,such as processing data from multiple sources
    or transforming a stream of objects into a stream of values.*/

    public void StreamsFlatmap(){
        List<Integer> li1=Arrays.asList(1,2,3);
        List<Integer> li2=Arrays.asList(4,5,6);
        List<Integer> li3=Arrays.asList(7,8,9);
        List<Integer> li4=Arrays.asList(10,11,12);
        List<List<Integer>> finalList=Arrays.asList(li1,li2,li3,li4);

        List<Integer> finalResults1=finalList.stream().flatMap(c->c.stream()).collect(Collectors.toList());
        System.out.println(finalResults1);

        List<Integer> finalResults2=finalList.stream().flatMap(c->c.stream().map(n->n+10)).collect(Collectors.toList());
        System.out.println(finalResults2);
    }


}
