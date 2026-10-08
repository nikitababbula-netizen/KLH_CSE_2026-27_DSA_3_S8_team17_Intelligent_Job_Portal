import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        JobPortal portal = new JobPortal("data/jobs.csv");

        while (true) {
            System.out.println("\n===============================");
            System.out.println("     INTELLIGENT JOB PORTAL");
            System.out.println("===============================");
            System.out.println("1. Display all jobs");
            System.out.println("2. Search using KMP");
            System.out.println("3. Search using Rabin-Karp");
            System.out.println("4. Search using Z-Algorithm");
            System.out.println("5. Fuzzy skill search");
            System.out.println("6. Compare skills using Jaccard Similarity");
            System.out.println("7. Sort jobs by salary using Quick Sort");
            System.out.println("8. Show top job matches using Max Heap");
            System.out.println("9. Suffix Array and LCP demo");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(br.readLine());

            if (choice == 1) {
                portal.displayAllJobs();
            } else if (choice >= 2 && choice <= 4) {
                System.out.print("Enter keyword: ");
                String keyword = br.readLine();
                portal.search(keyword, choice - 1);
            } else if (choice == 5) {
                System.out.print("Enter skill: ");
                String skill = br.readLine();
                System.out.print("Maximum edit distance: ");
                int d = Integer.parseInt(br.readLine());
                portal.fuzzySearch(skill, d);
            } else if (choice == 6) {
                System.out.print("Candidate skills (space or ; separated): ");
                String a = br.readLine();
                System.out.print("Job skills (space or ; separated): ");
                String b = br.readLine();
                portal.compareSkills(a, b);
            } else if (choice == 7) {
                portal.sortBySalary();
            } else if (choice == 8) {
                System.out.print("Enter candidate skills: ");
                String skills = br.readLine();
                portal.topMatches(skills);
            } else if (choice == 9) {
                System.out.print("Enter job row number (1-60, for example 1): ");
                int row = Integer.parseInt(br.readLine()) - 1;
                portal.suffixAndLcpDemo(row);
            } else if (choice == 10) {
                System.out.println("Thank you.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
