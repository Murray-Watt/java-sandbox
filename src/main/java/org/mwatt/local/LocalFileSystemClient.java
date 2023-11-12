package org.mwatt.local;

import org.mwatt.domain.FileSystemNativeClient;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalFileSystemClient implements FileSystemNativeClient {
    public Set<String> getRootFolders() {
        List<File> roots = Arrays.asList(File.listRoots());
        Set<String> rootFolders = roots.stream().map(f -> f.getAbsolutePath().toString()).collect(Collectors.toSet());

        return rootFolders;
    }

    public Set<String> getSubFolders(String parentFolder) {

        File parentDirectory = new File(parentFolder);

        if (!parentDirectory.exists()) {
            throw new IllegalArgumentException(String.format("Parent folder %s does not exist", parentFolder));
        }

        List<File> directories = Arrays.asList(parentDirectory.listFiles(File::isDirectory));
        Set<String> subFolders = directories.stream().map(f -> f.getName().toString()).collect(Collectors.toSet());

        return new HashSet<>(subFolders);
    }

    public boolean folderExists(String folder) {
        File directory = new File(folder);
        return directory.isDirectory() && directory.exists();
    }
}
