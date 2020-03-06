/**
 * Class that handles the conversion from roman numerals to arabic numerals, and checks if a roman numeral is valid
 *
 * @author Dean Farwell
 */
public class RomanToArabic {

    /**
     * Method that takes in a valid roman numeral and returns it's equivalent arabic numeral as an integer
     * @param roman A valid roman numeral (equivalent to 1 to 3999 (I to MMMCMXCIX))
     * @return An arabic numeral between 1 and 3999
     */
    public static int rToA(String roman) {
        int arabic = 0;
        boolean changed = false;
        String tmpRoman = roman.toUpperCase();

        while (!tmpRoman.equals("")) {
            for (int x = 0; x < ArabicRomanConversion.ROMAN_LETTERS.length; x++) { // checks each roman numeral against the string
                if (!changed && tmpRoman.charAt(0) == ArabicRomanConversion.ROMAN_LETTERS[x]) { // makes sure the string hasn't been changed yet and there is a matching character
                    if ((tmpRoman.length() > 1) && (x == 2 || x == 4 || x == 6)) { // Numerals C X and I have special cases for letters that follow them, they are checked first
                        if (tmpRoman.charAt(1) == ArabicRomanConversion.ROMAN_LETTERS[x - 1]) { // looking at the arrays, the two special cases for each special numeral line up in the same positions of the array,
                            arabic += ArabicRomanConversion.NUMS[(2 * x) - 1];                  // these two cases deal with those two positions
                            tmpRoman = tmpRoman.substring(2); // gets rid of roman numerals that were just compared against and found their arabic equivalent
                            changed = true; // changed prevent further comparisons until the while loop does a check to prevent indexing issues
                        }
                        else if (tmpRoman.charAt(1) == ArabicRomanConversion.ROMAN_LETTERS[x - 2]) {
                            arabic += ArabicRomanConversion.NUMS[(2 * x) - 3];
                            tmpRoman = tmpRoman.substring(2);
                            changed = true;
                        }
                        else { // if the numeral was not a part of a special case, it is dealt with as usual
                            arabic += ArabicRomanConversion.NUMS[2 * x];
                            tmpRoman = tmpRoman.substring(1);
                            changed = true;
                        }
                    }
                    else { // if not a special case, add arabic and shorten roman numeral
                        arabic += ArabicRomanConversion.NUMS[2 * x]; // position of relevant number within character array is twice the position
                        tmpRoman = tmpRoman.substring(1);
                        changed = true;
                    }
                }
            }
            if (changed) {
                changed = false;
            }
        }

        return arabic;
    }

    /**
     * Method that checks if a roman numeral entry is valid
     * @param roman Any string to be compared
     * @return Boolean, True if valid, false if not valid
     */
    public static boolean romanCheck(String roman) {

        boolean valid = false;
        int i = 0;

        roman = roman.toUpperCase();

        return roman.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

//        for (int x = 0; x < ArabicRomanConversion.ROMAN_LETTERS.length; x++) {
//            if (roman.charAt(i) ==
//        }

        /*
        int charCount = 0, repeatCount = 1, currentCharIndex;
        char lastChar = ' ';
        String[] doubles = {"CM", "CD", "XC", "XL", "IX", "IV", "MM", "CC", "XX", "II"};
        boolean check = true, specialCaseCheck = false;
        roman = roman.toUpperCase();
        for (int i = 0; i < roman.length(); i++) {
            for (int x = 0; x < ArabicRomanConversion.romanLetters.length; x++) {
                if (roman.charAt(i) == ArabicRomanConversion.romanLetters[x]) {
                    currentCharIndex = x;
                    if (roman.charAt(i) == lastChar) {
                        repeatCount++;
                    }
                    else {
                        repeatCount = 1;
                    }

                    if (repeatCount > 3) {
                        check = false;
                    }

                    if (( i < roman.length() - 1)) {
                        if (x == 2 || x == 4 || x == 6) {
                            for (int y = 0; y < doubles.length; y++) {
                                if ((Character.toString(roman.charAt(i)) + roman.charAt(i + 1)).equals(doubles[y])) {
                                    specialCaseCheck = true;
                                }
                            }
                        }
                        if (!specialCaseCheck) {
                            specialCaseCheck = true;
                            for (int t = 0; t < currentCharIndex + 1; t++) {
                                if (roman.charAt(i + 1) == ArabicRomanConversion.romanLetters[t]) { // check for higher index than earlier for casses like iiv
                                    specialCaseCheck = false;
                                }
                            }
                        }
                        if (!specialCaseCheck) {
                            check = false;
                        }
                        specialCaseCheck = false;
                    }

                    charCount++;
                    lastChar = roman.charAt(i);

                }
            }
        }

        if (charCount != roman.length()) {
            check = false;
        }

        //if (!roman.equals())

        return check;


         */
    }
}
