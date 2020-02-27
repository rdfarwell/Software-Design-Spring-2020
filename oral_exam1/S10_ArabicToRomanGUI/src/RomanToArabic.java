public class RomanToArabic {
    public int rToA(String roman) {
        int arabic = 0, i = 0;

        while (!roman.equals("")) {
            for (int x = 0; x < ArabicRomanConversion.romanLetters.length; x++) {
                if (roman.charAt(i) == ArabicRomanConversion.romanLetters[x]) {
                    // back one and two is special cases
                    if (roman.charAt(i + 1) == ArabicRomanConversion.romanLetters[x-1]) {
                        //arabic += ArabicRomanConversion.nums[]
                    }
                    if (roman.charAt(i + 1) == ArabicRomanConversion.romanLetters[x-2]) {
                        //arabic += ArabicRomanConversion.nums[]
                    }
                    else {
                        arabic += ArabicRomanConversion.nums[2*x];
                    }

                }
            }
        }

        return arabic;
    }
}
