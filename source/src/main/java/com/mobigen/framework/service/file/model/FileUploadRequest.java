package com.mobigen.framework.service.file.model;

import java.util.List;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadRequest {
	private List<MultipartFile> files;
	private String type;
}
