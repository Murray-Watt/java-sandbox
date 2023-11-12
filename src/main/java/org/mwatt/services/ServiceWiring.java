package org.mwatt.services;

import org.mwatt.domain.FileSystemNativeClient;
import org.mwatt.domain.Lazy;
import org.mwatt.domain.LazyImpl;
import org.mwatt.services.filesystem.local.LocalFileSystemClient;

public class ServiceWiring {

    private final Lazy<FileSystemNativeClient> localFileSystem = new LazyImpl<>(LocalFileSystemClient::create);

    public FileSystemNativeClient getLocalFileSystem() {
        return localFileSystem.get();
    }
}
