package com.epam.mjc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String fileName=file.getAbsolutePath();
        Profile profile=new Profile();
        ArrayList<String> list=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new java.io.FileReader(fileName))){
            String l;
            while ((l=reader.readLine())!=null){
                list.add(l.substring(l.lastIndexOf(" ")+1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        profile.setName(list.get(0));
        profile.setAge(Integer.valueOf(list.get(1)));
        profile.setEmail(list.get(2));
        profile.setPhone(Long.valueOf(list.get(3)));

        return profile;
    }
}
