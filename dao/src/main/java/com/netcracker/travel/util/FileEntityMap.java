package com.netcracker.travel.util;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileEntityMap<T> {

    private static String filePath = "dao\\src\\main\\resources\\storage\\";
    private static String txt = ".txt";

    public void writeEntity(T t, String name) {

        String entityFilePath = filePath + name + txt;
        Gson gson = new Gson();

        try {
            FileWriter fw = new FileWriter(entityFilePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String json = gson.toJson(t);
            bw.write(json);
            bw.newLine();
            bw.close();

            System.out.println("done writing to file " + entityFilePath);

        }
        catch(FileNotFoundException fnf)
        {
            System.out.println(fnf + "File not found ");
        }
        catch(IOException ioe)
        {
            System.out.println("Error while writing to file: " + ioe);
        }
    }


   /* public HashMap<String, String> readEntity(String name) {
        String entityFilePath = filePath + name + txt;
         Map<String, String> entityList = new HashMap<>();
       try {

            System.out.println("read file: " + entityFilePath);

            FileInputStream fis = new FileInputStream(entityFilePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            InputStreamReader isr = new InputStreamReader(bis);
            Scanner scanner = new Scanner(isr);

            String json = "";

            while (scanner.hasNextLine()){
                json = scanner.nextLine();
                JSONObject jsonObject = new JSONObject(json);

                entityList.put(map);


            System.out.println("file read ok! Has " + entityList.size() + " entities");

            scanner.close();

        }
        catch (FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
        } catch(IOException ioe){
            System.out.println("Error while reading to file: " + ioe);
        }

        return entityList;
    }*/

}
