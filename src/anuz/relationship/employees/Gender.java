package anuz.relationship.employees;

import java.util.Random;

public class Gender {
	private enum Gen {
		Male,
		Female
	};
	
	private Gen g;
	
	public Gen getGender() {
		Random rand = new Random();
		int randomizer = rand.nextInt(2)+0;
		if(randomizer == 1)
			g = Gen.Male;
		else
			g = Gen.Female;
		
		return g;
	}
}
