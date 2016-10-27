package com.duansky.dream.mavenchecker.bean;

/**
 * Created by DuanSky on 2016/10/26.
 */
public class Coordinate {
    /**
     * path is the absolute path of this jar.
     */
    String path;

    String groupId;
    String artifactId;
    String version;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * <!--  -->
     * <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.8.2</version>
        </dependency>
     * @return
     */
    @Override
    public String toString(){
        return String.format("<!-- %s -->\n" +
                "<dependency>\n" +
                "      <groupId>%s</groupId>\n" +
                "      <artifactId>%s</artifactId>\n" +
                "      <version>%s</version>\n" +
                "</dependency>\n",path,groupId,artifactId,version);
    }
}
