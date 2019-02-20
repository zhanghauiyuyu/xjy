package com.jk.dao;

import com.jk.model.Blogger;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDao {
    @Select("SELECT * FROM  t_blogger s WHERE s.`username`=#{username}")
    List<Blogger> getTestNameIsNull(Blogger blogger);

    @Select("SELECT * FROM t_tree  r ")
    List<Tree> findTree(Integer pid);
}
