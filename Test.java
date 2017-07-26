
public class Test {
	public static void main(String[] args) {
		System.out.println("test");
		
    	System.out.println("Test");

    	String db = System.getenv("$(env.DB_URL)");
    	
    	System.out.println(db);
    	String db2 = System.getProperty("${env.DB_URL}");
    	
    	System.out.println(db2);
    	
//    	String testing1 = System.getenv("$(env.DATABASE)");
//    	
//    	System.out.println(testing1);
//    	
//    	String testing2 = System.getenv("$(env.testdatabase)");
//    	
//    	System.out.println(testing1);
	}
}
