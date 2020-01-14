package com.shenruan.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shenruan.mybatisplus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        System.out.println(("-------selectAll method test-------"));
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectById(){

        QueryWrapper<User> wrapper=  new QueryWrapper<User>();
        wrapper.like("name","o");
        List <User>list = this.userMapper.selectList(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }


    @Test
    public void testSelectByLe(){

        QueryWrapper<User> wrapper=  new QueryWrapper<User>();
        wrapper.le("age",20);
        List <User>list = this.userMapper.selectList(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 保存
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setAge(25);
        user.setEmail("zhangsan@qq.com");
        user.setName("zhangsan");
        int count = this.userMapper.insert(user);
        System.out.println("新增数据成功! count=>"+count);
    }


    /**
     * 删除
     */
    @Test
    public void testDelete(){
        this.userMapper.deleteById(7L);
        System.out.println("删除成功!");
    }

    /**
     * 修改
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(6L);
        user.setName("lisi");
        int count = this.userMapper.updateById(user);
        System.out.println("修改数据成功! ");
    }


    @Test
    public void testSelectPage(){
        Page<User> page = new Page<>(2, 2);//第几页; 2条数据
        IPage<User> userIPage =this.userMapper.selectPage(page,null);
        System.out.println("总条数----->"+userIPage.getTotal());
        System.out.println("当前页数---->"+userIPage.getCurrent());
        System.out.println("当前每页显示页数---->"+userIPage.getSize());

        List<User> records = userIPage.getRecords();
        for (User user : records) {
            System.out.println(user);
        }
    }

}
