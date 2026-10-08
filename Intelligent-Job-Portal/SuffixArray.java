public class SuffixArray {
    private static int compare(int a, int b, int[] rank, int k, int n) {
        if (rank[a] != rank[b]) return rank[a] - rank[b];
        int ra = a + k < n ? rank[a + k] : -1;
        int rb = b + k < n ? rank[b + k] : -1;
        return ra - rb;
    }

    public static int[] build(String text) {
        int n = text.length();
        int[] sa = new int[n];
        int[] rank = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) { sa[i] = i; rank[i] = text.charAt(i); }

        for (int k = 1; k < n; k *= 2) {
            quickSort(sa, 0, n - 1, rank, k, n);
            next[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                int prev = sa[i - 1], cur = sa[i];
                next[cur] = next[prev] + (compare(prev, cur, rank, k, n) < 0 ? 1 : 0);
            }
            for (int i = 0; i < n; i++) rank[i] = next[i];
            if (rank[sa[n - 1]] == n - 1) break;
        }
        return sa;
    }

    private static void quickSort(int[] a, int low, int high, int[] rank, int k, int n) {
        if (low >= high) return;
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(a[j], pivot, rank, k, n) <= 0) { i++; swap(a, i, j); }
        }
        swap(a, i + 1, high);
        int p = i + 1;
        quickSort(a, low, p - 1, rank, k, n);
        quickSort(a, p + 1, high, rank, k, n);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
