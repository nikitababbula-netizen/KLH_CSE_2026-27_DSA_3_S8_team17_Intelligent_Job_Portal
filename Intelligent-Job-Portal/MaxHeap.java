public class MaxHeap {
    private int[] ids;
    private double[] scores;
    private int size;

    public MaxHeap(int capacity) {
        ids = new int[capacity];
        scores = new double[capacity];
        size = 0;
    }

    public void add(int id, double score) {
        if (size == ids.length) return;
        ids[size] = id;
        scores[size] = score;
        int current = size++;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (scores[parent] >= scores[current]) break;
            swap(parent, current);
            current = parent;
        }
    }

    public int removeMax() {
        if (size == 0) return -1;
        int result = ids[0];
        size--;
        if (size > 0) {
            ids[0] = ids[size];
            scores[0] = scores[size];
            heapify(0);
        }
        return result;
    }

    public double getLastRemovedScore() { return lastRemovedScore; }

    private double lastRemovedScore;

    public int removeMaxWithScore(double[] holder) {
        if (size == 0) return -1;
        int result = ids[0];
        holder[0] = scores[0];
        size--;
        if (size > 0) {
            ids[0] = ids[size];
            scores[0] = scores[size];
            heapify(0);
        }
        return result;
    }

    public int size() { return size; }

    private void heapify(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if (left < size && scores[left] > scores[largest]) largest = left;
            if (right < size && scores[right] > scores[largest]) largest = right;
            if (largest == index) break;
            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int a, int b) {
        int id = ids[a]; ids[a] = ids[b]; ids[b] = id;
        double score = scores[a]; scores[a] = scores[b]; scores[b] = score;
    }
}
