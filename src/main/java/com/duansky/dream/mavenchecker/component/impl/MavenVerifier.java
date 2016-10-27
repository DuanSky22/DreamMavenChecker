package com.duansky.dream.mavenchecker.component.impl;

import com.duansky.dream.mavenchecker.Contracts;
import com.duansky.dream.mavenchecker.component.Verifier;

import java.io.File;

/**
 * Created by DuanSky on 2016/10/26.
 */
public class MavenVerifier implements Verifier {

    /**
     * In general, a jar is broken may contains two features.
     * 1. Its contains _remote.repositories file;
     * 2. It doesn't contain any jar files.
     * @param jarPath the jar path.
     * @return whether this jar is broken.
     */
    public boolean verify(String jarPath) {
        File file = new File(jarPath);
        if(file.exists() || file.isDirectory()){
            boolean existsJar = false;
            for(String name : file.list()) {
                if(name.contains(Contracts.BROKEN))
                    return true;
                if(name.contains(".jar"))
                    existsJar = true;
            }
            if(existsJar == false) return true;
        }
        return false;
    }
}
