package com.exercise.mybatis.dao;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dir {
    private Long id;
    private Long parentId;
    private String dirName;
    private Long isAddDir;
    private List<Dir> children;
}
