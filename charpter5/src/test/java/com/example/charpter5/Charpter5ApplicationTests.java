package com.example.charpter5;

import com.example.charpter5.pojo.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class Charpter5ApplicationTests {


    @Test
    void contextLoads() {

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

        //5.1  筛选
        //5.1.1  用谓词筛选
        List<Dish> vegetables = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        //5.1.2 筛选各异的元素
        List<String> stringList = Arrays.asList("2", "4", "6", "4", "4", "1", "3", "5");
        stringList.stream().filter(s -> Integer.parseInt(s) % 2 == 0).distinct().forEach(System.out::println);

        //测验5.1 筛选前两个类型为MEAT的菜
        List<Dish> top2MeatDishes = menu.stream().filter(dish -> Dish.Type.META == dish.getType()).limit(2).collect(Collectors.toList());

        //5.2 流的切片
        //5.2.1 使用谓词对流进行切片
        //使用java9的takeWhile和dropWhile

        //5.2.2 截短流
        //使用limit(n),该方法返回一个不超过给定长度的流，所需的长度作为参数n传递。如果流是排序好的，那么最多会返回前n个元素。
        List<Dish> dishes = menu.stream().filter(dish -> dish.getCalories() > 300).limit(3).collect(Collectors.toList());

        //5.2.3 跳过元素
        //使用skip(n),该方法返回一个扔掉了前n个元素的流。如果流的元素不足，则返回空流。
        List<Dish> dishList = menu.stream().filter(dish -> dish.getCalories() > 300).skip(2).collect(Collectors.toList());

        //5.3 映射
        //5.3.1 对流中每一个元素应用函数
        List<Integer> integerList = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        List<Integer> integers = menu.stream().map(dish -> dish.getName().length()).collect(Collectors.toList());

        //5.3.2 流的扁平化
        //flatMap把一个流的每一个值转变成新的一个流，然后把所有流连接起来成为一个流
        List<String> worlds = new ArrayList<>();
        worlds.add("Hello");
        worlds.add("World");
        List<String> strings = worlds.stream().map(world -> world.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());

    }

}
