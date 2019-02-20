package com.jk.service;

import com.jk.model.Blogger;
import com.jk.model.Tree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TestService {

    String say(String something);

    String login(Blogger blogger);

    List<Tree> findTree(Integer pid);
}
