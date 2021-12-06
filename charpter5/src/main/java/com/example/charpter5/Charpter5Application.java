package com.example.charpter5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Charpter5Application {

    public static void main(String[] args) {
        SpringApplication.run(Charpter5Application.class, args);

        //筛选  切片  映射  查找  匹配  规约
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = numberList.stream().map(num -> num * num).collect(Collectors.toList());
        collect.stream().forEach(number ->{
            System.out.println(number);

        });
    }

}
