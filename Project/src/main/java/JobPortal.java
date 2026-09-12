package main.java;

public class JobPortal {

    String[] jobTitles = {
        "Java Developer",
        "Python Developer",
        "Web Developer",
        "Data Analyst",
        "Software Engineer",
        "QA Engineer"
    };

    String[] companies = {
        "TechNova",
        "CodeWorks",
        "WebTech",
        "DataLabs",
        "NextGen",
        "TestCore"
    };

    String[] locations = {
        "Hyderabad",
        "Bangalore",
        "Hyderabad",
        "Bangalore",
        "Chennai",
        "Hyderabad"
    };

    String[] jobSkills = {
        "java python sql",
        "python sql machinelearning",
        "html css javascript",
        "python sql excel",
        "java c++ dsa",
        "java selenium sql"
    };

    // Display all available jobs
    public void displayJobs() {

        System.out.println("\n========== AVAILABLE JOBS ==========");

        for (int i = 0; i < jobTitles.length; i++) {

            System.out.println("\nJob ID   : " + (i + 101));
            System.out.println("Title    : " + jobTitles[i]);
            System.out.println("Company  : " + companies[i]);
            System.out.println("Location : " + locations[i]);
            System.out.println("Skills   : " + jobSkills[i]);

            System.out.println("------------------------------------");
        }
    }

    // KMP pattern searching
    public void searchJob(String keyword) {

        System.out.println("\n========== KMP JOB SEARCH ==========");
        System.out.println("Searching for: " + keyword);

        boolean found = false;

        for (int i = 0; i < jobTitles.length; i++) {

            String text = jobTitles[i] + " " + jobSkills[i];

            int result = KMP.search(text, keyword);

            if (result != -1) {

                System.out.println("\nJob Found");
                System.out.println("Job ID   : " + (i + 101));
                System.out.println("Title    : " + jobTitles[i]);
                System.out.println("Company  : " + companies[i]);
                System.out.println("Location : " + locations[i]);
                System.out.println("Skills   : " + jobSkills[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching jobs found.");
        }
    }

    // Edit Distance based fuzzy search
    public void fuzzySearch(String skill, int maxDistance) {

        System.out.println("\n========== FUZZY SEARCH ==========");
        System.out.println("Searching for: " + skill);

        boolean found = false;

        for (int i = 0; i < jobSkills.length; i++) {

            String[] skills = jobSkills[i].split(" ");

            for (int j = 0; j < skills.length; j++) {

                int distance =
                        EditDistance.calculate(skill, skills[j]);

                if (distance <= maxDistance) {

                    System.out.println("\nFuzzy Match Found");
                    System.out.println("Entered Skill : " + skill);
                    System.out.println("Matched Skill : " + skills[j]);
                    System.out.println("Edit Distance : " + distance);

                    System.out.println("Job ID   : " + (i + 101));
                    System.out.println("Title    : " + jobTitles[i]);
                    System.out.println("Company  : " + companies[i]);
                    System.out.println("Location : " + locations[i]);

                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No close skill matches found.");
        }
    }

    // Jaccard Similarity
    public void compareSkills(String candidateSkills,
                              String jobSkills) {

        double score =
                JaccardSimilarity.calculate(
                        candidateSkills,
                        jobSkills
                );

        System.out.println("\n========== SKILL SIMILARITY ==========");
        System.out.println("Candidate Skills : " + candidateSkills);
        System.out.println("Job Skills       : " + jobSkills);
        System.out.println("Similarity Score : "
                + String.format("%.2f", score) + "%");

        if (score >= 70) {
            System.out.println("Result: Excellent Match");
        } else if (score >= 40) {
            System.out.println("Result: Good Match");
        } else {
            System.out.println("Result: Low Match");
        }
    }

    // Find the most suitable job using Jaccard similarity
    public void recommendJobs(String candidateSkills) {

        System.out.println("\n========== JOB RECOMMENDATIONS ==========");

        double[] scores = new double[jobSkills.length];

        for (int i = 0; i < jobSkills.length; i++) {

            scores[i] =
                    JaccardSimilarity.calculate(
                            candidateSkills,
                            jobSkills[i]
                    );
        }

        // Simple sorting of scores in descending order
        for (int i = 0; i < scores.length - 1; i++) {

            for (int j = i + 1; j < scores.length; j++) {

                if (scores[j] > scores[i]) {

                    double tempScore = scores[i];
                    scores[i] = scores[j];
                    scores[j] = tempScore;

                    String tempTitle = jobTitles[i];
                    jobTitles[i] = jobTitles[j];
                    jobTitles[j] = tempTitle;

                    String tempCompany = companies[i];
                    companies[i] = companies[j];
                    companies[j] = tempCompany;

                    String tempLocation = locations[i];
                    locations[i] = locations[j];
                    locations[j] = tempLocation;

                    String tempSkills = jobSkills[i];
                    jobSkills[i] = jobSkills[j];
                    jobSkills[j] = tempSkills;
                }
            }
        }

        for (int i = 0; i < 3 && i < scores.length; i++) {

            System.out.println("\nRank " + (i + 1));
            System.out.println("Match Score : "
                    + String.format("%.2f", scores[i]) + "%");
            System.out.println("Job Title   : " + jobTitles[i]);
            System.out.println("Company     : " + companies[i]);
            System.out.println("Location    : " + locations[i]);
            System.out.println("Skills      : " + jobSkills[i]);
        }
    }
}