package com.mobigen.framework.service.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobigen.framework.result.JsonResult;
import com.mobigen.framework.service.file.model.FileUploadRequest;

@Controller
@RequestMapping(value = "/service/file")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	private static final int BUFFER_SIZE = 4096;

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult upload(@ModelAttribute("uploadForm") FileUploadRequest uploadForm, HttpServletRequest request) {

		JsonResult js = new JsonResult();

		try {
			File workDir = (File) request.getServletContext().getAttribute(ServletContext.TEMPDIR);
			js.setData(fileService.fileUpload(uploadForm, workDir.getPath() + "file-upload-test"));
		} catch (Exception e) {
			logger.error("Error", e);
		}

		return js;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam("originalFileName") String originalFileName,
			@RequestParam("saveFileName") String saveFileName, @RequestParam("type") String type,
			HttpServletRequest request, HttpServletResponse response) {

		ServletContext context = request.getServletContext();
		String fullPath = fileService.getDownloadPath(type, saveFileName);

		FileInputStream inputStream = null;
		OutputStream outStream = null;

		try {
			File downloadFile = new File(fullPath);
			inputStream = new FileInputStream(downloadFile);

			String mimeType = context.getMimeType(fullPath);
			if (mimeType == null)
				mimeType = "application/octet-stream";

			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			String headerValue = fileService.getDisposition(originalFileName, request);
			response.setHeader(headerKey, headerValue);

			outStream = response.getOutputStream();

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		}

		catch (Exception e) {
			logger.error("Download Error", e);
		}

		finally {
			try {
				inputStream.close();
				outStream.close();
			} catch (Exception e1) {
				logger.error("Download Error", e1);
			}
		}
	}
}
