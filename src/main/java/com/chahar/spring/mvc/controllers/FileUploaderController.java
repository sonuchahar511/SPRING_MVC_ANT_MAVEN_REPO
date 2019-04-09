package com.chahar.spring.mvc.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import com.chahar.spring.mvc.dto.response.FileUploadProgressResponse;
import com.chahar.spring.mvc.resolvers.QuickerProgressListener;
import com.chahar.spring.mvc.resolvers.QuickerUploadProgressListenerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.chahar.spring.mvc.dto.form.AttachmentFileForm;

@Controller
@RequestMapping(value="/fileUploader")
public class FileUploaderController extends AbstractPageController{
	
	@Value("${file.upload.destination.dir}")
	private String attachmentDestinationDir;
	
	@RequestMapping(value="/uploadPage",method=RequestMethod.GET)
	public String fileUploadPage() {
		LOG.info(" /fileUploader/uploadPage + GET: rendering page: fileUploadPage " );
		
		return "fileUploadPage";
	}
	
	@RequestMapping(value="/singleUpload",method=RequestMethod.POST)
	public String doupload(AttachmentFileForm fileForm,final Model model,HttpServletRequest request) {

		LOG.info(" /fileUploader/singleUpload + POST: rendering page: fileUploadPage: data: {} " , fileForm );
		
		MultipartFile attachmentFile = fileForm.getAttachment(); 
		CommonsMultipartFile commonMultipartFile = (CommonsMultipartFile) attachmentFile;
		LOG.info("Tomcat stored Uploaded file in Temp folder, Details are {} , size: {} , location: {} ",
					commonMultipartFile.getOriginalFilename() ,commonMultipartFile.getSize() ,  commonMultipartFile.getStorageDescription());
		
		String projectRootPath = request.getServletContext().getRealPath("/");
		LOG.info("Project Root Path : " + projectRootPath);
		
		File uploadDestinationDir = new File(projectRootPath , attachmentDestinationDir);
		if(!uploadDestinationDir.exists()) {
			uploadDestinationDir.mkdir();
			
			LOG.info("CREATED Directory: {} in {} " , attachmentDestinationDir,projectRootPath);
		}
		
		 try {
	            Path path = Paths.get(uploadDestinationDir + "/"+attachmentFile.getOriginalFilename());
	            Files.write(path, attachmentFile.getBytes());
	            
	            String message = String.format("SUCCESS: %1$s is saved at location: %2$s" , attachmentFile.getOriginalFilename() ,uploadDestinationDir );
	            model.addAttribute("message" , message);
	            model.addAttribute("success",Boolean.TRUE);

	            LOG.info("SUCCESS: {} is saved at location: {}" , attachmentFile.getOriginalFilename() ,uploadDestinationDir );
	        }  catch (IOException e) {
                 String message = String.format("FAILED to save %1$s at location: %2$s" , attachmentFile.getOriginalFilename() ,uploadDestinationDir );
                 model.addAttribute("message" , message);
                 model.addAttribute("success" , Boolean.FALSE);

	        	 LOG.info("FAILED to save {} at location: {}" , attachmentFile.getOriginalFilename() ,uploadDestinationDir );
	             e.printStackTrace();
	        }
		
		return "fileUploadPage";
	}

    @RequestMapping(value="/checkProgress",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody FileUploadProgressResponse checkFileUploadProgress(HttpServletRequest request){
	    LOG.info("Checking Session id: " , request.getSession().getId());

        QuickerProgressListener progressListener = (QuickerProgressListener) request.getSession().getAttribute(QuickerUploadProgressListenerImpl.BEAN_NAME);
        if(progressListener  != null){
            return new FileUploadProgressResponse(progressListener.getFileUploadPercentage(), "todo_filename" );
        }
        return new FileUploadProgressResponse(-1, "" );
    }
	
}
