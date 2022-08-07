package com.laxman.practspringthrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PractSpringThriftApplicationTests {
	private TTransport transport;
	TProtocol protocol;
	GreetingService.Client client;

	@BeforeAll
	void setUp() throws TTransportException {
		transport = new TSocket("localhost", 8082);
		protocol = new TBinaryProtocol(transport);
		client = new GreetingService.Client(protocol);
	}

	@AfterAll
	void tearDown(){
		transport.close();
	}


	@Test
	void shouldReturnTrueWhenPingGreetService() throws TException, InterruptedException {
		Thread.sleep(3000);
		transport.open();
		Assertions.assertTrue(client.ping());
	}

}
