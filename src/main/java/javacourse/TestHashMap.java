package javacourse;

import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) {
		
		HashMap<String, String> capitalCitites = new HashMap<String, String>();
		
		capitalCitites.put("Jordan", "Amman");
		capitalCitites.put("Palistine", "Alqudes");
		capitalCitites.put("Iraq", "Baghdad");
		capitalCitites.put("Lebanon", "Beirut");
		
		System.out.println(capitalCitites);
		System.out.println(capitalCitites.entrySet());
		System.out.println(capitalCitites.keySet());
		System.out.println(capitalCitites.values());
		System.out.println(capitalCitites.get("Iraq"));
		System.out.println(capitalCitites.remove("Iraq"));
		System.out.println(capitalCitites);

	}

}
