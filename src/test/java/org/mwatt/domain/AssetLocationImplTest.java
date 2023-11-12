package org.mwatt.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetLocationImplTest {

    @Test
    void changeAssetLocation() {
        AssetLocation assetLocation = new AssetLocationImpl(NativeClientType.LOCAL_FILE_SYSTEM, "path");
        AssetLocation newLocation = assetLocation.move(NativeClientType.LOCAL_FILE_SYSTEM, "newPath");

        assertEquals(NativeClientType.LOCAL_FILE_SYSTEM, assetLocation.getNativeClientType());
        assertEquals(NativeClientType.LOCAL_FILE_SYSTEM, newLocation.getNativeClientType());

        assertEquals("newPath", assetLocation.getPath(), "Should change the path on the original object");
        assertEquals("newPath", newLocation.getPath(), "The path on the returned object should be changed");
        assertSame(assetLocation, newLocation, "Should return the same object");
    }
}