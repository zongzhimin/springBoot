package com.zzm.test.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



public interface ShipDao {
//	@Select("select id,name,ipaddr,loadstation,status from t_ship where NAME= #{shipName}")
//	@Results({
//		@Result(property = "id",column = "id"),
//		@Result(property = "name",column = "name"),
//		@Result(property = "ipaddr",column = "ipaddr"),
//		@Result(property = "loadstation",column = "loadstation"),
//		@Result(property = "status",column = "status"),
//	})
//	public Ship querShoreByShipName(String shipName);
//	
//	@Select("select id,name,ipaddr,loadstation,status from t_ship")
//	public List<Ship> query();
//	
////	@Select("SELECT s.chnName,c.seaPhone FROM t_ship s ,t_commset c WHERE s.`id`=c.`shipId`")
////	@Results({
////		@Result(property = "name",column="chnName"),
////		@Result(property = "seaPhone",column="seaPhone")
////	})
////	public List<Ship> queryAllShip();
//	
//	@Select("select chnName from t_ship where id =#{ id}")
//	public String queryNameById(int id);
//	
////	@Select("SELECT loginIp FROM t_crew WHERE loginSetSn = #{seaPhone} ORDER BY loginTime DESC LIMIT 1")
////	public String queryIpaddrBySeaphone(String seaPhone);
//	
//	@Insert("INSERT INTO t_ship (NAME,ipaddr,loadstation) VALUES(#{name},#{ipaddr},#{loadstation})")
//	public void insertShip(Ship ship);
//	
//	
//	@Update("TRUNCATE TABLE t_ship")
//	public void truncateShip();
//	
//	@Update("UPDATE t_ship SET STATUS = #{status} WHERE NAME = #{shipName}")
//	public void updateStatusByname(String shipname, int status);
//	
//	@Select("SELECT id,name,ipaddr,loadstation,status,tips FROM t_ship WHERE name =#{shipName}")
//	public Ship queryShipBySeaphone(String shipname);
	
}
