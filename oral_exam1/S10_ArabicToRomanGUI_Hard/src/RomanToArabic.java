public class RomanToArabic {
    public static int rToA(String roman) {
        int arabic = 0;
        boolean changed = false;
        String tmpRoman = roman.toUpperCase();

        while (!tmpRoman.equals("")) {
            for (int x = 0; x < ArabicRomanConversion.ROMAN_LETTERS.length; x++) {
                if (!changed && tmpRoman.charAt(0) == ArabicRomanConversion.ROMAN_LETTERS[x]) {
                    if ((tmpRoman.length() > 1) && (x == 2 || x == 4 || x == 6)) {
                        if (tmpRoman.charAt(1) == ArabicRomanConversion.ROMAN_LETTERS[x - 1]) {
                            arabic += ArabicRomanConversion.NUMS[(2 * x) - 1];
                            tmpRoman = tmpRoman.substring(2);
                            changed = true;
                        }
                        else if (tmpRoman.charAt(1) == ArabicRomanConversion.ROMAN_LETTERS[x - 2]) {
                            arabic += ArabicRomanConversion.NUMS[(2 * x) - 3];
                            tmpRoman = tmpRoman.substring(2);
                            changed = true;
                        }
                        else {
                            arabic += ArabicRomanConversion.NUMS[2 * x];
                            tmpRoman = tmpRoman.substring(1);
                            changed = true;
                        }
                    }
                    else {
                        arabic += ArabicRomanConversion.NUMS[2 * x];
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

    public static boolean romanCheck(String roman) {

        roman = roman.toUpperCase();

        return roman.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        // https://stackoverflow.com/questions/38214744/java-roman-numeral-validity


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
