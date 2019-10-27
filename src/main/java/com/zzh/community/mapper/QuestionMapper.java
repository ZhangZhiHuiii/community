package com.zzh.community.mapper;

import com.zzh.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values(#{title},#{description}," +
            "#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset")Integer offset,@Param(value = "size")Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question where creator = #{id}")
    Integer countById(@Param(value = "id") Integer id);

    @Select("select * from question where creator = #{id} limit #{offset},#{size}")
    List<Question> listByUserId(@Param(value = "id") Integer id,@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
}
