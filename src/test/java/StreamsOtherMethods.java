import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsOtherMethods {

    @Test
    public void sorted(){
        List<Integer> list1=Arrays.asList(8,4,3,5,2);

        //ascending sort
        List<Integer> sortedList=list1.stream().sorted().collect(Collectors.toList());

        //descending/reverse sort
        List<Integer> reverseSortedList=list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
