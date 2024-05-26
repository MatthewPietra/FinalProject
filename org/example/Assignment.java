package org.example;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = "A" + nextId++;
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
    }

    public void calcAssignmentAvg() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        assignmentAverage = (double) sum / scores.size();
    }

    public void generateRandomScore(int numStudents) {
        scores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            int randomNum = random.nextInt(11);
            int score = switch (randomNum) {
                case 0 -> random.nextInt(60);
                case 1, 2 -> 60 + random.nextInt(10);
                case 3, 4 -> 70 + random.nextInt(10);
                case 5, 6, 7, 8 -> 80 + random.nextInt(10);
                default -> 90 + random.nextInt(11);
            };
            scores.add(score);
        }
    }
    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }
}