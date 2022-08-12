package Util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.*;


class Teacher implements CSVPrintable{
    String Name;
    int teacherID;
    int phone;


    public Teacher() {
    }

    public Teacher(String name, int teacherID, int phone) {

        this.Name = name;
        this.teacherID = teacherID;
        this.phone = phone;
    }



    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getID() {
        return teacherID;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        if(getPhone() < 1000 && getPhone()>100) {
            out.println(getName() + ", " + getID() + ", " + "0" + getPhone());

            out.flush();
        }else if(getPhone()<100 && getPhone()>10){
            out.println(getName() + ", " + getID() + ", " + "0" + "0" + getPhone());

            out.flush();
        }
        else if(getPhone()<100){
            out.println(getName() + ", " + getID() + ", " + "0" + "0" + "0" + getPhone());

            out.flush();
        }
        else{
            out.println(getName() + ", " + getID() + ", " + getPhone());

            out.flush();
        }
    }

    @Override
    public String toString() {
        if(getPhone()<1000 && getPhone()>100) {
            return "*Teacher*" + " " + "Name:" + " " + getName() + " " + "TeacherID:" + " " + getID() + " " + "Phone:" + " " + "0" + getPhone();
        }
        else if(getPhone()<100 && getPhone()>10){
            return "*Teacher*" + " " + "Name:" + " " + getName() + " " + "TeacherID:" + " " + getID() + " " + "Phone:" + " " + "0" + "0" + getPhone();
        }else if(getPhone()<100){
            return "*Teacher*" + " " + "Name:" + " " + getName() + " " + "TeacherID:" + " " + getID() + " " + "Phone:" + " " + "0" + "0" + "0" + getPhone();
        }

        return "*Teacher*" + " " + "Name:" + " " + getName() + " " + "TeacherID:" + " " + getID() + " " + "Phone:" + " " + getPhone();
        }


}



class Student implements CSVPrintable{
    String Name;
    int studentID;
    long PHONE;

    public Student(String name, int studentID, long PHONE) {
        this.Name = name;
        this.studentID = studentID;
        this.PHONE = PHONE;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getID() {
        return studentID;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + ", " + getID() + ", " + getPHONE());

        out.flush();
    }

    public long getPHONE() {
        return PHONE;
    }

    @Override
    public String toString() {
        return "*Student*" + " " + "Name:" + " " + getName() + "" + "StudentID:" + " " + getID() + " " + "Phone:" + " " + getPHONE();
    }
}

class TA extends Student{
    long NewPhone;
    int taID;

    public TA(String name, int studentID, long PHONE) {
        super(name, studentID, PHONE);
        NewPhone = PHONE;

    }


    @Override
    public int getID() {


        return taID;

    }

    @Override
    public long getPHONE() {
        return NewPhone;
    }

    public void setTaID(int taID) {
        this.taID = taID;
    }

    @Override
    public String toString() {
        return "*TA*" + " " + "Name:" + " " + getName() + " " + "MaxID:" + " " + getID() +  " " + "Phone:" + " " + getPHONE();
    }


}




class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Object> arrayListAdd = new ArrayList<>();
        Scanner keyBoard = new Scanner(System.in);
        String [] schoolInfo;

        int counter = 0;

        String position;
        String name;
        String studentID;
        String teacherID;
        int phone;

        System.out.println("");
        System.out.println("Welcome to the school interface");
        System.out.println("Please enter: *an integer of inputs*");
        String userInput = keyBoard.nextLine();






        if (userInput.matches("[^a-zA-Z-]+$")) {
            PrintWriter writer = new PrintWriter("out.csv");
            int tester = Integer.parseInt(userInput);
            for(int u = 0; u<tester ;u++) {
                System.out.println("=================================");
                System.out.println("Enter 'Quit' to end cycle");
                System.out.println("=================================");
                System.out.println("");
                System.out.println("Input information in the order below with a 'space' (for Student 0 for Teacher ID, for Teacher 0 Student ID and TA has both)");
                System.out.println("FORMAT = " + " " + "Position:(Teacher, Student or TA) " + "\t" + "Name(First name','Last name): " + "\t" + "Student ID(5 digits): " + "\t" + "Teacher ID(5 digits): " + "\t" + "Phone #(10 digit): ");

                String school = keyBoard.nextLine();
                schoolInfo = school.split(" ");

                if(school.equalsIgnoreCase("Quit")){
                    System.out.println("Thank you, goodbye");
                    break;
                }


                if (schoolInfo.length == 5 //Teacher!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        && schoolInfo[0].equalsIgnoreCase("Teacher")
                        && schoolInfo[1].matches("[^0-9]+$")
                        && schoolInfo[2].equalsIgnoreCase("0")
                        && schoolInfo[3].matches("^[0-9]{5}$")
                        && schoolInfo[4].matches("^[0-9]{10}$")) {//Teacher!!!!!!!!!!!!!!!!

                    int k = 0;
                    int d = 0;
                    for (int i = 0; i < schoolInfo[1].length(); i++) {

                        if (schoolInfo[1].charAt(i) == ',') {
                            k++;

                        }

                    }

                    //comma counter
                    if (k > 1) {
                        System.out.println("Error:Too many commas!!!!!!");
                        continue;

                    }
                    if (k == 0) {
                        System.out.println("Error:Name needs a comma!!!!!");
                        continue;
                    }

                    //print something for teacher
                    counter++;

                    position = schoolInfo[0];
                    name = schoolInfo[1];
                    studentID = schoolInfo[2];
                    teacherID = schoolInfo[3];

                    String char1 = String.valueOf(schoolInfo[4].charAt(6));
                    String char2 = String.valueOf(schoolInfo[4].charAt(7));
                    String char3 = String.valueOf(schoolInfo[4].charAt(8));
                    String char4 = String.valueOf(schoolInfo[4].charAt(9));
                    String charComplete = char1 + char2 + char3 + char4;

                    phone = Integer.parseInt(charComplete);


                    String newName = name.replace(',', ' ');
                    System.out.println(newName);
                    System.out.println("Teacher!!!!!!!!!!!!!!!!");
                    Teacher teachers = new Teacher(newName, Integer.parseInt(teacherID), (phone));


                    arrayListAdd.add(teachers);
                    teachers.csvPrintln(writer);


                } else if (schoolInfo.length == 5 //Student!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                        && (schoolInfo[0].equalsIgnoreCase("Student"))
                        && schoolInfo[1].matches("[^0-9]+$")
                        && schoolInfo[2].matches("^[0-9]{5}$")
                        && schoolInfo[3].equalsIgnoreCase("0")
                        && schoolInfo[4].matches("^[0-9]{10}$")) {//Student!!!!!!!!!!!!!!

                    int k = 0;
                    for (int i = 0; i < schoolInfo[1].length(); i++) {

                        if (schoolInfo[1].charAt(i) == ',') {
                            k++;
                        }
                    }

                    //comma counter
                    if (k > 1) {
                        System.out.println("Error:Too many commas!!!!!!");
                        continue;
                    }
                    if (k == 0) {
                        System.out.println("Error:Name needs a comma!!!!!");
                        continue;
                    }
                    counter++;
                    System.out.println("Student!!!!!!!!!!!!!!!!!!!!!");


                    position = schoolInfo[0];
                    name = schoolInfo[1];
                    studentID = schoolInfo[2];
                    teacherID = schoolInfo[3];
                    String phoneStudent = schoolInfo[4];

                    String char1 = String.valueOf(schoolInfo[4].charAt(0));
                    String char2 = String.valueOf(schoolInfo[4].charAt(1));
                    String char3 = String.valueOf(schoolInfo[4].charAt(2));
                    String char4 = String.valueOf(schoolInfo[4].charAt(3));
                    String char5 = String.valueOf(schoolInfo[4].charAt(4));
                    String char6 = String.valueOf(schoolInfo[4].charAt(5));
                    String char7 = String.valueOf(schoolInfo[4].charAt(6));
                    String char8 = String.valueOf(schoolInfo[4].charAt(7));
                    String char9 = String.valueOf(schoolInfo[4].charAt(8));
                    String char10 = String.valueOf(schoolInfo[4].charAt(9));
                    String charComplete = char1 + char2 + char3 + char4 + char5 + char6 + char7 + char8 + char9 + char10;


                    String newName = name.replace(',', ' ');
                    System.out.println(newName);
                    Student students = new Student(newName, Integer.parseInt(studentID), Long.parseLong(charComplete));

                    arrayListAdd.add(students);
                    students.csvPrintln(writer);


                } else if (schoolInfo.length == 5 ////TA!!!!!!!!!!!!!!!!!!!!
                        && schoolInfo[0].equalsIgnoreCase("TA")
                        && schoolInfo[1].matches("[^0-9]+$")
                        && !schoolInfo[2].equalsIgnoreCase("0")
                        && schoolInfo[2].matches("^[0-9]{5}$")
                        && !schoolInfo[3].equalsIgnoreCase("0")
                        && schoolInfo[3].matches("^[0-9]{5}$")
                        && schoolInfo[4].matches("^[0-9]{10}$")) {//TA!!!!!!!!!!!!!!!!!!!!

                    int k = 0;
                    for (int i = 0; i < schoolInfo[1].length(); i++) {

                        if (schoolInfo[1].charAt(i) == ',') {
                            k++;
                        }
                    }
                    //comma counter
                    if (k > 1) {
                        System.out.println("Error:Too many commas!!!!!!");
                        continue;
                    }
                    if (k == 0) {
                        System.out.println("Error:Name needs a comma!!!!!");
                        continue;
                    }
                    counter++;
                    System.out.println("TA!!!!!!!!!!");


                    position = schoolInfo[0];
                    name = schoolInfo[1];
                    studentID = schoolInfo[2];
                    teacherID = schoolInfo[3];
                    String phoneStudent = schoolInfo[4];

                    String char1 = String.valueOf(schoolInfo[4].charAt(0));
                    String char2 = String.valueOf(schoolInfo[4].charAt(1));
                    String char3 = String.valueOf(schoolInfo[4].charAt(2));
                    String char4 = String.valueOf(schoolInfo[4].charAt(3));
                    String char5 = String.valueOf(schoolInfo[4].charAt(4));
                    String char6 = String.valueOf(schoolInfo[4].charAt(5));
                    String char7 = String.valueOf(schoolInfo[4].charAt(6));
                    String char8 = String.valueOf(schoolInfo[4].charAt(7));
                    String char9 = String.valueOf(schoolInfo[4].charAt(8));
                    String char10 = String.valueOf(schoolInfo[4].charAt(9));
                    String charComplete = char1 + char2 + char3 + char4 + char5 + char6 + char7 + char8 + char9 + char10;

                    String newName = name.replace(',', ' ');
                    System.out.println(newName);

                    TA assistant = new TA(newName, Integer.parseInt(studentID), Long.parseLong(charComplete));

                    int SID = Integer.parseInt(studentID);
                    int TID = Integer.parseInt(teacherID);
                    if (TID > SID) {
                        assistant.setTaID(Integer.parseInt(teacherID));
                    } else {
                        assistant.setTaID(Integer.parseInt(studentID));
                    }


                    arrayListAdd.add(assistant);
                    assistant.csvPrintln(writer);


                } else {
                    System.out.println("");
                    System.out.println("Incorrect command: please input correct info");
                    System.out.println("");
                }
                if (counter > 0){
                System.out.println("====================================");
                System.out.println("The input info");
                System.out.println("====================================");
            }
                            for (int i = 0; i < arrayListAdd.size(); i++) {
                                System.out.println(arrayListAdd.get(i));


                                }
                            System.out.println("");
                        }//for loop
        }else{
            System.out.println("error!!!!!!!! *Goodbye*");
        }



        System.out.println("Number of entries:" + counter);
    }//end of main


}//end Class
