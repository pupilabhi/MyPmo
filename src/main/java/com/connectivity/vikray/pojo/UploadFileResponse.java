package com.connectivity.vikray.pojo;

public class UploadFileResponse {

//	private String fileName;
    private String fileDownloadUri;
//    private String fileType;
//    private long size;

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
//        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
//        this.fileType = fileType;
//        this.size = size;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

   }
