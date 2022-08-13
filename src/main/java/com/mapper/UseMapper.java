package com.mapper;

import com.pojo.Use;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface UseMapper {
    public List<Use> getAllUse();

}
