package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
    private String studentSchedulingInfo; // Fixed: Declared the missing field!
    private String meetingTime;
    private String roomNumber;

    // 1. Mandatory Default Constructor
    public Course() {
    }

    // 2. Overloaded Constructor
    public Course(String courseName, String courseCode, String instructorName,
                  String instructorInfo, String meetingTime, String roomNumber, int credits,
                  String studentRoster, String studentEmailString, String studentPhoneNumberString, 
                  String studentSchedulingInfo) {
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

    // 3. Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorInfo() {
        return instructorInfo;
    }

    public void setInstructorInfo(String instructorInfo) {
        this.instructorInfo = instructorInfo;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getStudentRoster() {
        return studentRoster;
    }

    public void setStudentRoster(String studentRoster) {
        this.studentRoster = studentRoster;
    }

    public String getStudentEmailString() {
        return studentEmailString;
    }

    public void setStudentEmailString(String studentEmailString) {
        this.studentEmailString = studentEmailString;
    }

    public String getStudentPhoneNumberString() {
        return studentPhoneNumberString;
    }

    public void setStudentPhoneNumberString(String studentPhoneNumberString) {
        this.studentPhoneNumberString = studentPhoneNumberString;
    }

    public String getStudentSchedulingInfo() {
        return studentSchedulingInfo;
    }

    public void setStudentSchedulingInfo(String studentSchedulingInfo) {
        this.studentSchedulingInfo = studentSchedulingInfo;
    }
// 1. Add these new private fields to the top of Course.java
private String currentAssignmentName = "None";
private double studentGradeAverage = 0.0;

// 2. Add these Getters and Setters at the bottom of Course.java
public String getCurrentAssignmentName() {
    return currentAssignmentName;
}

public void setCurrentAssignmentName(String currentAssignmentName) {
    this.currentAssignmentName = currentAssignmentName;
}

public double getStudentGradeAverage() {
    return studentGradeAverage;
}

public void setStudentGradeAverage(double studentGradeAverage) {
    this.studentGradeAverage = studentGradeAverage;
}

// 3. Add a helper method to calculate Letter Grades automatically
public String getLetterGrade() {
    if (this.studentGradeAverage >= 90) return "A";
    if (this.studentGradeAverage >= 80) return "B";
    if (this.studentGradeAverage >= 70) return "C";
    if (this.studentGradeAverage >= 60) return "D";
    return "F";
}



}