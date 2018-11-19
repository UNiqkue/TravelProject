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














   /* public void writeEntity(User user) {
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonSlave = new JSONObject();
            try {
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                List<String> idList = new ArrayList<>();
                // if(jsonObject.length() == 0){
                // idList.add(user.getId().toString());
                jsonSlave.put("id", idList);

                if(user.getFirstName()!=null) {
                jsonObject.put("firstName", user.getFirstName());
                } else {
                jsonObject.put("firstName", "null");
                }
                jsonObject.put("lastName", user.getLastName());
                jsonObject.put("username", user.getUsername());
                jsonObject.put("password", user.getPassword());
                jsonObject.put("email", user.getEmail());
                jsonObject.put("activationCode", user.getActivationCode());
                jsonObject.put("role", user.getRole());
                bw.write(jsonObject.toString());
                bw.newLine();
                bw.close();

            System.out.println("done writing to file " + filePath);

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
/ /
    public String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
        }

        public List<User> readEntity() {
            List<User> entityList = new ArrayList<>();
            User user = new User();
            try {
                System.out.println("read file: " + filePath);
            JSONObject jsonObject = new JSONObject(readFile(filePath, Charset.defaultCharset()));
            JSONArray jsonArrayId = jsonObject.getJSONArray("id");
            JSONArray jsonArrayFirstName = jsonObject.getJSONArray("firstName");
            JSONArray jsonArrayLastName = jsonObject.getJSONArray("lastName");
            JSONArray jsonArrayUsername = jsonObject.getJSONArray("username");
            JSONArray jsonArrayPassword = jsonObject.getJSONArray("password");
            JSONArray jsonArrayEmail = jsonObject.getJSONArray("email");
            JSONArray jsonArrayActivationCode = jsonObject.getJSONArray("activationCode");

            for (int i = 0; i < jsonArrayId.length(); i++){
            user.setId(UUID.fromString(jsonArrayId.getJSONObject(i).getString("id")));
            user.setFirstName(jsonArrayFirstName.getJSONObject(i).getString("firstName"));
            user.setLastName(jsonArrayLastName.getJSONObject(i).getString("lastName"));
            user.setUsername(jsonArrayUsername.getJSONObject(i).getString("username"));
            user.setPassword(jsonArrayPassword.getJSONObject(i).getString("password"));
            user.setEmail(jsonArrayEmail.getJSONObject(i).getString("email"));
            user.setActivationCode(jsonArrayActivationCode.getJSONObject(i).getString("activationCode"));

            entityList.add(user);
            System.out.println("User " + i + " info: " + user.toString());
            }
            */

            /* user.setId(UUID.fromString(jsonObject.get("id").toString()));
            user.setFirstName((String) jsonObject.get("firstName"));
            user.setLastName((String) jsonObject.get("lastName"));
            user.setUsername((String) jsonObject.get("username"));
            user.setPassword((String) jsonObject.get("password"));
            user.setEmail((String) jsonObject.get("email"));
            user.setActivationCode((String) jsonObject.get("activationCode"));*/

            /* System.out.println("file read ok! Has " + entityList.size() + " entities");
            } catch(FileNotFoundException fnf){
            System.out.println(fnf + "Unable to open file ");
            } catch(IOException e){
            System.out.println("Error while reading to file: " + e);
            }
            return entityList;
            } */

}
