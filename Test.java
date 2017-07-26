
public class Test {
	public static void main(String[] args) {

    	String db = System.getenv("$(env.DB_URL)");
    	
    	System.out.println(db);
    	String db2 = System.getProperty("${env.DB_URL}");
    	
    	System.out.println(db2);
    	String db3 = System.getenv("env.DB_URL");
    	
    	System.out.println(db3);
    	String db4 = System.getProperty("$env.DB_URL");
    	
    	System.out.println(db4);
    	
//    	String testing1 = System.getenv("$(env.DATABASE)");
//    	
//    	System.out.println(testing1);
//    	
//    	String testing2 = System.getenv("$(env.testdatabase)");
//    	
//    	System.out.println(testing1);
	}
}
