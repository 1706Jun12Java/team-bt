import java.util.Map;


public class Test {

	public static void main(String[] args) {

//		testURDao();
		Map<String, String> env = System.getenv();
		
//		for (String envName : env.keySet()) {
//		    System.out.format("%s=%s%n", envName, env.get(envName));
//		}

		System.out.println(env.get("DB_PASSWORD"));
		
		
		System.out.println(System.getenv("DB_PASSWORD"));
		System.out.println(System.getenv("DB_USERNAME"));
		System.out.println(System.getenv("DB_URL"));


//    	String testing1 = System.getenv("$(env.DATABASE)");
//    	
//    	System.out.println(testing1);
//    	
//    	String testing2 = System.getenv("$(env.testdatabase)");
//    	
//    	System.out.println(testing1);
	}
	
}
