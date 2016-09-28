import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Binary-search based guessing player.
 * This player is for task C.
 *
 * You may implement/extend other interfaces or classes, but ensure ultimately
 * that this class implements the Player interface (directly or indirectly).
 */
public class BinaryGuessPlayer implements Player
{
	Loader load = new Loader();
	ArrayList<Person> people;
	Map<String, ArrayList<String>> options;
	
	Map<String, Double> opNum;
	ArrayList<String> attributes = new ArrayList<String>();
	
	Person person;
    /**
     * Loads the game configuration from gameFilename, and also store the chosen
     * person.
     *
     * @param gameFilename Filename of game configuration.
     * @param chosenName Name of the chosen person for this player.
     * @throws IOException If there are IO issues with loading of gameFilename.
     *    Note you can handle IOException within the constructor and remove
     *    the "throws IOException" method specification, but make sure your
     *    implementation exits gracefully if an IOException is thrown.
     */
    public BinaryGuessPlayer(String gameFilename, String chosenName)
        throws IOException
    {
    	this.people = load.loadPeople(gameFilename);
    	for(Person personEntry : this.people){
    		if(personEntry.getAttr("name").equals(chosenName)){
    			this.person = personEntry;
    			break;
    		}
    	}
    	this.options = load.getOptions();
    	for(Map.Entry<String, ArrayList<String>> entry : options.entrySet()){
    		attributes.add(entry.getKey());
    	}
    } // end of BinaryGuessPlayer()


    public Guess guess() {
    	Guess.GuessType mType = null;
    	String mAttribute = null, mValue = null;
    	int ppl = people.size();
    	double percent, goalPercent = 1, wantedPercent = 0.5;
    	opNum = new HashMap<String, Double>();
    	
    	//If one person left in array, guess Person
    	if (people.size() == 1){
    		mType = Guess.GuessType.Person;
    		mAttribute = "";
    		mValue = people.get(0).getAttr("name");
    	}
    	//If guessing attribute...
    	else{
    		mType = Guess.GuessType.Attribute;
    		//Loop for choosing the attribute
    		for(String attrKey : options.keySet()){
    			opNum.clear();
    			if (attrKey.equals("name")){
    				continue;
    			}
    			//Loop to iterate and count total of each option
    			for (int i = 0; i < people.size(); i++){
    				String op = people.get(i).getAttr(attrKey);
	    			if (op.equals("name")){
	    				break;
	    			}
	    			if(opNum.containsKey(op)){
	    				opNum.put(op,opNum.get(op) + 1);
	    			}	
	    			else {
	    				opNum.put(op,(double) 1);
	    			}
	    		}
    			//Changing total number to percentage
				for(Map.Entry<String, Double> entry : opNum.entrySet()){
					String key = entry.getKey();
					double value = entry.getValue();
					percent = value/ppl;
					//Calculate difference between percent and 50%
					double distance = Math.abs(percent - wantedPercent);
					//break out of loop if percent is a perfect 50%
					if (distance == 0){
						mAttribute = attrKey;
			    		mValue = key;
			    		return new Guess(mType, mAttribute, mValue);	
					}
					//find most ideal attribute and value to guess
					if(distance < goalPercent){
						goalPercent = distance;
						mAttribute = attrKey;
			    		mValue = key;
					}
				}
    		}
    	}
    	return new Guess(mType, mAttribute, mValue);
    } // end of guess()


	public boolean answer(Guess currGuess) {
	   	boolean bool = false;
    	String mAttribute = currGuess.getAttribute();
    	String mValue = currGuess.getValue();
    	Guess.GuessType mType = currGuess.getType();
    	// Check if the guess was correct
    	if(mAttribute.equals("") && mType.equals(Guess.GuessType.Person)){
    		// Guessing person
    		if(mValue.equals(this.person.getAttr("name"))){
    			bool = true;
    		}
    	}
    	else{
    		// Guessing attributes
    		if(attributes.contains(mAttribute)){
    			if(mValue.equals(this.person.getAttr(mAttribute))){
    				bool = true;
    			}
    		}
    	}
        return bool;
    } // end of answer()


	public boolean receiveAnswer(Guess currGuess, boolean answer) {

		String mAttribute = currGuess.getAttribute();
    	String mValue = currGuess.getValue();
    	Guess.GuessType mType = currGuess.getType();
    	ArrayList<Person> peopleRemove = new ArrayList<Person>();
    	ArrayList<String> optionRemove = new ArrayList<String>();
		if(mType.equals(Guess.GuessType.Person)){
			// If current guess was a person guess
			if(answer==true){
				//Return true if person is correct
				return true;
			}
		}
		else{
			// Delete people and options here
			if(answer == true){
				for (Iterator<Person> iterator = people.iterator(); iterator.hasNext();) {
				    Person person = iterator.next();
				    if (!person.getAttr(mAttribute).equals(mValue)) {
				        // Remove the current element from the iterator and the list.
				        iterator.remove();
				    }
				}
			}
			else{
				for (Iterator<Person> iterator = people.iterator(); iterator.hasNext();) {
				    Person person = iterator.next();
				    if (person.getAttr(mAttribute).equals(mValue)) {
				        // Remove the current element from the iterator and the list.
				        iterator.remove();
				    }
				}
			}
		}
        return false;
    } // end of receiveAnswer()

} // end of class BinaryGuessPlayer
