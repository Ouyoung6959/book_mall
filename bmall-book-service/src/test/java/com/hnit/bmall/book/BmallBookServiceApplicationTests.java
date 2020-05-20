package com.hnit.bmall.book;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.gson.JsonObject;
import com.hnit.bmall.bean.PmsBookInfo;
import com.hnit.bmall.bean.PmsSearchBook;
import com.hnit.bmall.service.BookInfoService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.apache.commons.beanutils.BeanUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BmallBookServiceApplicationTests {

    @Reference
    BookInfoService bookInfoService ;


    @Test
    public void contextLoads() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //match
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("title","娜");

        //term
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("pmsBookAttrValues.valueId",47);

        // bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.filter(termQueryBuilder);
        boolQueryBuilder.must(matchQueryBuilder);

        //query size from highlight  分页
        //  searchSourceBuilder.from(0);
        //  searchSourceBuilder.size(20);
        //  searchSourceBuilder.highlight();
        searchSourceBuilder.query(boolQueryBuilder);
        String dslStr = searchSourceBuilder.toString();

        Search search = new Search.Builder(dslStr).addIndex("bookstudy").addType("PmsBookInfo").build();
        JestClient jestClient = getJestClient();
        JestResult execute = jestClient.execute(search);
        List<PmsSearchBook> pmsSearchBooks = execute.getSourceAsObjectList(PmsSearchBook.class);

    }

    public JestClient getJestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://192.168.249.131:9200")
                .build());
        JestClient jestClient= factory.getObject();
        return jestClient;
    }

    @Test
    public void put() throws InvocationTargetException, IllegalAccessException, IOException {

        JestClient jestClient = getJestClient();
        List<PmsBookInfo> pmsBookInfos = bookInfoService.getAllBooks();

        List<PmsSearchBook> pmsSearchBooks = new ArrayList<>();

        for (PmsBookInfo pmsBookInfo : pmsBookInfos) {
            PmsSearchBook pmsSearchBook = new PmsSearchBook();
            BeanUtils.copyProperties(pmsSearchBook,pmsBookInfo);
            pmsSearchBooks.add(pmsSearchBook);
        }

        for (PmsSearchBook pmsSearchBook : pmsSearchBooks) {

            Index put = new Index.Builder(pmsSearchBook).index("bookstudy").type("PmsBookInfo").id(String.valueOf(pmsSearchBook.getBid())).build();
            jestClient.execute(put);
        }
    }



}
