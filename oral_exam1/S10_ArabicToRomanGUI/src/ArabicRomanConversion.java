public class ArabicRomanConversion {
    static final int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static final char[] romanLetters = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    public static void main(String[] args) {

        System.out.println(ArabicToRoman.aToR(1));
        System.out.println(ArabicToRoman.aToR(4));
        System.out.println(ArabicToRoman.aToR(3));
        System.out.println(ArabicToRoman.aToR(945));
        System.out.println(ArabicToRoman.aToR(403));

        System.out.println(RomanToArabic.rToA("I"));
        System.out.println(RomanToArabic.rToA("IV"));
        System.out.println(RomanToArabic.rToA("III"));
        System.out.println(RomanToArabic.rToA("CMXLV"));
        System.out.println(RomanToArabic.rToA("CDIII"));

    }

}
