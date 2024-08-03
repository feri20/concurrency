package com.wolf.concurrency;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {

    private ProductService service;

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filter(@RequestBody FilterRequest request) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Product>> productCompletableFuture = service.filterProduct(request);
        return ResponseEntity.ok(productCompletableFuture.get());
    }
    @GetMapping("/by-name")
    public ResponseEntity<Product> getByName(@RequestParam(name = "name")String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product) {
        return ResponseEntity.ok(service.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
