package digitalinnovation.santander_dev.service.impl;

import digitalinnovation.santander_dev.domain.model.User;
import digitalinnovation.santander_dev.domain.repository.UserRepository;
import digitalinnovation.santander_dev.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
           throw new IllegalArgumentException("Account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
