package org.mwatt.domain;

public interface AssetLocation {
    NativeClientType getNativeClientType();
    String getPath();

    AssetLocation move(NativeClientType type, String newPath);
}
