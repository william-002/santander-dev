package digitalinnovation.santander_dev.service;

import digitalinnovation.santander_dev.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);


}
