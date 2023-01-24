import java.util.Random;
import java.util.Scanner;  // Import the Scanner class
/**
    RockPaperScissors - класс игра (кто играет, кто выйграл, начать и прекратить игру, статистика побед)
 */
public class RockPaperScissors {
    // кто играет:
    Computer comp; // компьютер
    Human man; // человек (пользователь)

    // конструктор класса
    public RockPaperScissors() {
        comp = new Computer();
        man = new Human();
    }

    public void startGame() {
        System.out.println("Game Started!");
        int mt = man.getTurn();
        if (mt >= 0 && mt <= 2) {
            int ct = comp.getTurn();
            System.out.println("Man's turn: " + mt);
            System.out.println("Comp's turn: " + ct);
            System.out.println(winnerName(ct, mt) + " has won!");
        } else {
            System.out.println("No thanks");
        }
    }

    String winnerName(int ct, int mt) {
// [TODO] Подумать, как посчитать кто выйграл, зная кто что выкинул в виде чисел (0 - Бумага, 1 - Ножницы, 2 - Камень)
        if (ct == 0) {
            if (mt == 0) {
                return "noone";
            }
            if (mt == 1) {
                return "man";
            }
            if (mt == 2) {
                return "comp";
            }
        }
        if (ct == 1) {
            if (mt == 0) {
                return "comp";
            }
            if (mt == 1) {
                return "noone";
            }
            if (mt == 2) {
                return "man";
            }
        }
        if (ct == 2) {
            if (mt == 0) {
                return "man";
            }
            if (mt == 1) {
                return "comp";
            }
            if (mt == 2) {
                return "noone";
            }
        }
        return "XZ";
    }

    private class Computer {

        Random random;
        public Computer() {
            random = new Random();
        }

        public int getTurn() {
            int turn;
            turn = random.nextInt(3);
            System.out.println("Computer turn is " + turn);
            return turn;
        }
    }

    private class Human {
        Scanner input;

        public Human() {
            input = new Scanner(System.in);
        }

        public int getTurn() {
            System.out.println("Your turn, man! >>>");
            int turn = input.nextInt();
            System.out.println("Your turn is " + turn);
            return turn;
        }
    }
}