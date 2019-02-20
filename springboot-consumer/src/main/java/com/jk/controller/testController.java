package com.jk.controller;

import com.jk.model.Blogger;
import com.jk.model.Tree;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class testController {

    @Autowired
    private TestService myService;

    @GetMapping("/test")
    public String getDate(){
        String say = myService.say("你吃了吗");
        System.out.println(say);
        return say;
    }

    //登陆
    @RequestMapping("/loginuser")
    @ResponseBody
    public String loginuser(Blogger blogger) {
        String loginFlag = null;
        loginFlag = myService.login(blogger);
        return loginFlag;
    }
    //权限树
    @RequestMapping("findTree")
    @ResponseBody
    public List<Map<String, Object>> findTree(Integer id) {
        List<Tree> list = myService.findTree(id);
        return treeStr(list, 0);
    }

    public List<Map<String, Object>> treeStr(List<Tree> list, Integer pid) {

        // 定义返回变量
        List<Map<String, Object>> newlist = new ArrayList<Map<String, Object>>();
        // 循环所有数据
        for (int i = 0; i < list.size(); i++) {
            // 定义以个map集合 用来存放 单个节点数据
            Map<String, Object> map = null;
            // 获取单个对象数据
            Tree m = list.get(i);
            // 判断当前节点是否存在父节点
            if (m.getP_parentid().equals(pid)) {
                map = new HashMap<String, Object>();
                map.put("id", m.getP_id());
                map.put("text", m.getP_text());
                map.put("href", m.getP_href());
                map.put("icon", m.getP_icon());
                map.put("nodes", treeStr(list, m.getP_id()));
            }
            if (map != null) {
                // 获取子节点数据
                List<Map<String, Object>> l = (List<Map<String, Object>>) map.get("nodes");
                // 如果没有子节点数据 移除 nodes
                if (l.size() == 0) {
                    map.remove("nodes");
                }
                newlist.add(map);
            }
        }
        return newlist;
    }

}
