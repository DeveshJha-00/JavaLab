package StringOperations;

public class StringProcessor implements StringManipulator{

    public String reverse(String ip) {
        char[] charArray = ip.toCharArray();
        int l=0, r=ip.length()-1;
        while (l < r) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
            l++;
            r--;
        }
        return new String(charArray);
    }

    public boolean isPalin(String ip) {
        String reversed = reverse(ip);
        return ip.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String ip) {
        return ip.toUpperCase();
    }

    public String toLowerCase(String ip) {
        return ip.toLowerCase();
    }

    public String concati(String ip1, String ip2) {
        return ip1.concat(ip2);
    }

    public int countVowels(String ip) {
        int count = 0;
        for (char c : ip.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        return count;
    }

    public int wordCount(String ip) {
        if (ip.trim().isEmpty()) return 0;
        return ip.trim().split("\\s+").length;
    }
}
