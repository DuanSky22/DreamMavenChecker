package com.duansky.dream.mavenchecker.component.impl;

import com.duansky.dream.mavenchecker.component.Parser;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DuanSky on 2016/10/26.
 */
public class MavenParser implements Parser {

    public List<String> parse(String path) {
        List<String> res = new LinkedList<String>();
        parse0(new File(path),res);
        return res;
    }

    private void parse0(File file,List<String> res){
        if(!file.exists() || file.isFile()) return;
        if(isJarPath(file)) res.add(file.getPath());
        for(File name : file.listFiles())
            parse0(name,res);
    }

    /**
     * TODO is this function correct?
     *the given file is a jar path file? a jar path file is a directory that holds jar file directly.
     * @param file
     * @return true if the file is a jar path file,otherwise false.
     */
    private boolean isJarPath(File file){
        if(file.exists() && file.isDirectory()){
            for(File child : file.listFiles()){
                if(child.isDirectory())
                    return false;
            }
            return true;
        }
        return false;
    }
}
