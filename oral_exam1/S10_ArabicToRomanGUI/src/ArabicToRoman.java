public class ArabicToRoman {
    public String aToR(int arabic) {

        String roman = "";
        int i = 0;
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        while (arabic > 0) {
            if ((arabic % nums[i]) != arabic) {
                roman += letters[i];
                arabic -= nums[i];
            }
            else {
                i++;
            }
        }

        return roman;
    }
}
