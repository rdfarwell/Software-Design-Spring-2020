public class Hamming {
    public static int hammingDistance(String a, String b) {
        int count = 0;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
            return count;
        }
        else {
            return -1;
        }
    }
}
