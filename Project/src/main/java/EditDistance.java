package main.java;

public class EditDistance {

    public static int calculate(String candidateSkill, String requiredSkill) {

        candidateSkill = candidateSkill.toLowerCase();
        requiredSkill = requiredSkill.toLowerCase();

        int n = candidateSkill.length();
        int m = requiredSkill.length();

        int[][] dp = new int[n + 1][m + 1];

        // Deletion
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Insertion
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (candidateSkill.charAt(i - 1)
                        == requiredSkill.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                            insert,
                            Math.min(delete, replace)
                    );
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {

        String candidateSkill = "Jvaa";
        String requiredSkill = "Java";

        int distance = calculate(candidateSkill, requiredSkill);

        System.out.println("Candidate Skill : " + candidateSkill);
        System.out.println("Required Skill  : " + requiredSkill);
        System.out.println("Edit Distance   : " + distance);

        if (distance <= 2) {
            System.out.println("Result: Suitable Fuzzy Match");
        } else {
            System.out.println("Result: Not a Close Match");
        }
    }
}
