package com.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> students = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("No of Students : ");

		if (scanner.hasNextInt()) {

			int totalStudent = scanner.nextInt();
			// Loop to input student details
			for (int i = 0; i < totalStudent; i++) {
				System.out.println("Student" + (i + 1) + " :");

				System.out.println("Enter Student Id : ");
				if (scanner.hasNextInt()) {
					int studentID = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter Student Name : ");

					if (scanner.hasNextLine()) {
						String studentName = scanner.nextLine();
						System.out.println("Enter Student Score : ");
						if (scanner.hasNextDouble()) {

							double score = scanner.nextDouble();
							students.add(new Student(studentID, studentName, score));

						} else {
							System.out.println("Invalid input for score. Please enter a number");
							break;
						}

					} else {
						System.out.println("Invalid input for name. Please enter a string");
						break;
					}

				} else {
					System.out.println("Invalid input for ID. Please enter a number");
					break;
				}
				System.out.println();

			}

		} else {
			System.out.println("Please enter an valid Input");
		}

		scanner.close();

		if (!students.isEmpty()) {

			double passScore = 80.0;

			// Display average score
			System.out.println("Average Score: " + getAverageScore());
			
			// Display top scorer
			String topScorer = getTopScorer();
			if (topScorer != null) {
				System.out.println("Top Scorer: " + getTopScorer());
			}

			// Display students with passing score in ascending order
			List<Student> studentsWithPassingScore = getStudentsWithPassingScore(passScore);
			System.out.println("Students with Scores >= " + passScore + ":");

			studentsWithPassingScore
					.forEach(student -> System.out.println(student.getName() + " - " + student.getScore()));
		}

	}
	// Calculate and return the average score of all students
	private static double getAverageScore() {

		return students.stream().mapToDouble(Student::getScore).average().orElse(0);

	}
	// Identify and return the name of the top scorer
	private static String getTopScorer() {
		return students.stream().max(Comparator.comparingDouble(Student::getScore)).map(Student::getName)
				.orElse("No top scorer found");
	}
	// Return a list of students who have scored equal to or higher than the given passing score
	private static List<Student> getStudentsWithPassingScore(double passScore) {
		return students.stream().filter(student -> student.getScore() >= passScore)
				.sorted(Comparator.comparingDouble(Student::getScore)).toList();
	}

}
