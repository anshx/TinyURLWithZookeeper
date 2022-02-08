package com.org.tinyurl.configuration;

import com.org.tinyurl.exception.NodeNotFoundException;
import com.org.tinyurl.util.DataStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ApplicationInit {

    @Autowired
    private DataStorage dataStorage;

    @PostConstruct
    public void connectWithZookeeper() {
        /**
         *
         * Application will initialize itself on startup with zookeeper
         *
         */
        try {
            log.info("initializing the data storage..");
            dataStorage.initializeDataStorage();
        }catch (NodeNotFoundException nodeNotFoundException) {
            log.error("Node counter not found..");
        }

    }

}
