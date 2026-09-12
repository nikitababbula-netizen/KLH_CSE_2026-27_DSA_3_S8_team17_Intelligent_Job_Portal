package main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        JobPortal portal = new JobPortal();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      INTELLIGENT JOB PORTAL");
            System.out.println("=================================");
            System.out.println("1. Display Jobs");
            System.out.println("2. Search Job using KMP");
            System.out.println("3. Fuzzy Skill Search");
            System.out.println("4. Compare Candidate and Job Skills");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                portal.displayJobs();

            } else if (choice == 2) {

                System.out.print("Enter keyword to search: ");
                String keyword = sc.nextLine();

                portal.searchJob(keyword);

            } else if (choice == 3) {

                System.out.print("Enter skill to search: ");
                String skill = sc.nextLine();

                System.out.print("Enter maximum edit distance: ");
                int distance = sc.nextInt();
                sc.nextLine();

                portal.fuzzySearch(skill, distance);

            } else if (choice == 4) {

                System.out.print("Enter candidate skills: ");
                String candidateSkills = sc.nextLine();

                System.out.print("Enter job required skills: ");
                String jobSkills = sc.nextLine();

                portal.compareSkills(candidateSkills, jobSkills);

            } else if (choice == 5) {

                System.out.println("Thank you for using Intelligent Job Portal!");
                break;

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
