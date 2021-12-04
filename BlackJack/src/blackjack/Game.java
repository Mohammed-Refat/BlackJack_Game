/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author hi tec
 */
public class Game {
    public Player players[]=new Player[4];
    public Card cards[]=new Card[52];
    public boolean valid;

   
    
    public void generate(){
        int a=0;
        for(int i=0;i<13;i++){
             
                //suit 0
          if(i>=9) 
             cards[a]=new Card(0,i,10);  
          else
             cards[a]=new Card(0,i,i+1);
                
                //suit 1
          if(i>=9)
            cards[a+1]=new Card(1,i,10);
          else
             cards[a+1]=new Card(1,i,i+1);
          
                 //suit 2
          if(i>=9)
             cards[a+2]=new Card(2,i,10);
          else
             cards[a+2]=new Card(2,i,i+1);
          
                 //suit 3
          if(i>=9)
             cards[a+3]=new Card(3,i,10);
          else
             cards[a+3]=new Card(3,i,i+1);
          
          a+=4;
        }
              
    }
    public Card draw(){
        Card temp=new Card();
        while(true){
        Random rand =new Random(); 
        int randomChoice=rand.nextInt(52);       
        temp=cards[randomChoice];
        if(cards[randomChoice]==null)
            continue;
        cards[randomChoice]=null;
        break;
    }
        return temp;
    }
    public void setInfo_player(){
        
        for(int i=0;i<4;i++){
        System.out.println("Enter name of player "+(i+1));
        Scanner read=new Scanner(System.in);
        String nameOfPlayer=read.next();
        players[i]=new Player();
        players[i].setName(nameOfPlayer);
        players[i].cards[0]=draw();
        players[i].cards[1]=draw();
        
        players[i].setScore(players[i].cards[0].getValue()+players[i].cards[1].getValue());
        
            System.out.println("Your Cards is "+players[i].cards[0].getValue()+" "+players[i].cards[1].getValue());
           
        }
    }
    public int updateScore(int p,int val){
        
        return val+players[p].getScore();//after the fucntion returned new Score we will save it in main  
        
    }
    
}
