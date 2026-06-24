package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity 
public class Course {

    @Id 
    private String courseCode;
    private String courseName;
    private String instructorName;
    private String instructorInfo;
    private int credits;
    private String studentRoster;
    private String studentEmailString;
    private String studentPhoneNumberString;
    private String studentSchedulingInfo;
    private String meetingTime;
    private String roomNumber;
    private String currentAssignmentName = "None";
    private double studentGradeAverage = 88.5;

    public Course() {}

    public Course(String courseName, String courseCode, String instructorName, String instructorInfo, String meetingTime, String roomNumber, int credits, String studentRoster, String studentEmailString, String studentPhoneNumberString, String studentSchedulingInfo){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructorName = instructorName;
        this.instructorInfo = instructorInfo;
        this.meetingTime = meetingTime;
        this.roomNumber = roomNumber;
        this.credits = credits;
        this.studentRoster = studentRoster;
        this.studentEmailString = studentEmailString;
        this.studentPhoneNumberString = studentPhoneNumberString;
        this.studentSchedulingInfo = studentSchedulingInfo;     
    }

    public static List<Course> getStudentCourses() {
        List<Course> list = new ArrayList<>();
        Course c1 = new Course("Advanced Java Web Development", "CS-302", "Dr. Smith", "Faculty Info", "MWF 10AM", "Room 404", 4, "Katie", "katie@univ.edu", "555-0123", "Full-time");
        c1.setStudentGradeAverage(94.5);
        list.add(c1);
        return list;
    }

    public static List<Course> getInstructorCourses() {
        List<Course> list = new ArrayList<>();
        Course c1 = new Course("Advanced Java Web Development", "CS-302", "Dr. Smith", "Faculty Info", "MWF 10AM", "Room 404", 4, "Katie Carlson", "katie@univ.edu", "555-0123", "Full-time");
        list.add(c1);
        return list;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String instructorName) { this.instructorName = instructorName; }
    public String getInstructorInfo() { return instructorInfo; }
    public void setInstructorInfo(String instructorInfo) { this.instructorInfo = instructorInfo; }
    public String getMeetingTime() { return meetingTime; }
    public void setMeetingTime(String meetingTime) { this.meetingTime = meetingTime; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getStudentRoster() { return studentRoster; }
    public void setStudentRoster(String studentRoster) { this.studentRoster = studentRoster; }
    public String getStudentEmailString() { return studentEmailString; }
    public void setStudentEmailString(String studentEmailString) { this.studentEmailString = studentEmailString; }
    public String getStudentPhoneNumberString() { return studentPhoneNumberString; }
    public void setStudentPhoneNumberString(String studentPhoneNumberString) { this.studentPhoneNumberString = studentPhoneNumberString; }
    public String getStudentSchedulingInfo() { return studentSchedulingInfo; }
    public void setStudentSchedulingInfo(String studentSchedulingInfo) { this.studentSchedulingInfo = studentSchedulingInfo; }
    public String getCurrentAssignmentName() { return currentAssignmentName; }
    public void setCurrentAssignmentName(String currentAssignmentName) { this.currentAssignmentName = currentAssignmentName; }
    public double getStudentGradeAverage() { return studentGradeAverage; }
    public void setStudentGradeAverage(double studentGradeAverage) { this.studentGradeAverage = studentGradeAverage; }
}