/*
Khoo Zheng Jie, Anthony
I declare that all the following work is mine and have not passed my program to anyone.
I did not take CSIT111, and I am sorry I submitted my assignment late
Sir I saw that in your Assignment 1, for the sample display screen,it did not
contain any cards that have the digit 10, I included digit 10.
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

enum SuitEnum
{
	// declare constants of suits
	Spade ("S"),
	Heart("H"),
	Diamond ("D"),
	Club ("C");
	
	private String suit;
	
	SuitEnum(String suit) {
		
		this.suit = suit;
		
	}
	
	public String getSuit () {
		
		return suit;
		
	}
	
} // end of enum definition

enum RankEnum
{
	// declare constants of ranks
	Two 	("2"),
	Three	("3"),
	Four	("4"),
	Five	("5"),
	Six		("6"),
	Seven	("7"),
	Eight	("8"),
	Nine	("9"),
	Ten		("10"),
	Jack	("J"),
	Queen 	("Q"),
	King	("K"),
	Ace		("A");
	
	private String rank;
	
	RankEnum(String rank) {
		
		this.rank = rank;
		
	}
	
	public String getRank () {
		
		return rank;
		
	}
	
} // end of enum definition

class PlayingCard
{
	//initialise enums
	private SuitEnum suit;
	private RankEnum rank;
	
	//constructors
	public PlayingCard (SuitEnum suit, RankEnum rank) {
		
		this.suit = suit;
		this.rank = rank;
		
	}
	
	public PlayingCard(PlayingCard pc) {
		
		this(pc.suit, pc.rank);
		
	}
	
	//getters for enums
	public SuitEnum getSuit() {
		
		return this.suit;
		
	}
	
	public RankEnum getRank() {
		
		return this.rank;
		
	}
	
	//setter
	public void setCard(SuitEnum suit, RankEnum rank) {
		
		this.suit = suit;
		this.rank = rank;
		
	}
	
	// A method to get a string displaying the combination of Suit & Rank
	public String toString () {
		
		return String.format ("%s%s ",
								suit.getSuit(), 
								rank.getRank()
								);
								
	}
	
}

//Main class
//I use static in all methods in order to be able to reference
//out of public static void main.
class Enum_Sets
{
	
	private static Random rand;

	private static final int MAXC = 13;
	private static final int MAXD = 52;

		
	public static void printDeck(ArrayList<PlayingCard> values) {
		
		System.out.println("Printing from ArrayList" + "\n");
		
		int i = 0;
		
		for (PlayingCard v : values) {
			
			System.out.print(v);
						
			i++;
			
			//generate a new line once there are 13 cards displayed
			if (i%13 ==0)
				System.out.println("");
				
		}
		
		System.out.println ("\n-------------------------------------------------------\n");
	
	}
	
	public static void printDeck(PlayingCard[] valuesArray){
		
		System.out.println("Printing from Array" + "\n");
		
		int j = 0;
		
		for(int i = 0; i< valuesArray.length; i++) {
			
			System.out.print(valuesArray[i]);
			
			//generate a new line once there are 13 cards displayed
			j++;
			if (j%13 ==0)
				System.out.println("");
								
		}

		
		System.out.println ("\n-------------------------------------------------------\n");
	}
	//valuesArray now contains all elements from value ArrayList	
	public static void listToArray(ArrayList <PlayingCard> values, PlayingCard[] valuesArray) {
		
		//I realised that i cannot initialised a new values array in here like the following:
		//values = new values.toArray(new PlayingCard(values.size())
		//eitherwise the toArray elements for valuesArray will only be stored in this method
		valuesArray = values.toArray(valuesArray);
	
	}
	
	public static void deckOfCards(ArrayList<PlayingCard> values) {
	
		//using a nested for loop to generate the values
		for (SuitEnum suit : SuitEnum.values()) {
		
			for(RankEnum rank : RankEnum.values()) {
				
				values.add(new PlayingCard (suit, rank));
				
			}
		}
		
	}
	
	public static void shuffle(PlayingCard[] valuesArray) {
	
		Random r = new Random();
		
		//initialising integers
		int i = 0;
		int j = 0;
		
		//placeholder
		PlayingCard l;
		
		//Print out statement to show start of shuffle method
		System.out.println("Shuffle the cards - Array Version");
		
		//to make sure to randomly generate a shuffle max of 52 times
		//min of 1 time. Using this formula from internet.
		//r.nextInt((max - min) + 1) + min;
		int k = 1 + Math.abs(r.nextInt((52-1) + 1) + 1);
		
		//for loop, loops betwee 1 to k
		for (int h = 0; h < k; h++) {
			
			//Generate a random card in a pile of 52 cards
			i = Math.abs(r.nextInt((MAXD)));
			j = Math.abs(r.nextInt((MAXD)));
			
			//Exchanging position of cards with the use of a placeholder
			l = valuesArray[i];
			valuesArray[i] = valuesArray[j];
			valuesArray[j] = l;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		//initialise ArrayList, fill ArrayList, and print
		ArrayList <PlayingCard> values = new ArrayList<PlayingCard>();
		deckOfCards(values);
		printDeck(values);
		
		//initialise array
		PlayingCard[] valuesArray = new PlayingCard[MAXD];
		
		//I was wondering why after using listToArray method is not able to 
		//let values array have the elements information when called inside main method
		//which caused printDeck to print null values
		//googled and chance upon this document whereby it says
		//java is a pass-by-value not a pass-by-reference
		//which let me learnt something today 
		listToArray(values, valuesArray);		
		
		//printing valuesArray
		printDeck(valuesArray);
		
		//Shuffling valuesArray
		shuffle(valuesArray);
		
		//printing shuffled valuesArray
		printDeck(valuesArray);

	}
}


	