package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.TestDao;
import com.jk.model.Blogger;
import com.jk.model.Tree;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public String say(String something) {
        return "小明说的"+something;
    }

    @Override
    public String login(Blogger blogger) {
        List<Blogger> list = testDao.getTestNameIsNull(blogger);
        if (list.size() == 1) {
            if (blogger.getPassword().equals(list.get(0).getPassword())) {
                return "loginSuccess";
            } else {
                return "userPassNo";
            }
        } else {
            return "userNameNO";
        }
    }

    @Override
    public List<Tree> findTree(Integer pid) {
        return testDao.findTree(pid);
    }


}
