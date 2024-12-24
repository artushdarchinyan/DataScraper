package com.ds_intelligence_arm.for_tasks; 

import com.ds_intelligence_arm.storage.model.list_am_DataRecord;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataRecordCheck {

    public static List<list_am_DataRecord> readDataRecordsFromJson(String filePath) {
        List<list_am_DataRecord> dataRecords = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Define the type for a List of list_am_DataRecord
            Type listType = new TypeToken<List<list_am_DataRecord>>() {}.getType();

            // Deserialize JSON to List<list_am_DataRecord>
            dataRecords = gson.fromJson(reader, listType);

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }

        return dataRecords;
    }

    public static void main(String[] args) {
        // Path to the JSON file
        String filePath = "src/resources/list_am.json";

        // Read the data records from the JSON file
        List<list_am_DataRecord> records = readDataRecordsFromJson(filePath);
        list_am_DataRecord[] records_array= records.toArray(new list_am_DataRecord[0]);

        // Print each record
        for (list_am_DataRecord record : records) {
            System.out.println("URL: " + record.getUrl());
            System.out.println("Title: " + record.getTitle());
            System.out.println("Description: " + record.getDescription());
            System.out.println("Price in USD: " + record.getPriceInUSD());
            System.out.println("Price in AMD: " + record.getPriceInAMD());
            System.out.println("-----");
        }
    }
}
