package com.chahar.spring.mvc.resolvers;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class QuickerMultipartResolver extends CommonsMultipartResolver {
    protected final Logger LOG = LogManager.getLogger(getClass());

    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);

        /* ************** Custom business  logic starts from here ***************************** */

        ProgressListener progressListener = new QuickerUploadProgressListenerImpl(fileUpload);
        fileUpload.setProgressListener(progressListener);
        request.getSession().setAttribute(QuickerUploadProgressListenerImpl.BEAN_NAME , progressListener);

        LOG.info("Setting Session id: {} " , request.getSession().getId());

        /****************** Custom business logic ends here ***********************************  */

        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        }
        catch (FileUploadBase.SizeLimitExceededException ex) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
        }
        catch (FileUploadException ex) {
            throw new MultipartException("Could not parse multipart servlet request", ex);
        }
    }

}
