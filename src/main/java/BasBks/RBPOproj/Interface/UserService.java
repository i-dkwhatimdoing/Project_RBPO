package BasBks.RBPOproj.Interface;


import BasBks.RBPOproj.models.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);


}
