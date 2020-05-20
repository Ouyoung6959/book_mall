package com.hnit.bmall.book.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/8
 **/
public class MockRoutes {

    public static List getRoutes() {
        String path = "path";
        String component ="component";
        String hidden ="hidden";
        String redirect ="redirect";
        String name= "name" ;
        String children="children";
        String meta ="meta";
        String title="title";
        String icon ="icon";
        String affix ="affix";

        ArrayList<Object> Routes = new ArrayList<>();

        HashMap<String, Object> map0 = new HashMap<>();
        map0.put(path,"/redirect");
        map0.put(component,"layout/Layout");
        map0.put(hidden,true);
        ArrayList<Map<String, Object>> Map0childrens = new ArrayList<>();
        HashMap<String, Object> Map0children = new HashMap<>();
        Map0children.put(path,"/redirect/:path*");
        Map0children.put(component,"views/redirect/index");
        Map0childrens.add(Map0children);

        map0.put(children,Map0childrens);
        Routes.add(map0);

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put(path,"/login");
        map1.put(component,"views/login/index");
        map1.put(hidden,true);
        Routes.add(map1);

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(path,"/auth-redirect");
        map2.put(component,"views/login/auth-redirect");
        map2.put(hidden,true);
        Routes.add(map2);

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put(path,"");
        map3.put(component,"layout/Layout");
        map3.put(redirect,"dashboard");

        ArrayList<Map<String, Object>> Map3childrens = new ArrayList<>();
        HashMap<String, Object> Map3children = new HashMap<>();
        Map3children.put(path,"dashboard");
        Map3children.put(component,"views/dashboard/index");
        Map3children.put(name,"Dashboard");
        HashMap<String, Object> metaMap = new HashMap<>();
        metaMap.put(title,"dashboard");
        metaMap.put(icon,"dashboard");
        metaMap.put(affix,true);
        Map3children.put(meta,metaMap);
        Map3childrens.add(Map3children);
        map3.put(children,Map3childrens);
        Routes.add(map3);

        HashMap<String, Object> map4 = new HashMap<>();
        map4.put(path,"/401");
        map4.put(component,"views/error-page/401");
        map4.put(hidden,true);
        Routes.add(map4);

        // book-info
        HashMap<String, Object> map5 = new HashMap<>();
        map5.put(path,"/book-info");
        map5.put(component,"Layout");
        map5.put(redirect,"/book-info/book-list");
        map5.put(name,"BookInfo");
        HashMap<String, Object> book_info_metaMap = new HashMap<>();
        book_info_metaMap.put(title,"BookInfo");
        book_info_metaMap.put(icon,"table");
        map5.put("meta",book_info_metaMap);
        map5.put("alwaysShow",true);
        ArrayList<Map<String, Object>> book_info_childrens = new ArrayList<>();
        HashMap<String, Object> book_info_children1 = new HashMap<>();
        book_info_children1.put(path,"book-list");
        book_info_children1.put(name,"bookList");
        book_info_children1.put(component,"views/book-info/book-list");
        HashMap<String, Object> bookListMeta= new HashMap<>();
        book_info_metaMap.put(title,"bookList");
        book_info_children1.put(meta,book_info_metaMap);
        book_info_childrens.add(book_info_children1);
        HashMap<String, Object> book_info_children2 = new HashMap<>();
        book_info_children2.put(path,"book-upload");
        book_info_children2.put(name,"bookUpload");
        book_info_children2.put(component,"views/book-info/book-upload");
        HashMap<String, Object> bookListMeta2= new HashMap<>();
        bookListMeta2.put(title,"bookUpload");
        book_info_children2.put(meta,bookListMeta2);
        book_info_childrens.add(book_info_children2);
        map5.put(children,book_info_childrens);
        Routes.add(map5);

        return  Routes;
    }
}
