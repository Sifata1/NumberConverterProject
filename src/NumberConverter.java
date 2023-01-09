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

    public int[] convertToDecimal() {
        int decimalValue = 0;
        if (base == 2) {
            int power = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                decimalValue = decimalValue + (power * digits[i]);
                power = power * 2;
            }
        }
        if (base == 8) {
            int power = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                decimalValue = decimalValue + (power * digits[i]);
                power = power * 8;
            }
        }

        String numberAsString = Integer.toString(decimalValue);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
      return digits;
    }

    public int convertToBinary() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }

        String binary = "";
        int[] decDigits = digits;
        int decDigit = Integer.valueOf(o);

        if (base == 8) {
            decDigits = convertToDecimal();
        }

        int power = 0;
        for (int i = digits.length - 1; i > decDigits.length; i++) {
                int subtract = (int) Math.pow(decDigit,i);
                if (decDigit % Math.pow(2, power) == 0) {
                    binary+= "1";
                    decDigit -= subtract;
                    power++;
                } else {
                    binary+= "0";
                    power++;
                }
            }

        int b = Integer.parseInt(binary);
        return b;
    }

    public int[] convertToOctal() {
        return null;
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
