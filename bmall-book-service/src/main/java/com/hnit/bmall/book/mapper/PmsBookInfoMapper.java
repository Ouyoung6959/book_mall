package com.hnit.bmall.book.mapper;
import com.hnit.bmall.bean.PmsBookInfo;
import tk.mybatis.mapper.common.Mapper;

public interface PmsBookInfoMapper extends Mapper<PmsBookInfo> {
    Integer insertBackId(PmsBookInfo pmsBookInfo);
}