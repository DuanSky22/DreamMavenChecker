package com.duansky.dream.mavenchecker.component;

import com.duansky.dream.mavenchecker.bean.Coordinate;

/**
 * Created by DuanSky on 2016/10/27.
 */
public interface Storer {
    void store(String path,Coordinate... coordinates);
}
