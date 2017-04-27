package com.mit.lab.norm;

/**
 * <p>Project    : Blueprint</p>
 * <p>Description: Track</p>
 * <p>Summary    : ${SUMMARY}</p>
 * <p>Copyright  : Copyright (c) 2014</p>
 * <p>Company    : MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 5/9/2014
 */
public final class Track {

    private final String name;
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }
}
