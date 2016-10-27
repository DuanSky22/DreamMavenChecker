package com.duansky.dream.mavenchecker.component;

/**
 * Created by DuanSky on 2016/10/26.
 */
public interface Verifier {

    /**
     * verify if this jar need to re download. As we know, many maven jars
     * will not be downloaded correctly. SO if the jar of the given jar path
     * is broken, we need to re-download this jar.
     * @param jarPath the jar path.
     * @return true if the jar of the given jar path is brokern.
     */
    boolean verify(String jarPath);
}
