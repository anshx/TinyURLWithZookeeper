package com.org.tinyurl.impl;

import com.org.tinyurl.exception.NodeNotFoundException;
import com.org.tinyurl.service.TinyURLService;
import com.org.tinyurl.util.Base62Encoding;
import com.org.tinyurl.util.DataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TinyURLServiceImpl implements TinyURLService {

    @Autowired
    private DataStorage dataStorage;

    @Autowired
    private Base62Encoding base62Encoding;

    @Override
    public String getTinyURL(String originalURL) throws NodeNotFoundException {
        long uniqueIndex = dataStorage.getNextIndex();
        String encodedString = base62Encoding.encodeString(uniqueIndex);
        return encodedString;
    }

}
