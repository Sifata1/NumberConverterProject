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
     * Turns the list of the digits into a string
     * @param list the string list of the digits
     * @return Returns the num as a string
     */
    public static String listToString(String[] list){
        String numAsString = "";
        for (int i = 0; i < list.length; i++){
            numAsString += list[i];
        }
        return numAsString;
    }

    /**
     * Turns the string of digits/letters into a list with each digit.
     * @param string the string representation of the number
     * @return Returns the number as a list
     */
    public static String[] stringToList(String string){
        String[] list = new String[string.length()];
        for (int i = 0; i < string.length(); i++){
            String num = string.charAt(i) + "";
            list[i] = num;
        }
        return list;
    }

    /**
     * Converts the original number from any base to decimal.
     * @return the decimal value of the original number
     */
    public String[] convertToDecimal() {
        String[] newDigits;
        String values = "0123456789ABCDEF";
        int decimalValue = 0;
        int digitValue, power;
        for (int i = 0; i < digits.length; i++){
            digitValue = values.indexOf(digits[i]);
            power = digits.length - i - 1;
            decimalValue += digitValue * (int) Math.pow(base, power);
        }
        String numberAsString = decimalValue + "";
        newDigits = stringToList(numberAsString);
        return newDigits;
    }

    /**
     * Converts the original number from any base to binary.
     * @return the binary value of the original number
     */
    public String[] convertToBinary() {
        String[] newDigits;
        String values = "0123456789ABCDEF";
        String binaryValue = "";
        int decimalValue = 0;
        int digitValue;
        int power;
        for (int i = 0; i < digits.length; i++) {
            digitValue = values.indexOf(digits[i]);
            power = digits.length - i - 1;
            decimalValue += digitValue * (int) Math.pow(base, power);
        }
        while (decimalValue > 0) {
            binaryValue = (decimalValue % 2) + binaryValue;
            decimalValue = decimalValue / 2;
        }
        newDigits = stringToList(binaryValue);
        return newDigits;
    }

    /**
     * Converts the original number from any base to octal.
     * @return the octal value of the original number
     */
    public String[] convertToOctal() {
        String[] newDigits;
        String values = "0123456789ABCDEF";
        String octalValue = "";
        int decimalValue = 0;
        int digitValue, power;
        for (int i = 0; i < digits.length; i++) {
            digitValue = values.indexOf(digits[i]);
            power = digits.length - i - 1;
            decimalValue += digitValue * (int) Math.pow(base, power);
        }
        while (decimalValue > 0) {
            octalValue = (decimalValue % 8) + octalValue;
            decimalValue = decimalValue / 8;
        }
        newDigits = stringToList(octalValue);
        return newDigits;
    }

    /**
     * Converts the given decimal value to the
     * @param decimal the given decimal number the user wants to convert
     * @param base the base the user wants to convert to
     * @return Returns the conversion from the decimal value to the given base
     */
    public static String decToAllBases(int decimal, int base) {
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

    /**
     *
     * @param min The minimum base the user can input
     * @param max The maximum base the user can input
     * @param num The string representation of the base inputted by the user
     * @return Returns true if the base is within the min-max, returns false if not
     */

    public static boolean numIsInRange(int min, int max, String num){
        int num2 = Integer.parseInt(num);
        String numbers = "1234567890";
        for (int i = 0; i < num.length(); i++){
            if (numbers.indexOf(num.substring(i, i + 1)) == -1) return false;
        }
        if (num2 > max) return false;
        else if (num2 < min) return false;
        return true;
    }

    /**
     * Checks to see if the number inputted
     * @param base the base inputted by the user
     * @param num the string representation of the number inputted by the user
     * @return Returns true if the number inputted by the user corresponds with the base, returns false if not
     */
    public static boolean checkInputs(int base, String num){
        String v = "0123456789ABCDEF";
        String b = v.substring(0, base);
        for (int i = 0; i < num.length(); i++){
            char number = num.charAt(i);
            if (b.indexOf(number) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return Returns a string with all the conversions along with the original number.
     */
    public String toString() {
        String s ="\n\nDigit array: " + Arrays.toString(digits) + "\n";
        s+="Original Number: " + displayOriginalNumber() ;
        if (base != 10) s+= "Decimal: " + decToAllBases(Integer.parseInt(listToString(convertToDecimal())), 10) + "\n";
        if (base != 2) s+= "Binary: " + decToAllBases(Integer.parseInt(listToString(convertToDecimal())), 2) + "\n";
        if (base != 8) s+= "Octal: " + decToAllBases(Integer.parseInt(listToString(convertToDecimal())), 8) + "\n";
        if (base != 16) s+= "Hexadecimal: " +decToAllBases(Integer.parseInt(listToString(convertToDecimal())), 16);
        return s;

    }

}


