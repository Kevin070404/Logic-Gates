#include <stdio.h>
#include <stdlib.h>

int and_gate(int inputs[], int n);
int or_gate(int inputs[], int n);
int not_gate(int input);
int xor_gate(int inputs[], int n);
int nand_gate(int inputs[], int n);
int nor_gate(int inputs[], int n);
int xnor_gate(int inputs[], int n);

void clear_screen() {
    #ifdef _WIN32
        system("cls");
    #else
        system("clear");
    #endif
}

void print_gate_choice(int choice, int num_inputs) {
    switch (choice) {
        case 1:
            printf("AND gate selected.\n");
            break;
        case 2:
            printf("OR gate selected.\n");
            break;
        case 3:
            printf("NOT gate selected.\n");
            break;
        case 4:
            printf("XOR gate selected.\n");
            break;
        case 5:
            printf("NAND gate selected.\n");
            break;
        case 6:
            printf("NOR gate selected.\n");
            break;
        case 7:
            printf("XNOR gate selected.\n");
            break;
        default:
            printf("Invalid choice!\n");
            return;
    }
    if (choice != 3) {
        printf("Number of inputs: %d\n\n", num_inputs);
    }
}

int get_valid_input(int i) {
    int input;
    while (1) {
        scanf("%d", &input);
        if (input == 0 || input == 1) {
            break;
        } else {
            printf("Please enter 0 or 1\nEnter input %d (0 or 1): ", i + 1 );
        }
    }
    return input;
}

int main() {
    int choice, num_inputs, i;
    int inputs[4];

    while (1) {
        clear_screen();

        printf("Select a gate:\n");
        printf("1. AND gate\n");
        printf("2. OR gate\n");
        printf("3. NOT gate\n");
        printf("4. XOR gate\n");
        printf("5. NAND gate\n");
        printf("6. NOR gate\n");
        printf("7. XNOR gate\n\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        clear_screen();

        if (choice == 3) {
            print_gate_choice(choice, 1);
            printf("\nEnter input (0 or 1): ");
            inputs[0] = get_valid_input(i);
            printf("\nResult: %d\n\n", not_gate(inputs[0]));
            printf("Press Enter to continue...");
            getchar(); getchar();
            continue;
        }

        printf("Select number of inputs:\n");
        printf("1. 2\n");
        printf("2. 3\n");
        printf("3. 4\n");
        printf("\nEnter choice: ");
        scanf("%d", &num_inputs);
        num_inputs += 1; 

        clear_screen();

        print_gate_choice(choice, num_inputs);

        for (i = 0; i < num_inputs; i++) {
            printf("Enter input %d (0 or 1): ", i + 1);
            inputs[i] = get_valid_input(i);
        }

        int result;
        switch (choice) {
            case 1:
                result = and_gate(inputs, num_inputs);
                break;
            case 2:
                result = or_gate(inputs, num_inputs);
                break;
            case 4:
                result = xor_gate(inputs, num_inputs);
                break;
            case 5:
                result = nand_gate(inputs, num_inputs);
                break;
            case 6:
                result = nor_gate(inputs, num_inputs);
                break;
            case 7:
                result = xnor_gate(inputs, num_inputs);
                break;
            default:
                printf("Invalid choice!\n");
                continue;
        }
        printf("\nResult: %d\n\n", result);
        printf("Press Enter to continue...");
        getchar(); getchar(); 
    }

    return 0;
}

int and_gate(int inputs[], int n) {
    int result = 1;
    for (int i = 0; i < n; i++) {
        result &= inputs[i];
    }
    return result;
}

int or_gate(int inputs[], int n) {
    int result = 0;
    for (int i = 0; i < n; i++) {
        result |= inputs[i];
    }
    return result;
}

int not_gate(int input) {
    return !input;
}

int xor_gate(int inputs[], int n) {
    int result = 0;
    for (int i = 0; i < n; i++) {
        result ^= inputs[i];
    }
    return result;
}

int nand_gate(int inputs[], int n) {
    return !and_gate(inputs, n);
}

int nor_gate(int inputs[], int n) {
    return !or_gate(inputs, n);
}

int xnor_gate(int inputs[], int n) {
    return !xor_gate(inputs, n);
}

