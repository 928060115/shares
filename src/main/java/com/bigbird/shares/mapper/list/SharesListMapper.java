package com.bigbird.shares.mapper.list;

import com.bigbird.shares.pojo.list.SharesList;

public interface SharesListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SharesList record);

    int insertSelective(SharesList record);

    SharesList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SharesList record);

    int updateByPrimaryKey(SharesList record);
}