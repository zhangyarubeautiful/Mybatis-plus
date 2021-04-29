package com.xihua;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xihua.dao.PersonMapper;
import com.xihua.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatisPlus {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = personMapper.selectList(null);
        userList.forEach(System.out::println);
        Assert.assertEquals(7, userList.size());
    }

    @Test
    public void testSelectById() {
        System.out.println(("----- selectByID method test ------"));
        User user = personMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectOne() {
        System.out.println(("----- SelectOne method test ------"));
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id",1).eq("name","Jone");
        User user = personMapper.selectOne(qw);
        System.out.println(user);
    }

    @Test
    public void testselectBatchIds() {
        System.out.println(("----- selectBatchIds method test ------"));
        List<User> users = personMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
        Assert.assertEquals(3,users.size());
    }

    @Test
    public void testselectByMap() {
        System.out.println(("----- selectByMap method test ------"));
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("id",1);
        queryMap.put("name","Jone");
        List<User> users = personMapper.selectByMap(queryMap);
        users.forEach(System.out::println);
        Assert.assertEquals(3,users.size());
    }

    /**
     * 需要配置分页插件MybatisPlusConfig
     */
    @Test
    public void testselectPage() {
        System.out.println(("----- selectPage method test ------"));
        /*Page<User> userPage = personMapper.selectPage(new Page<>(3, 2), null);*/
        Page<User> userPage = personMapper.selectPage(new Page<>(1, 2), new QueryWrapper<User>().between("age", 18, 20));
        List<User> users = userPage.getRecords();
        users.forEach(System.out::println);
        Assert.assertEquals(2,users.size());
    }

    @Test
    public void testInsert() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setName("liudehua");
        user.setAge(52);
        user.setEmail("liudehua@vip.qq.com");
        int insert = personMapper.insert(user);
        Assert.assertEquals(5, insert);
    }

    @Test
    public void testInsertAll() {
        System.out.println(("----- insertAll method test ------"));
        User user = new User();
        user.setName("insertAll");
        user.setAge(0);
        user.setEmail("insertAll@mybatis_plus.com");
        int insert = personMapper.myInsertAll(user);
        Assert.assertEquals(1, insert);
    }

    @Test
    public void testDeleteById() {
        System.out.println(("----- delete method test ------"));
        int delete = personMapper.deleteById(9L);
        Assert.assertEquals(5, delete);
    }

    @Test
    public void testUpdate() {
        System.out.println(("----- update method test ------"));
        User user = new User();
        user.setId(9);
        user.setName("liudehua");
        int update = personMapper.updateById(user);
        Assert.assertEquals(5, update);
    }
}
