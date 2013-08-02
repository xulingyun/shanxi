package my;

public class Myself {
	int level;
	long exp;
	long money;
	int nengliang;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public int getNengliang() {
		return nengliang;
	}

	public void setNengliang(int nengliang) {
		this.nengliang = nengliang;
	}

	public Myself() {
		this.level = 1;
		this.exp = 0;
		this.money = 0;
		this.nengliang = 20;
	}

	/*public Myself(int level, long exp, long money, int nengliang) {
		this.level = level;
		this.exp = exp;
		this.money = money;
		this.nengliang = nengliang;
	}*/
}
