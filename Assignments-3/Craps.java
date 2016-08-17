import java.util.Random;

public class Craps {


	public  int[] rollDices(){	
		
		int diceValue[] = new int[2];
		diceValue = randInts();
		return diceValue;
	}
	
	public  int[] randInts() {
		int randomNum[] = new int[2];
		Random rand = new Random();
		randomNum[0] = rand.nextInt(6) + 1;
	    System.out.println("Dice value of D1 :" +randomNum[0]);
	    randomNum[1] = rand.nextInt(6) + 1;
	    System.out.println("Dice value of D2 :" +randomNum[1]);
	    return randomNum;
	}
	
		
	public static void main(String[] args) {
		// Declaring local variables
		int diceCount = 0 , counter =0, maxCount=0, maxDiceVal =0 , dicesSum=0;
		int tempValue[] = new int[2];
		int point = 0, wins = 0, loss =0, gamecount=10;
		
		Craps CrapGame =  new Craps();
				
		for (int i=0; i<gamecount; i++){
			System.out.println("!!!Lets Play New Craps Game!!!");	
			// Initialize counter variables before each run
			diceCount = 0 ;
			dicesSum=0;
			counter =0;
			boolean notLoser = true;
			
			// First Roll of dices 
			tempValue = CrapGame.rollDices();
			dicesSum = tempValue[0] + tempValue[1];
			counter++;
			
			if ( dicesSum == 7 ){
				System.out.println("You Won Hurray!!!");	
				wins += 1;
				notLoser = false;
			}
			else if (dicesSum == 2 || dicesSum == 3 || dicesSum == 12){
				System.out.println("You Lost Sorry!!!");	
				notLoser = false;
				loss +=1;
			}
			else {
				point = dicesSum; 
				System.out.println("The Point is :"+ point);
			}
			
			diceCount += dicesSum;
			
			while(notLoser){
				
				tempValue = CrapGame.rollDices();
				dicesSum = tempValue[0] + tempValue[1];
				counter++;
				if ( dicesSum == 7 ){
					System.out.println("You Lost Sorry!!!");	
					notLoser = false;	
					loss +=1;
				}
				else if (dicesSum == point){
					System.out.println("You Won Hurray!!!");	
					notLoser = false;
					wins += 1;
				}
				else {
					diceCount += dicesSum;
				}
			}
			System.out.println("Number of Rolls :"+counter);		

			
			if ( diceCount > maxDiceVal){
				maxDiceVal = diceCount;
				maxCount = counter; 
			}
					
		}
	
		// Print summary of the Game 
		System.out.println("Total Number of program runs :"+gamecount);
		System.out.println("No of Wins :"+wins);	
		System.out.println("No of Loss :"+loss);
		System.out.println("Highest Number of Rolls :"+maxCount);	

		
	}
	

}
