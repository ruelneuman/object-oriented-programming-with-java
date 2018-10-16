
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rueln
 */
import java.util.ArrayList;

public class ExamGrades {

    private int[] totalGrades;

    public ExamGrades() {
        this.totalGrades = new int[6];
    }

    public void add(int score) {
        if (grade(score) >= 0 && grade(score) <= 5) {
            this.totalGrades[grade(score)]++;
        }

    }

    public int grade(int score) {
        if (score >= 0 && score <= 29) {
            return 0;
        } else if (score >= 30 && score <= 34) {
            return 1;
        } else if (score >= 35 && score <= 39) {
            return 2;
        } else if (score >= 40 && score <= 44) {
            return 3;
        } else if (score >= 45 && score <= 49) {
            return 4;
        } else if (score >= 50 && score <= 60) {
            return 5;
        } else {
            return -1;
        }
    }

    public void gradeDistribution() {
        System.out.println("Grade Distribution: ");
        
        for (int i = this.totalGrades.length - 1; i >= 0; i--) {
            System.out.print(i + ": ");
            for (int j = 0; j < this.totalGrades[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public double acceptancePercentage() {
        int totalNumberOfExams = 0;
        
        for (int exams : this.totalGrades) {
            totalNumberOfExams += exams;
        }
        
        return 100.00 * (totalNumberOfExams - this.totalGrades[0]) / totalNumberOfExams;
    }
}
