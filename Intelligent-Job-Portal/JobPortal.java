import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JobPortal {
    private static final int MAX_JOBS = 200;
    private int count = 0;
    private int[] ids = new int[MAX_JOBS];
    private String[] titles = new String[MAX_JOBS];
    private String[] companies = new String[MAX_JOBS];
    private String[] locations = new String[MAX_JOBS];
    private String[] qualifications = new String[MAX_JOBS];
    private int[] experience = new int[MAX_JOBS];
    private double[] salary = new double[MAX_JOBS];
    private String[] skills = new String[MAX_JOBS];
    private String[] descriptions = new String[MAX_JOBS];

    public JobPortal(String filePath) {
        loadJobs(filePath);
    }

    private void loadJobs(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null && count < MAX_JOBS) {
                if (line.trim().length() == 0) continue;
                String[] p = line.split(",", -1);
                if (p.length < 9) continue;
                ids[count] = Integer.parseInt(p[0].trim());
                titles[count] = p[1].trim();
                companies[count] = p[2].trim();
                locations[count] = p[3].trim();
                qualifications[count] = p[4].trim();
                experience[count] = Integer.parseInt(p[5].trim());
                salary[count] = Double.parseDouble(p[6].trim());
                skills[count] = p[7].trim();
                descriptions[count] = p[8].trim();
                count++;
            }
            System.out.println(count + " job records loaded.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load dataset: " + e.getMessage());
        }
    }

    private String searchableText(int i) {
        return titles[i] + " " + companies[i] + " " + locations[i] + " "
                + qualifications[i] + " " + skills[i] + " " + descriptions[i];
    }

    public void displayAllJobs() {
        for (int i = 0; i < count; i++) printJob(i);
    }

    private void printJob(int i) {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + ids[i]);
        System.out.println("Job: " + titles[i]);
        System.out.println("Company: " + companies[i]);
        System.out.println("Location: " + locations[i]);
        System.out.println("Qualification: " + qualifications[i]);
        System.out.println("Experience: " + experience[i] + " years");
        System.out.println("Salary: " + salary[i] + " LPA");
        System.out.println("Skills: " + skills[i]);
        System.out.println("Description: " + descriptions[i]);
    }

    public void search(String keyword, int choice) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            String text = searchableText(i);
            int position;
            if (choice == 1) position = KMP.search(text, keyword);
            else if (choice == 2) position = RabinKarp.search(text, keyword);
            else position = ZAlgorithm.search(text, keyword);
            if (position != -1) { printJob(i); found = true; }
        }
        if (!found) System.out.println("No matching jobs found.");
    }

    public void fuzzySearch(String word, int maxDistance) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            String[] jobSkills = skills[i].split("[;,\\s]+");
            for (int j = 0; j < jobSkills.length; j++) {
                int d = EditDistance.calculate(word, jobSkills[j]);
                if (d <= maxDistance) {
                    System.out.println("Matched skill: " + jobSkills[j] + " | Edit Distance: " + d);
                    printJob(i);
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No fuzzy matches found.");
    }

    public void compareSkills(String candidateSkills, String jobSkills) {
        double score = JaccardSimilarity.calculate(candidateSkills, jobSkills);
        System.out.printf("Jaccard Similarity: %.2f%%%n", score);
    }

    public void sortBySalary() {
        int[] tempIds = new int[count];
        double[] scores = new double[count];
        for (int i = 0; i < count; i++) { tempIds[i] = ids[i]; scores[i] = salary[i]; }
        QuickSort.sortByScore(tempIds, scores, 0, count - 1);
        System.out.println("Jobs sorted by salary (high to low):");
        for (int j = 0; j < count; j++) {
            int index = findIndexById(tempIds[j]);
            System.out.println(tempIds[j] + " | " + titles[index] + " | " + scores[j] + " LPA");
        }
    }

    private int findIndexById(int id) {
        for (int i = 0; i < count; i++) if (ids[i] == id) return i;
        return -1;
    }

    public void topMatches(String candidateSkills) {
        MaxHeap heap = new MaxHeap(count);
        for (int i = 0; i < count; i++) {
            double score = JaccardSimilarity.calculate(candidateSkills, skills[i]);
            heap.add(ids[i], score);
        }
        System.out.println("Top matching jobs:");
        double[] holder = new double[1];
        int rank = 1;
        while (heap.size() > 0 && rank <= 5) {
            int id = heap.removeMaxWithScore(holder);
            int index = findIndexById(id);
            System.out.printf("Rank %d: %s | %.2f%%%n", rank, titles[index], holder[0]);
            rank++;
        }
    }

    public void suffixAndLcpDemo(int jobIndex) {
        if (jobIndex < 0 || jobIndex >= count) {
            System.out.println("Invalid job index.");
            return;
        }
        String text = descriptions[jobIndex].toLowerCase();
        if (text.length() > 200) text = text.substring(0, 200);
        int[] sa = SuffixArray.build(text);
        int[] lcp = LCPArray.build(text, sa);
        System.out.println("Suffix Array + LCP for job: " + titles[jobIndex]);
        for (int i = 0; i < sa.length && i < 20; i++) {
            System.out.println(i + " | suffix index=" + sa[i] + " | LCP=" + lcp[i]);
        }
    }
}
