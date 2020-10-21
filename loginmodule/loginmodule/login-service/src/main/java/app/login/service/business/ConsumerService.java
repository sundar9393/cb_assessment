package app.login.service.business;

import app.login.service.dao.ConsumerDao;
import app.login.service.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsumerService {

    @Autowired
    ConsumerDao consumerDao;

    @Transactional
    public Consumer registerUser(Consumer newUSer) {
        return consumerDao.addUser(newUSer);
    }

    public Consumer isValidUSer(String phoneNumber) {
        return consumerDao.fetchUserByPhone(phoneNumber);
    }

    @Transactional
    public Consumer updateRole(String phoneNumber, String role) {
        return consumerDao.updateRole(phoneNumber, role);
    }



}
