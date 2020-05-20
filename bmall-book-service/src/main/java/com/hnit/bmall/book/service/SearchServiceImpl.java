package com.hnit.bmall.book.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.hnit.bmall.bean.PmsBookAttrValue;
import com.hnit.bmall.bean.PmsBookInfo;
import com.hnit.bmall.bean.PmsSearchBook;
import com.hnit.bmall.bean.PmsSearchParams;
import com.hnit.bmall.service.SearchService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ouyoung
 * @date 2020/5/15
 **/
@Service
public class SearchServiceImpl implements SearchService {

    public JestClient getJestClient(){
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://192.168.249.131:9200")
                .build());
        JestClient jestClient= factory.getObject();
        return jestClient;
    }


    private String getSearchDsl(PmsSearchParams params) {
        Integer catalog2Id = params.getCatalog2Id();
        String keyWord = params.getKeyWord();
        String[] valueIds = params.getValueId();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        if (catalog2Id !=null){
            TermQueryBuilder termQueryBuilder = new TermQueryBuilder("catalog2Id",catalog2Id);
            boolQueryBuilder.filter(termQueryBuilder);
        }

        if (StringUtils.isNotBlank(keyWord)){
            MatchQueryBuilder title = new MatchQueryBuilder("title",keyWord);
//            MatchQueryBuilder description = new MatchQueryBuilder("description", keyWord);
            boolQueryBuilder.must(title);
        }


        if (valueIds!=null){
            for (String valueId : valueIds) {
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("pmsBookAttrValues.valueId",Integer.parseInt(valueId));
                boolQueryBuilder.filter(termQueryBuilder);
            }

        }

        searchSourceBuilder.query(boolQueryBuilder);
        //分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(20);

        //highlight
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span style='color:red;'>");
        highlightBuilder.field("title");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlight(highlightBuilder);

        //aggs
        TermsBuilder groupby_attr = AggregationBuilders.terms("groupby_attr").field("pmsBookAttrValues.valueId");
        searchSourceBuilder.aggregation(groupby_attr);

        return  searchSourceBuilder.toString();
    }

    @Override
    public List<PmsSearchBook> list(PmsSearchParams params) {
        String dsl = getSearchDsl(params);
//        System.out.println(dsl);
        Search search = new Search.Builder(dsl).addIndex("bookstudy").addType("PmsBookInfo").build();
        JestClient jestClient = getJestClient();
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<SearchResult.Hit<PmsSearchBook, Void>> hits = execute.getHits(PmsSearchBook.class);
        List<PmsSearchBook> pmsSearchBooks = new ArrayList<PmsSearchBook>();
        for (SearchResult.Hit<PmsSearchBook, Void> hit : hits) {
            PmsSearchBook pmsSearchBook = hit.source;
            Map<String, List<String>> highlight = hit.highlight;
            if (highlight != null){
                String title = highlight.get("title").get(0);
                pmsSearchBook.setTitle(title);
            }
            pmsSearchBooks.add(pmsSearchBook);

        }


        return pmsSearchBooks;
    }

}
