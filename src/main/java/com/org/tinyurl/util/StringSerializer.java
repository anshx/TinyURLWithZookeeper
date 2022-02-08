package com.org.tinyurl.util;

import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.nio.charset.StandardCharsets;

public class StringSerializer implements ZkSerializer {

    @Override
    public byte[] serialize(Object data) {
        return ((String) data).getBytes();
    }

    @Override
    public Object deserialize(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
