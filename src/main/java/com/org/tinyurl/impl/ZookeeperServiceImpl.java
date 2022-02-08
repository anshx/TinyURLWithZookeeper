package com.org.tinyurl.impl;

import com.org.tinyurl.exception.NodeNotFoundException;
import com.org.tinyurl.service.ZookeeperService;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.org.tinyurl.constants.ZkConstants.COUNTERNODE;

@Service
public class ZookeeperServiceImpl implements ZookeeperService {

    @Autowired
    private ZkClient zkClient;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public List<String> getAllNodes() {
        return null;
    }

    @Override
    public String getZNodeData(String path) {
        return zkClient.readData(path, null);
    }

    @Override
    public List<String> getChildrenNodes() throws NodeNotFoundException {
        if(!zkClient.exists(COUNTERNODE.getName())) {
            throw new NodeNotFoundException("Counter node is not present..");
        }
        return zkClient.getChildren(COUNTERNODE.getName());
    }

    @Override
    public void createNodeInCounter() {
        if(!zkClient.exists(COUNTERNODE.getName())) {
            zkClient.create(COUNTERNODE.getName(), "This is the parent node", CreateMode.PERSISTENT);
        }
        zkClient.create(COUNTERNODE.getName().concat("/").concat(applicationName),
                "This is the child data of a particular application",
                CreateMode.PERSISTENT_SEQUENTIAL);
    }

}
