package com.netcracker.travel.dao;

import com.netcracker.travel.dao.interfaces.AbstractDao;

import java.io.*;
import java.util.Map;

public class FileEntityMap {

    public static void writeEntityMap(String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(path))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(AbstractDao.entityMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readEntityMap(String path) {
        Map tempMemoryMap = null;
        System.out.println("Path: " + path + "\n");
        try (FileInputStream inputStream = new FileInputStream(new File(path))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            tempMemoryMap = (Map) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        AbstractDao.entityMap.putAll(tempMemoryMap);
    }
}
