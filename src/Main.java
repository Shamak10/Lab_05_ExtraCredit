import java.util.Random;
import java.util.Scanner;

class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;
        int ties = 0;

        while (true) {
            System.out.println("Let's play Rock, Paper, Scissors!");
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }

            // Determine computer's strategy
            String strategy = getComputerStrategy();

            int computerChoiceIndex;
            String[] choices = {"rock", "paper", "scissors"};

            switch (strategy) {
                case "Least Used":
                    computerChoiceIndex = getLeastUsedChoiceIndex(playerChoice); // Implement this method
                    break;
                case "Most Used":
                    computerChoiceIndex = getMostUsedChoiceIndex(playerChoice); // Implement this method
                    break;
                case "Last Used":
                    computerChoiceIndex = getLastUsedChoiceIndex(playerChoice); // Implement this method
                    break;
                case "Cheat":
                    computerChoiceIndex = getCheatChoiceIndex(playerChoice); // Implement this method
                    break;
                default:
                    computerChoiceIndex = random.nextInt(3); // Random strategy
                    break;
            }

            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(playerChoice, computerChoice);
            System.out.println("Result: " + result + " (" + strategy + ")");

            if (result.equals("Player wins!")) {
                playerScore++;
            } else if (result.equals("Computer wins!")) {
                computerScore++;
            } else {
                ties++;
            }

            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + computerScore);
            System.out.println("Ties: " + ties);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                        (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                        (playerChoice.equals("paper") && computerChoice.equals("rock"))
        ) {
            return "Player wins!";
        } else {
            return "Computer wins!";
        }
    }

    private static String getComputerStrategy() {
        String[] strategies = {"Least Used", "Most Used", "Last Used", "Cheat", "Random"};
        int randomIndex = new Random().nextInt(strategies.length);
        return strategies[randomIndex];
    }

    private static int getLeastUsedChoiceIndex(String playerChoice) {
        return 0;
    }

    private static int getMostUsedChoiceIndex(String playerChoice) {
        return 0;
    }

    private static int getLastUsedChoiceIndex(String playerChoice) {
        return 0;
    }

    private static int getCheatChoiceIndex(String playerChoice) {
        return 0;
    }
}