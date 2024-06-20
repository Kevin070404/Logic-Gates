import java.util.Scanner;

public class LogicGateSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Clear the console screen
            clearScreen();

            // Main menu
            System.out.println("Select a gate:");
            System.out.println("1. AND gate");
            System.out.println("2. OR gate");
            System.out.println("3. NOT gate");
            System.out.println("4. XOR gate");
            System.out.println("5. NAND gate");
            System.out.println("6. NOR gate");
            System.out.println("7. XNOR gate");
            System.out.print("Enter choice: ");
            int choice = getValidInput(scanner);

            // Handle NOT gate separately
            if (choice == 3) {
                printGateChoice(choice, 1);
                System.out.print("\nEnter input (0 or 1): ");
                int input = getValidInput(scanner);
                int result = notGate(input);
                System.out.println("Result: " + result + "\n");
                pause(scanner);
                continue;
            }

            // For other gates, select number of inputs
            System.out.println("Select number of inputs:");
            System.out.println("1. 2");
            System.out.println("2. 3");
            System.out.println("3. 4");
            System.out.print("\nEnter choice: ");
            int numInputsChoice = getValidInput(scanner);
            int numInputs = numInputsChoice + 1; // Adjust to match actual number of inputs (2, 3, or 4)

            // Clear the console screen
            clearScreen();

            // Display selected gate and number of inputs
            printGateChoice(choice, numInputs);

            // Get the inputs
            int[] inputs = new int[numInputs];
            for (int i = 0; i < numInputs; i++) {
                System.out.print("Enter input " + (i + 1) + " (0 or 1): ");
                inputs[i] = getValidInput(scanner);
            }

            // Calculate and display the result
            int result = 0;
            switch (choice) {
                case 1: // AND gate
                    result = andGate(inputs);
                    break;
                case 2: // OR gate
                    result = orGate(inputs);
                    break;
                case 4: // XOR gate
                    result = xorGate(inputs);
                    break;
                case 5: // NAND gate
                    result = nandGate(inputs);
                    break;
                case 6: // NOR gate
                    result = norGate(inputs);
                    break;
                case 7: // XNOR gate
                    result = xnorGate(inputs);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }
            System.out.println("Result: " + result + "\n");
            pause(scanner);
        }
    }

    // AND gate function
    public static int andGate(int[] inputs) {
        int result = 1;
        for (int input : inputs) {
            result &= input;
        }
        return result;
    }

    // OR gate function
    public static int orGate(int[] inputs) {
        int result = 0;
        for (int input : inputs) {
            result |= input;
        }
        return result;
    }

    // NOT gate function
    public static int notGate(int input) {
        return input == 0 ? 1 : 0;
    }

    // XOR gate function
    public static int xorGate(int[] inputs) {
        int result = 0;
        for (int input : inputs) {
            result ^= input;
        }
        return result;
    }

    // NAND gate function
    public static int nandGate(int[] inputs) {
        return notGate(andGate(inputs));
    }

    // NOR gate function
    public static int norGate(int[] inputs) {
        return notGate(orGate(inputs));
    }

    // XNOR gate function
    public static int xnorGate(int[] inputs) {
        return notGate(xorGate(inputs));
    }

    // Print selected gate and number of inputs
    public static void printGateChoice(int choice, int numInputs) {
        switch (choice) {
            case 1:
                System.out.println("AND gate selected.");
                break;
            case 2:
                System.out.println("OR gate selected.");
                break;
            case 3:
                System.out.println("NOT gate selected.");
                break;
            case 4:
                System.out.println("XOR gate selected.");
                break;
            case 5:
                System.out.println("NAND gate selected.");
                break;
            case 6:
                System.out.println("NOR gate selected.");
                break;
            case 7:
                System.out.println("XNOR gate selected.");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        if (choice != 3) {
            System.out.println("Number of inputs: " + numInputs + "\n");
        }
    }

    // Function to get valid binary input (0 or 1)
    public static int getValidInput(Scanner scanner) {
        int input;
        while (true) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input == 0 || input == 1) {
                    break;
                } else {
                    System.out.print("Invalid input. Please enter 0 or 1: ");
                }
            } else {
                System.out.print("Invalid input. Please enter 0 or 1: ");
                scanner.next();  // Consume the invalid input
            }
        }
        return input;
    }

    // Clear the console screen
    public static void clearScreen() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Pause and wait for Enter key to continue
    public static void pause(Scanner scanner) {
        System.out.print("Press Enter to continue...");
        scanner.nextLine();  // Consume the leftover newline
        scanner.nextLine();  // Wait for Enter key press
    }
}
