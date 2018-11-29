package com.example.jsdengluprovider.dao;

import com.example.jsdengluprovider.pojo.Equipment;
import com.example.jsdengluprovider.pojo.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecordMessageDao {
    //查看登录信息
    @Select("SELECT COUNT(1) from equipment where IPconfig=#{IPconfig}")
    int recordSelect(@Param("IPconfig") String IPconfig);

    //增加IP信息
    @Insert("INSERT INTO recoed(userid,IPconfig) VALUES (#{userid},#{IPconfig})")
    int addRecord(Record record);

    //增加第一次登录绑定设备信息
    @Insert("INSERT INTO equipment(userid,time,equipmentname,IPconfig) VALUES (#{userid},#{time},#{equipmentname},#{IPconfig})")
    int addEquipment(Equipment equipment);
//@Param("userid") Integer userid,@Param("time") String time,@Param("IPconfig") String IPconfig

    //通过用户ID查到手机号码
    @Select("select phone from cardnumber where userid=#{userid}")
    String selectPhone(@Param("userid") Integer userid);


    //显示一个用户所有的登录信息
    @Select("select indate,IPconfig from recoed where userid=#{userid}")
    List<Record> selectAll(@Param("userid")Integer userid);

    /**
     * 忘记密码
     */
    //用户输入银行卡号和密码判断是否有次用户，获得该用户id
    @Select("select userid from cardnumber where cardnum=#{cardnum} and userpwd=#{userpwd}")
    String selectCardnum(@Param("cardnum")String cardnum,@Param("userpwd")String userpwd);
    //用户输入姓名和身份证判断是否有次用户，获得该用户id
    @Select("select userid from bankuser where name=#{name} and idcard=#{idcard}")
    String getIdcard(@Param("name")String name,@Param("idcard") String idcard);
    //用户输入新密码，进行修改网银密码
    @Update("update cardnumber set webpwd=#{webpwd} where userid=#{userid}")
    int UpdateWebpwd(@Param("webpwd")String webpwd,@Param("userid")Integer userid);



}
