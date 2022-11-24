# Gradebook
This is a gradebook simulator. I worked on this during my data structures class as a review of OOP concepts. 

This project utilizes 2 classes: One hosts the main method and all of the supplemenetal methods to make the program function. The other is the actual student object. 
The student class is comprised of:
 - An integer named ID
 - A string for first name and a string for last name
 - An integer array for their exam grades
 - A double for their final grade
 - A character for their letter grade
 - A static integer for the number of students in the database 
 
 TO USE THE SIMULATOR: 
 1. The first input is a course number. I.E. "CSC2290"
 2. The next input is the professor's name. I.E. "Johnathan Cazalas"
 3. The next input is the max number of students in the database. I.E. "8"
 The next possible commands are:
  - ADDRECORD: Takes in an int for their ID, 2 strings for first and last name, and 3 grades for the course
        ADDRECORD 1234567 BOB BUILDER 85 67 100
  - SEARCHBYID: Takes in an int for ID
        SEARCHBYID 1234567
  - SEARCHBYNAME: Takes in 2 strings for first and last name
        SEARCHBYNAME BOB BUILDER
  - DISPLAYSTATS: Takes in 2 strings for course number and professor's name 
        DISPLAYSTATS CSC2290 JOHNATHAN CAZALAS
  - DISPLAYSTUDENTS: Requires no other input.
        DISPLAYSTUDENTS
  - QUIT: Requiers no other input.
        QUIT
  
  
 


