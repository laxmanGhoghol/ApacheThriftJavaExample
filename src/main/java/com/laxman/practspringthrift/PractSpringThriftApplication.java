package com.laxman.practspringthrift;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class PractSpringThriftApplication {
    public static void main(String[] args) {
		int port = 8082;
        SpringApplication.run(PractSpringThriftApplication.class, args);
		Runnable server = new Runnable() {
			@Override
			public void run() {
				start(port);
			}
		};
		new Thread(server).start();
		log.info("Started the server at port: " + port);
    }
	public static void start(int port){
		TServerTransport serverTransport;
		try {
			serverTransport = new TServerSocket(port);
		} catch (TTransportException e) {
			throw new IllegalStateException("Failed to start the server");
		}
		GreetingService.Processor<GreetingServiceImpl> processor = new GreetingService.Processor<>(new GreetingServiceImpl());
		TServer server = new TSimpleServer(new TSimpleServer.Args(serverTransport).processor(processor));
		server.serve();
	}
}
