package Programs;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class RemoveDuplicate{

    @Test(enabled = false)
    public void test(){
        String ip="mmmddsslll";
        String op="";
        Set<Character> s=new HashSet<>();
        for(char v:ip.toCharArray()){
            s.add(v);
        }

        for(Character v: s){
                int counter = 0;
//                Character c=it.next();
                for (int i = 0; i < ip.length(); i++) {
                    if (ip.charAt(i) == v) {
                        counter++;
                    }
                }
                if (!(counter > 2)) {
                    op = op + ip.charAt(1);
                }
                System.out.println("stop");
            }
        System.out.println(op);
        }

        @Test(enabled = false)
        public void restTest(){
            RestAssured.baseURI="";
            given().
                    header("key","value").
                    queryParam("key","value").
                    pathParam("key","value").
                    auth().
                    preemptive().
                    basic("usserid","paswd").
                    body("json").
                    when().
                    post("path").
                    then().
                    assertThat().body("staus",equalTo("")).
                    and().body("code",is("das"));

        }

        @Test
        public void creatingPOJO(){
            Employee emp=new Employee();
            emp.setId("12");
            emp.setSalary(1200);
            cars cars1=new cars();
            cars cars2=new cars();
            cars1.setCompany("Audi");
            cars1.setModel("Q7");
            cars2.setCompany("BMW");
            cars2.setModel("X5");
            resourceInfo resourceInfo=new resourceInfo();
            resourceInfo.setAge(30);
            resourceInfo.setCars(Arrays.asList(cars1,cars2));
            emp.setResourceInfo(resourceInfo);
            JSONObject jobj=new JSONObject(emp);
            System.out.println(jobj.toString());
            String company=JsonPath.from(jobj.toString()).get("resourceInfo.cars[0].company");
            System.out.println(company);

            JSONObject JSONObj= jobj.getJSONObject("resourceInfo");
            JSONArray jArr=JSONObj.getJSONArray("cars");
            System.out.println(jArr);
            for(int i=0;i< jArr.length();i++){
                JSONObject job=jArr.getJSONObject(i);
//                System.out.println(job.get());
            }

            Map.of("content-type","json","accepted-lang","ENG");
        }

    @Test
    public void jsonParse() throws IOException {
        System.out.println(this.getClass().getClassLoader().getResource("data/body.json"));;
        String json=new String(Files.readAllBytes(Paths.get(this.getClass().getClassLoader().getResource("data/body.json").getPath())));
        System.out.println(json);
        String jsonPatExp="sales[]";
        JsonPath jp=new JsonPath(json);
        int size=jp.get("sales.size()");
        jp.get("find{it.sales.age==27}");
        for(int i=0;i<size;i++){
            if(jp.get("sales["+i+"].age").equals(27)){
                System.out.println("The firstname whose age is 27 is "+jp.get("sales["+i+"].firstName"));
            }
        }

        //jsonpath to find object whose firstname is sally
        jp.get("sales.findAll{sales->sales.firstName=='Sally'}");

        //to get age whose firstname is sally
        jp.get("sales.findAll{sales->sales.firstName=='Sally'}.age");
    }
}