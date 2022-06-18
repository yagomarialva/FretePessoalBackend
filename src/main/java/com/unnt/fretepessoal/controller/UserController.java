package com.unnt.fretepessoal.controller;

import com.unnt.fretepessoal.dto.NewUserDTO;
import com.unnt.fretepessoal.dto.UserDTO;
import com.unnt.fretepessoal.model.User;
import com.unnt.fretepessoal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<UserDTO> findAll(@RequestParam() String query){
        return service.getUserList();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> saveApp(@RequestBody NewUserDTO dto) {
        User body = service.saveApp(dto);
        return ResponseEntity.ok().body(body);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody NewUserDTO dto){
//        TODO: add @Valid
        User body = service.save(dto);
        return ResponseEntity.ok().body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody UserDTO dto){
//      TODO: add @Valid
        User body = service.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    /*DELETE*/
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
