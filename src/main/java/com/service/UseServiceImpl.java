package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UseMapper;
import com.pojo.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UseServiceImpl implements UseService{
    @Autowired
    private UseMapper useMapper;
    @Override
    public List<Use> getAllUse() {
        return useMapper.getAllUse();
    }

    @Override
    public PageInfo<Use> findByPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Use> uu = useMapper.getAllUse();
        PageInfo<Use> pageInfo = new PageInfo<Use>(uu);
        return pageInfo;
    }
}
