package com.generalmotors.artists.network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class FileUtil {

    private FileUtil() {
        throw new IllegalStateException("Utility class");
    }

   /* Get the file path using class loader return the file path
    * transforms the name into a file name and then reads a
    * "class file" of that name from a file system.*/
    public static File getFile(String path) {
        ClassLoader loader = com.bcbsa.fepblue.util.FileUtil.class.getClassLoader();
        if (loader != null) {
            URL url = loader.getResource(path);
            return new File(url.getPath());
        }
        return null;
    }
    /* gets the filepath for the json and Reads from JSON file */
    public static String getJson(String path) throws IOException {
        File jsonFile = getFile(path);
        InputStream is = new FileInputStream(jsonFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        }
        finally {
            bufferedReader.close();
        }
        return sb.toString();
    }
}
