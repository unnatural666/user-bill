package test.two.spring.mapper;

import org.apache.ibatis.annotations.*;
import test.two.spring.bean.billInfo;

import java.util.List;

@Mapper
public interface BillMapper {

    @Insert("insert into billinfo values(0,'','','','','','','','',#{path})")
    int addPath(@Param("path") String path);

    @Update("update billinfo set account=#{account},eename=#{eename},billname=#{billname},money=#{money},billtime=#{billtime},flaw=#{flaw},want=#{want},endorse=#{endorse} where path=#{path}")
    int updateBill(@Param("account") String account,@Param("eename") String eename,@Param("billname") String billname,@Param("money") String money,@Param("billtime") String billtime,@Param("flaw") String flaw,@Param("want") String want,@Param("endorse") String endorse,@Param("path") String path);

    @Select("select * from billinfo")
    List<billInfo> showAllBill();

    @Select("select * from billinfo where billname=#{billname}")
    billInfo showBillInfo(@Param("billname") String billname);

    @Select("select * from billinfo where account=#{account}")
    billInfo showMyBill(@Param("account") String account);
}
