package mx.edu.utez.Marketplace.category.controller;

import mx.edu.utez.Marketplace.category.model.Category;
import mx.edu.utez.Marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/")
    public ResponseEntity<Message>getAll(){
        return  categoryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id")long id){
        return categoryService.findById(id);
    }
    @PostMapping("/save")
    public ResponseEntity<Message>createCategory(@RequestBody CategoryBTO categoryBTO){
        Category category= new Category(categoryBTO.getDescripcion());
        return categoryService.save(category);
    }
    @PutMapping("/save")
    public ResponseEntity<Message>updateCategory(@RequestBody CategoryBTO categoryBTO){
        Category category= new Category(categoryBTO.getId(),categoryBTO.getDescripcion());
        return categoryService.save(category);
    }

}
