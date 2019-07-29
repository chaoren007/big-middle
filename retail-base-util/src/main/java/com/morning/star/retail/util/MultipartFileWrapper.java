package com.morning.star.retail.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileWrapper implements MultipartFile, Serializable {
    private static final long serialVersionUID = 1L;

    private byte[] bytes;
    private long size;
    private String contentType;
    private String name;
    private String originalFilename;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return bytes;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(dest);
            fout.write(bytes);
        } finally {
            if (fout != null) {
                fout.close();
            }
        }
    }

    public static MultipartFileWrapper of(MultipartFile file) throws IOException {
        MultipartFileWrapper wrapper = new MultipartFileWrapper();
        wrapper.bytes = file.getBytes();
        wrapper.size = file.getSize();
        wrapper.contentType = file.getContentType();
        wrapper.name = file.getName();
        wrapper.originalFilename = file.getOriginalFilename();
        return wrapper;
    }
}
