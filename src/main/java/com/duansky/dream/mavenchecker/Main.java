package com.duansky.dream.mavenchecker;

import com.duansky.dream.mavenchecker.manager.Pipeline;

import java.io.File;

/**
 * Created by DuanSky on 2016/10/26.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        if(args == null || args.length == 0)
            throw new IllegalArgumentException("Please enter the maven path as an argument.");
        String basePath = args[0];
        String storePath = args[1];

//        String basePath = "C:\\Users\\DuanSky\\.m2\\repository";
//        String storePath = "C:\\Users\\DuanSky\\Desktop\\";

        basePath = init(basePath);

        Pipeline pipeline = new Pipeline(storePath,basePath);
        pipeline.go();
    }

    /**
     * modify the base path that the user given to the form of
     * /user/.m2/repository/
     * @param basePath the given base path.
     * @return the standard base path like XXX/user/.m2/repository/
     */
    private static String init(String basePath) {
        //check if it ends with file separator.
        if(!basePath.endsWith(File.separator)) basePath += File.separator;

        //check if it contains repo folder.
        if(!basePath.contains(Contracts.REPO))
            basePath += (Contracts.REPO + File.separator);

        return basePath;
    }
}
