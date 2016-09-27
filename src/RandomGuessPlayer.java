import java.io.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Random guessing player.
 * This player is for task B.
 *
 * You may implement/extend other interfaces or classes, but ensure ultimately
 * that this class implements the Player interface (directly or indirectly).
 */
public class RandomGuessPlayer implements Player
{
	Helper help = new Helper();
	Loader load = new Loader();
	ArrayList<Person> people;
	Map<String, ArrayList<String>> options;
	Person person;
	ArrayList<String> attributes = new ArrayList<String>();
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
    public RandomGuessPlayer(String gameFilename, String chosenName)
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
    } // end of RandomGuessPlayer()


    public Guess guess() {
    	Guess.GuessType mType = null;
    	String mAttribute = null, mValue = null;
    	
    	
    	if (people.size() == 1){
    		mType = Guess.GuessType.Person;
    		mAttribute = "";
    		mValue = people.get(0).getAttr("name");
    	}
    	else{
    		mType = Guess.GuessType.Attribute;
    		mAttribute = attributes.get(help.getRandom(attributes.size()));
    		mValue = options.get(mAttribute).get(help.getRandom(options.get(mAttribute).size()));
    		//delete from attributes & person
    		//options if list size == 1, cannot guess that option ( while loop)
    	}
    	
        return new Guess(mType, mAttribute, mValue);
    } // end of guess()


    public boolean answer(Guess currGuess) {
    	String mAttribute = currGuess.getAttribute();
    	String mValue = currGuess.getValue();
    	Guess.GuessType mType = currGuess.getType();
    	//check if the guess was correct
    	if(mAttribute.equals("") && mType.equals(Guess.GuessType.Person)){
    		//Guessing person
    	}
    	else{
    		for(String attr : attributes){
        		if(mAttribute.equals(attr)){
        			if(mValue.equals(this.person.getAttr(attr))){
        				
        			}
        		}
    		}
    	}
        // placeholder, replace
        return false;
    } // end of answer()


	public boolean receiveAnswer(Guess currGuess, boolean answer) {
		//delete shit here
        // placeholder, replace
        return true;
    } // end of receiveAnswer()

} // end of class RandomGuessPlayer
