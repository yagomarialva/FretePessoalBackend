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
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    /*GET*/
//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = service.getUserList();
        List<UserDTO> dtos = users.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    /*POST*/
    @PostMapping
    public ResponseEntity<User> save(@RequestBody NewUserDTO dto){
//        TODO: add @Valid
        User body = service.save(dto);
        return ResponseEntity.ok().body(body);
    }

    /*PUT*/
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
