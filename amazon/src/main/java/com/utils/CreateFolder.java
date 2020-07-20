package com.utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CreateFolder
{
    public static String createFolder(String str_Path, String str_FolderName) {
        String strFolderPath = str_Path + "/" + str_FolderName;
        File file = new File(strFolderPath);
        if (!file.exists())
        {
            if (file.mkdir())
            {
                System.out.println("Directory is created! \n");
            }else
            {
                System.out.println("Failed to create directory! \n");
            }
        }else
        {
            System.out.println("Test Results Folder Already exists for the Current Date \n");
        }
        return strFolderPath;
    }

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // Convert timestamp to instant
//
        Instant instant = timestamp.toInstant();
        // System.out.println(instant);

        // Convert instant to timestamp
        Timestamp tsFromInstant = Timestamp.from(instant);
        return String.valueOf(tsFromInstant.getTime());
    }
}