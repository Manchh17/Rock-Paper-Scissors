import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static boolean playAgain(Scanner scanner) {
        System.out.println("Play again? Y(8), N(9)?");
        switch (scanner.nextInt()) {
        case 8:
            System.out.println("Rock, Paper, Scissors!");
            return true;
        default:
            System.out.println("Thanks for playing!");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RPSPlayer computer = new RandomComputerPlayer(new Random());
        RPSPlayer human = new HumanPlayer(scanner);

        System.out.println("Rock Paper Scissors, by 200_success!");
        do {
            String comp = computer.play();
            String you = human.play();

            System.out.printf("%s vs. %s", comp, you);
            if (you.equals(comp)) {
                System.out.println(", IT'S A TIE!");
            } else if ( ("Rock".equals(you) && "Scissors".equals(comp)) ||
                        ("Scissors".equals(you) && "Paper".equals(comp)) ||
                        ("Paper".equals(you) && "Rock".equals(comp)) ) {
                System.out.println("! You win!");
            } else {
                assert (("Rock".equals(comp) && "Scissors".equals(you)) ||
                        ("Scissors".equals(comp) && "Paper".equals(you)) ||
                        ("Paper".equals(comp) && "Rock".equals(you)));
                System.out.println("! You lose!");
            }
        } while (playAgain(scanner));
    }
}
