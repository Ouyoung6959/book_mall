package com.hnit.bmall.service;

import com.hnit.bmall.bean.*;
import org.bson.Document;

import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/3
 **/
public interface BookInfoService {
    List<PmsBookInfo> getBookList(Integer catalog2Id);

    Integer saveInfo(PmsBookInfo bookInfo);

    Integer deleteInfo(PmsBookInfo bookInfo);

    List<PmsBaseAttrInfo> getBaseAttrList();

    List<PmsBaseAttrValue> getBaseValueList(Integer attrId);

    void saveBookInfo(Map<Object, Object> bookInfo);

    List<Object> getRoutes(Integer username);

    List<User> getRoles();

    User addRole(Map<String, Object> map);

    void updateRole(Map<String, Object> map);

    void deleteRole(Integer id);

    PmsBookInfo getBookById(Integer bid);

    List<PmsBookInfo> getAssociateBook(Integer bid);

    List<PmsBookImages> getImages(Integer bid);

    List<PmsBookInfo> getAllBooks();


}
