import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger; 

public class Test {


	  
	private static org.apache.log4j.Logger log = Logger.getLogger(Test.class);
	
	   
	   public static void main(String[] args){
		   BasicConfigurator.configure();
	     log.debug("Hello this is a debug message");
	   }
}