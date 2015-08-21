package com.vv.dao.inter;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.vv.base.pojo.AppNews;
import com.vv.base.pojo.AppNewsExample;

public interface AppNewsMapper {
    int countByExample(AppNewsExample example);

    int deleteByExample(AppNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppNews record);

    int insertSelective(AppNews record);

    List<AppNews> selectByExampleWithBLOBs(AppNewsExample example);

    List<AppNews> selectByExample(AppNewsExample example);

    AppNews selectByPrimaryKey(Integer id);
    @Select("select * from app_news limit #{pageNo},#{num}")
    List<AppNews> selectByPrimaryKey2(@Param("pageNo") Integer pageNo,@Param("num") Integer num);
    @Select("select id from app_news limit #{pageNo},#{num}")
    List<AppNews> selectByPrimaryKey3(@Param("pageNo") Integer pageNo,@Param("num") Integer num);

    int updateByExampleSelective(@Param("record") AppNews record, @Param("example") AppNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") AppNews record, @Param("example") AppNewsExample example);

    int updateByExample(@Param("record") AppNews record, @Param("example") AppNewsExample example);

    int updateByPrimaryKeySelective(AppNews record);

    int updateByPrimaryKeyWithBLOBs(AppNews record);

    int updateByPrimaryKey(AppNews record);
}