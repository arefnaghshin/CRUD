package guru.springframework.controllers;


import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


/**
     * Created by jt on 6/1/17.
     */
    @Controller
    public class IndexController {

        private CategoryRepository categoryRepository;
        private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
        public String getIndexPage(){
            Optional<Category> categoryOptional=categoryRepository.findByDescription("Italian");
            Optional<UnitOfMeasure> unitOfMeasure=unitOfMeasureRepository.findByDescription("Ounce");
           // Optional<Category> category=categoryRepository.findById(1);

            System.out.println("Cat Id is:" +categoryOptional.get().getId());
        System.out.println("unit of measure is:" + unitOfMeasure.get().getId());
            return "index";
        }
    }

