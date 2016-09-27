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
						}
						else if(token.equals("glasses")){
							glasses = st.nextToken();
						}
						else if(token.equals("facialHair")){
							facialHair = st.nextToken();
						}
						else if(token.equals("eyeColor")){
							eyeColor = st.nextToken();
						}
						else if(token.equals("pimples")){
							pimples = st.nextToken();
						}
						else if(token.equals("hat")){
							hat = st.nextToken();
						}
						else if(token.equals("hairColor")){
							hairColor = st.nextToken();
						}
						else if(token.equals("noseShape")){
							noseShape = st.nextToken();
						}
						else if(token.equals("faceShape")){
							faceShape = st.nextToken();
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

	private void addOptions(String attibute, String value) throws IOException{
		
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
