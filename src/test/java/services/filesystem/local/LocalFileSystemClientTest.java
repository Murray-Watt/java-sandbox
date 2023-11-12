package services.filesystem.local;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mwatt.domain.LazyImpl;
import org.mwatt.services.filesystem.local.LocalFileSystemClient;
import org.mwatt.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LocalFileSystemClientTest extends TestBase {

    private static class Fixture {
        LocalFileSystemClient subject;

        protected Fixture() {
            subject = new LazyImpl<>(LocalFileSystemClient::create).get();
        }
    }

    private Fixture fixture;


    @BeforeEach
    void setUp() {
        fixture = new Fixture();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getsRootFolders() {
        List<String> roots = Arrays.stream(File.listRoots()).map(File::getAbsolutePath).collect(Collectors.toList());

        Set<String> rootFolders = fixture.subject.getRootFolders();

        assertEquals(roots.size(), rootFolders.size(), "Number of root folders does not match");

        for (String root : roots) {
            assertTrue(rootFolders.contains(root), "Root folder " + root + " not found");
        }
    }

    @Test
    void getsSubFolders() throws IOException {
        String tmpDirsLocation = System.getProperty("java.io.tmpdir");

        String tmpdir1 = Files.createTempDirectory("test").toFile().getAbsolutePath();
        String folder1 = tmpdir1.substring(tmpDirsLocation.length());

        String tmpdir2 = Files.createTempDirectory("test").toFile().getAbsolutePath();
        String folder2 = tmpdir2.substring(tmpDirsLocation.length());

        logger.trace("parent: " + tmpDirsLocation);
        logger.trace("tmpdir: " + tmpdir1);

        Set<String> subFolders = fixture.subject.getSubFolders(tmpDirsLocation);

        assertTrue(subFolders.contains(folder1), "Folder " + folder1 + " not found");
        assertTrue(subFolders.contains(folder2), "Folder " + folder2 + " not found");
    }

    @Test
    void getEmptyFolders() throws IOException {
        String tmpDir = Files.createTempDirectory("test").toFile().getAbsolutePath();

        Set<String> subFolders = fixture.subject.getSubFolders(tmpDir);
        assertTrue(subFolders.isEmpty(), "Sub folders should be empty");
    }

    @Test
    void getsSubFoldersThrowsIfParentDirectoryDoesNotExist() {
        String parentFolder = "does-not-exist-" + UUID.randomUUID();

        try {
            fixture.subject.getSubFolders(parentFolder);
            fail("Expected exception not thrown");
        } catch (IllegalArgumentException exception) {
            assertEquals(String.format("Parent folder %s does not exist", parentFolder), exception.getMessage(), "Exception message does not match");
        }
    }

    @Test
    void doesFolderExists() throws IOException {
        String tmpDirsLocation = System.getProperty("java.io.tmpdir");
        String tmpdir = Files.createTempDirectory("test").toFile().getAbsolutePath();

        assertTrue(fixture.subject.folderExists(tmpdir),"folder exists returned false for a directory exists");

        String file = Files.createTempFile("test", ".txt").toFile().getAbsolutePath();
        assertFalse(fixture.subject.folderExists(file),"folder exists returned true for a file that exists");

        String nonExistentFolder = tmpDirsLocation + "does-not-exist-" + UUID.randomUUID();
        assertFalse(fixture.subject.folderExists(nonExistentFolder),"folder exists returned true for a directory/file that does not exist");
    }

    @Test
    void doesFileExist() throws IOException {
        String tmpFile = System.getProperty("java.io.tmpdir") + "does-not-exist-" + UUID.randomUUID();
        assertFalse(fixture.subject.assetExists(tmpFile),"file exists returned true for a file that does not exist");

        String filePath = Files.createTempFile("test", ".txt").toFile().getAbsolutePath();

        assertTrue(fixture.subject.assetExists(filePath),"file exists returned false for a file that exists");

        String tmpdir2 = Files.createTempDirectory("test").toFile().getAbsolutePath();

        assertFalse(fixture.subject.assetExists(tmpdir2),"file exists returned true for a directory that exists");
    }
}