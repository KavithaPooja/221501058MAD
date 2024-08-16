package com.example.exe04_test04;

import android.content.Context;
import android.util.Log;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoogleSheetsClient {

    private static final String APPLICATION_NAME = "StudentDatabaseApp";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private Sheets sheetsService;

    public GoogleSheetsClient(Context context) {
        try {
            // Load service account credentials from the JSON file
            InputStream serviceAccountStream = context.getResources().openRawResource(R.raw.credentials);
            GoogleCredential credential = GoogleCredential.fromStream(serviceAccountStream)
                    .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));

            // Build the Sheets service
            sheetsService = new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            Log.i("GoogleSheetsClient", "Sheets service initialized successfully");

        } catch (GeneralSecurityException e) {
            Log.e("GoogleSheetsClient", "Security exception: " + e.getMessage());
        } catch (IOException e) {
            Log.e("GoogleSheetsClient", "IO exception: " + e.getMessage());
        } catch (Exception e) {
            Log.e("GoogleSheetsClient", "Error initializing Sheets API: " + e.getMessage());
        }
    }

    public List<Student> readStudentsData(String spreadsheetId, String range) throws IOException {
        ValueRange response = sheetsService.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();

        List<Student> students = new ArrayList<>();
        if (values != null && !values.isEmpty()) {
            for (List<Object> row : values) {
                if (row.size() >= 14) { // Ensure there are enough columns
                    String rollNo = row.get(0).toString();
                    String name = row.get(1).toString();
                    String address = row.get(2).toString();
                    String fatherMobileNumber = row.get(3).toString();
                    String motherMobileNumber = row.get(4).toString();
                    String personalMobileNumber = row.get(5).toString();

                    double sem1GPA = parseDouble(row.get(6));
                    double sem2GPA = parseDouble(row.get(7));
                    double sem3GPA = parseDouble(row.get(8));
                    double sem4GPA = parseDouble(row.get(9));
                    double cgpa = parseDouble(row.get(10));

                    String govtOrManagement = row.get(11).toString();
                    String dayScholarOrHosteler = row.get(12).toString();
                    String community = row.get(13).toString();

                    students.add(new Student(rollNo, name, address, fatherMobileNumber, motherMobileNumber,
                            personalMobileNumber, sem1GPA, sem2GPA, sem3GPA, sem4GPA, cgpa,
                            govtOrManagement, dayScholarOrHosteler, community));
                }
            }
        }
        return students;
    }

    private double parseDouble(Object value) {
        if (value == null || value.toString().trim().isEmpty()) {
            Log.e("GoogleSheetsClient", "Value is null or empty, returning 0.0");
            return 0.0; // Handle null or empty values
        }
        try {
            return Double.parseDouble(value.toString().trim()); // Trim spaces
        } catch (NumberFormatException e) {
            Log.e("GoogleSheetsClient", "Invalid number format for value: " + value);
            return 0.0; // Return a default value or handle it as needed
        }
    }
}