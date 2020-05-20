package com.hnit.bmall.manage.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hnit.bmall.bean.UmsMember;
import com.hnit.bmall.bean.User;
import com.hnit.bmall.manage.mapper.UserMapper;
import com.hnit.bmall.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/4/20
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper ;

    @Override
    public User getUserById(Integer userid ) {
        User base_user =new User();
        base_user.setUsername(userid);

        List<User> selectUsers = userMapper.select(base_user);


        return selectUsers.get(0) ;
    }

//
//    @Autowired
//    UmsMemberMapper umsMemberMapper ;
//
//    @Override
//    public List<UmsMember> getAllUser() {
//        List<UmsMember> umsMembers = umsMemberMapper.selectAll();
//
//
//        return umsMembers;
//    }
//

}
