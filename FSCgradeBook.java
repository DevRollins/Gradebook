import java.util.*;

public class FSCgradeBook {
    
    // Parameters:  FSCstudent[] students, int studentID, String firstName, String lastName, int exam1Grade, int exam2Grade, int exam3Grade)
    // Return Type: None
    // Description: This method creates a record of a student and adds them to an existing array
    //              of students
    public static void ADDRECORD(FSCstudent[] students, int studentID, String firstName, String lastName, int exam1Grade, int exam2Grade, int exam3Grade){
        FSCstudent newStudent = new FSCstudent();   //Create a new FSCstudent object
        //Manually assign each characteristic 
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        newStudent.setID(studentID);
        int[] examGrades = {exam1Grade, exam2Grade, exam3Grade};    //Use the grades given to add them to the examGrades array
        newStudent.setExamGrades(examGrades);
        
        double exam1Final = exam1Grade * 0.3;   //Calculate their final grades with the appropriate weights
        double exam2Final = exam2Grade * 0.3;
        double finalExamFinal = exam3Grade * 0.4;   
        double finalGrade = exam1Final + exam2Final + finalExamFinal;
        //Save the finalGrade to the student
        newStudent.setFinalGrade(finalGrade);
        
        //This is the scale for determining the letter grade. Set it accordingly
        if (finalGrade > 89.9) {
            newStudent.setLetterGrade('A');
        }
        else if(finalGrade > 79.9) {
            newStudent.setLetterGrade('B');
        }
        else if(finalGrade > 69.9){
            newStudent.setLetterGrade('C');
        }
        else if(finalGrade > 59.9){
            newStudent.setLetterGrade('D');
        }
        else{
            newStudent.setLetterGrade('F');
        }
        
        //Shift and add it to the array of students 
            //Find the insertion point
        int insertionID = 0;
        for (int i = 0; i < FSCstudent.getNumStudents()-1; i++) {
            if (students[i].getID() < newStudent.getID()) {
                insertionID++;
            }
            else{
                break;
            }
        }   
        
            //Allocate space for it 
        for (int i = FSCstudent.getNumStudents()-1; i > insertionID; i--) {
            students[i] = students[i-1];
        }
        
            //Add them to the array of students
        students[insertionID] = newStudent;
        
        //Print out the "student has been added jawn
        System.out.println("Command: ADDRECORD");
        System.out.printf("%s %s (ID# %d) has been added to the FSC Grade Book.\n", firstName, lastName, studentID);
        System.out.printf("   Final Grade: %.2f (%s).\n", finalGrade,newStudent.getLetterGrade());
    }   //End of ADDRECORD()
    
    //Get the letter grade of their final grade
    public static char finalLetterGrade(double finalGrade){
        if (finalGrade > 89.9) {
            return 'A';
        }
        else if(finalGrade > 79.9){
            return 'B';
        }
        else if(finalGrade > 69.9){
            return 'C';           
        }
        else if(finalGrade > 59.9){
            return 'D';
        }
        else{
            return 'F';
        }
    }
    
    // Parameters:  FSCstudent[] students, int studentID
    // Return Type: None
    // Description: Searches through the array of students and finds one
    //              with a matching student ID
    public static void SEARCHBYID(FSCstudent[] students, int studentID){ 
        boolean flag = false;   //This flag will be used to determine if we found the student we're searching for or not 
        //This is what we need to create a binary search
        int low = 0;    
        int high = FSCstudent.getNumStudents() - 1;
        int mid;
        int findIdx = 0;
        if (FSCstudent.getNumStudents() == 0) { //Can't search if there aren't any students to search through
            System.out.println("Command: SEARCHBYID");
            System.out.println("   ERROR: cannot perform search. The gradebook is empty (no students added yet).");
        }
        else{   
            System.out.println("Command: SEARCHBYID");
            while(low <= high){
                mid = (low + high) / 2;
                if (studentID == students[mid].getID()){ //We found them!!
                    findIdx = mid;
                    flag = true;
                    break;
                }
                 else if (studentID < students[mid].getID()){   //We're too low
                     high = mid - 1;
                 }
                 else{
                     low = mid + 1; //We're too high
                 }
            } 
            if (flag) { //We found them in the array
                System.out.println(students[findIdx]);
            }
            else if (flag == false){   //We did NOT find them
                System.out.printf("   ERROR: there is no record for student ID # %d\n", studentID);
            }
        }
    }   //End of SEARCHBYID()
    
    // Parameters:  String firstName, String lastName
    // Return Type: None
    // Description: Searches through the array of students and finds one with
    //              a matching name combination
    public static void SEARCHBYNAME(FSCstudent[] students, String firstName, String lastName){
        boolean match = false;  //We foudn a match 
        
        int low = 0;    //The things we need to do the binary search
        int high = FSCstudent.getNumStudents() - 1;
        int mid;
        int findIdx = 0;
        
        if (FSCstudent.getNumStudents() == 0) {
            System.out.println("Command: SEARCHBYNAME");
            System.out.println("   ERROR: cannot perform search. The gradebook is empty (no students added yet).");
        }
        else{
            while(low <= high){
                mid = (low + high) / 2;
                if (firstName.equals(students[mid].getFirstName()) && students[mid].getLastName().equals(lastName)){ // We found them
                    findIdx = mid;
                    match = true;
                    break;
                }
                else if (firstName.compareTo(students[mid].getFirstName()) < 0){     //Use compareTo here to determine if we are too far or too low
                     high = mid - 1;
                 }
                 else{
                     low = mid + 1;
                 } 
            }
            if (match) {    //We found them in the array
                System.out.println("Command: SEARCHBYNAME");
                System.out.println(students[findIdx]);
            }
            else if (match == false){   //We did NOT find them in the array
                System.out.println("Command: SEARCHBYNAME");
                System.out.printf("   ERROR: there is no record for student\"%s %s \"\n",firstName, lastName);
            }   
        }    
    }   //End of SEARCHBYNAME()
    
    // Parameters:  None
    // Return Type: None
    // Description: Displays the statistics of student exam grades
    public static void DISPLAYSTATS(FSCstudent[] students, String courseName, String profName){
        //Unlike the other methods, this one will function even without any students currently in the system
        //To keep it simple, I am going to make an entirely separate print statement to avoid dividing 0 by 0
        System.out.println("Command: DISPLAYSTATS");
        System.out.printf("Statistical Results of %s (Instructor: Dr %s):\n", courseName, profName);
        System.out.printf("   Total number of student records: %d\n", FSCstudent.getNumStudents());
        if (FSCstudent.getNumStudents() == 0 ) {
        System.out.println("   Average Score: 0.00");
        System.out.println("   Highest Score: 0.00");
        System.out.println("   Lowest Score:  0.00");
        System.out.println("   Total 'A' Grades: 0  (0% of class)");
        System.out.println("   Total 'B' Grades: 0  (0% of class)");
        System.out.println("   Total 'C' Grades: 0  (0% of class)");
        System.out.println("   Total 'D' Grades: 0  (0% of class)");
        System.out.println("   Total 'F' Grades: 0  (0% of class)");    
        }
        else{
    //Set the lowestScore to be the highest value int possible, so that anything is lower than it and it can be properly judged
                //Do the exact opposite for the highestScore
            double lowestScore = students[0].getFinalGrade();
            double highestScore = students[0].getFinalGrade();
            double sum = 0.0;
            //Calculate the sum(which will be used for averages, the lowest and highest scores
            for (int i = 0; i < FSCstudent.getNumStudents(); i++) {
                sum += students[i].getFinalGrade();
                if  (students[i].getFinalGrade() < lowestScore) {
                    lowestScore = students[i].getFinalGrade();
                }
                else if(students[i].getFinalGrade() > highestScore){
                    highestScore = students[i].getFinalGrade();
                }
            }

            //Now, let's count the letter grades
            int numA = 0;
            int numB = 0;
            int numC = 0;
            int numD = 0;
            int numF = 0;
            for (int i = 0; i < FSCstudent.getNumStudents(); i++) {
                switch(finalLetterGrade(students[i].getFinalGrade())){  //Compare this to 
                    case 'A':   //All of these cases and increment accordingly
                        numA++;
                        break;
                    case 'B':
                        numB++;
                        break;
                    case 'C':
                        numC++;
                        break;
                    case 'D':
                        numD++;
                        break;
                    case 'F':
                        numF++;
                        break;
                }  
            }   //End of for loop

            System.out.printf("   Average Score: %.2f\n", 1.0 * sum/FSCstudent.getNumStudents());
            System.out.printf("   Highest Score: %.2f\n", highestScore);
            System.out.printf("   Lowest Score:  %.2f\n", lowestScore);
            System.out.printf("   Total 'A' Grades:   %d (%.2f%% of class)\n", numA, 100.0 * numA/FSCstudent.getNumStudents());
            System.out.printf("   Total 'B' Grades:   %d ( %.2f%% of class)\n", numB, 100.0 * numB/FSCstudent.getNumStudents());
            System.out.printf("   Total 'C' Grades:   %d ( %.2f%% of class)\n", numC, 100.0 * numC/FSCstudent.getNumStudents());
            System.out.printf("   Total 'D' Grades:   %d ( %.2f%% of class)\n", numD, 100.0 * numD/FSCstudent.getNumStudents());
            System.out.printf("   Total 'F' Grades:   %d ( %.2f%% of class)\n", numF, 100.0 * numF/FSCstudent.getNumStudents());  
           
            }  
        
    }   //End of DISPLAYSTATS()
    
    // Parameters:  None
    // Return Type: None
    // Description: Dispalys all of the students currently in the database.
    public static void DISPLAYSTUDENTS(FSCstudent[] students){
        if (FSCstudent.getNumStudents() == 0) {
            System.out.println("Command: DISPLAYSTUDENTS");
            System.out.println("   ERROR: there are no students currently in the system.");
        }
        else{
            System.out.println("Command: DISPLAYSTUDENTS");
            System.out.println("***Class Roster and Grade Sheet***");   
            for (int i = 0; i < FSCstudent.getNumStudents(); i++) {
                System.out.println(students[i]);   //Call the overriden toString() method to print each student
            }            
        }
    }   //End of DISPLAYSTUDENTS()
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the FSC Grade Book.\n"); //Welcome user to program
        String courseNumber = input.nextLine();
        String professorName = input.nextLine();
        int maxStudents = input.nextInt();
        FSCstudent[] students = new FSCstudent[maxStudents];
        OUTER:
        while(true){
            String[] line = input.nextLine().split(" ");
            switch(line[0]){
                case "ADDRECORD":
                    ADDRECORD(students,Integer.parseInt(line[1]), line[2], line[3],Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                    break;
                case "SEARCHBYID":
                    SEARCHBYID(students, Integer.parseInt(line[1]));
                    break;
                case "SEARCHBYNAME":
                    SEARCHBYNAME(students, line[1], line[2]);
                    break;
                case "DISPLAYSTATS":
                    DISPLAYSTATS(students, courseNumber, professorName);
                    break;
                case "DISPLAYSTUDENTS":
                    DISPLAYSTUDENTS(students);
                    break;
                case "QUIT":
                    System.out.println("Thank you for using the FSC Grade Book");
                    System.out.println("Goodbye.");
                    break OUTER;
            }   //End of switch block
        }   //End of while loop   
    }   // End of main()  
}   //End of FSCgradebook()
