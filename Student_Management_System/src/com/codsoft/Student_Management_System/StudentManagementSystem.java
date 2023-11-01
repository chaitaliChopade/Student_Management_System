package com.codsoft.Student_Management_System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
	private List<Student> students=new ArrayList();

	public void addStudent(Student student) {
		students.add(student);
	}
	public void removeStudnt(String rollNo) {
	   students.removeIf(student->student.getRollNo().equals(rollNo));
	}
	//return null;

	public Student searchStudent(String rollNo) {
	for(Student student :students) {
		if(student.getRollNo().equals(rollNo)) {
			return student;
		}
	}
	return null;
	}

	public void displayAllStudent() {
	for(Student student :students) {
		System.out.println(student);
	}
	}

	public void saveStudentsFile(String filename) {
	try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
		for(Student student: students) {
			writer.println(student.getName()+" ," + student.getRollNo() +" ,"+ student.getGrade());
		}
	}catch(IOException e) {
		System.out.println("Error saving students to file :" +e.getMessage());
	}
	}
	public void loadStudentsFromFile(String filename) throws IOException {
	try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
		String line;
		while((line=reader.readLine())!=null) {
			String [] parts=line.split(" ,");
			if(parts.length==3) {
				String name=parts[0];
				String rollNo=parts[1];
				String grade=parts[2];
				Student student=new Student(name, rollNo, grade);
				students.add(student);
			}
		}
	}

	}
}
