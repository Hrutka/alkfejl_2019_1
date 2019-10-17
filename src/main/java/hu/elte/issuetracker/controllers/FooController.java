/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Foo;
import hu.elte.issuetracker.repositories.FooRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KeresztiKrisztián
 */
@RestController
@RequestMapping("foos")
public class FooController {
  @Autowired
  private FooRepository fooRepository;

  @GetMapping("")
  public ResponseEntity<Iterable<Foo>> getAll() {
    return ResponseEntity.ok(fooRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Foo> get(@PathVariable Integer id) {
    Optional<Foo> foo = fooRepository.findById(id);
    if (!foo.isPresent())
    {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    return ResponseEntity.ok(foo.get());
  }

  @PostMapping("")
  public ResponseEntity<Foo> post(@RequestBody Foo foo) {
    Foo newFoo = fooRepository.save(foo);
    return ResponseEntity.ok(newFoo);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Integer id) {
    Optional<Foo> foo = fooRepository.findById(id);
    if (!foo.isPresent())
    {
      ResponseEntity.notFound();
    }
    
    fooRepository.delete(foo.get());
    
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Foo> put(@PathVariable Integer id, @RequestBody Foo foo) {
    Optional<Foo> oldFoo = fooRepository.findById(id);
    if (!oldFoo.isPresent())
    {
      ResponseEntity.notFound();
    }

    foo.setId(id);
    return ResponseEntity.ok(fooRepository.save(foo));
  }
}