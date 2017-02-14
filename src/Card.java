/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

/**
 *
 * @author Raahym
 */
public class Card {
	private final Rank rank;
    private final Suit suit;

    public Card(int rank, int suit){
        this.rank = Rank.values()[rank];
        this.suit = Suit.values()[suit];
    } 
    
    /**
     *  @return the order of suit in enum Suits
     */
    public int getSuit() {
        return suit.ordinal();
    }
    
    /**
     *  @return the order of rank in enum Ranks
     */
    public int getRank() {
        return rank.ordinal();
    }
    
    /**
     * output for cards
     * @return 
     */
        @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        int numberCard = this.rank.ordinal() + 1;

        if ( numberCard >= 2 && numberCard <= 10 ) {
            output.append(numberCard);
        } else {
            output.append(rank);
        }

        switch (suit.ordinal()) {
            case 0: output.append("A");
                    break;
            case 1: output.append("B");
                    break;
            case 2: output.append("C");
                    break;
            case 3: output.append("D");
                    break;
        }
        return output.toString();
    }

    enum Rank {
        A, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K
    }

    enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS
    }
}
