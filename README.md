# TinyURLWithZookeeper
A highly available and highly consistent TinyURL system implementation using Zookeeper which is capable of generating 10 billion unique URL combinations


<img src="https://user-images.githubusercontent.com/62032144/152983862-c3187786-3db7-4e49-90b9-867e1837fbb1.jpg">

Url Shortener is required to create shorter aliases for long URL's. For these type of system, we want our systems to be
1. Highly available
2. Must be able to create unique URL's.

Inorder to generate a large number of URL's and reduce latency while generating URL's, we can use Zookeeper.

Zookeeper is a centralized coordination service. It is mainly used for
1. Leader election
2. Distributed Locks

All these magic's happen with the help of zNodes. 
There are different types of zNodes - Persistent and Ephemeral.

In this design, whenever an application starts and registers itself with zookeeper, zookeeper assigns a range of unique numbers to the application.
The uniqueness is guaranteed because zookeeper inherently guarantees lock on a zNode. We can also maintain an odd number of ZK instances to reach quorum.
