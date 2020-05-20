package com.hnit.bmall.book.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.hnit.bmall.bean.*;
import com.hnit.bmall.book.mapper.*;
import com.hnit.bmall.book.utils.MongoDBUtil;
import com.hnit.bmall.service.BookInfoService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.sf.json.JSONObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author Ouyoung
 * @date 2020/5/3
 **/
@Service
public class BookInfoServiceImpl implements BookInfoService {

    MongoDatabase connect = MongoDBUtil.getConnect();

    @Autowired
    PmsBookInfoMapper pmsBookInfoMapper;

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    PmsBookAttrValueMapper pmsBookAttrValueMapper;

    @Autowired
    PmsBookImagesMapper pmsBookImagesMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PmsBookAssociateMapper pmsBookAssociateMapper;


    @Override
    public List<PmsBookInfo> getBookList(Integer catalog2Id) {
        PmsBookInfo pmsBookInfo = new PmsBookInfo();
        pmsBookInfo.setCatalog2Id(catalog2Id);

        List<PmsBookInfo> pmsBookInfos = pmsBookInfoMapper.select(pmsBookInfo);
        return  pmsBookInfos;
    }

    @Override
    public Integer saveInfo(PmsBookInfo bookInfo) {
        return pmsBookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    @Override
    public Integer deleteInfo(PmsBookInfo bookInfo) {
        return pmsBookInfoMapper.delete(bookInfo);
    }

    @Override
    public List<PmsBaseAttrInfo> getBaseAttrList() {
        return  pmsBaseAttrInfoMapper.selectAll();
    }

    @Override
    public List<PmsBaseAttrValue> getBaseValueList(Integer attrId) {
        PmsBaseAttrValue attrValue = new PmsBaseAttrValue();
        attrValue.setAttrId(attrId);
        return pmsBaseAttrValueMapper.select(attrValue);
    }

    @Override
    public void saveBookInfo(Map<Object, Object> bookInfo) {
        PmsBookInfo pmsBookInfo = new PmsBookInfo();
        pmsBookInfo.setTitle((String) bookInfo.get("title"));
        pmsBookInfo.setCatalog2Id((Integer)bookInfo.get("catalog2Id"));
        pmsBookInfo.setDescription((String) bookInfo.get("description"));
        pmsBookInfo.setPrice((String) bookInfo.get("price"));
        pmsBookInfo.setPubilshTime((String) bookInfo.get("pubilshTime"));


        List<Map<String ,Object>> bookAttrValueList = (List<Map<String, Object>>) bookInfo.get("BookAttrValueList");
        List<Map<String ,Object>> bookImageList = (List<Map<String, Object>>) bookInfo.get("BookImageList");

        pmsBookInfo.setImageUrl((String) bookImageList.get(0).get("imgUrl"));

        pmsBookInfoMapper.insert(pmsBookInfo);
        Integer bid = pmsBookInfo.getBid();
        System.out.println("bid:"+bid);
        for (Map<String ,Object> bookAttrValue: bookAttrValueList){
            PmsBookAttrValue attrValue = new PmsBookAttrValue();
            attrValue.setBid(bid);
            attrValue.setAttrId((Integer) bookAttrValue.get("attrId"));
            attrValue.setValueId((Integer) bookAttrValue.get("valueId"));
            pmsBookAttrValueMapper.insert(attrValue);
        }

        for (Map<String ,Object> bookImage: bookImageList){
            PmsBookImages bookImages = new PmsBookImages();
            bookImages.setBid(bid);
            bookImages.setImageName((String) bookImage.get("imgName"));
            bookImages.setImageUrl((String) bookImage.get("imgUrl"));
            pmsBookImagesMapper.insert(bookImages);
        }
    }

    @Override
    public List<Object > getRoutes(Integer username) {
        MongoCollection<Document> admin = connect.getCollection(String.valueOf(username));
        FindIterable<Document> documents = admin.find();
        List<Object> list = new ArrayList<>();
        for(Document document :documents){
            document.remove("_id");
            list.add( document.toJson());
        }
        return list;
    }

    @Override
    public List<User> getRoles() {
        return userMapper.selectAll();
    }

    @Override
    public User addRole(Map<String, Object> map) {
        User user = new User();
        user.setName((String) map.get("name"));
        user.setRole((String) map.get("role"));
        user.setPassword("88888888");
        userMapper.insert(user);
        Integer username = user.getUsername();
        List<Map<String,Object>> routes = (List<Map<String, Object>>) map.get("routes");
        List<Document> list = new ArrayList<>();
        for (Map<String,Object> route:routes){
            JSONObject jsonObject = JSONObject.fromObject(route);
            String json = jsonObject.toString();
            Document doc = Document.parse(json);
            list.add(doc);
        }
        connect.getCollection(String.valueOf(username)).insertMany(list);

        return user;
    }

    @Override
    public void updateRole(Map<String, Object> map) {
        User user =new User();
        user.setUsername((Integer) map.get("username"));
        user.setName((String) map.get("name"));
        user.setRole((String) map.get("role"));
        userMapper.updateByPrimaryKey(user);

        Integer username1 = (Integer) map.get("username");
        MongoCollection<Document> username = connect.getCollection(String.valueOf(username1));
        username.deleteMany(new Document());

        List<Map<String,Object>> routes = (List<Map<String, Object>>) map.get("routes");
        List<Document> list = new ArrayList<>();
        for (Map<String,Object> route:routes){
            JSONObject jsonObject = JSONObject.fromObject(route);
            String json = jsonObject.toString();
            Document doc = Document.parse(json);
            list.add(doc);
        }
        connect.getCollection(String.valueOf(username1)).insertMany(list);
    }

    @Override
    public void deleteRole(Integer id) {
        userMapper.deleteByPrimaryKey(id);
        connect.getCollection(String.valueOf(id)).deleteMany(new Document());

    }

    @Override
    public PmsBookInfo getBookById(Integer bid) {
        return pmsBookInfoMapper.selectByPrimaryKey(bid);
    }

    @Override
    public List<PmsBookInfo> getAssociateBook(Integer bid) {
        PmsBookAssociate pmsBookAssociate = new PmsBookAssociate();
        pmsBookAssociate.setBid(bid);
        List<PmsBookAssociate> pmsBookAssociates = pmsBookAssociateMapper.select(pmsBookAssociate);
        List<PmsBookInfo> pmsBookInfos =new ArrayList<PmsBookInfo>();
        for (PmsBookAssociate bookAssociate :pmsBookAssociates){
            PmsBookInfo pmsBookInfo = pmsBookInfoMapper.selectByPrimaryKey(bookAssociate.getAssociatedId());
            pmsBookInfos.add(pmsBookInfo);
        }
        return pmsBookInfos;
    }

    @Override
    public List<PmsBookImages> getImages(Integer bid) {
        PmsBookImages pmsBookImage = new PmsBookImages();
        pmsBookImage.setBid(bid);
        List<PmsBookImages> pmsBookImages = pmsBookImagesMapper.select(pmsBookImage);
        return  pmsBookImages;
    }

    @Override
    public List<PmsBookInfo> getAllBooks() {
        List<PmsBookInfo> pmsBookInfos = pmsBookInfoMapper.selectAll();
        for (PmsBookInfo pmsBookInfo : pmsBookInfos) {
            Integer bid = pmsBookInfo.getBid();
            PmsBookAttrValue attrValue = new PmsBookAttrValue();
            attrValue.setBid(bid);
            List<PmsBookAttrValue> pmsBookAttrValues = pmsBookAttrValueMapper.select(attrValue);
            pmsBookInfo.setPmsBookAttrValues(pmsBookAttrValues);
        }
        return pmsBookInfos;
    }

}
