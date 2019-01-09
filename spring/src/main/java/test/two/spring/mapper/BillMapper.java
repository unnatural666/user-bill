package test.two.spring.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface BillMapper {

    @Insert("insert into billinfo values(0,'','','','','','','','',#{path})")
    int addPath(@Param("path") String path);

    @Update("update billinfo set account=#{account},eename=#{eename},billname=#{billname},money=#{money},billtime=#{billtime},flaw=#{flaw},want=#{want},endorse=#{endorse} where path=#{path}")
    int updateBill(@Param("account") String account,@Param("eename") String eename,@Param("billname") String billname,@Param("money") String money,@Param("billtime") String billtime,@Param("flaw") String flaw,@Param("want") String want,@Param("endorse") String endorse,@Param("path") String path);
}
