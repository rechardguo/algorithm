package rechard.learn.algorithm;
/**
 * 2元买一瓶，2个空瓶换1瓶，4个瓶盖换1瓶
 * 问100元买几瓶？
 * @author Rechard
 *
 */
public class WineBuy {
	
	public static int buy(int amount){
		int bottle = amount>>1;
		int bottleGai = bottle ;
		int num = bottle;
		while(bottleGai>3 || bottle>1){
			while(bottleGai>3){
				int changeBottle = bottleGai>>2;
				num+=changeBottle;
				bottle+=changeBottle;
				bottleGai=changeBottle+(bottleGai%4);
			}
			while(bottle>1){
				int changeBottle = bottle>>2;
				num+=changeBottle;
				bottle=changeBottle+(bottle%2);
				bottleGai+=changeBottle;
			}
		}
		return num;
	}
	public static int Drink(int n,int d,int p,int total){
		int drink = n>>1;
		int leftd = d + drink%2;
		int leftp = p + drink%4;
		int s = drink>>1;
		int f = drink>>2;
		if(s>1||f>3){
			total = Drink(drink, leftd, leftp,total);
		}
		return total + drink + s + f ;
	}
	public static void main(String[] args) {
		for(int i=0;i<=100;i++){
			System.out.println("==========="+i+"=============");
			//System.out.println(Drink(i, 0, 0, 0));
			System.out.println(buy(i));
		}

	}
}
