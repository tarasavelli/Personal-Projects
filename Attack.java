/*
 * Attack Object - this object holds the name, type and speed of the attack that will be thrown at the user
 * 6/5/2020
 * Teddy Arasavelli
 */



public class Attack implements Comparable<Attack> {
	private String type;
	private String name;
	private double speed;
	
	
	
	/*
	 * Constructor 
	 * pre: assumes that the type is one of either punch, kick, elbow, knee
	 * post: creates an attack object with the given type and name and sets its speed
	 */
	public Attack(String type, String name) {
		if (type.equals("punch")) {
			this.speed = 5;
		} else if (type.equals("kick")) {
			this.speed = 3.2;
		} else if (type.equals("elbow")) {
			this.speed = 4;
		} else if (type.equals("knee")) {
		this.speed = 1.5;
		}
		
		this.name = name;
		this.type = type;
		
	}
	
	/*
	 * pre: assumes that speed is correct
	 * post: returns speed
	 */
	public double getSpeed() {
		return speed;
	}
	
	/*
	 * pre: assumes that the variable passed in is a double
	 * post: sets the attack speed to what was passed in.
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/*
	 * pre: assumes that the name is correct
	 * post: returns name
	 */
	public String getAttackName() {
		return this.name;
	}
	
	/*
	 * pre: assumes type is correct.
	 * post: returns attack type
	 */
	public String getAttackType() {
		return this.type;
	}
	
	
	//These are methods necessary to allows Attack to work with HashSet
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Attack) {
			return this.name.equals(((Attack) o).getAttackName());
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int bigPrime = 31;
		int littlePrime = 1;
		
		int hashCode = bigPrime * 1 + name.hashCode();
		return hashCode;
	}
	
	//Methods needed to work with TreeSet
	
	@Override
	public int compareTo(Attack attack) {
		return this.name.compareTo(attack.getAttackName());

	}
	
	
		
}

