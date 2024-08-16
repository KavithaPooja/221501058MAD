package com.example.exe04_test04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText rollnoInput;
    private Button fetchButton;
    private TextView studentInfo;
    private GoogleSheetsClient sheetsClient;
    private final String SPREADSHEET_ID = "1i3tgnRsIt1umf8CCDICdSXNv9UN89gmIO3axePuLDk4"; // Replace with your spreadsheet ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollnoInput = findViewById(R.id.rollno_input);
        fetchButton = findViewById(R.id.fetch_button);
        studentInfo = findViewById(R.id.student_info);

        sheetsClient = new GoogleSheetsClient(this);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchStudentDetails();
            }
        });
    }

    private void fetchStudentDetails() {
        String rollNumber = rollnoInput.getText().toString().trim();
        if (rollNumber.isEmpty()) {
            studentInfo.setText("Please enter a roll number.");
            return;
        }

        new Thread(() -> {
            try {
                List<Student> students = sheetsClient.readStudentsData(SPREADSHEET_ID, "Sheet1!A:N");
                Student foundStudent = null;

                for (Student student : students) {
                    if (student.rollNo.equals(rollNumber)) {
                        foundStudent = student;
                        break;
                    }
                }

                if (foundStudent != null) {
                    StringBuilder result = new StringBuilder();
                    result.append("Roll No: ").append(foundStudent.rollNo).append("\n")
                            .append("Name: ").append(foundStudent.name).append("\n")
                            .append("Address: ").append(foundStudent.address).append("\n")
                            .append("Father's Mobile: ").append(foundStudent.fatherMobileNumber).append("\n")
                            .append("Mother's Mobile: ").append(foundStudent.motherMobileNumber).append("\n")
                            .append("Personal Mobile: ").append(foundStudent.personalMobileNumber).append("\n")
                            .append("Sem 1 GPA: ").append(foundStudent.sem1GPA).append("\n")
                            .append("Sem 2 GPA: ").append(foundStudent.sem2GPA).append("\n")
                            .append("Sem 3 GPA: ").append(foundStudent.sem3GPA).append("\n")
                            .append("Sem 4 GPA: ").append(foundStudent.sem4GPA).append("\n")
                            .append("CGPA: ").append(foundStudent.cgpa).append("\n")
                            .append("Govt or Management: ").append(foundStudent.govtOrManagement).append("\n")
                            .append("Day Scholar or Hosteler: ").append(foundStudent.dayScholarOrHosteler).append("\n")
                            .append("Community: ").append(foundStudent.community).append("\n");

                    runOnUiThread(() -> studentInfo.setText(result.toString()));
                } else {
                    runOnUiThread(() -> studentInfo.setText("No student found with roll number " + rollNumber));
                }

            } catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> studentInfo.setText("Error retrieving data: " + e.getMessage()));
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> studentInfo.setText("An unexpected error occurred: " + e.getMessage()));
            }
        }).start();
    }
}