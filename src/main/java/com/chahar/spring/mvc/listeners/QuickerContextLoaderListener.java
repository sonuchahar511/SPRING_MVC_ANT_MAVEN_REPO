package com.chahar.spring.mvc.listeners;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.io.File;
import java.io.IOException;

public class QuickerContextLoaderListener extends ContextLoaderListener {
    private final Logger LOG = LogManager.getLogger(QuickerContextLoaderListener.class);

    @Value("${file.upload.destination.dir}")
    private String attachmentDestinationDir;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOG.info("contextInitialized(ServletContextEvent)");

        super.contextInitialized(event);

        File uploadDestinationDir = uploadDestinationDir(event.getServletContext());
        if(uploadDestinationDir.exists()){
            try {
                FileUtils.deleteDirectory(uploadDestinationDir);
            } catch (IOException e) {
                LOG.error("Exception occured during deleting directory" + uploadDestinationDir.getAbsolutePath()
                            + " , reason: " +  e ) ;
            }

            LOG.info("Emptied Upload temp directory {} " , uploadDestinationDir.getAbsolutePath());

            uploadDestinationDir.mkdir();
        }else{
            uploadDestinationDir.mkdir();

            LOG.info("CREATED Upload temp Directory: {}" , uploadDestinationDir.getAbsolutePath());
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LOG.info("contextDestroyed(ServletContextEvent)");

        super.contextDestroyed(event);

       File uploadDestinationDir = uploadDestinationDir(event.getServletContext());

        if(uploadDestinationDir.exists()){
            try {
                FileUtils.deleteDirectory(uploadDestinationDir);
            } catch (IOException e) {
                LOG.error("Exception occured during deleting directory" + uploadDestinationDir.getAbsolutePath()
                        + " , reason: " +  e ) ;
            }
            LOG.info("Deleted Upload temp Directory: {} " , uploadDestinationDir.getAbsolutePath());
        }
    }

    private File uploadDestinationDir(ServletContext context){
        String projectRootPath = context.getRealPath("/");

        return new File(projectRootPath , "UPLOADED_DIR");
    }

}
