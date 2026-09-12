public class KMP {

    // Create LPS array
    public static int[] createLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int length = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(length)) {

                length++;
                lps[i] = length;
                i++;

            } else {

                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Search pattern in text
    public static int search(String text, String pattern) {

        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        if (pattern.length() == 0) {
            return 0;
        }

        int[] lps = createLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

                if (j == pattern.length()) {
                    return i - j;
                }

            } else {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    // Test the algorithm
    public static void main(String[] args) {

        String jobDescription =
                "Looking for Java developer with Python and SQL skills";

        String searchSkill = "Python";

        int result = search(jobDescription, searchSkill);

        System.out.println("Job Description : " + jobDescription);
        System.out.println("Search Skill    : " + searchSkill);

        if (result != -1) {

            System.out.println("Result          : Skill Found");
            System.out.println("Position        : " + result);

        } else {

            System.out.println("Result          : Skill Not Found");
        }
    }
}