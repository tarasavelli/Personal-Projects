import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestClient{
	
	
	public static void main(String[] args) {
		Set<Attack> attacks = new HashSet<Attack>();
		attacks.add(new Attack("punch", "jab"));
		attacks.add(new Attack("punch", "uppercut"));
		attacks.add(new Attack("punch", "jab"));
		for(Attack attack : attacks) {
			System.out.println(attack.getAttackName());
		}
		
		
		
		
	}
	 
		

		
		
		
		
		
}

