import java.io.IOException;
import java.util.*;

public class main {

	public static void main(String[] args) {
		Loader load = new Loader();
		ArrayList<Person> people;
		try{
			people = load.loadPeople();
			System.out.println(people.size());
		}catch(IOException e){
			System.out.println("Error occured : " + e.getMessage());
		}
	}

}
