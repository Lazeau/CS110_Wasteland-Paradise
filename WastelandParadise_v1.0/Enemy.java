
public class Enemy {
	String type = "";
	int enemyHealth = 0;
	int enemyDamage = 0;
	
	Enemy(String type) {
		if (type.equals("Animal")) {
			this.type = "Animal";
			this.enemyHealth = 100;
			this.enemyDamage = 10;
		} else if (type.equals("Zombie")){
			this.type = "Zombie";
			this.enemyHealth = 150;
			this.enemyDamage = 30;
		} else {
			// This type of enemy should not be generated unless you tamper with the code
			this.type = "Super Mutant";
			this.enemyHealth = 500;
		}
	}
	
	public String getType() {
		return type;
	}
	
	public int getHealth() {
		return enemyHealth;
	}
	
	public int getDamage() {
		return enemyDamage;
	}
	
	public void setHealth(int damage) {
		enemyHealth = enemyHealth - damage;
	}
}
