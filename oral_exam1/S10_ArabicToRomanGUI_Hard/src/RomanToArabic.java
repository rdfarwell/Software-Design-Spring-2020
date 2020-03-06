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

        boolean mDone = false, dDone = false, cDone = false, lDone = false, xDone = false, vDone = false, iDone = false;
        int charCount = 0, mCount = 0, dCount = 0, cCount = 0, lCount = 0, xCount = 0, vCount = 0, iCount = 0;
        String tempRoman;

        roman = roman.toUpperCase();
        tempRoman = roman;

        for (int y = 0; y < roman.length(); y++) {
            for (int x = 0; x < ArabicRomanConversion.ROMAN_LETTERS.length; x++) {
                if (roman.charAt(y) == ArabicRomanConversion.ROMAN_LETTERS[x]) {
                    charCount++;
                }
            }
        }

        if (charCount != roman.length()) {
            return false;
        }

        while (!tempRoman.equals("")) {
            if (tempRoman.charAt(0) == 'M') {
                if (mDone || mCount > 3) {
                    return false;
                }
                else {
                    mCount++;
                    tempRoman = tempRoman.substring(1);
                }
            }
            else if (tempRoman.charAt(0) == 'D') {
                if (dDone || dCount > 1) {
                    return false;
                }
                else {
                    dCount++;
                    tempRoman = tempRoman.substring(1);
                }
                mDone = true;
            }
            else if (tempRoman.charAt(0) == 'C') {
                if (cDone || cCount > 3) {
                    return false;
                }
                else if ((tempRoman.length() > 1) && (tempRoman.charAt(1) == 'M' || tempRoman.charAt(1) == 'D')) {
                    if (cCount > 0) {
                        return false;
                    }
                    cDone = true;
                    tempRoman = tempRoman.substring(2);
                }
                else {
                    cCount++;
                    tempRoman = tempRoman.substring(1);
                }
                mDone = true;
                dDone = true;
            }
            else if (tempRoman.charAt(0) == 'L') {
                if (lDone || lCount > 1) {
                    return false;
                }
                else {
                    lCount++;
                    tempRoman = tempRoman.substring(1);
                }
                mDone = true;
                dDone = true;
                cDone = true;
            }
            else if (tempRoman.charAt(0) == 'X') {
                if (xDone || xCount > 3) {
                    return false;
                }
                else if ((tempRoman.length() > 1) && (tempRoman.charAt(1) == 'C' || tempRoman.charAt(1) == 'L')) {
                    if (xCount > 0) {
                        return false;
                    }
                    xDone = true;
                    tempRoman = tempRoman.substring(2);
                }
                else {
                    xCount++;
                    tempRoman = tempRoman.substring(1);
                }
                mDone = true;
                dDone = true;
                cDone = true;
                lDone = true;
            }
            else if (tempRoman.charAt(0) == 'V') {
                if (vDone || vCount > 1) {
                    return false;
                }
                else {
                    vCount++;
                    tempRoman = tempRoman.substring(1);
                }
                mDone = true;
                dDone = true;
                cDone = true;
                lDone = true;
                xDone = true;
            }
            else if (tempRoman.charAt(0) == 'I') {
                if (iDone || iCount > 3) {
                    return false;
                }
                else if ((tempRoman.length() > 1) && (tempRoman.charAt(1) == 'X' || tempRoman.charAt(1) == 'V')) {
                    if (iCount > 0) {
                        return false;
                    }
                    iDone = true;
                    tempRoman = tempRoman.substring(2);
                }
                else {
                    iCount++;
                    tempRoman = tempRoman.substring(1);
                }
                mDone = true;
                dDone = true;
                cDone = true;
                lDone = true;
                xDone = true;
                vDone = true;
            }
        }

        if (mCount > 3 || dCount > 1 || cCount > 3 || lCount > 1 || xCount > 3 || vCount > 1 || iCount > 3) {
            return false;
        }

        return true;
    }
}
