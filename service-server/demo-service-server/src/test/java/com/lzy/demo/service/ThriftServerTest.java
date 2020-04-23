/*
 * Created by lzy on 2020/4/23 2:56 PM.
 */
package com.lzy.demo.service;

import com.lzy.demo.service.thrift.ThriftService;
import com.lzy.demo.service.thrift.impl.ThriftServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.junit.jupiter.api.Test;

/**
 * 测试Thrift
 *
 * @author lzy
 * @version v1.0
 */
public class ThriftServerTest {

    /**
     * thrift服务端
     */
    @Test
    public void testThriftServer() throws Exception {
        TServerTransport serverTransport = new TServerSocket(28010);
        ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor<>(new ThriftServiceImpl());
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        // 多线程
        // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
        System.out.println("Starting the simple server...");
        server.serve();
    }
}
