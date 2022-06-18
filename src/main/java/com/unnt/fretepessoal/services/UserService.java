package com.unnt.fretepessoal.services;

import com.unnt.fretepessoal.dto.NewUserDTO;
import com.unnt.fretepessoal.dto.UserDTO;
import com.unnt.fretepessoal.model.User;
import com.unnt.fretepessoal.model.enums.Profile;
import com.unnt.fretepessoal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserDTO> getUserList() {
        return userRepo.findAll()
            .stream()
            .map(UserDTO::new)
            .collect(Collectors.toList());
    }

    public User findById (Integer id){
        Optional<User> userSelect = userRepo.findById(id);
        return userSelect.orElseThrow(
                () -> null
        );
    }

    @Transactional
    public User saveApp(NewUserDTO dto) {
        User user = fromUser(dto);
        user.setProfiles(Set.of(Profile.CLIENT.getNumber()));
        return userRepo.save(user);
    }

//    Post
    @Transactional
    public User save(NewUserDTO dto){
        User user = fromUser(dto);
        return userRepo.save(user);
    }

//  Put
    public User update(Integer id, UserDTO dto){
        User obj = findById(id);
        fromUser(dto, obj);
        return userRepo.save(obj);
    }

    /*DELETE*/
    public void delete(Integer id){
        findById(id);
        try {
            userRepo.deleteById(id);
        }catch (DataIntegrityViolationException ex){
//            throw new DataIntegrityException("Não foi possível deletar esse cliente.");
        }
    }

    private User fromUser(NewUserDTO dto) {
        return new User(
        null,
            dto.getName(),
            dto.getEmail(),
            dto.getCpf(),
            dto.getPhone(),
            dto.getCity(),
            dto.getUf(),
            dto.getBirthDate(),
            dto.getCep(),
            dto.getAddress(),
            bCryptPasswordEncoder.encode(dto.getPassword())
        );
    }

    private User fromUser(UserDTO dto, User user){
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

}
