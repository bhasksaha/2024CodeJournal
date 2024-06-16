import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//Collection->Stream->Filter->Map->Collect
//below eg shows combination of filter and map

class Employee {
    int empId;
    String empName;
    int salary;
    Employee(int empId,String empName,int salary){
        this.empId=empId;
        this.empName=empName;
        this.salary=salary;
    }
}

public class StreamsMap{

    @Test
    public void StreamsMapFilter(){
        List<Employee> epLi1= Arrays.asList(new Employee(1,"Bhaskar",20000),
                new Employee(2,"Divya",25000),
                new Employee(1,"Vilas",30000),
                new Employee(1,"Mahi",50000)
        );
        List<Integer> epSal=new ArrayList<>();

        epSal=epLi1.stream().filter(c->c.salary>20000).map(c->c.salary).collect(Collectors.toList());
    }

}
