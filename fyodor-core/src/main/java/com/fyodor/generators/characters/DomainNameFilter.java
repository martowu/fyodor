package com.fyodor.generators.characters;

public class DomainNameFilter extends RegExCharacterFilter {

    private static CharacterFilter filter = new DomainNameFilter();

    private DomainNameFilter() {
        super("[a-zA-Z0-9\\-]");
    }

    public static CharacterFilter getFilter() {
        return filter;
    }
}