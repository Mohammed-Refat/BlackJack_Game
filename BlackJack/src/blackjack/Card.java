/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
/**
 *
 * @author hi tec
 */
public class Card {
     private  int suit;
     private  int rank;
     private  int value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public Card(Card obj) {
    this.suit = obj.suit;
        this.rank = obj.rank;
        this.value = obj.value;
    
    }

    public Card() { //to initialize the cards without constructore
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
    
}
