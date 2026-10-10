# Intelligent Job Portal

**DSA-3 Project | Team 17**

An intelligent job-search web application that applies string-matching algorithms and skill-similarity techniques to help candidates discover relevant job opportunities.

---

## 1. Project Abstract

The Intelligent Job Portal is a web-based application designed to simplify job searching through the application of Data Structures and Algorithms (DSA). Traditional job portals allow users to search for opportunities using keywords and filters. This project extends that approach by incorporating multiple string-matching algorithms and skill-comparison techniques.

The application provides a user-friendly frontend developed using HTML, CSS, and JavaScript, while the backend is developed using Java and Spring Boot. Job information is maintained in a CSV dataset containing job titles, company names, locations, qualifications, experience requirements, salary ranges, skills, and job descriptions.

The project incorporates the Knuth–Morris–Pratt (KMP) algorithm, Rabin–Karp algorithm, and Z-Algorithm for pattern matching. Edit Distance is used to identify similar keywords and skills, while Jaccard Similarity measures the overlap between candidate skills and the skills required by a job.

Additional graph algorithms, including Breadth-First Search (BFS), Depth-First Search (DFS), Dijkstra's algorithm, and Bipartite Matching, are implemented as algorithm modules for exploring graph traversal, shortest paths, and candidate-to-job matching.

The main objective is to demonstrate how DSA concepts can be applied to a practical recruitment-related problem through an interactive web application.

## 2. Problem Statement

Searching for suitable job opportunities can be challenging when candidates need to compare multiple job descriptions and identify the skills relevant to their qualifications.

Simple keyword searches may not handle spelling variations effectively or indicate how closely a candidate's skills match a job's requirements.

This project addresses these challenges by implementing efficient string-search techniques and a skill-similarity calculation within a job-search application.

## 3. Objectives

- Develop a responsive and user-friendly job-search interface.
- Store and retrieve job information from a structured CSV dataset.
- Implement KMP, Rabin–Karp, and Z-Algorithm for string matching.
- Use Edit Distance to identify similar or misspelled keywords and skills.
- Apply Jaccard Similarity to compare candidate skills with job requirements.
- Integrate the frontend with Java through REST APIs using Spring Boot.
- Implement graph algorithms for traversal, shortest-path analysis, and matching demonstrations.
- Demonstrate the practical application of advanced DSA concepts.

## 4. Technologies Used

### Frontend
- **HTML5:** Structure of the website.
- **CSS3:** Styling, responsive layouts, animations, and visual design.
- **JavaScript:** User interactions, search inputs, filters, sorting, and API requests.

### Backend
- **Java:** Implementation of the core algorithms and application logic.
- **Spring Boot:** Backend application and REST API development.
- **Spring Web:** HTTP request handling and JSON responses.
- **Maven:** Dependency management and project building.

### Dataset
- **CSV (Comma-Separated Values):** Stores the job records used by the application.

## 5. System Architecture

The application follows a frontend–backend architecture.

1. The user interacts with the website and enters a search keyword, location, or set of skills.
2. JavaScript sends an HTTP request to the Spring Boot REST API.
3. The controller receives the request and passes it to the service layer.
4. The service loads and processes job records from the CSV dataset and invokes the appropriate Java algorithm.
5. Matching job information is returned to the frontend in JSON format.
6. The frontend displays the results as job cards, including relevant job details and skill-similarity scores.

### Architecture Overview

```text
                 USER
                   |
                   v
        FRONTEND: HTML, CSS, JS
                   |
             HTTP / JSON
                   |
                   v
        SPRING BOOT REST API
                   |
                   v
               CONTROLLER
                   |
                   v
                SERVICE
                   |
          +--------+---------+
          |                  |
          v                  v
      JOBS.CSV         JAVA ALGORITHMS
                       - KMP
                       - Rabin-Karp
                       - Z-Algorithm
                       - Edit Distance
                       - Jaccard Similarity
                       - Graph Algorithm Modules
          |                  |
          +--------+---------+
                   |
                   v
          MATCHING JOB RESULTS
                   |
                   v
              FRONTEND
```

## 6. Data Structures and Algorithms

### 6.1 Knuth–Morris–Pratt (KMP)

KMP searches for a pattern within a text using an LPS (Longest Proper Prefix which is also Suffix) array. This helps avoid repeated comparisons after a mismatch.

**Application:** Searching job titles, skills, company names, and descriptions.

**Time complexity:** O(n + m), where n is the text length and m is the pattern length.

### 6.2 Rabin–Karp Algorithm

Rabin–Karp uses hash values to compare a search pattern with text windows. When hash values match, the actual characters are checked to confirm the match.

**Application:** Keyword searching across job information.

**Average-case time complexity:** Approximately O(n + m). The worst case can be O(nm).

### 6.3 Z-Algorithm

The Z-Algorithm constructs a Z-array to identify how many characters at each position match the beginning of a combined pattern and text.

**Application:** Pattern matching in job titles and descriptions.

**Time complexity:** O(n + m).

### 6.4 Edit Distance

Edit Distance calculates the minimum number of insertions, deletions, and replacements required to transform one string into another. The standard dynamic programming implementation is used.

**Application:** Finding similar keywords or skills despite small spelling differences.

**Time complexity:** O(n × m).

### 6.5 Jaccard Similarity

Jaccard Similarity measures the overlap between two sets of skills.

**Formula:**

J(A, B) = |A ∩ B| / |A ∪ B|

The result ranges from 0 to 1. The frontend can display the value as a percentage.

**Application:** Comparing a candidate's skills with a job's required skills.

### 6.6 Graph Algorithms

The project also contains graph algorithm modules:

- **Breadth-First Search (BFS):** Traverses graph vertices level by level.
- **Depth-First Search (DFS):** Traverses graph vertices by exploring a path before backtracking.
- **Dijkstra's Algorithm:** Finds shortest paths in graphs with non-negative edge weights.
- **Bipartite Matching:** Finds the maximum number of compatible matches between two groups.

The graph modules can be used for demonstrations of graph traversal and matching. Exposing them through the website requires corresponding backend API endpoints.

## 7. Main Features

- Job listing and job-details display.
- Search by keyword and location.
- Filter jobs by category.
- Sort the job listings.
- Save and unsave jobs during the current browser session.
- Compare candidate skills with job requirements.
- Display skill-similarity scores.
- Search using selectable string-matching algorithms.
- Find similar skills using Edit Distance.
- Load job records from a CSV dataset.
- Responsive interface for desktop, tablet, and mobile screens.

**Note:** Job-application submission, user authentication, and persistent saved-job storage are not included unless implemented separately.

## 8. Project Structure

```text
Intelligent-Job-Portal/
|
|-- pom.xml
|
|-- data/
|   |-- jobs.csv
|
|-- frontend/
|   |-- index.html
|   |-- style.css
|   |-- script.js
|
|-- src/
|   |-- main/
|       |-- java/
|       |   |-- com/
|       |       |-- team17/
|       |           |-- intelligentjobportal/
|       |               |-- IntelligentJobPortalApplication.java
|       |               |-- JobController.java
|       |               |-- JobService.java
|       |               |-- JobResponse.java
|       |               |-- Job.java
|       |               |-- JobPortal.java
|       |               |-- Main.java
|       |               |-- KMP.java
|       |               |-- RabinKarp.java
|       |               |-- ZAlgorithm.java
|       |               |-- EditDistance.java
|       |               |-- JaccardSimilarity.java
|       |               |-- Graph.java
|       |               |-- BFS.java
|       |               |-- DFS.java
|       |               |-- Dijkstra.java
|       |               |-- BipartiteMatching.java
|       |
|       |-- resources/
|           |-- static/
|               |-- index.html
|               |-- style.css
|               |-- script.js
|
|-- README.md
```

The frontend files in `frontend/` are the editable frontend copies. Spring Boot serves the copies placed in `src/main/resources/static/`.

## 9. Dataset Description

The project uses `data/jobs.csv` as its job dataset.

The CSV contains the following columns:

| Column | Description |
|---|---|
| ID | Unique job identifier |
| JobTitle | Job position |
| Company | Company name |
| Location | Job location |
| Qualification | Required qualification |
| Experience | Experience requirement |
| Salary | Salary range |
| Skills | Skills associated with the position |
| Description | Description of the job |

The dataset contains sample demonstration listings. These records are not verified or live vacancies.

## 10. Setup and Installation

### Prerequisites

- Java Development Kit (JDK) 17 or a compatible newer JDK.
- Maven, or the Maven Wrapper (`mvnw.cmd` on Windows).
- Visual Studio Code or another Java IDE.
- A web browser.
- An internet connection for the initial download of project dependencies.

### Step 1: Open the project

Open the main `Intelligent-Job-Portal` folder in Visual Studio Code. Verify that `pom.xml` is in the project root, beside `src`, `frontend`, and `data`.

### Step 2: Verify the Java version

Open the terminal and run:

```bash
java -version
javac -version
```

### Step 3: Run the application

On Windows, when the Maven Wrapper is present in the project root:

```powershell
.\mvnw.cmd spring-boot:run
```

If Maven is installed and available on PATH, alternatively run:

```bash
mvn spring-boot:run
```

Run the command from the folder containing `pom.xml`.

### Step 4: Open the website

After Spring Boot starts, open:

http://localhost:8080

### Step 5: Test the backend API

Open:

http://localhost:8080/api/jobs

The endpoint should return JSON containing the job records.

## 11. API Endpoints

The following endpoints correspond to the intended Spring Boot controller implementation.

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/jobs` | Retrieve and filter jobs |
| GET | `/api/jobs?q=Java&algorithm=KMP` | Search with KMP |
| GET | `/api/jobs?q=Java&algorithm=RABIN_KARP` | Search with Rabin–Karp |
| GET | `/api/jobs?q=Java&algorithm=Z_ALGORITHM` | Search with the Z-Algorithm |
| GET | `/api/jobs?q=Jav&algorithm=EDIT_DISTANCE` | Search using edit-distance-based matching |
| GET | `/api/jobs?skills=Java,SQL` | Compare skills using Jaccard Similarity |
| GET | `/api/jobs/101` | Retrieve a particular job by ID |
| GET | `/api/jobs/fuzzy?skill=Jav&maxDistance=2` | Search for similar skills |

The actual availability of these endpoints depends on the backend implementation compiling and running successfully.

## 12. Expected Results

When the application is running correctly:

- The website displays job cards loaded from the dataset.
- Keyword and location searches return matching records.
- The algorithm selector changes the backend's string-matching method.
- The skill matcher returns jobs ranked by skill similarity.
- Job details can be opened through the frontend.
- The graph algorithm classes can be tested separately or exposed through additional APIs.

## 13. Current Implementation Status

The project is designed to integrate the frontend, Spring Boot backend, CSV job dataset, and Java DSA algorithms.

Before final submission, verify that:

- The Java classes compile with the correct package declarations.
- Spring Boot starts successfully.
- The CSV dataset loads without errors.
- The website is served through Spring Boot.
- Search requests return the expected results from the Java algorithms.
- Jaccard skill matching produces valid similarity scores.
- The graph algorithm modules run correctly.
- The README matches the functionality demonstrated in the final application.

## 14. Limitations

- The current dataset contains demonstration job records and is not a live job feed.
- The system does not independently verify vacancies or employer information.
- Jaccard Similarity compares overlapping skill tokens; it does not assess skill proficiency.
- Edit Distance measures string differences and does not establish that two skills have the same technical meaning.
- User authentication, a persistent database, real job applications, and live job integrations require additional development.
- Graph modules require additional API integration before they can be operated directly from the website.

## 15. Future Enhancements

- Integrate MySQL or another database for persistent job storage.
- Add user registration and login.
- Introduce candidate profiles and saved-job persistence.
- Integrate verified job feeds or employer-submitted vacancies.
- Improve skill matching with weighted skills and semantic similarity.
- Expose graph algorithms through REST APIs.
- Add automated tests and performance comparisons for the implemented algorithms.
- Add pagination and additional job filters.

## 16. Team Information

**Project:** Intelligent Job Portal  
**Course:** DSA-3  
**Team Number:** 17  
**Department:** Computer Science and Engineering

**Team Members**

1. [Member 1 Name] — [Student ID]
2. [Member 2 Name] — [Student ID]
3. [Member 3 Name] — [Student ID]
4. [Member 4 Name] — [Student ID]

**Project Supervisor:** [Supervisor Name]

## 17. Conclusion

The Intelligent Job Portal demonstrates how string matching, dynamic programming, set similarity, and graph algorithms can be applied to a job-search application. By combining a web-based frontend with a Java backend and a structured job dataset, the project provides a practical environment for understanding how DSA techniques can support searching, skill comparison, and job discovery.

The project also provides opportunities for further development through database integration, improved matching techniques, additional API endpoints, and more advanced recruitment features.
