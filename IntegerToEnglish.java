public class IntegerToEnglish {
    private final String[] ZERO_TO_TWENTY = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String word = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + THOUSANDS[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }

    String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return ZERO_TO_TWENTY[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return ZERO_TO_TWENTY[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
