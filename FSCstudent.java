
public class FSCstudent {
    private int ID;
    private String firstName;
    private String lastName;
    private int[] examGrades;
    private double finalGrade;
    private char letterGrade;
    private static int numStudents = 0;

    public FSCstudent(int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examGrades = examGrades;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        numStudents++;
    }

    public FSCstudent() {
        numStudents++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int[] getExamGrades() {
        return examGrades;
    }

    public void setExamGrades(int[] examGrades) {
        this.examGrades = examGrades;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public static void setNumStudents(int numStudents) {
        FSCstudent.numStudents = numStudents;
    }
    
    public static void increaseStudents(){
        numStudents++;
    }
    
    
    
    @Override
    public String toString(){
        String line = "";
        line += String.format(" - Student Record for %s %s (ID # %d):\n",firstName,lastName,ID);
        line += String.format("      Exam 1:       %d\n",examGrades[0]);
        line += String.format("      Exam 2:       %d\n", examGrades[1]);
        line += String.format("      Final Exam:   %d\n", examGrades[2]);
        line += String.format("      Final Grade:  %.2f\n", finalGrade);
        line += String.format("      Letter Grade: %s\n", letterGrade);
        return line;
    } 
}
