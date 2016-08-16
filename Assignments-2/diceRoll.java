import java.util.Random;

public class diceRoll {


	public  int rollDice(String dice){	
		
		int diceValue = randInt(1,6,dice);
		return diceValue;
	}
	
	public  int randInt(int min, int max , String dice) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
	    System.out.println("Dice value of "+ dice + " :" +randomNum);
	    return randomNum;
	}
	
		
	public static void main(String[] args) {
		
		int diceCount = 0 , tempValue=0, counter =0, maxCount=0, maxDiceVal =0 , tempValue2=0;
		
		    
		diceRoll D1 =  new diceRoll();
		diceRoll D2 =  new diceRoll();
		
		for (int i=0; i<100; i++){
		diceCount = 0 ;
		tempValue=0;
		tempValue2=0;
		counter =0;
		boolean notSeven = true;
		while(notSeven){
			tempValue = D1.rollDice("D1");
			tempValue2 = D2.rollDice("D2");
			tempValue += tempValue2;
			counter++;
			if ( tempValue != 7 ){
				diceCount += tempValue;
			}
			else notSeven = false;
		}
		System.out.println("Number of Rolls :"+counter);		
		System.out.println("Total count :"+diceCount);	
		
		if ( diceCount > maxDiceVal){
			maxDiceVal = diceCount;
			maxCount = counter; 
		}
				
	}
		
		System.out.println("Total Number of program runs 100:");
		System.out.println("Highest Number of Rolls :"+maxCount);	
		System.out.println("Total count :"+maxDiceVal);	
		
	}
	

}
