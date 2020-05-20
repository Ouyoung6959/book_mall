package com.hnit.bmall.service;

import com.hnit.bmall.bean.UmsMember;
import com.hnit.bmall.bean.User;

import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/4/20
 **/
public interface UserService {
   // List<UmsMember> getAllUser();

    User getUserById(Integer userid);
}
