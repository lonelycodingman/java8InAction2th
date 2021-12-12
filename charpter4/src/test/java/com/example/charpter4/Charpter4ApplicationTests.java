package com.example.charpter4;

import com.example.charpter4.pojo.Dish;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class Charpter4ApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void test(){

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.META),
                new Dish("beef", false, 700, Dish.Type.META),
                new Dish("chicken", false, 400, Dish.Type.META),
                new Dish("french", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        //流的定义： 从支持数据处理操作的源生成的元素序列
        //流的使用一般包括三件事情： 1.数据源   2.中间操作  3.终端操作

        //找出所有的蔬菜
        List<Dish> vegetables = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        //筛选出热量最高的三个菜
        List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());

    }

}
