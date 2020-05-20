package com.hnit.bmall.user.service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.hnit.bmall.bean.User;
import com.hnit.bmall.service.UserService;
import com.hnit.bmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ouyoung
 * @date 2020/4/20
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper ;

    @Override
    public User getUserById(String userid ) {
        User user = userMapper.selectByPrimaryKey(userid);
        return user ;
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
