package com.mobigen.framework.service.file;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mobigen.framework.service.file.model.FileUploadRequest;
import com.mobigen.framework.service.file.model.FileUploadResponse;

import lombok.extern.java.Log;

@Log
@Service
public class FileService {

	@Autowired
	MessageSource messageSource;

	private String getRandomFileName()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int seed = (new Random()).nextInt(1000) + 8999;

		String result = sdf.format(new Date()) + seed + "";
		return result;
	}
	private String getPath(String type)
	{
		String path = messageSource.getMessage("file.directory", null, Locale.getDefault());
		String key = "file." + type;
		path += "/" +  messageSource.getMessage(key, null, Locale.getDefault());
		return path;
	}

	private String getUploadPath(String path, String fileName)
	{
		File fDir = new File(path);
		if (!fDir.exists())
			fDir.mkdirs();

		path += "/" + fileName;

		return path;
	}

    private String getBrowser(HttpServletRequest request)
    {
        String header = request.getHeader("User-Agent");
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        }
        return "Firefox";
    }

    /**
     * 브라우저별 다운로드 해더값 생성
     * @param filename
     * @param request
     * @return
     * @throws Exception
     */
    public String getDisposition(String filename, HttpServletRequest request) throws Exception
    {
    	String browser = getBrowser(request);

        String dispositionPrefix = "attachment;filename=";
        String encodedFilename = null;

        if (browser.equals("MSIE"))
            encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");

        else if (browser.equals("Firefox"))
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";

        else if (browser.equals("Opera"))
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";

        else if (browser.equals("Chrome"))
        {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < filename.length(); i++) {
                char c = filename.charAt(i);
                if (c > '~') {
                    sb.append(URLEncoder.encode("" + c, "UTF-8"));
                } else {
                    sb.append(c);
                }
            }
            encodedFilename = sb.toString();
        }

        return dispositionPrefix + encodedFilename;
    }

	/**
	 * 다운로드 경로 생성
	 * @param type
	 * @param fileName
	 * @return
	 */
	public String getDownloadPath(String type, String fileName)
	{
		String path = getPath(type) + "/" + fileName;
		return path;
	}

	/**
	 * 파일 업로드
	 * @param uploadForm
	 * @return
	 * @throws Exception
	 */
	public List<FileUploadResponse> fileUpload(FileUploadRequest uploadForm, String savePath) throws Exception
	{
		List<FileUploadResponse> result = new ArrayList<FileUploadResponse>();

        List<MultipartFile> files = uploadForm.getFiles();
        if(null != files && files.size() > 0)
        {
            for (MultipartFile multipartFile : files)
            {
                String originalFileName = multipartFile.getOriginalFilename();
                String extType = originalFileName.substring(originalFileName.indexOf("."), originalFileName.length());

                String saveFileName = getRandomFileName() + extType;
				String path = getUploadPath(savePath, saveFileName);
				log.info("File Upload Path: " + path);

				File f = new File(path);
				multipartFile.transferTo(f);

				FileUploadResponse fure = new FileUploadResponse(originalFileName, saveFileName, uploadForm.getType());
				result.add(fure);
            }
        }
		return result;
	}
}
