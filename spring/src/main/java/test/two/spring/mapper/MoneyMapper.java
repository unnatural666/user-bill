package test.two.spring.mapper;

import org.apache.ibatis.annotations.*;
import test.two.spring.bean.money;

@Mapper
public interface MoneyMapper {
    @Select("select * from money where account=#{account}")
    money findMoneyByAccount(@Param("account") String account);

    @Insert("insert into money values(0,#{account},#{eename},0,0,0)")
    int addMoneyInfo(@Param("account") String account,@Param("eename") String eename);

    @Update("update money set money=#{money},time=#{time} where account=#{account}")
    int charge(@Param("money") int money,@Param("time") int time,@Param("account") String account);

}
