import java.util.Random;
import java.util.Scanner; 

public class Dices {


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
		int point = 0, wins = 0, loss =0, gamecount=0 , money =0, bet=0;
		char input;
		boolean play;
		Dices CrapGame =  new Dices();
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Do you want to play Craps ( Enter Y/y to play) : ");
		input = reader.next().charAt(0);
		
		if ( input == 'Y' || input == 'y')
				play = true;
		else    play = false;
		
//		System.out.println("Enter how many times you wanna play : ");
//		gamecount = reader.nextInt();
		
		System.out.println("Enter how much money you got : ");
		money = reader.nextInt();
				
//		for (int i=0; i<gamecount; i++){
		while(money > 0 && play )
		{
			System.out.println("!!!Lets Play New Dices Game!!!");	
			System.out.println("Enter how much money you wanna bet : ");
			bet = reader.nextInt();
			if ( bet > money )
			{
				do{
				System.out.println("You cant bet more than you have");
				System.out.println("Enter how much money you wanna bet : ");
				bet = reader.nextInt();
				} while(bet > money);
				
			}
			
			
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
				money +=  bet ;
				wins += 1;
				notLoser = false;
			}
			else if (dicesSum == 2 || dicesSum == 3 || dicesSum == 12){
				System.out.println("You Lost Sorry!!!");	
				notLoser = false;
				money -= bet;
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
					money -= bet;
					loss +=1;
				}
				else if (dicesSum == point){
					System.out.println("You Won Hurray!!!");	
					notLoser = false;
					wins += 1;
					money += bet;
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
			System.out.println("You have $"+money + " remaining");
			if (money > 0) {
			System.out.println("Do you want play again ( Enter Y/y to play) : ");
			input = reader.next().charAt(0);
			if ( input == 'Y' || input == 'y')
					play = true;
			else    play = false;
			}
		}
	
		// Print summary of the Game 
		System.out.println("You have $"+money);
		System.out.println("No of Wins :"+wins);	
		System.out.println("No of Loss :"+loss);
		System.out.println("Maximum Number of Rolls :"+maxCount);	

		
//	}
	}
	

}
