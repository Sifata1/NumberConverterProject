import java.util.Scanner;
import java.util.Arrays;

 public class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10 or 16): ");

        Scanner s = new Scanner(System.in);
        String base = s.nextLine();


        while (!(base.equals("2") || base.equals("8") || base.equals("10") || base.equals("16"))){ // Makes sure that you entered one of the compatible bases
            System.out.print("Please enter a base of 2, 8, 10, or 16: ");
            base = s.nextLine();
        }

        int base2 = Integer.parseInt(base);

        if (base2 == 2 || base2 == 8 || base2 == 10 || base2 == 16) {
            System.out.print("Enter your number: ");
            String number = s.nextLine();

            while (NumberConverter.checkInputs(base2, number) == false){ // Checks to see if the number you entered is compatible with your given base
                System.out.println(number + " does not work for base " + base);
                System.out.print("Please enter another number: ");
                number = s.nextLine();
            }

            NumberConverter nc = new NumberConverter(number, base2);
            System.out.println(nc.toString()); // Prints all the conversions with the toString method

        }

        System.out.println("");
        System.out.println("Would you like to convert a decimal number to any base within 1-64? Enter 1 for YES or 2 for NO:"); // Option to convert decimal number to any other base
        String answer = s.nextLine();

        if (answer.equals("1")) {
            System.out.print("Enter your number: ");
            String n = s.nextLine();
            while (NumberConverter.checkInputs(10,n) == false){ // Checks inputs
                System.out.print("Please enter a decimal number: ");
                n = s.nextLine();
            }
            System.out.print("Enter the base you would like to convert to (1 - 64): ");
            String base3 = s.nextLine();
            while (NumberConverter.numIsInRange(1, 64, base3) == false){ // Checks to see if the base is within 1-64
                System.out.print("Please enter a number from 1 - 64: ");
                base3 = s.nextLine();
            }
            System.out.println(NumberConverter.decToAllBases(Integer.parseInt(n),Integer.parseInt(base3))); // Prints the conversion
        }
    }

}