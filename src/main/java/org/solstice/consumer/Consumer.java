package org.solstice.consumer;

import org.solstice.common.Invocation;
import org.solstice.protocol.http.HttpClient;
import org.solstice.provider.service.MessageService;

public class Consumer {
    public static void main(String[] args) {
        HttpClient client = new HttpClient();
        Invocation invocation = new Invocation(MessageService.class.getName(), "say", new Object[]{"12132"}, new Class[]{String.class});
        String result = client.post("localhost", 8080, invocation);
        System.out.println(result);
    }
}
