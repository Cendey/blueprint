package com.mit.lab.norm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.maxBy;

/**
 * <p>Project    : Blueprint</p>
 * <p>Description: Artist</p>
 * <p>Summary    : The artist who create art</p>
 * <p>Copyright  : Copyright (c) 2014</p>
 * <p>Company    : MIT-LAB Co., Ltd</p>
 *
 * @author Developer
 * @version 1.0
 * @date 5/9/2014
 */
public final class Artist {

    private String name;
    private List<Artist> members;
    private String nationality;

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the members
     */
    public Stream<Artist> getMembers() {
        return members.stream();
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(Collectors.<Artist>toList());
        return new Artist(name, members, nationality);
    }

    public static Optional<Artist> biggestGroup(Stream<Artist> groups) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return groups.collect(maxBy(Comparator.comparing(getCount)));
    }
}
