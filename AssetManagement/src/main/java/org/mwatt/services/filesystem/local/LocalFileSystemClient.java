package org.mwatt.services.filesystem.local;

import org.mwatt.domain.FileSystemNativeClient;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class LocalFileSystemClient implements FileSystemNativeClient {

    static public LocalFileSystemClient create() {
        return new LocalFileSystemClient();
    }

    public Set<String> getRootFolders() {
        List<File> roots = Arrays.asList(File.listRoots());
        return roots.stream().map(File::getAbsolutePath).collect(Collectors.toSet());
    }

    public Set<String> getSubFolders(String parentFolder) {

        File parentDirectory = new File(parentFolder);

        if (!parentDirectory.exists()) {
            throw new IllegalArgumentException(String.format("Parent folder %s does not exist", parentFolder));
        }

        List<File> directories = Arrays.asList(Objects.requireNonNull(parentDirectory.listFiles(File::isDirectory)));
        return directories.stream().map(File::getName).collect(Collectors.toSet());
    }

    public boolean folderExists(String folder) {
        File directory = new File(folder);
        return directory.isDirectory();
    }

    @Override
    public boolean assetExists(String assetFullName) {
        File asset = new File(assetFullName);
        return asset.isFile();
    }
}
