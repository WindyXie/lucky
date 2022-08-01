package com.exercise.useSpringBoot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.mybatis.dao.Dir;
import com.exercise.mybatis.dao.dirMapper;

@RestController
@RequestMapping(value = "/xx")
public class ShowController {
    @Resource
    dirMapper dirMapper;

    @GetMapping("/get")
    public List<Dir> get() {
        return dirMapper.sel();
    }
}
