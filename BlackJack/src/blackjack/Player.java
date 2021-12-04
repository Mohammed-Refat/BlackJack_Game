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
public class Player {
    
    private String Name;
    private int Score;
    public Card cards[]=new Card[11]; 
    public boolean bj=false;
    public boolean lost=false;

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
    
    
}
