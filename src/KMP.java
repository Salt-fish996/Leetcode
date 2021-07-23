public class KMP {
    public void prefixTable(char[] pattern, int[] prefix) {
        int n = pattern.length;
        int i = 1;
        int len = 0;
        prefix[0] = 0;
        while (i < n) {
            if (pattern[i] == pattern[len]) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i++;
                }
            }

        }
        movePrefix(prefix);
    }

    public void movePrefix(int[] prefix) {
        if (prefix.length - 1 >= 0) System.arraycopy(prefix, 0, prefix, 1, prefix.length - 1);
        prefix[0] = -1;
    }

    boolean search(int[] prefix, char[] pattern, char[] text) {
        int i = 0;
        int j = 0;
        int m = text.length;
        int n = pattern.length;
        while (i < m) {
            if (j == n - 1 && text[i] == pattern[j]) {
                System.out.println("成功");
                return true;
            }
            if (pattern[j] == text[i]) {
                i++;
                j++;
            } else {
                j = prefix[j];
                if (j == -1) {
                    i++;
                    j++;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        char[] chars = "ABABCABAA".toCharArray();
        int[] p = new int[chars.length];
        kmp.prefixTable(chars, p);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
        char[] chars1 = "cdsABABCABAA".toCharArray();
        System.out.println(kmp.search(p, chars, chars1));
    }
}
