public class QuickSort {
    public static void sortByScore(int[] ids, double[] scores, int low, int high) {
        if (low < high) {
            int p = partition(ids, scores, low, high);
            sortByScore(ids, scores, low, p - 1);
            sortByScore(ids, scores, p + 1, high);
        }
    }

    private static int partition(int[] ids, double[] scores, int low, int high) {
        double pivot = scores[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (scores[j] >= pivot) {
                i++;
                swap(ids, scores, i, j);
            }
        }
        swap(ids, scores, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] ids, double[] scores, int i, int j) {
        int tempId = ids[i]; ids[i] = ids[j]; ids[j] = tempId;
        double tempScore = scores[i]; scores[i] = scores[j]; scores[j] = tempScore;
    }
}
