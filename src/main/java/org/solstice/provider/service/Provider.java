package org.solstice.provider.service;

import org.solstice.common.URL;
import org.solstice.protocol.http.HttpServer;
import org.solstice.provider.service.impl.MessageServiceImpl;
import org.solstice.register.Register;

public class Provider {

    public static void main(String[] args){
        URL url = new URL("localhost", 8080);
        Register.regist( MessageService.class.getName(), url, MessageServiceImpl.class);

        HttpServer server = new HttpServer();
        server.start(url.getHostname(), url.getPort());
    }
}
