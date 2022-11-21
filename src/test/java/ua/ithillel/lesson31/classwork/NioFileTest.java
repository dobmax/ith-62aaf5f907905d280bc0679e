package ua.ithillel.lesson31.classwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

class NioFileTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldRead_HelloWorld_fromFile_inTestResourceDirectory_One() throws IOException {
        var testResourcesPath = Path.of("src","test", "resources", "test.txt");
        var txtFile  = testResourcesPath.toAbsolutePath().toFile();

        try (var reader = new BufferedReader(new FileReader(txtFile))) {
            Assertions.assertEquals("Hello, world!", reader.readLine());
        }
    }

    @Test
    void shouldRead_HelloWorld_fromFile_inTestResourceDirectory_Two() throws IOException {
        var testScopeClassLoader = this.getClass().getClassLoader();
        var txtFileIn = testScopeClassLoader.getResourceAsStream("test.txt");

        try (var reader = new BufferedReader(new InputStreamReader(txtFileIn))) {
            Assertions.assertEquals("Hello, world!", reader.readLine());
        }
    }

    // Bad practice
    @Test
    void shouldCreateNewFile_inTestResourceDirectory() throws IOException {
        var testResourcesPath = Path.of("src","test", "resources", "test1.txt");
        var createdFiled = Files.createFile(testResourcesPath);
        Assertions.assertTrue(Files.exists(createdFiled));

        // tear down (after test)
        Files.delete(createdFiled);
    }

    @Test
    void shouldCreateNewFile_inTempDirectory() throws IOException {
        var testResourcesPath = tempDir.resolve( "test1.txt");
        var createdFiled = Files.createFile(testResourcesPath);
        Assertions.assertTrue(Files.exists(createdFiled));
    }
}
