import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestMasterC {

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
