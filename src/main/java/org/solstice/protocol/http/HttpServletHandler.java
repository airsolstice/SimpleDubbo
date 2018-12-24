package org.solstice.protocol.http;

import org.apache.commons.io.IOUtils;
import org.solstice.common.Invocation;
import org.solstice.common.URL;
import org.solstice.register.Register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class HttpServletHandler {


    public void handle(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream is = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            Invocation invocation = (Invocation) ois.readObject();

            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8080);
            Class implClass = Register.get(interfaceName, url);

            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            OutputStream os = resp.getOutputStream();
            IOUtils.write(result, os);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
