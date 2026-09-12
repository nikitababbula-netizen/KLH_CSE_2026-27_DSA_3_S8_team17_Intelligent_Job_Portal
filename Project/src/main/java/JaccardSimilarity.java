package main.java;

public class JaccardSimilarity {

    public static double calculate(String candidateSkills, String jobSkills) {

        String[] candidate = candidateSkills.toLowerCase().split(" ");
        String[] job = jobSkills.toLowerCase().split(" ");

        int common = 0;
        int total = 0;

        // Count common skills
        for (int i = 0; i < candidate.length; i++) {

            for (int j = 0; j < job.length; j++) {

                if (candidate[i].equals(job[j])) {
                    common++;
                    break;
                }
            }
        }

        // Count unique skills
        for (int i = 0; i < candidate.length; i++) {

            boolean found = false;

            for (int k = 0; k < i; k++) {

                if (candidate[i].equals(candidate[k])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                total++;
            }
        }

        for (int i = 0; i < job.length; i++) {

            boolean found = false;

            for (int k = 0; k < candidate.length; k++) {

                if (job[i].equals(candidate[k])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                total++;
            }
        }

        if (total == 0) {
            return 0;
        }

        return ((double) common / total) * 100;
    }

    public static void main(String[] args) {

        String candidateSkills = "java python sql";
        String jobSkills = "java python html";

        double result = calculate(candidateSkills, jobSkills);

        System.out.println("Candidate Skills : " + candidateSkills);
        System.out.println("Job Skills       : " + jobSkills);
        System.out.println("Jaccard Similarity: " + result + "%");
    }
}