package com.duansky.dream.mavenchecker.component.impl;

import com.duansky.dream.mavenchecker.Contracts;
import com.duansky.dream.mavenchecker.bean.Coordinate;
import com.duansky.dream.mavenchecker.component.Storer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by DuanSky on 2016/10/27.
 */
public class CoordinateStore implements Storer{

    private String defaultPath = Coordinate.class.getClassLoader().getResource("")
            + Contracts.DEFAULT_STORE_FILE;


    public void store(String path,Coordinate... coordinates){
        //if it contains ".", which means the user given a file path not a directory.
        if(!path.contains(".")){
           path += (path.endsWith(File.separator) ?
                   Contracts.DEFAULT_STORE_FILE :
                   (File.separator + Contracts.DEFAULT_STORE_FILE));
        }
        //create file.
        File file = new File(path);
        if(!file.exists()){//if it doesn't exists, we will crate a new file.
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(String.format("Create file for %s failed! we will store in %s", path,defaultPath));
                file = new File(defaultPath);
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        System.out.println(String.format("Create file both on %s and %s failed! The store failed！", path,defaultPath));
                        return;
                    }
                }
            }
        }
        //write coordinate
        try {
            PrintWriter writer = new PrintWriter(file);
            for(Coordinate coordinate : coordinates){
                writer.write(coordinate.toString());
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
