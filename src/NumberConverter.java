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

    public int[] convertToBinary() {
        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}
