package com.ch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddImgPrefix {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址

    public String addPrefix(String img) {
        if ( (img.substring(0, 6)).equals("group1") ) {
            return FILE_SERVER_URL + img;
        }
        return img;
    }

}
