import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
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

    public int[] getDigits() {
        return digits;
    }

    public int convertToDecimal() {
        int decimalValue = 0;
        int power = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            decimalValue += digits[i] * power;
            power *= base;
        }
        return decimalValue;
    }

    public String convertToBinary() {
        int decimal = 0;
        for (int i = 0; i < digits.length; i++) {
            decimal = decimal * base + digits[i];
        }

        String binary = "";
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary = remainder + binary;
            decimal = decimal / 2;
        }
        return binary;
    }

    public String convertToOctal() {
        int decimal = 0;
        for (int i = 0; i < digits.length; i++) {
            decimal = decimal * base + digits[i];
        }

        String octal = "";
        while (decimal > 0) {
            int remainder = decimal % 8;
            octal = remainder + octal;
            decimal = decimal / 8;
        }
        return octal;
    }

    public static boolean checkInputs(int base, int num){
        String number = num + "";
        if (base == 2){
            for (int i = 0; i < number.length(); i++){
                String currentChar = number.charAt(i) + "";
                if (!(currentChar.equals("1") || currentChar.equals("0"))) return false;
            }
        }
        if (base == 8){
            for (int i = 0; i < number.length(); i++){
                if (number.charAt(i) > 8) return false;
            }
        }
        return true;
    }
}
