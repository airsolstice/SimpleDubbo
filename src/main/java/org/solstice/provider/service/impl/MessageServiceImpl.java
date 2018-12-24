package org.solstice.provider.service.impl;

import org.solstice.provider.service.MessageService;

public class MessageServiceImpl implements MessageService {

    @Override
    public String say(String username) {
        return "Hello, " + username;
    }
}
