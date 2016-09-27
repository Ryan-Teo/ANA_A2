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
	Loader load = new Loader();
	ArrayList<Person> people;
	Map<String, ArrayList<String>> options;
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
    public RandomGuessPlayer(String gameFilename, String chosenName)
        throws IOException
    {
    	this.people = load.loadPeople(gameFilename);
    	for(Person personEntry : this.people){
    		if(personEntry.getName().equals(chosenName)){
    			this.person = personEntry;
    			break;
    		}
    	}
    	this.options = load.getOptions();
    } // end of RandomGuessPlayer()


    public Guess guess() {
    	Guess.GuessType mType = null;
    	String mAttribute = null, mValue = null;
    	
    	
    	if (people.size() == 1){
    		mType = Guess.GuessType.Person;
    		mAttribute = null;
    		mValue = people.get(0).getName();
    	}
    	else{
    		for(Map.Entry<String, ArrayList<String>> entry : options.entrySet()){
    			
    		}
    	}
    	
    	
    	
        // placeholder, replace
        return new Guess(Guess.GuessType.Person, "", "Placeholder");
    } // end of guess()


    public boolean answer(Guess currGuess) {

        // placeholder, replace
        return false;
    } // end of answer()


	public boolean receiveAnswer(Guess currGuess, boolean answer) {

        // placeholder, replace
        return true;
    } // end of receiveAnswer()

} // end of class RandomGuessPlayer
