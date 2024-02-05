package org.mwatt.services;

import org.mwatt.domain.FileSystemNativeClient;
import org.mwatt.domain.LazyBuilder;
import org.mwatt.domain.Lazy;
import org.mwatt.services.filesystem.local.LocalFileSystemClient;

public class ServiceWiring {

    private final LazyBuilder<FileSystemNativeClient> localFileSystem = new Lazy<>(LocalFileSystemClient::create);

    public FileSystemNativeClient getLocalFileSystem() {
        return localFileSystem.get();
    }
}
