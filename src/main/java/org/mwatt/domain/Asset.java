package org.mwatt.domain;

import lombok.Getter;

public class Asset {
    private final FileSystemNativeClient fileSystemNativeClient;

    @Getter
    private String name;
    @Getter
    private Namespace namespace;
    @Getter
    private AssetLocation assetLocation;

    public Asset(FileSystemNativeClient fileSystemNativeClient, String name, Namespace namespace, AssetLocation  assetLocation) {
        this.fileSystemNativeClient = fileSystemNativeClient;
        this.name = name;
        this.namespace = namespace;
        this.assetLocation = assetLocation;
    }

    public boolean exists() {
        return fileSystemNativeClient.assetExists(assetLocation.getPath());
    }
}
