package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.Use;

import java.util.List;

public interface UseService {
    public List<Use> getAllUse();

    PageInfo<Use> findByPage(Integer pageNum, Integer pageSize);
}
