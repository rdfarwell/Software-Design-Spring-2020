/**
 * Class that contains the Arabic to roman converter and a checker to make sure the arabic entry is valid
 *
 * @author Dean Farwell
 */
public class ArabicToRoman {

    /**
     * Method that takes in an arabic numeral and converts it into its corresponding Roman Numeral
     * @param arabic Arabic numeral entry to be converted
     * @return A String of Roman Numerals that represents the arabic entry
     */
    public static String aToR(int arabic) {

        String roman = "";
        int i = 0;

        while (arabic > 0) {
            if ((arabic % ArabicRomanConversion.NUMS[i]) != arabic) { // uses modulus to check if current roman numeral equivalent can be "removed" from arabic numeral
                roman += ArabicRomanConversion.LETTERS[i]; // since the arabic and roman numerals are in order, if a match is found it is added to the string
                arabic -= ArabicRomanConversion.NUMS[i]; //  The roman numeral equivalent is removed from arabic for further conversion
            }
            else { // only moves when a character is not created as roman numerals can repeat
                i++;
            }
        }

        return roman;
    }

    /**
     * Method that makes sure the arabic entry is within the allocated range
     * @param arabic Arabic integer to be checked
     * @return A boolean that either confirms or denies if the arabic entry is valid
     */
    public static boolean arabicCheck(int arabic) {
        if ((arabic >= 1) && (arabic <= 3999)) {
            return true;
        }
        else {
            return false;
        }
    }
}
