class Main {
    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;
    private String[] results = new String[3]; // To store the results

    private int getLeastUsedChoiceIndex(String[] lines) {
        int[] choiceCounts = {0, 0, 0};

        for (String line : lines) {
            if (line.contains("Player wins")) {
                if (line.contains("Rock")) {
                    choiceCounts[0]++;
                } else if (line.contains("Paper")) {
                    choiceCounts[1]++;
                } else if (line.contains("Scissors")) {
                    choiceCounts[2]++;
                }
            }
        }

        // Find the least used choice by the player
        int minChoiceIndex = 0;
        for (int i = 1; i < choiceCounts.length; i++) {
            if (choiceCounts[i] < choiceCounts[minChoiceIndex]) {
                minChoiceIndex = i;
            }
        }

        return minChoiceIndex;
    }

    private int getMostUsedChoiceIndex(String[] lines) {
        int[] choiceCounts = {0, 0, 0};

        for (String line : lines) {
            if (line.contains("Player wins")) {
                if (line.contains("Rock")) {
                    choiceCounts[0]++;
                } else if (line.contains("Paper")) {
                    choiceCounts[1]++;
                } else if (line.contains("Scissors")) {
                    choiceCounts[2]++;
                }
            }
        }

        // Find the most used choice by the player
        int maxChoiceIndex = 0;
        for (int i = 1; i < choiceCounts.length; i++) {
            if (choiceCounts[i] > choiceCounts[maxChoiceIndex]) {
                maxChoiceIndex = i;
            }
        }

        return maxChoiceIndex;
    }

    private int getLastUsedChoiceIndex(String[] lines, String playerChoice) {
        if (lines.length < 2) {
            // No previous game to consider
            return getRandomChoiceIndex();
        }

        String lastLine = lines[lines.length - 2]; // Get the line before the last line
        if (lastLine.contains("Player wins")) {
            if (lastLine.contains("Rock")) {
                return 0; // Player used Rock last
            } else if (lastLine.contains("Paper")) {
                return 1; // Player used Paper last
            } else if (lastLine.contains("Scissors")) {
                return 2; // Player used Scissors last
            }
        }

        return getRandomChoiceIndex();
    }

    private int getRandomChoiceIndex() {
        return 0;
    }

    private int getCheatChoiceIndex(String playerChoice) {
        double randomValue = Math.random();

        if (randomValue <= 0.1) {
            switch (playerChoice) {
                case "Rock":
                    return 1; // Paper covers Rock
                case "Paper":
                    return 2; // Scissors cut Paper
                case "Scissors":
                    return 0; // Rock breaks Scissors
            }
        }
        return getRandomChoiceIndex();
    }

    private String determineResult(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Tie";
        } else if (
                (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                        (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                        (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            return "Player wins";
        } else {
            return "Computer wins";
        }
    }

    private void updateStats(String result) {
        if (result.equals("Player wins")) {
            playerWins++;
        } else if (result.equals("Computer wins")) {
            computerWins++;
        } else {
            ties++;
        }
    }

    private String getComputerStrategy() {
        String[] strategies = {"Least Used", "Most Used", "Last Used", "Cheat", "Random"};
        int randomIndex = (int) (Math.random() * strategies.length);
        return strategies[randomIndex];
    }

    public static void main(String[] args) {
    }
}