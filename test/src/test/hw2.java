package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0344218_葉建夆
 * Try to write some comments for your codes (methods, 15 points)
 */
public class hw2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int card_n=0;card_n<nDeck;card_n++) { //有幾副牌
			for(int card_s=1;card_s<=4;card_s++) //牌的花色 S,H,D,C
			{
				for(int card_r=1;card_r<=13;card_r++) //牌的點數 1-13
				{
					Card card=new Card(card_s,card_r); //建立一副新的牌,並填入花色跟數字
					cards.add(card); //將剛剛建立的牌存入ArrayList裡面
				}
			}
		}
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int deck_count=1; //計算第幾副撲克牌的數量
		for(int i=0;i<cards.size();i++) {
			if(i%52==0) {
				System.out.println("\nDeck_"+deck_count); //印出第幾副牌
				deck_count++;
				}
			cards.get(i).printCard(); //印出所有的牌
			}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		switch(suit) { //用suit判斷並印出花色,rank判斷並印出點數(JQK特例)
		case 1:
			switch(rank) {
			case 11:
				System.out.println(suit+","+rank + " is J of Clubs");
				break;
			case 12:
				System.out.println(suit+","+rank + " is Q of Clubs");
				break;
			case 13:
				System.out.println(suit+","+rank + " is K of Clubs");
				break;
			default:
				System.out.println(suit+","+rank + " is "+ rank +" of Clubs");
				break;
			}
			break;
		case 2:
			switch(rank) {
			case 11:
				System.out.println(suit+","+rank + " is J of Diamonds");
				break;
			case 12:
				System.out.println(suit+","+rank + " is Q of Diamonds");
				break;
			case 13:
				System.out.println(suit+","+rank + " is K of Diamonds");
				break;
			default:
				System.out.println(suit+","+rank + " is "+ rank +" of Diamonds");
				break;
			}
			break;
		case 3:
			switch(rank) {
			case 11:
				System.out.println(suit+","+rank + " is J of Hearts");
				break;
			case 12:
				System.out.println(suit+","+rank + " is Q of Hearts");
				break;
			case 13:
				System.out.println(suit+","+rank + " is K of Hearts");
				break;
			default:
				System.out.println(suit+","+rank + " is "+ rank +" of Hearts");
				break;
			}
			break;
		case 4:
			switch(rank) {
			case 11:
				System.out.println(suit+","+rank + " is J of Spades");
				break;
			case 12:
				System.out.println(suit+","+rank + " is Q of Spades");
				break;
			case 13:
				System.out.println(suit+","+rank + " is K of Spades");
				break;
			default:
				System.out.println(suit+","+rank + " is "+ rank +" of Spades");
				break;
			}
			break;
		}
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
