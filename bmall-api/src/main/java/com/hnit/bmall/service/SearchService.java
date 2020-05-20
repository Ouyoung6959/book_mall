package com.hnit.bmall.service;

import com.hnit.bmall.bean.PmsBookInfo;
import com.hnit.bmall.bean.PmsSearchBook;
import com.hnit.bmall.bean.PmsSearchParams;

import java.util.List;

/**
 * @author Ouyoung
 * @date 2020/5/15
 **/
public interface SearchService {
    List<PmsSearchBook> list(PmsSearchParams pmsSearchParams);
}
