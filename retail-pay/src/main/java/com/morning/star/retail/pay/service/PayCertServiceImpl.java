package com.morning.star.retail.pay.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PayCertServiceImpl implements PayCertService {

    private static Logger LOGGER = LoggerFactory.getLogger(PayCertServiceImpl.class);
    private Map<String, byte[]> certMap = new ConcurrentHashMap<>();
    
    @Override
    public byte[] getCert(String path) {
        try {
            byte[] result = certMap.get(path);
            if(result != null) {
                return result;
            }
            File file = path.startsWith("/") ? new File(path) : new File(this.getClass().getClassLoader().getResource(path).toURI());
            InputStream certStream = new FileInputStream(file);
            byte[] certData = new byte[(int) file.length()];
            certStream.read(certData);
            certStream.close();
            certMap.put(path, certData);
            return certData;
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("get cert", e);
            return null;
        }
    }

    
}
