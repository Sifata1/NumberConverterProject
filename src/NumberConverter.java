import java.util.Arrays;

public class NumberConverter {
    String[] digits;
    int base;

    public NumberConverter(String number, int base) {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            String d = number.substring(i, i + 1);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public String[] getDigits() {
        return digits;
    }

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


