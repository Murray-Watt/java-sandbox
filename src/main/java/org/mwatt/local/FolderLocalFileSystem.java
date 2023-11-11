package org.mwatt.local;

import lombok.Getter;
import org.mwatt.domain.Folder;

public class FolderLocalFileSystem implements Folder {
    @Getter
    private String name;

    public FolderLocalFileSystem(String name) {
        this.name = name;
    }
}

