import java.util.Random;

public class diceRoll {

	public  int rollDice(){	
		
		int diceValue = randInt(1,6);
		return diceValue;
	}
	
	public  int randInt(int min, int max) {
		
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
	    System.out.println("Dice value :"+randomNum);
	    return randomNum;
	}
	
		
	public static void main(String[] args) {
		
		int diceCount = 0 , tempValue=0, counter =0, maxCount=0, maxDiceVal =0;
		
		    
		diceRoll D1 =  new diceRoll();
		for (int i=0; i<1000; i++){
		diceCount = 0 ;
		tempValue=0;
		counter =0;
		boolean notOne = true;
		while(notOne){
			tempValue = D1.rollDice();
			counter++;
			if ( tempValue != 1 ){
				diceCount += tempValue;
			}
			else notOne = false;
		}
		System.out.println("Number of Rolls :"+counter);		
		System.out.println("Total count :"+diceCount);	
		
		if ( diceCount > maxDiceVal){
			maxDiceVal = diceCount;
			maxCount = counter; 
		}
				
	}
		
		System.out.println("Total Number of program runs 1000:");
		System.out.println("Highest Number of Rolls :"+maxCount);	
		System.out.println("Total count :"+maxDiceVal);	
		
	}
	

}
