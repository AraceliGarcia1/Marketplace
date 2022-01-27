package mx.edu.utez.Marketplace.category.controller;

import mx.edu.utez.Marketplace.category.model.Category;
import mx.edu.utez.Marketplace.category.model.CategoryRepository;
import mx.edu.utez.Marketplace.utils.Message;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Transactional
    public ResponseEntity<Message>findAll(){
        return new ResponseEntity<>(new Message("ok", false,categoryRepository.findAll()), HttpStatus.OK);
    }
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message>save(Category category){
        Optional<Category> existsCategory= categoryRepository.findByDescription(category.getDescription());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("La categoria ya existe", true, null),
                    HttpStatus.BAD_REQUEST);

        }
        Category savedCategory= categoryRepository.saveAndFlush(category);
        return new ResponseEntity<>(new Message("La categoria registrada", false, savedCategory),HttpStatus.OK);
    }
    @Transactional(rollbackOn ={SQLException.class} )
    public ResponseEntity<Message>update(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            return new ResponseEntity<>(new Message("Categoria actualiza", false, categoryRepository.saveAndFlush(category)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Categoria actualiza", false, null), HttpStatus.BAD_REQUEST);
    }
    @Transactional
    public ResponseEntity<Message>findById(long id){
        if (categoryRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok",false,categoryRepository.findById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("No se enocntro la categoria",true, null),HttpStatus.BAD_REQUEST);
    }
}
