package com.duansky.dream.mavenchecker.component;

import java.util.List;

/**
 * Created by DuanSky on 2016/10/26.
 */
public interface Parser {
    /**
     * Given a path, parse its all jar paths.
     * @param path may contains many modules(or jars).
     * @return all jar path that this path contains.
     */
    List<String> parse(String path);
}
