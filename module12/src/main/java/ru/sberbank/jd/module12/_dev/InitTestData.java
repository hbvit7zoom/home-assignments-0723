package ru.sberbank.jd.module12._dev;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.jd.module12.entity.Client;
import ru.sberbank.jd.module12.repository.ClientRepository;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitTestData {
    private ClientRepository clientRepository;

    @Autowired
    @Transactional
    public void initTestData() {
        Client client = new Client();
        client.setFirstName("Nikita");
        client.setLastName("Kozlov");

        clientRepository.save(client);
    }
}
