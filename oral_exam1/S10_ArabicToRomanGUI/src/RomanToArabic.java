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
}
