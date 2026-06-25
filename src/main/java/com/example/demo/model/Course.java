package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseName;
    private String instructorName;
    private String instructorInfo;
    private String meetingTime;
    private String roomNumber;
    private String credits;
    private String studentRoster;
    private String studentEmailString;
    private String studentPhoneNumberString;
    private String studentSchedulingInfo;
    private String currentAssignmentName;
    private double studentGradeAverage;

    public Course() {}

    public Course(String code, String name, String instructor, String info, String time, String room, String credits, 
              String roster, String email, String phone, String schedule, String assignment, double avg) {
    this.courseCode = code;
    this.courseName = name;
    this.instructorName = instructor;
    this.instructorInfo = info;
    this.meetingTime = time;
    this.roomNumber = room;
    this.credits = credits;
    this.studentRoster = roster;
    this.studentEmailString = email;
    this.studentPhoneNumberString = phone;
    this.studentSchedulingInfo = schedule;
    this.currentAssignmentName = assignment;
    this.studentGradeAverage = avg;
}
    

    // Getters and Setters
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String code) { this.courseCode = code; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String name) { this.courseName = name; }
    public String getInstructorName() { return instructorName; }
    public void setInstructorName(String name) { this.instructorName = name; }
    public String getInstructorInfo() { return instructorInfo; }
    public void setInstructorInfo(String info) { this.instructorInfo = info; }
    public String getMeetingTime() { return meetingTime; }
    public void setMeetingTime(String time) { this.meetingTime = time; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String room) { this.roomNumber = room; }
    public String getCredits() { return credits; }
    public void setCredits(String credits) { this.credits = credits; }
    public String getStudentRoster() { return studentRoster; }
    public void setStudentRoster(String roster) { this.studentRoster = roster; }
    public String getStudentEmailString() { return studentEmailString; }
    public void setStudentEmailString(String email) { this.studentEmailString = email; }
    public String getStudentPhoneNumberString() { return studentPhoneNumberString; }
    public void setStudentPhoneNumberString(String phone) { this.studentPhoneNumberString = phone; }
    public String getStudentSchedulingInfo() { return studentSchedulingInfo; }
    public void setStudentSchedulingInfo(String info) { this.studentSchedulingInfo = info; }
    public String getCurrentAssignmentName() { return currentAssignmentName; }
    public void setCurrentAssignmentName(String name) { this.currentAssignmentName = name; }
    public double getStudentGradeAverage() { return studentGradeAverage; }
    public void setStudentGradeAverage(double avg) { this.studentGradeAverage = avg; }
}
