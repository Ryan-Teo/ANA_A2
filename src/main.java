import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) {
		Loader load = new Loader();
		ArrayList<Person> people;
		Map<String, ArrayList<String>> options;
		try{
			people = load.loadPeople();
			System.out.println(people.size());
		}catch(IOException e){
			System.out.println("Error occured : " + e.getMessage());
		}
		try{
			options = load.loadOptions();
			System.out.println(options.size());
			for(Map.Entry<String, ArrayList<String>> entry : options.entrySet()){
				String key = entry.getKey();
				ArrayList<String> optionList = entry.getValue();
				System.out.println(">Key : "+key + " " + optionList.size());
				System.out.printf(">>Options : ");
				for(String optionEntry : optionList){
					System.out.printf(optionEntry+" ");
				}
				System.out.println();
			}
		}catch(IOException e){
			System.out.println("Error occured : " + e.getMessage());
		}
	}

}
