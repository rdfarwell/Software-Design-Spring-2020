public class ArabicToRoman {
    public static String aToR(int arabic) {

        String roman = "";
        int i = 0;

        while (arabic > 0) {
            if ((arabic % ArabicRomanConversion.nums[i]) != arabic) {
                roman += ArabicRomanConversion.letters[i];
                arabic -= ArabicRomanConversion.nums[i];
            }
            else {
                i++;
            }
        }

        return roman;
    }
}
