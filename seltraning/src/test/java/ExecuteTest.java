import java.io.IOException;
import java.util.Properties;

import com.techcanvass.operations.ReadObjects;

public class ExecuteTest {

	public static void main(String[] args) throws IOException {
		
		ReadObjects myobj = new ReadObjects();
		Properties p = myobj.getObjectRepository();
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("username"));
		
		

	}

}
