import java.util.Random;

public class Helper {
	int getRandom(int limit){
		Random rand = new Random(System.currentTimeMillis());
		int random = rand.nextInt(limit);
		return random;
	}
}
