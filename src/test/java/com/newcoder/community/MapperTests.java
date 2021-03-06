package com.newcoder.community;


import com.newcoder.community.dao.DiscussPostMapper;
import com.newcoder.community.dao.MessageMapper;
import com.newcoder.community.dao.UserMapper;
import com.newcoder.community.entity.DiscussPost;
import com.newcoder.community.entity.Message;
import com.newcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testSelectByName() {
        String username = "liubei";
        User liubei = userMapper.selectByName(username);
        System.out.println(liubei);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("毕然");
        user.setPassword("1996626B");
        user.setEmail("1534283696@qq.com");
        int i = userMapper.insertUser(user);
        System.out.println(i);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateStatus() {
        int i = userMapper.updateStatus(154, 1);
        System.out.println(i);
        User user = userMapper.selectById(154);
        System.out.println(user);
    }

    @Test
    public void testSelectDiscussPosts() {
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10, 0);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
        int i = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(i);
    }

    @Test
    public void testLetters() {
        List<Message> messages = messageMapper.selectConversations(111, 0, 20);
        for (Message message : messages) {
            System.out.println(message);
        }

        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);

        messages = messageMapper.selectLetters("111_112", 0, 10);
        for (Message message : messages) {
            System.out.println(message);
        }

        count = messageMapper.selectLetterCount("111_112");
        System.out.println(count);

        count = messageMapper.selectLetterUnreadCount(131, "111_131");
        System.out.println(count);
    }
}
