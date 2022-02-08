package com.org.tinyurl;

import com.org.tinyurl.exception.NodeNotFoundException;
import com.org.tinyurl.service.ZookeeperService;
import com.org.tinyurl.util.DataStorage;
import com.org.tinyurl.util.StringSerializer;
import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TinyUrlWithZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyUrlWithZookeeperApplication.class, args);
    }

    @Value("${zookeeper.port}")
    private String hostPort;

    @Bean
    public ZkClient zkClient() {
        return new ZkClient(hostPort, 12000, 3000, new StringSerializer());
    }

}
