public class RomanToArabic {
    public static int rToA(String roman) {
        int arabic = 0;
        boolean changed = false;
        String tmpRoman = roman.toUpperCase();

        while (!tmpRoman.equals("")) {
            for (int x = 0; x < ArabicRomanConversion.romanLetters.length; x++) {
                if (!changed && tmpRoman.charAt(0) == ArabicRomanConversion.romanLetters[x]) {
                    if ((tmpRoman.length() > 1) && (x == 2 || x == 4 || x == 6)) {
                        if (tmpRoman.charAt(1) == ArabicRomanConversion.romanLetters[x - 1]) {
                            arabic += ArabicRomanConversion.nums[(2 * x) - 1];
                            tmpRoman = tmpRoman.substring(2);
                            changed = true;
                        }
                        else if (tmpRoman.charAt(1) == ArabicRomanConversion.romanLetters[x - 2]) {
                            arabic += ArabicRomanConversion.nums[(2 * x) - 3];
                            tmpRoman = tmpRoman.substring(2);
                            changed = true;
                        }
                        else {
                            arabic += ArabicRomanConversion.nums[2 * x];
                            tmpRoman = tmpRoman.substring(1);
                            changed = true;
                        }
                    }
                    else {
                        arabic += ArabicRomanConversion.nums[2 * x];
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
        int charCount = 0, repeatCount = 0;
        char lastChar = ' ';
        String[] doubles = {"CM", "CD", "XC", "XL", "IX", "IV"};
        boolean check = true, specialCaseCheck = false;
        roman = roman.toUpperCase();
        for (int i = 0; i < roman.length(); i++) {
            for (int x = 0; x < ArabicRomanConversion.romanLetters.length; x++) {
                if (roman.charAt(i) == ArabicRomanConversion.romanLetters[x]) {
                    if (roman.charAt(i) == lastChar) {
                        repeatCount++;
                    }
                    else {
                        repeatCount = 0;
                    }

                    if (repeatCount > 3) {
                        check = false;
                    }

                    if (( i < roman.length() - 1) && (x == 2 || x == 4 || x == 6)) {
                        for (int y = 0; y < doubles.length; y++) {
                            if ((Character.toString(roman.charAt(i)) + roman.charAt(i + 1)).equals(doubles[y])) {
                                specialCaseCheck = true;
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

        return check;

    }
}
