package com.korit.springboot.controller;

import com.korit.springboot.dto.InsertProductReqDto;
import com.korit.springboot.dto.InsertStudyReqDto;
import com.korit.springboot.dto.ProductDto;
import com.korit.springboot.mapper.ProductMapper;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MybatisController {

    @Autowired
    private StudyMapper studyMapper;
    @Autowired
    private ProductMapper productMapper;

//    @PostMapping("/mybatis/study")
//    public ResponseEntity<?> insert(
//         @RequestBody Map<String, Object> reqMap){
//        studyMapper.insert((String) reqMap.get("name"), (Integer) reqMap.get("age"));
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/mybatis/study")
    public ResponseEntity<?> insert(
            @RequestBody InsertStudyReqDto dto){
        studyMapper.insert(dto.getName(), dto.getAge());
        return ResponseEntity.ok().build();
    }


    @GetMapping("/mybatis/study/names")
    public ResponseEntity<List<String>> getNames(){
        return ResponseEntity.ok(studyMapper.findAllName());
    }

    @GetMapping("/mybatis/study")
    public ResponseEntity<List<Map<String, Object>>> getAll(){
        return ResponseEntity.ok(studyMapper.findAll());
    }


    @PostMapping("/mybatis/product")
    public ResponseEntity<?> insertProduct(@RequestBody InsertProductReqDto dto) {
        productMapper.insertProduct(dto.getSize(), dto.getProductName(), dto.getPrice());
        return ResponseEntity.ok().build();
    }

}
