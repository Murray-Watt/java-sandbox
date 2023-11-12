package org.mwatt.domain;

import lombok.Getter;

@Getter
public class AssetLocationImpl implements AssetLocation {
    private NativeClientType nativeClientType;
    private String path;

    public AssetLocationImpl(NativeClientType nativeClientType, String path) {
        this.nativeClientType = nativeClientType;
        this.path = path;
    }

    @Override
    public AssetLocation move(NativeClientType type, String newPath) {
        nativeClientType = type;
        path = newPath;
        return this;
    }
}
