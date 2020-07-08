import java.util.Random;

public class User {
    int p1;
    int p2;
    int p3;
    int p4;

    int newAvailablePosition1;
    int newAvailablePosition2;
    int newAvailablePosition3;
    int newAvailablePosition4;

    int startingPosition;
    int endingPosition;
    int startingWinningPosition;
    int endingWinningPosition;

    String color;
    int thrownDice;

    public User(int p1, int p2, int p3, int p4, String color) {

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.color = color;

    }

    public void setPositions() {
        if (color == "blue") {
            startingPosition = 1;
            endingPosition = 50;
            startingWinningPosition = 101;
            endingWinningPosition = 104;
        }
        if (color == "red") {
            startingPosition = 6;
            endingPosition = 55;
            startingWinningPosition = 106;
            endingWinningPosition = 109;
        }
        if (color == "yellow") {
            startingPosition = 11;
            endingPosition = 60;
            startingWinningPosition = 111;
            endingWinningPosition = 114;
        }
        if (color == "green") {
            startingPosition = 16;
            endingPosition = 65;
            startingWinningPosition = 116;
            endingWinningPosition = 119;
        }
    }

    static int throwDice() {
        Random dice = new Random();
        return dice.nextInt(6) + 1;
    }

    public static void startGame(User user1, User user2) {
        user1.setPositions();
        user2.setPositions();

        while (!user1.hasWon() && (!user2.hasWon())) {
            user1.newMove(user1, user2);
            System.out.println("------------");
            user2.newMove(user1, user2);

        }
    }

    public boolean hasWon() {

        return (p1 >= startingWinningPosition && p1 <= endingWinningPosition)
                && (p2 >= startingWinningPosition && p2 <= endingWinningPosition)
                && (p3 >= startingWinningPosition && p3 <= endingWinningPosition)
                && (p4 >= startingWinningPosition && p4 <= endingWinningPosition);

    }
    // nowy ruch
    // rzut kostka
    // sprawdzenie pozycji
    // wybor pozycji
    // przypisanie nowej pozycji
    // sprawdzenie czy wygral



    public void newMove(User user1, User user2) {
        thrownDice = throwDice();
        System.out.println(thrownDice);
        calculateNewAvailablePositions(thrownDice);

        chooseNewAvailablePositions();
        changeOppontentsPosition(user1, user2);
        resetNewPosition();

    }

    public void calculateNewAvailablePositions(int rzut) {

        // if thrown 6 goes out of home

        if ((p1 <= 0) && (rzut == 6)) {
            newAvailablePosition1 = startingPosition;
        }
        if ((p2 <= 0) && (rzut == 6)) {
            newAvailablePosition2 = startingPosition;
        }
        if ((p3 <= 0) && (rzut == 6)) {
            newAvailablePosition3 = startingPosition;
        }
        if ((p4 <= 0) && (rzut == 6)) {
            newAvailablePosition4 = startingPosition;
        } else {

            // if new pX position is not equal to others p's positions and is higher than 0;

            if ((p1 > 0) && (p1 + rzut != p2) && (p1 + rzut != p3) && (p1 + rzut != p4)
                    && (p1 + rzut <= endingPosition)) {
                newAvailablePosition1 = p1 + rzut;
            }
            if ((p2 > 0) && (p2 + rzut != p1) && (p2 + rzut != p3) && (p2 + rzut != p4)
                    && (p2 + rzut <= endingPosition)) {
                newAvailablePosition2 = p2 + rzut;
            }
            if ((p3 > 0) && (p3 + rzut != p2) && (p3 + rzut != p1) && (p3 + rzut != p4)
                    && (p3 + rzut <= endingPosition)) {
                newAvailablePosition3 = p3 + rzut;
            }
            if ((p4 > 0) && (p4 + rzut != p2) && (p4 + rzut != p1) && (p4 + rzut != p3)
                    && (p4 + rzut <= endingPosition)) {
                newAvailablePosition4 = p4 + rzut;

            }

            // when arrived to end of common fields if can enter to winning fields
            if ((p1 > 0) && (p1 + rzut + 50 != p2) && (p1 + rzut + 50 != p3) && (p1 + rzut + 50 != p4)
                    && (p1 + rzut > endingPosition) && (p1 + rzut + 50 < endingWinningPosition) && (p1 < 66)) {
                newAvailablePosition1 = p1 + rzut + 50;
            }
            if ((p2 > 0) && (p2 + rzut + 50 != p1) && (p2 + rzut + 50 != p3) && (p2 + rzut + 50 != p4)
                    && (p2 + rzut > endingPosition) && (p2 + rzut + 50 < endingWinningPosition) && (p2 < 66)) {
                newAvailablePosition2 = p2 + rzut + 50;
            }
            if ((p3 > 0) && (p3 + rzut + 50 != p2) && (p3 + rzut + 50 != p1) && (p3 + rzut + 50 != p4)
                    && (p3 + rzut > endingPosition) && (p3 + rzut + 50 < endingWinningPosition) && (p3 < 66)) {
                newAvailablePosition3 = p3 + rzut + 50;
            }
            if ((p4 > 0) && (p4 + rzut + 50 != p2) && (p4 + rzut + 50 != p1) && (p4 + rzut + 50 != p3)
                    && (p4 + rzut > endingPosition) && (p4 + rzut + 50 < endingWinningPosition) && (p4 < 66)) {
                newAvailablePosition4 = p4 + rzut + 50;
            }

            // if moves are available inside of winning fields
            if ((p1 > 0) && (p1 + rzut != p2) && (p1 + rzut != p3) && (p1 + rzut != p4)
                    && (p1 + rzut <= endingWinningPosition) && (p1 > 66)) {
                newAvailablePosition1 = p1 + rzut;
            }

            if ((p2 > 0) && (p2 + rzut != p1) && (p2 + rzut != p3) && (p2 + rzut != p4)
                    && (p2 + rzut <= endingWinningPosition) && (p2 > 66)) {
                newAvailablePosition2 = p2 + rzut;
            }

            if ((p3 > 0) && (p3 + rzut != p2) && (p3 + rzut != p1) && (p3 + rzut != p4)
                    && (p3 + rzut <= endingWinningPosition) && (p3 > 66)) {
                newAvailablePosition3 = p3 + rzut;
            }

            if ((p4 > 0) && (p4 + rzut != p2) && (p4 + rzut != p1) && (p4 + rzut != p3)
                    && (p4 + rzut <= endingWinningPosition) && (p4 > 66)) {
                newAvailablePosition4 = p4 + rzut;
            }

        }
        System.out.println("aktualne pozycje pionkow " + p1 + " " + p2 + " " + p3 + " " + p4);

        System.out.println("mozliwe pozycje pionkow " + newAvailablePosition1 + " " + newAvailablePosition2 + " "
                + newAvailablePosition3 + " " + newAvailablePosition4);

    }

    public void chooseNewAvailablePositions() {

        Random randomNumber = new Random();
        int wybor = randomNumber.nextInt(4) + 1;

        if (wybor == 1) {
            p1 = newAvailablePosition1;
        }
        if (wybor == 2) {
            p2 = newAvailablePosition2;
        }
        if (wybor == 3) {
            p3 = newAvailablePosition3;
        }
        if (wybor == 4) {
            p4 = newAvailablePosition4;
        }
    }

    public void changeOppontentsPosition(User user1, User user2) {

        if (this.equals(user1)) {

            if (user1.p1 == user2.p1) {
                user2.p1 = 0;
            }
            if (user1.p1 == user2.p2) {
                user2.p2 = 0;
            }
            if (user1.p1 == user2.p3) {
                user2.p3 = 0;
            }
            if (user1.p1 == user2.p4) {
                user2.p4 = 0;
            }

            if (user1.p2 == user2.p1) {
                user2.p1 = 0;
            }
            if (user1.p2 == user2.p2) {
                user2.p2 = 0;
            }
            if (user1.p2 == user2.p3) {
                user2.p3 = 0;
            }
            if (user1.p2 == user2.p4) {
                user2.p4 = 0;
            }

            if (user1.p3 == user2.p1) {
                user2.p1 = 0;
            }
            if (user1.p3 == user2.p2) {
                user2.p2 = 0;
            }
            if (user1.p3 == user2.p3) {
                user2.p3 = 0;
            }
            if (user1.p3 == user2.p4) {
                user2.p4 = 0;
            }

            if (user1.p4 == user2.p1) {
                user2.p1 = 0;
            }
            if (user1.p4 == user2.p2) {
                user2.p2 = 0;
            }
            if (user1.p4 == user2.p3) {
                user2.p3 = 0;
            }
            if (user1.p4 == user2.p4) {
                user2.p4 = 0;
            }
        }
        if (this.equals(user2)) {

            if (user1.p1 == user2.p1) {
                user1.p1 = 0;
            }
            if (user1.p1 == user2.p2) {
                user1.p1 = 0;
            }
            if (user1.p1 == user2.p3) {
                user1.p1 = 0;
            }
            if (user1.p1 == user2.p4) {
                user1.p1 = 0;
            }

            if (user1.p2 == user2.p1) {
                user1.p2 = 0;
            }
            if (user1.p2 == user2.p2) {
                user1.p2 = 0;
            }
            if (user1.p2 == user2.p3) {
                user1.p2 = 0;
            }
            if (user1.p2 == user2.p4) {
                user1.p2 = 0;
            }

            if (user1.p3 == user2.p1) {
                user1.p3 = 0;
            }
            if (user1.p3 == user2.p2) {
                user1.p3 = 0;
            }
            if (user1.p3 == user2.p3) {
                user1.p3 = 0;
            }
            if (user1.p3 == user2.p4) {
                user1.p3 = 0;
            }

            if (user1.p4 == user2.p1) {
                user1.p4 = 0;
            }
            if (user1.p4 == user2.p2) {
                user1.p4 = 0;
            }
            if (user1.p4 == user2.p3) {
                user1.p4 = 0;
            }
            if (user1.p4 == user2.p4) {
                user1.p4 = 0;
            }
        }

    }

    private void resetNewPosition() {
        newAvailablePosition1 = p1;
        newAvailablePosition2 = p2;
        newAvailablePosition3 = p3;
        newAvailablePosition4 = p4;
        System.out.println(this.toString());
        System.out.println("nowe pozycje pionkow " + p1 + " " + p2 + " " + p3 + " " + p4);
    }

    @Override
    public String toString() {
        return "User [color=" + color + "]";
    }

}