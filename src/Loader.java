import java.io.*;
import java.util.*;

public class Loader {
	
	Map<String, ArrayList<String>> options = new HashMap<String, ArrayList<String>>();
	
	ArrayList<Person> loadPeople(String gameFilename) throws IOException{
		String line, token, name = null, hairLength = null, glasses = null, facialHair = null;
		String eyeColor = null, pimples = null, hat = null, hairColor = null, noseShape = null, faceShape = null;
		FileReader fr = new FileReader(gameFilename);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Person> people = new ArrayList<Person>();
		while((line=br.readLine()) != null){
			if(line.equals("")){
				continue;
			}
			if(line.charAt(0)!='P'){
				continue;
			}
			else{
				name = line;
				while((line=br.readLine()) != null){
					if(line.equals("")){
						break;
					}
					else{
						StringTokenizer st = new StringTokenizer(line);
						token = st.nextToken();
						if(token.equals("hairLength")){
							hairLength = st.nextToken();
							addOptions ("hairLength", hairLength);
						}
						else if(token.equals("glasses")){
							glasses = st.nextToken();
							addOptions ("glasses", glasses);
						}
						else if(token.equals("facialHair")){
							facialHair = st.nextToken();
							addOptions ("facialHair", facialHair);
						}
						else if(token.equals("eyeColor")){
							eyeColor = st.nextToken();
							addOptions ("eyeColor", eyeColor);
						}
						else if(token.equals("pimples")){
							pimples = st.nextToken();
							addOptions ("pimples", pimples);
						}
						else if(token.equals("hat")){
							hat = st.nextToken();
							addOptions ("hat", hat);
						}
						else if(token.equals("hairColor")){
							hairColor = st.nextToken();
							addOptions ("hairColor", hairColor);
						}
						else if(token.equals("noseShape")){
							noseShape = st.nextToken();
							addOptions ("noseShape", noseShape);
						}
						else if(token.equals("faceShape")){
							faceShape = st.nextToken();
							addOptions ("faceShape", faceShape);
						}
					}
					
				}
			Person person = new Person(name, hairLength, glasses, facialHair, eyeColor, pimples, hat, hairColor, noseShape, faceShape);
			people.add(person);
			}
		}
		br.close();
		fr.close();
		return people;
	}

	private void addOptions(String attribute, String value){
		if(options.containsKey(attribute)){
			//if attribute already has a list
			if(!options.get(attribute).contains(value)){
				//if value does not exist, add to list
				options.get(attribute).add(value);
			}
		}
		else{
			ArrayList<String> optionList = new ArrayList<String>();
			optionList.add(value);
			options.put(attribute, optionList);
		}
	}

	public Map<String, ArrayList<String>> getOptions() {
		return options;
	}
	
	
//	Map<String, ArrayList<String>> loadOptions(ArrayList<Person> people) throws IOException{
//		String line, list;
//		Map<String, ArrayList<String>> options = new HashMap<String, ArrayList<String>>();
//		FileReader fr = new FileReader(gameFilename);
//		BufferedReader br = new BufferedReader(fr);
//		while((line=br.readLine()) != null){
//			if(line.equals("")){
//				break;
//			}
//			ArrayList<String> optionList = new ArrayList<String>();
//			StringTokenizer st = new StringTokenizer(line);
//			list = st.nextToken();
//			while(st.hasMoreTokens()){
//				optionList.add(st.nextToken());
//			}
//			options.put(list, optionList);
//		}
//		br.close();
//		fr.close();
//		return options;
//	}

}
