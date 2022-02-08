package com.org.tinyurl.util;

import com.org.tinyurl.exception.NodeNotFoundException;
import com.org.tinyurl.service.ZookeeperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DataStorage {

    private long start;
    private long end;
    private long current;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private ZookeeperService zookeeperService;

    public void initializeDataStorage() throws NodeNotFoundException {

        log.info("Initializing data storage..");

        zookeeperService.createNodeInCounter();
        List<String> childNodes = zookeeperService
                .getChildrenNodes().stream()
                .filter(s -> s.startsWith(applicationName))
                .sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());

        String latestValue = childNodes.get(0);
        start = Long.parseLong(latestValue.substring(latestValue.indexOf("-")+1))*10000L;
        end = start + 10000L;
        current = start;

        log.info(start + "-" + current + "-" + end);

    }

    public long getNextIndex() throws NodeNotFoundException {
        if(current > end) {
            initializeDataStorage();
        }
        return current++;
    }

}
