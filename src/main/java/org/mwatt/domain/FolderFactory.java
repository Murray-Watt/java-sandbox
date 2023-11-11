package org.mwatt.domain;

import java.nio.file.Path;
import java.util.List;

public interface FolderFactory {
    Folder create(Folder parent, String name);
}
