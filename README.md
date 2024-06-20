
# Logic Gates Simulator

The Logic Gate Simulator is a C and Java console application designed to simulate the behavior of various logic gates. It provides functionalities to choose different types of logic gates (AND, OR, NOT, XOR, NAND, NOR, XNOR), input binary values, and compute the results based on the chosen logic gate.

## Setup Instructions  

### Prerequisites  
* C complier (eg., DevC++)  
* Java complier (e.g., Eclipse IDE)
 ## User Guide
 ### Running the Application
 Upon running the application, you will be presented with a menu displaying various logic gates to choose from.

 ### Using the Application
1. Select a Gate

The application will prompt you to select a logic gate from the following options:
```ruby
Select a gate:
1. AND gate
2. OR gate
3. NOT gate
4. XOR gate
5. NAND gate
6. NOR gate
7. XNOR gate
Enter choice:
   ```
2. Input Values

 * If you select the NOT gate, you will be prompted to enter a single binary value (0 or 1).
 * For other gates, you will be prompted to select the number of inputs (2, 3, or 4) and then enter the corresponding binary values.
3. View Results
* The application will compute and display the result based on the chosen logic gate and input values.
4. Continue or Exit
* After displaying the result, the application will prompt you to press Enter to continue. You can then choose another gate or exit the application by closing the console window.
## Functions
### Logic Gate Functions
* int and_gate(int inputs[], int n);
* int or_gate(int inputs[], int n);
* int not_gate(int input);
* int xor_gate(int inputs[], int n);
* int nand_gate(int inputs[], int n);
* int nor_gate(int inputs[], int n);
* int xnor_gate(int inputs[], int n);

### Utility Functions
* void clear_screen();
* void print_gate_choice(int choice, int num_inputs);
* int get_valid_input(int i);
