package com.org.tinyurl.service;

import com.org.tinyurl.exception.NodeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ZookeeperService {

    /**
     *
     *
     * This will return all Nodes which are present
     *
     * @return
     */
    public List<String> getAllNodes();


    /**
     *
     * This will return a data for a ZNode
     *
     * @param path
     * @return
     */
    public String getZNodeData(String path);

    /**
     *
     * This will return all the child nodes
     * In our case, we will get the child nodes of 'Counter'
     *
     * @return
     */
    public List<String> getChildrenNodes() throws NodeNotFoundException;

    /**
     * Counter will be the parent node
     * All other nodes, when wanting to get a range of values,
     * will create an 'Ephemeral Sequential Node' under 'Counter'
     *
     */
    public void createNodeInCounter();
}
