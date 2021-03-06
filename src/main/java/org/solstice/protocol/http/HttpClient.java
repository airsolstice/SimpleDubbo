package org.solstice.protocol.http;

import org.apache.commons.io.IOUtils;
import org.solstice.common.Invocation;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public String post(String hostname, Integer port, Invocation invocation) {
        try {
            URL url = new URL("http", hostname, port, "/dispatcher");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream is = connection.getInputStream();
            return IOUtils.toString(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
