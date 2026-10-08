public class RabinKarp {
    private static final long BASE = 256;
    private static final long MOD1 = 1000000007L;
    private static final long MOD2 = 1000000009L;

    public static int search(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        text = text.toLowerCase();
        pattern = pattern.toLowerCase();
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0;
        if (m > n) return -1;

        long high1 = 1, high2 = 1;
        long p1 = 0, p2 = 0, t1 = 0, t2 = 0;
        for (int i = 0; i < m - 1; i++) {
            high1 = (high1 * BASE) % MOD1;
            high2 = (high2 * BASE) % MOD2;
        }
        for (int i = 0; i < m; i++) {
            p1 = (p1 * BASE + pattern.charAt(i)) % MOD1;
            p2 = (p2 * BASE + pattern.charAt(i)) % MOD2;
            t1 = (t1 * BASE + text.charAt(i)) % MOD1;
            t2 = (t2 * BASE + text.charAt(i)) % MOD2;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p1 == t1 && p2 == t2) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) { match = false; break; }
                }
                if (match) return i;
            }
            if (i < n - m) {
                t1 = (BASE * (t1 - text.charAt(i) * high1) + text.charAt(i + m)) % MOD1;
                t2 = (BASE * (t2 - text.charAt(i) * high2) + text.charAt(i + m)) % MOD2;
                if (t1 < 0) t1 += MOD1;
                if (t2 < 0) t2 += MOD2;
            }
        }
        return -1;
    }
}
