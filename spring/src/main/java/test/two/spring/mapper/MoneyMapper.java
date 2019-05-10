package test.two.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import test.two.spring.bean.money;

@Mapper
public interface MoneyMapper {
    @Select("select * from money where account=#{account}")
    money findMoneyByAccount(@Param("account") String account);

    @Insert("insert into money values(0,#{account},0,0,0)")
    int addMoneyInfo(@Param("account") String account);
}
