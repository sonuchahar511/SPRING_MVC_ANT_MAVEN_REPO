package com.chahar.spring.mvc.resolvers;

import org.apache.commons.fileupload.FileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickerUploadProgressListenerImpl implements QuickerProgressListener{
    public static final String BEAN_NAME= "com.chahar.spring.mvc.resolvers.QuickerUploadProgressListenerImpl_BEAN_ID";

    protected final Logger LOG = LogManager.getLogger(getClass());

    private int uploadProgressPercentage = 0;
    private FileUpload fileUpload;

    //NOTE: This method called internally many times when small byte chunks is uploaded.
    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        int uploadProgressPercentage =   new Long( pBytesRead * 100 / pContentLength).intValue() ;
        if(uploadProgressPercentage > this.uploadProgressPercentage) {
            if (pContentLength == -1) {
                LOG.info("So far, {} bytes have been read", pBytesRead);
            } else {
                LOG.info("So far, {} of {} bytes have been read, Progress= {} %", pBytesRead, pContentLength, uploadProgressPercentage);
            }
        }else{
            System.out.print(".");
        }
        this.uploadProgressPercentage = uploadProgressPercentage;
    }

    @Override
    public int getFileUploadPercentage() {
        return uploadProgressPercentage;
    }
    @Override
    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public QuickerUploadProgressListenerImpl(FileUpload fileUpload){
        this.fileUpload = fileUpload;
    }
}
