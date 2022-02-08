package com.org.tinyurl.service;

import com.org.tinyurl.exception.NodeNotFoundException;

public interface TinyURLService {

    public String getTinyURL(String originalURL) throws NodeNotFoundException;

}
