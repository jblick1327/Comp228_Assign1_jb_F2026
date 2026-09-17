package utils;

public class GradeCalculation implements Util {
    private static float calculateAverage(float grades[]) {
        float sum = 0;
        for (float grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    private static char getLetterGrade(float grades[]) {
        char grade;
        float average = calculateAverage(grades);
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 40) {
            grade = 'C';
        } else {
            grade = 'D';
        }
        return grade;
    }

    @Override
    public void printInputString() {
        System.out.println("Enter all grades separated by spaces...");
    }

    @Override
    public boolean processInputAndPrintOutputString(String input) {
        String[] gradeStrings = input.split(" ");
        float[] grades = new float[gradeStrings.length];
        for (int i = 0; i < gradeStrings.length; i++) {
            try {
                grades[i] = Float.parseFloat(gradeStrings[i]);
            } catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
        }
        char letterGrade = getLetterGrade(grades);
        System.out.printf("The student's grade is %c\n", letterGrade);
        return true;
    }
}
