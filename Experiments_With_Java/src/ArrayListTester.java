import java.util.HashMap;

public class ArrayListTester {

	public static void main(String[] args) {
		HashMap<String, Double> grades = new HashMap<String, Double>();
		
//		System.out.println(grades);
//		System.out.println(grades != null);
//		System.out.println(grades.size());
//		System.out.println(grades.containsKey("Alan"));
//		System.out.println(grades.containsValue(7.5));
		
		grades.put("Alan", 8.0);
		
//		System.out.println(grades.get("Alan"));
		
		grades.put("Mark", 7.5);
		
//		System.out.println(grades);
		
		grades.put("Mark", 6.0);
		grades.put("John", 7.0);
		
//		System.out.println(grades.get("Mark"));
//		System.out.println(grades);
		double totalGrades = 0;
		
		for (String name : grades.keySet()) {
			totalGrades += grades.get(name);
		}
		
		double totalGrades1 = 0;
		
		for (HashMap.Entry<String, Double> entry : grades.entrySet()) {
			totalGrades1 += entry.getValue();
		}
		
		System.out.println(totalGrades1);
	}
	
}
