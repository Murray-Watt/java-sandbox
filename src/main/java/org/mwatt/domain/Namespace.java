package org.mwatt.domain;

import lombok.Getter;

import java.util.Optional;

public class Namespace {
    @Getter
    private Optional<Namespace> parent;

    @Getter
    private String leafName;

    @Getter
    private String separator = "/";

    public Namespace(String leafName) {
        this.parent = Optional.empty();
        this.leafName = leafName;
    }

    public Namespace(Namespace parent, String leafName) {
        this.parent = Optional.of(parent);
        this.leafName = leafName;
    }

    public String getFullName() {
        return parent
                .map(namespace -> namespace.getFullName() + separator + leafName)
                .orElseGet(() -> separator + leafName);
    }
}
