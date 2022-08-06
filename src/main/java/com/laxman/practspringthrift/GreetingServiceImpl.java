package com.laxman.practspringthrift;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
@Slf4j
public class GreetingServiceImpl implements GreetingService.Iface{
    @Override
    public boolean ping() throws InvalidOperationException, TException {
        log.info("ping from client");
        return true;
    }

    @Override
    public String greetMsg(String msg) throws InvalidOperationException, TException {
        if(msg == null || msg.isBlank()){
            throw new InvalidOperationException();
        }

        return "Msg received: " + msg +  ". Hello from server.";
    }

    @Override
    public void printLog(String msg) throws TException {
        log.info("printLog: " + msg);
    }
}
