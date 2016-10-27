package com.duansky.dream.mavenchecker.component;

import com.duansky.dream.mavenchecker.bean.Coordinate;

/**
 * Created by DuanSky on 2016/10/26.
 */
public interface Analyser {
    /**
     * analysis the {@link Coordinate} of the given jar path.
     * @param jarPath the jar path.
     * @return the coordinate of the jar of the given jar path.
     */
    Coordinate analysis(String jarPath);
}
