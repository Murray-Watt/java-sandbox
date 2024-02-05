package org.mwatt.domain;

import lombok.Getter;
import org.mwatt.utilities.StrUtil;

import java.util.Optional;

@Getter
public class Namespace {
    private static final String separator = "/";

    public static Namespace empty = new Namespace();

    private Optional<Namespace> parent = Optional.empty();
    private Optional<String> leafName = Optional.empty();

    private Namespace() {
    }

    public Namespace(String leafName) {
        this.leafName = StrUtil.mapOptional(leafName);
    }

    public Namespace(Namespace parent, String leafName) {
        this.parent = Optional.of(parent);
        this.leafName = StrUtil.mapOptional(leafName);
    }

    public String getFullName() {
        if (parent.isEmpty() && leafName.isEmpty()) {
            return "";
        } else if (parent.isEmpty()) {
            return separator + leafName.orElse("");
        } else {
            return leafName.map(s -> parent.get().getFullName() + separator + s).orElseGet(() -> parent.get().getFullName());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Namespace)) {
            return false;
        }

        Namespace otherAsNamespace =  (Namespace) other;

        return this.getFullName().equals(otherAsNamespace.getFullName());
    }

    @Override
    public int hashCode() {
        return getFullName().hashCode();
    }
}


