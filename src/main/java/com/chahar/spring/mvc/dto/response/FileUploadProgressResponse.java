package com.chahar.spring.mvc.dto.response;

public class FileUploadProgressResponse {
    private int progressPercentage;
    private String filename;

    public FileUploadProgressResponse(int progressPercentage, String filename) {
        this.progressPercentage = progressPercentage;
        this.filename = filename;
    }

    public FileUploadProgressResponse(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    @Override
    public String toString() {
        return "FileUploadProgressResponse{" +
                "progressPercentage=" + progressPercentage +
                ", filename='" + filename + '\'' +
                '}';
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
