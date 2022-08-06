package com.laxman.practspringthrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Client {
    public static void main(String[] args) throws TException {
        TTransport transport = new TSocket("localhost", 8082);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        GreetingService.Client client= new GreetingService.Client(protocol);
        client.ping();
        client.printLog("hi from client");
        System.out.println(client.greetMsg("Hello"));
        System.out.println(client.greetMsg("_"));
    }
}
