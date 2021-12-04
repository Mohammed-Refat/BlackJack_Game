/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author hi tec
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static Game game = new Game();

    public static void main(String[] args) {
        // TODO code application logic here 

        GUI gui = new GUI();
        game.generate();
        game.setInfo_player();
        gui.runGUI(game.cards, game.players[0].cards, game.players[1].cards, game.players[2].cards, game.players[3].cards);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.println(game.players[i].getName() + "'s Player hand is :" + game.players[i].getScore());
                System.out.println("1 : HIT");
                System.out.println("2 : . STAND");
                Scanner read = new Scanner(System.in);
                int choice = read.nextInt();
                if (choice == 1) {
                    game.players[i].cards[j] = game.draw();

                    gui.updatePlayerHand(game.players[i].cards[j], i);////GUI

                    int val = game.players[i].cards[j].getValue();
                    game.players[i].setScore(game.updateScore(i, val));
                    if (game.players[i].getScore() == 21) {
                        game.players[i].bj = true;
                        break;
                    } else if (game.players[i].getScore() > 21) {
                        game.players[i].lost = true;
                        game.valid = false;
                        System.out.println(" You BUSTED ");
                        break;
                    }
                } else {
                    System.out.println("Your Score is "+game.players[i].getScore());
                    break;
                }
            }
        }
        for (int j = 0; j < 11; j++) { //Dealer
            game.players[3].cards[j] = game.draw();
            gui.updateDealerHand(game.players[3].cards[j], game.cards);////Dealer

            int val = game.players[3].cards[j].getValue();
            game.players[3].setScore(game.updateScore(3, val));
            if (game.players[3].getScore() == 21) {
                game.players[3].bj = true;
                break;
            } else if (game.players[3].getScore() > 21) {
                game.players[3].lost = true;
                game.valid = false;
                break;
            } else {
                int maxi = 0;
                for (int i = 0; i < 4; i++) {
                    if (game.players[i].lost==false) {
                        if (game.players[i].getScore() > maxi) {
                            maxi = game.players[i].getScore();
                        }
                    }
                }
                if(game.players[3].getScore()==maxi)//to check the Dealer have the Max Score 
                {
                    if(game.players[0].getScore()!=maxi && game.players[1].getScore()!=maxi &&game.players[2].getScore()!=maxi)
                    break;
                }
            }
            

        }
                
        int cnt = 0;  //To calc number of blackjack
        int index[] = new int[4];
        for (int i = 0; i < 4; i++) {
            if (game.players[i].bj == true) {
                index[i] = 1;
                cnt++;
            }
        }
        if (cnt == 1) {//one blackjack

            for (int i = 0; i < 4; i++) {
                if (index[i] == 1) {
                    System.out.println(game.players[i].getName() + " Won");
                }
            }
        } else if (cnt > 1) {//more than one in this case they tied
            for (int i = 0; i < 4; i++) {
                if (index[i] == 1) {
                    System.out.println("Player " + index[i] + "Tie");
                }
            }

        } else {///No blackjack so we will calc number of max Score
            int maxi = 0;
            for (int i = 0; i < 4; i++) {
                if (game.players[i].getScore() < 21) {
                    if (game.players[i].getScore() > maxi) {
                        maxi = game.players[i].getScore();
                    }
                }
            }
            int maxNum = 0;
            int maxs[] = new int[4];
            if (maxi == 0) {//all of them are push
                System.out.println("PUSH");
            } else {
                for (int i = 0; i < 4; i++) {//
                    if (game.players[i].getScore() == maxi) {
                        maxNum++;
                        maxs[i] = 1;
                    }
                }
            }
            if (maxNum == 1) {
                for (int i = 0; i < 4; i++) {
                    if (maxs[i] == 1) {
                        System.out.println(game.players[i].getName() + " won");
                    }
                }
            } else if (maxNum > 1) {
                for (int i = 0; i < 4; i++) {
                    if (maxs[i] == 1) {
                        System.out.println("Player " + game.players[i].getName() + " tie");
                    }
                }
            }
        }
    }
}
