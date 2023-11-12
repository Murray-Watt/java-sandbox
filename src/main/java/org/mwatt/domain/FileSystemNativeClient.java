package org.mwatt.domain;

import java.util.Set;

public interface FileSystemNativeClient {
    Set<String> getRootFolders();
    Set<String> getSubFolders(String parentFolder);
    boolean folderExists(String folder);
    boolean assetExists(String tmpFile);
}
