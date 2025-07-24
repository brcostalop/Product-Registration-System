package com.brcostalop.products.controller;

import com.brcostalop.products.entity.Product;
import com.brcostalop.products.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

//    @Autowired
//    private ProductRepository productRepository;

//    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ApiResponse.successFactory("Olá mundo");
    }

    @PostMapping("/hello")
    public ResponseEntity<Product> hi(@RequestBody Product name) {
        return ApiResponse.successFactory(name);
    }

    @PutMapping("/hello/{id}")
    public ResponseEntity<String> update(@PathVariable(value = "id") Long id,
                                             @RequestBody String name) {
        return ApiResponse.successFactory("Alterar mundo " + id);
    }

    @DeleteMapping("/hello/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ApiResponse.successFactory("Apagar mundo " + id);
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Product>> listAll() {
//        return ApiResponse.successFactory(productRepository.findAll());
//    }

//    @PostMapping("/save")
//    public ResponseEntity<String> save(@RequestBody Product product) {
//        productService.criarProduto(product);
//        return ApiResponse.successFactory();
//    }

}
