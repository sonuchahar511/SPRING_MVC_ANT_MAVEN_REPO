package com.chahar.spring.mvc.resolvers;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.ProgressListener;

public interface QuickerProgressListener extends ProgressListener {
    public int getFileUploadPercentage();
    public FileUpload getFileUpload();
}
