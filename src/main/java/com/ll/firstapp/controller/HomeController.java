package com.ll.firstapp.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        String name = "mingu";
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("username", "kim");
        model.addAttribute("age", "25");
        model.addAttribute("city", "seoul");

        return "user";
    }

    @GetMapping("/fruits")
    public String fruits(Model model) {
        List<String> fruitList = new ArrayList<>();
        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("orange");

        model.addAttribute("fruits", fruitList);

        return "fruits.html";
    }

    @GetMapping("/grade")
    public String grade(Model model) {
        int socre = 88;
        model.addAttribute("score", socre);
        return "grade";
    }

    @GetMapping("/lunch")
    public String lunch(Model model) {
        List<String> menus = Arrays.asList("김밥", "라면", "돈까스");

        Random random = new Random();
        String pick = menus.get(random.nextInt(menus.size()));

        model.addAttribute("pick", pick);
        return "lunch";
    }

    @GetMapping("/lotto")
    public String lotto(Model model) {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lucky = numbers.subList(0, 6);

        model.addAttribute("lucky", lucky);
        return "lotto";
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "profile";
    }

    @GetMapping("/cube/{number}")
    public String cube(@PathVariable int number, Model model) {
        int result = number * number * number;
        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "cube";
    }

    @GetMapping("/odd/{number}")
    public String odd(@PathVariable int number, Model model) {
        String result = (number % 2 == 0) ? "짝수" : "홀수";

        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "odd";
    }

    @GetMapping("/age/{number}")
    public String age(@PathVariable int number, Model model) {
        int result =0;
        if (number > 1900 && number <= 2025) {
            result = 2025 - number;
        }

        model.addAttribute("number", number);
        model.addAttribute("result", result);
        return "age";
    }

}
