import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10 or 16): ");

        Scanner s = new Scanner(System.in);
        String base = s.nextLine();


        while (!(base.equals("2") || base.equals("8") || base.equals("10") || base.equals("16"))){
            System.out.print("Please enter a base of 2, 8, 10, or 16: ");
            base = s.nextLine();
        }

        int base2 = Integer.parseInt(base);

        if (base2 == 2 || base2 == 8 || base2 == 10) {
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            int n = Integer.parseInt(number);

            while (NumberConverter.checkInputs(base2, number) == false){
                System.out.println(number + " does not work for base " + base);
                System.out.print("Please enter another number: ");
                number = s.nextLine();
            }

            NumberConverter nc = new NumberConverter(n, base2);
            int[] digits = nc.getDigits();
            System.out.println("\n\nDigit array: " + Arrays.toString(digits));
            System.out.println("Number: " + nc.displayOriginalNumber());
            if (base2 != 10) System.out.println("Decimal: " + nc.convertToDecimal());
            if (base2 != 2) System.out.println("Binary: " + nc.convertToBinary());
            if (base2 != 8) System.out.println("Octal: " + nc.convertToOctal());
            if (base2 != 16) System.out.println("Hexadecimal: " +nc.convertDecimalToBaseX(nc.convertToDecimal(), 16) );

        } else {

        }

        System.out.println("");
        System.out.println("Would you like to convert a decimal number to any base within 1-64? Enter 1 for yes or 2 for no:");


        String answer = s.nextLine();

        if (answer.equals("1")) {
            System.out.print("Enter your number: ");
            String n = s.nextLine();
            while (NumberConverter.checkInputs(10,n) == false){
                System.out.print("Please enter a decimal number: ");
                n = s.nextLine();
            }
            System.out.print("Enter the base you would like to convert to (1 - 64): ");
            String base3 = s.nextLine();
            while (NumberConverter.numIsInRange(1, 64, base3) == false){
                System.out.print("Please enter a number from 1 - 64: ");
                base3 = s.nextLine();
            }
            System.out.println(NumberConverter.convertDecimalToBaseX(Integer.parseInt(n),Integer.parseInt(base3)));
        }
    }

}