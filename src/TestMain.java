import java.io.IOException;
import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		Loader load = new Loader();
		Helper help = new Helper(); 
		ArrayList<Person> people;
		Map<String, ArrayList<String>> options;
		
		//People testing
		try{
			people = load.loadPeople("game1.config");
			for(Person thisPerson : people){
				System.out.printf("Name : %s\nHair Length : %s\nGlasses : %s\nFacial Hair : %s\nEye Color : %s\nPimples : %s\nHat : %s\nHair Color : %s\nNose Shape : %s\nFace Shape : %s\n-------------\n",
									thisPerson.getAttr("name"), thisPerson.getAttr("hairLength"), thisPerson.getAttr("glasses"), thisPerson.getAttr("facialHair"), thisPerson.getAttr("eyeColor"), thisPerson.getAttr("pimples"),
									thisPerson.getAttr("hat"), thisPerson.getAttr("hairColor"), thisPerson.getAttr("noseShape"), thisPerson.getAttr("faceShape"));
			}
		}catch(IOException e){
			System.out.println("Error occured : " + e.getMessage());
		}

		//Options testing
		options = load.getOptions();
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
		
		System.out.println(help.getRandom(5));
		
	}

}
