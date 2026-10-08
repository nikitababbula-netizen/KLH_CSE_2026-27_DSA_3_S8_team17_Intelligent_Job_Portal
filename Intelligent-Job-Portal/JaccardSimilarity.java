public class JaccardSimilarity {
    private static String[] splitSkills(String text) {
        text = text == null ? "" : text.toLowerCase().trim();
        if (text.length() == 0) return new String[0];
        return text.split("[;,\\s]+");
    }

    private static boolean contains(String[] array, int size, String value) {
        for (int i = 0; i < size; i++) if (array[i].equals(value)) return true;
        return false;
    }

    public static double calculate(String candidateSkills, String jobSkills) {
        String[] a = splitSkills(candidateSkills);
        String[] b = splitSkills(jobSkills);
        String[] union = new String[a.length + b.length];
        int unionSize = 0;
        for (int i = 0; i < a.length; i++) if (!contains(union, unionSize, a[i])) union[unionSize++] = a[i];
        for (int i = 0; i < b.length; i++) if (!contains(union, unionSize, b[i])) union[unionSize++] = b[i];
        int intersection = 0;
        for (int i = 0; i < a.length; i++) {
            if (contains(b, b.length, a[i]) && !contains(a, i, a[i])) intersection++;
        }
        if (unionSize == 0) return 0;
        return (intersection * 100.0) / unionSize;
    }
}
