package ru.hogwards.school.school.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwards.school.school.interfaces.InfoService;

@Service
public class InfoServiceImpl implements InfoService {
    @Value("${server.port}")
    private static String port;

    @Override
    public String getPort() {
        return port;
    }
}
