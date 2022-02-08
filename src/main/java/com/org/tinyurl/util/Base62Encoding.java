package com.org.tinyurl.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Base62Encoding {

    String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encodeString(long num) {
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            ans.append(base62.charAt((int)(num%62)));
            num /= 62;
        }
        return ans.reverse().toString();
    }

    public void decodeString() {

    }

}
