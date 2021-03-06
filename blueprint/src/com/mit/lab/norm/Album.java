package com.mit.lab.norm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;

/**
 * <p>Project    : Blueprint</p>
 * <p>Description: Album</p>
 * <p>Summary    : Artist's album</p>
 * <p>Copyright  : Copyright (c) 2014</p>
 * <p>Company    : MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @since 5/9/2014
 */
public final class Album {

    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    private Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the tracks
     */
    private Stream<Track> getTracks() {
        return tracks.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Track> getTrackList() {
        return unmodifiableList(tracks);
    }

    /**
     * @return the musicians
     */
    private Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Artist> getMusicianList() {
        return unmodifiableList(musicians);
    }

    public Artist getMainMusician() {
        return musicians.get(0);
    }

    public Album copy() {
        List<Track> tracks = getTracks().map(Track::copy).collect(Collectors.<Track>toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(Collectors.<Artist>toList());
        return new Album(name, tracks, musicians);
    }
}
