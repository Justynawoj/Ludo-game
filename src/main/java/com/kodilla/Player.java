package com.kodilla;

import java.util.Random;

import javafx.event.ActionEvent;

public class Player extends ActionEvent {

    Pawn p1;
    Pawn p2;
    Pawn p3;
    Pawn p4;

    int newAvailablePosition1;
    int newAvailablePosition2;
    int newAvailablePosition3;
    int newAvailablePosition4;

    int startingPosition;
    int endingPosition;
    int startingWinningPosition;
    int endingWinningPosition;

    int p1HomePosition;
    int p2HomePosition;
    int p3HomePosition;
    int p4HomePosition;

    Color color;
    int thrownDice;

    boolean computersTurn = false;

    public Pawn getP1() {
        return p1;
    }

    public Pawn getP2() {
        return p2;
    }

    public Pawn getP3() {
        return p3;
    }

    public Pawn getP4() {
        return p4;
    }



    public Player(Field field1, Field field2, Field field3, Field field4, Color color) {

        this.color = color;
        this.p1 = new Pawn(this, field1);
        field1.setPawn(p1);
        this.p2 = new Pawn(this, field2);
        field2.setPawn(p2);
        this.p3 = new Pawn(this, field3);
        field3.setPawn(p3);
        this.p4 = new Pawn(this, field4);
        field4.setPawn(p4);//104
    }

//    public void setPositions() {
//        switch (this.color){
//            case BLUE:
//                 startingPosition = 1;
//                 endingPosition = 40;
//                 startingWinningPosition = 91;
//                 endingWinningPosition = 94;
//
//
//                  p1.setPosition(101);
//                  p2.setPosition(102);
//                  p3.setPosition(103);
//                  p4.setPosition(104);
//                  p1HomePosition = 101;
//                  p2HomePosition = 102;
//                  p3HomePosition = 103;
//                  p4HomePosition = 104;
//                  break;
//            case RED:
//                startingPosition = 1;
//                endingPosition = 40;
//                startingWinningPosition = 91;
//                endingWinningPosition = 94;
//
//
//                p1.setPosition(101);
//                p2.setPosition(102);
//                p3.setPosition(103);
//                p4.setPosition(104);
//                p1HomePosition = 101;
//                p2HomePosition = 102;
//                p3HomePosition = 103;
//                p4HomePosition = 104;
//                break;
//            case YELLOW:
//                startingPosition = 1;
//                endingPosition = 40;
//                startingWinningPosition = 91;
//                endingWinningPosition = 94;
//
//
//                p1.setPosition(101);
//                p2.setPosition(102);
//                p3.setPosition(103);
//                p4.setPosition(104);
//                p1HomePosition = 101;
//                p2HomePosition = 102;
//                p3HomePosition = 103;
//                p4HomePosition = 104;
//                break;
//            case GREEN:
//                startingPosition = 1;
//                endingPosition = 40;
//                startingWinningPosition = 91;
//                endingWinningPosition = 94;
//
//
//                p1.setPosition(101);
//                p2.setPosition(102);
//                p3.setPosition(103);
//                p4.setPosition(104);
//                p1HomePosition = 101;
//                p2HomePosition = 102;
//                p3HomePosition = 103;
//                p4HomePosition = 104;
//                break;
//         }
//   }

  /*     public static void startGame(Player player1, Player player2, Label label) {


          while (!player1.hasWon() && (!player2.hasWon())) {
          //    player1.setBluePawns(player1,player2);
          //    Controller.getController().setPawns(player1,player2);
          //	for (int i = 0; i < 100; i++) {


              player1.newMove(player1, player2);
              player2.newMove(player1,player2);
              System.out.println("------------");
          }
          if(player1.hasWon()){
              label.setText("wygral gracz nr 1");
          } else{
              label.setText("wygral gracz nr 2");
          }
      }
*/


  /*    public void newMove(Player player1, Player player2) {
          thrownDice = DiceService.getInstance().getDiceResult();
          System.out.println(thrownDice);
          resetNewPosition();
          calculateNewAvailablePositions(thrownDice);

        //  chooseNewAvailablePositions();
          changeOpponentsPosition(player1, player2);
          resetNewPosition();

      }
*/



//      public void calculateNewAvailablePositions(int rolledDiceNumber) {
//
//          // if thrown 6 goes out of home
//
//
//
//          if ((p1 >100) && (rolledDiceNumber == 6) && (p2!=startingPosition && p3!=startingPosition&& p4!=startingPosition)) {
//              newAvailablePosition1 = startingPosition;
//          }
//          if ((p2 >100) && (rolledDiceNumber == 6) && (p1!=startingPosition && p3!=startingPosition&& p4!=startingPosition)) {
//              newAvailablePosition2 = startingPosition;
//          }
//          if ((p3 >100) && (rolledDiceNumber == 6) && ((p2!=startingPosition && p1!=startingPosition && p4!=startingPosition))) {
//              newAvailablePosition3 = startingPosition;
//          }
//          if ((p4 >100) && (rolledDiceNumber == 6) && ((p2!=startingPosition && p3!=startingPosition && p1!=startingPosition))) {
//              newAvailablePosition4 = startingPosition;
//          }
//
//          if (this.color != Color.BLUE) {
//              if (p1 <100) {
//                  if (p1IsDifferent(rolledDiceNumber)) {
//
//                      if ((p1 >= startingPosition) && (p1 + rolledDiceNumber <= 40)) {
//                          newAvailablePosition1 = p1 + rolledDiceNumber;
//
//                      }
//                      if ((p1 >= startingPosition) && (p1 < 60)) {
//                          newAvailablePosition1 = ((p1 + rolledDiceNumber) % 40);
//
//                      }
//                      if (p1 < startingPosition) {
//                          if (p1 + rolledDiceNumber <= endingPosition) {
//                              newAvailablePosition1 = p1 + rolledDiceNumber;
//                          }
//                          if ((p1 + rolledDiceNumber > endingPosition) && (p1 + rolledDiceNumber + 50 <= endingWinningPosition) && p1 < 41) {
//                              newAvailablePosition1 = p1 + rolledDiceNumber + 50;
//                          }
//
//
//                      }
//                      else if ((p1 + rolledDiceNumber <= endingWinningPosition) && (p1 > 40)) {
//                          newAvailablePosition1 = p1 + rolledDiceNumber;
//                      }
//                  }
//
//              }
//
//              if (p2 <100) {
//                  if (p2IsDifferent(rolledDiceNumber)) {
//
//                      if ((p2 >= startingPosition) && (p2 + rolledDiceNumber <= 40)) {
//                          newAvailablePosition2 = p2 + rolledDiceNumber;
//
//                      }
//                      if ((p2 >= startingPosition) && (p2 + rolledDiceNumber > 40) && (p2 < 60)) {
//                          newAvailablePosition2 = p2 + rolledDiceNumber - 40;
//
//                      }
//                      if (p2 < startingPosition) {
//                          if (p2 + rolledDiceNumber <= endingPosition) {
//                              newAvailablePosition2 = p2 + rolledDiceNumber;
//                          }
//                          if ((p2 + rolledDiceNumber > endingPosition) && (p2 + rolledDiceNumber + 50 <= endingWinningPosition) && p2 < 41) {
//                              newAvailablePosition2 = p2 + rolledDiceNumber + 50;
//                          }
//
//
//                      }
//                      else if ((p2 + rolledDiceNumber <= endingWinningPosition) && (p2 > 40)) {
//                          newAvailablePosition2 = p2 + rolledDiceNumber;
//                      }
//
//                  }
//
//              }
//              if (p3 <100) {
//                  if (p3IsDifferent(rolledDiceNumber)) {
//
//                      if ((p3 >= startingPosition) && (p3 + rolledDiceNumber <= 40)) {
//                          newAvailablePosition3 = p3 + rolledDiceNumber;
//                      }
//                      if ((p3 >= startingPosition) && (p3 + rolledDiceNumber > 40) && (p3 < 60)) {
//                          newAvailablePosition3 = p3 + rolledDiceNumber - 40;
//
//                      }
//                      if (p3 < startingPosition) {
//                          if (p3 + rolledDiceNumber <= endingPosition) {
//                              newAvailablePosition3 = p3 + rolledDiceNumber;
//                          }
//                          if ((p3 + rolledDiceNumber > endingPosition) && (p3 + rolledDiceNumber + 50 <= endingWinningPosition) && p3 < 41) {
//                              newAvailablePosition3 = p3 + rolledDiceNumber + 50;
//                          }
//
//
//                      }
//                      else if ((p3 + rolledDiceNumber <= endingWinningPosition) && (p3 > 40)) {
//                          newAvailablePosition3 = p3 + rolledDiceNumber;
//                      }
//
//                  }
//
//              }
//
//              if (p4 <100) {
//                  if (p4IsDifferent(rolledDiceNumber)) {
//
//                      if ((p4 >= startingPosition) && (p4 + rolledDiceNumber <= 40)) {
//                          newAvailablePosition4 = p4 + rolledDiceNumber;
//                      }
//                      if ((p4 >= startingPosition) && (p4 + rolledDiceNumber > 40) && (p4 < 60)) {
//                          newAvailablePosition4 = p4 + rolledDiceNumber - 40;
//
//                      }
//                      if (p4 < startingPosition) {
//                          if (p4 + rolledDiceNumber <= endingPosition) {
//                              newAvailablePosition4 = p4 + rolledDiceNumber;
//                          }
//                          if ((p4 + rolledDiceNumber > endingPosition) && (p4 + rolledDiceNumber + 50 <= endingWinningPosition) && p4 < 41) {
//                              newAvailablePosition4 = p4 + rolledDiceNumber + 50;
//                          }
//                      }
//                       if ((p4 + rolledDiceNumber <= endingWinningPosition) && (p4 > 40)) {
//                          newAvailablePosition4 = p4 + rolledDiceNumber;
//                      }
//
//                  }
//
//              }
//
//          }
//
//          if (this.color == Color.BLUE) {
//              if (this.p1IsDifferent(rolledDiceNumber) && p1 <100) {
//                  if (p1 + rolledDiceNumber < endingPosition) {
//                      newAvailablePosition1 = p1 + rolledDiceNumber;
//                  } else if ((p1 + rolledDiceNumber > endingPosition) && (p1 + rolledDiceNumber + 50 < endingWinningPosition) && (p1 < 41)) {
//                      newAvailablePosition1 = p1 + rolledDiceNumber + 50;
//                  } else if ((p1 > 41) && (p1 + rolledDiceNumber <= endingWinningPosition)) {
//                      newAvailablePosition1 = p1 + rolledDiceNumber;
//                  }
//              }
//
//              if (this.p2IsDifferent(rolledDiceNumber) && p2 <100) {
//                  if (p2 + rolledDiceNumber < endingPosition) {
//                      newAvailablePosition2 = p2 + rolledDiceNumber;
//                  } else if ((p2 + rolledDiceNumber > endingPosition) && (p2 + rolledDiceNumber + 50 < endingWinningPosition) && (p2 < 41)) {
//                      newAvailablePosition2 = p2 + rolledDiceNumber + 50;
//                  } else if ((p2 > 41) && (p2 + rolledDiceNumber <= endingWinningPosition)) {
//                      newAvailablePosition2 = p2 + rolledDiceNumber;
//                  }
//              }
//              if (this.p3IsDifferent(rolledDiceNumber) && p3 <100) {
//                  if (p3 + rolledDiceNumber < endingPosition) {
//                      newAvailablePosition3 = p3 + rolledDiceNumber;
//                  } else if ((p3 + rolledDiceNumber > endingPosition) && (p3 + rolledDiceNumber + 50 < endingWinningPosition) && (p3 < 41)) {
//                      newAvailablePosition3 = p3 + rolledDiceNumber + 50;
//                  } else if ((p3 > 41) && (p3 + rolledDiceNumber <= endingWinningPosition)) {
//                      newAvailablePosition3 = p3 + rolledDiceNumber;
//                  }
//              }
//              if (this.p4IsDifferent(rolledDiceNumber) && p4 <100) {
//                  if (p4 + rolledDiceNumber < endingPosition) {
//                      newAvailablePosition4 = p4 + rolledDiceNumber;
//                  } else if ((p4 + rolledDiceNumber > endingPosition) && (p4 + rolledDiceNumber + 50 < endingWinningPosition) && (p4 < 41)) {
//                      newAvailablePosition4 = p4 + rolledDiceNumber + 50;
//                  } else if ((p4 > 41) && (p4 + rolledDiceNumber <= endingWinningPosition)) {
//                      newAvailablePosition4 = p4 + rolledDiceNumber;
//                  }
//
//              }
//
//          }
//          System.out.println("aktualne pozycje pionkow " + p1 + " " + p2 + " " + p3 + " " + p4);
//
//          System.out.println("mozliwe pozycje pionkow " + newAvailablePosition1 + " " + newAvailablePosition2 + " "
//                  + newAvailablePosition3 + " " + newAvailablePosition4);
//
//      }


//      public int choosePawnToMove(int fieldClicked) {
//
//          int newPosition = fieldClicked;
///*
//
//        if(computersTurn)  {
//            fieldClicked = randomMove.nextInt(4)+1;
//        }
//*/
//
//            if (fieldClicked == p1) {
//                p1 = newAvailablePosition1;
//                newPosition = p1;
//            }
//            if (fieldClicked == p2) {
//                p2 = newAvailablePosition2;
//                newPosition = p2;
//            }
//            if (fieldClicked == p3) {
//                p3 = newAvailablePosition3;
//                newPosition = p3;
//            }
//            if (fieldClicked == p4) {
//                p4 = newAvailablePosition4;
//                newPosition = p4;
//            }
//          return newPosition;
//      }

//      public void changeOpponentsPosition(Player player1, Player player2) {
//
//
//
//              if ((player1.p1 == player2.p1) || (player1.p2  == player2.p1)|| (player1.p3  == player2.p1) || (player1.p4  == player2.p1)){
//                  player2.p1 = player2.p1HomePosition;
//
//
//              }
//              if ((player1.p1 == player2.p2 )|| (player1.p2  == player2.p2) || (player1.p3  == player2.p2) || (player1.p4  == player2.p2)){
//                  player2.p2 = player2.p2HomePosition;
//
//
//              }
//              if ((player1.p1 == player2.p3) || (player1.p2  == player2.p3) || (player1.p3  == player2.p3) || (player1.p4  == player2.p3)){
//                  player2.p3 = player2.p3HomePosition;
//
//
//              }
//              if ((player1.p1 == player2.p4) || (player1.p2  == player2.p4) || (player1.p3  == player2.p4) || (player1.p4  == player2.p4)){
//                  player2.p4 = player2.p4HomePosition;
//
//
//              }
//      }

      @Override
      public String toString() {
          return "Player [color=" + color + "]";
      }

//      public boolean p1IsDifferent(int rolledDiceNumber) {
//
//          return ((p1 + rolledDiceNumber) %40 != p2) && ((p1 + rolledDiceNumber) %40 != p3) && ((p1 + rolledDiceNumber) %40 != p4) &&
//                  (p1 + rolledDiceNumber + 50 != p2) && (p1 + rolledDiceNumber + 50 != p3) && (p1 + rolledDiceNumber + 50 != p4);
//      }
//
//      public boolean p2IsDifferent(int rolledDiceNumber) {
//          return ((p2 + rolledDiceNumber) % 40 != p1) && ((p2 + rolledDiceNumber) %40 != p3) && ((p2 + rolledDiceNumber) %40 != p4) &&
//                   (p2 + rolledDiceNumber + 50 != p1) && (p2 + rolledDiceNumber + 50 != p3) && (p2 + rolledDiceNumber + 50 != p4);
//      }
//
//      public boolean p3IsDifferent(int rolledDiceNumber) {
//          return ((p3 + rolledDiceNumber) % 40 != p1) && ((p3 + rolledDiceNumber) %40 != p2) && ((p3 + rolledDiceNumber) %40 != p4) &&
//                  (p3 + rolledDiceNumber + 50 != p1) && (p3 + rolledDiceNumber + 50 != p2) && (p3 + rolledDiceNumber + 50 != p4);
//      }
//
//      public boolean p4IsDifferent(int rolledDiceNumber) {
//          return ((p4 + rolledDiceNumber) % 40 != p1) && ((p4 + rolledDiceNumber) %40 != p2) && ((p4 + rolledDiceNumber) %40 != p3) &&
//                  (p4 + rolledDiceNumber + 50 != p1) && (p4 + rolledDiceNumber + 50 != p2) && (p4 + rolledDiceNumber + 50 != p3);
//      }

      public Color getColor() {
        return color;
    }



}
