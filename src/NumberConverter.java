import java.util.Arrays;

public class NumberConverter {
    private String[] digits;
    private int base;

    // CONSTRUCTOR
    /**
     *
     * @param number is the string representation of the number given by the user.
     * @param base the base of the number the user inputted.
     */
    public NumberConverter(String number, int base) {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String d = number.substring(i, i + 1);
            digits[i] = d;
        }
        this.base = base;
    }

    // METHODS
    /**
     * Displays the string representation of the original number not as a list.
     * @return a String that contains the original number.
     */
    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    /**
     * @return Returns an array of the digits in the original number.
     */
    public String[] getDigits() {
        return digits;
    }

    /**
     * Converts the original number from any base to decimal.
     * @return the decimal value of the original number
     */
    public int convertToDecimal() {
        int decimalValue = 0;
        int power = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digitValue = Integer.parseInt(digits[i], base);
            decimalValue += digitValue * power;
            power *= base;
        }
        return decimalValue;
    }

    /**
     * Converts the original number from any base to binary.
     * @return the binary value of the original number
     */
    public String convertToBinary() {
        int decimal = convertToDecimal();

        String binary = "";
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary = remainder + binary;
            decimal = decimal / 2;
        }
        return binary;
    }

    /**
     * Converts the original number from any base to octal.
     * @return the octal value of the original number
     */
    public String convertToOctal() {
        int decimal = convertToDecimal();

        String octal = "";
        while (decimal > 0) {
            int remainder = decimal % 8;
            octal = remainder + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    /**
     * Converts the given decimal value to the
     * @param decimal the given decimal number the user wants to convert
     * @param base the base the user wants to convert to
     * @return
     */
    public static String convertDecimalToBaseX(int decimal, int base) {
        String baseXValue = "";
        if (base == 1) {
            for (int i = 0; i < decimal; i++) {
                baseXValue += "1";
            }
            return baseXValue;
        } else if (decimal == 0) return "0";
        String values = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        // finding the highest power of base X that can go into decimal:
        int power = 0;
        while (decimal - Math.pow(base, power) >= 0) power++;
        if (decimal - Math.pow(base, power) < 0) power--;
        // adding the characters to baseXValue:
        int quotient;
        while (power >= 0) {
            quotient = decimal / (int) Math.pow(base, power);
            baseXValue += values.substring(quotient, quotient + 1);
            decimal -= Math.pow(base, power) * quotient;
            power--;
        }
        return baseXValue;
    }

    public static boolean numIsInRange(int min, int max, String num){
        String numbers = "1234567890";
        for (int i = 0; i < num.length(); i++){
            if (numbers.indexOf(num.substring(i, i + 1)) == -1) return false;
        }
        if (Integer.parseInt(num) > max) return false;
        else if (Integer.parseInt(num) < min) return false;
        return true;
    }

    public static boolean checkInputs(int base, String num){
        String v = "0123456789ABCDEF";
        String b = v.substring(0, base);
        String[] numberList = new String[num.length()];
        for (int i = 0; i < numberList.length; i++){
            numberList[i] = num.substring(i, i + 1);
        }
        for (String number : numberList){
            if (b.indexOf(number) == -1) {
                return false;
            }
        }
        return true;
    }


}


