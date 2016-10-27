package com.duansky.dream.mavenchecker.manager;

import com.duansky.dream.mavenchecker.bean.Coordinate;
import com.duansky.dream.mavenchecker.component.Analyser;
import com.duansky.dream.mavenchecker.component.Parser;
import com.duansky.dream.mavenchecker.component.Storer;
import com.duansky.dream.mavenchecker.component.Verifier;
import com.duansky.dream.mavenchecker.component.impl.CoordinateStore;
import com.duansky.dream.mavenchecker.component.impl.MavenAnalyser;
import com.duansky.dream.mavenchecker.component.impl.MavenParser;
import com.duansky.dream.mavenchecker.component.impl.MavenVerifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DuanSky on 2016/10/26.
 */
public class Pipeline {

    /**
     * the paths holds all the paths that this pipeline will parse,verify and analysis.
     */
    private List<String> paths;

    private String storePath;

    private Parser parser = new MavenParser();

    private Verifier verifier = new MavenVerifier();

    private Analyser analyser = new MavenAnalyser();

    private Storer storer = new CoordinateStore();

    public Pipeline(String storePath,String ... path){
        this(storePath,Arrays.asList(path));
    }

    public Pipeline(String storePath,List<String> paths){
        this.storePath = storePath;
        this.paths = paths;
    }

    public void go(){
        List<Coordinate> t = getCoordinates();
        Coordinate[] coordinates = new Coordinate[t.size()];
        t.toArray(coordinates);
        storer.store(storePath,coordinates);
    }

    private List<Coordinate> getCoordinates(){
        List<Coordinate> coordinates = new LinkedList<Coordinate>();
        for(String path : paths){
            //get the jar paths of the given path.
            List<String> jarPaths = parser.parse(path);
            for(String jarPath : jarPaths){
                //verify this jar path is broken.
                if(verifier.verify(jarPath)){
                    //if this jar path is broken, we need analysis its coordinate.
                    Coordinate coordinate = analyser.analysis(jarPath);
                    coordinates.add(coordinate);
                }
            }
        }
        return coordinates;
    }
}
