package com.demoqa.tests;

import com.demoqa.pages.UploadDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadTest extends BaseTest {

    @Test
    public void shouldUploadFile() throws IOException {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);
        page.open();
        
        Path tempFile = Files.createTempFile("test-upload", ".txt");
        Files.write(tempFile, "Test file content for upload".getBytes());
        
        try {
            page.uploadFile(tempFile.toAbsolutePath().toString());
            Assert.assertTrue(page.isUploadedPathVisible(), "Ожидалось появление пути загруженного файла.");
            String uploadedPath = page.uploadedPath();
            Assert.assertTrue(uploadedPath.contains(tempFile.getFileName().toString()), 
                "Ожидалось отображение имени загруженного файла.");
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    public void shouldUploadTextFile() throws IOException {
        UploadDownloadPage page = new UploadDownloadPage(driver, wait);
        page.open();
        
        String fileName = "sample-upload.txt";
        Path tempFile = Files.createTempFile("sample", ".txt");
        Files.write(tempFile, "Sample text content for upload testing".getBytes());
        
        try {
            page.uploadFile(tempFile.toAbsolutePath().toString());
            Assert.assertTrue(page.isUploadedPathVisible(), "Ожидалось появление пути загруженного файла.");
            String uploadedPath = page.uploadedPath();
            Assert.assertFalse(uploadedPath.isEmpty(), "Путь загруженного файла не должен быть пустым.");
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}
