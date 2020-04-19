package Algorithms.strings.longest_commom_suffix;

// https://leetcode.com/media/original_images/14_lcp_diviso_et_lmpera.png

//using divide and conquer approach

public class Main {
    public String longestCommonSuffix(String[] str) {
        if (str.length == 0) { return ""; }
        return _longesCommon_suffix(str, 0, str.length - 1);
    }

    public static String _longesCommon_suffix(String[] str, int l, int r) {
        if (l == r) {
            System.out.println("r== l : returning : " + str[l]);return str[l]; }
        int mid = (l + r) / 2;
        System.out.println("l : " + l + " r : " + r + " mid : " + mid);
        String lcpLeft = _longesCommon_suffix(str, l, mid);
        System.out.println("lcpLeft : " + lcpLeft);
        String lcpRight = _longesCommon_suffix(str, mid+1, r);
        System.out.println("lcpRight : " + lcpRight);
        return _comparePrefix(lcpLeft, lcpRight);
    }

    public static String _comparePrefix(String left, String right) {
        int min = Math.min(left.length() ,right.length());
        for (int i =0; i<min; i++) {
            if (left.charAt(i) != right.charAt(i)) { return left.substring(0, i); }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestCommonSuffix(new String[]{"leetcode", "leet", "lee", "le"}));
    }
}
