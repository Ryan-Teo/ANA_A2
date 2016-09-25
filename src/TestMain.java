import java.io.IOException;
import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		Loader load = new Loader();
		ArrayList<Person> people;
		Map<String, ArrayList<String>> options;
		
		//People testing
		try{
			people = load.loadPeople();
			for(Person thisPerson : people){
				System.out.printf("Name : %s\nHair Length : %s\nGlasses : %s\nFacial Hair : %s\nEye Color : %s\nPimples : %s\nHat : %s\nHair Color : %s\nNose Shape : %s\nFace Shape : %s\n-------------\n",
									thisPerson.getName(), thisPerson.getHairLength(), thisPerson.getGlasses(), thisPerson.getFacialHair(), thisPerson.getEyeColor(), thisPerson.getPimples(),
									thisPerson.getHat(), thisPerson.getHairColor(), thisPerson.getNoseShape(), thisPerson.getFaceShape());
			}
		}catch(IOException e){
			System.out.println("Error occured : " + e.getMessage());
		}
		
		
		
		
		//Options testing
		try{
			options = load.loadOptions();
			System.out.println("No. of options : " + options.size());
			for(Map.Entry<String, ArrayList<String>> entry : options.entrySet()){
				String key = entry.getKey();
				ArrayList<String> optionList = entry.getValue();
				System.out.println(">Key : "+key + " " + optionList.size());
				System.out.printf(">Options : ");
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
