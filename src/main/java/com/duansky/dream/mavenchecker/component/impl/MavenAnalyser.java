package com.duansky.dream.mavenchecker.component.impl;

import com.duansky.dream.mavenchecker.Contracts;
import com.duansky.dream.mavenchecker.bean.Coordinate;
import com.duansky.dream.mavenchecker.component.Analyser;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DuanSky on 2016/10/26.
 */
public class MavenAnalyser implements Analyser {

    public Coordinate analysis(String jarPath) {

        Coordinate coordinate = new Coordinate();
        coordinate.setPath(jarPath);

        //remove the base path from the jar path.
        jarPath = jarPath.substring(
                jarPath.indexOf(Contracts.REPO) + Contracts.REPO.length() + File.separator.length(),
                jarPath.length());


        String[] parts = split(jarPath);
        int length = parts.length;

        //the last element is the version.
        String version = parts[length - 1];

        //the last but one is the artifactId
        String artifactId = parts[length - 2];

        //the last but two until to the base path is the groupId
        StringBuilder groupId = new StringBuilder();
        for(int i = 0; i < length - 2; i++)
            groupId.append(parts[i]+".");
        groupId.deleteCharAt(groupId.length()-1);


        coordinate.setGroupId(groupId.toString());
        coordinate.setArtifactId(artifactId);
        coordinate.setVersion(version);

        return coordinate;
    }

    /**
     * TODO the String.split("/") is wrong! So we should split it by ourselves.
     * @param path
     * @return
     */
    private String[] split(String path){
        if(!path.endsWith(File.separator)) path += File.separator;
        List<String> list = new LinkedList<>();
        int currentIndex;
        for(int lastIndex = 0; lastIndex < path.length();){
            //find the next file separator from the current index
            currentIndex = path.indexOf(File.separator,lastIndex);
            String part = path.substring(lastIndex,currentIndex);
            if(part != null && part.length() != 0)
                list.add(part);
            lastIndex = currentIndex + File.separator.length();
        }
        return list.toArray(new String[list.size()]);
    }

//    public static void main(String args[]){
//        MavenAnalyser a = new MavenAnalyser();
//        String s = "a\\b\\c";
//        String[] t = a.split(s);
//        System.out.println(t);
//    }

}
