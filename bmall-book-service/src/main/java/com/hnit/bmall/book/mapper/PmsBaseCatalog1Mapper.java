package com.hnit.bmall.book.mapper;

import com.hnit.bmall.bean.PmsBaseCatalog1;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsBaseCatalog1Mapper extends Mapper<PmsBaseCatalog1> {
    List<PmsBaseCatalog1> getCatalogs();
}