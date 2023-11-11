package org.mwatt.domain;

import java.util.List;
import java.util.Set;

public interface FileSystemNativeClient {
    Set<String> getRootFolders();
    Set<String> getSubFolders(String parentFolder);
}
