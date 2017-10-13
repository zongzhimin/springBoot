package com.zzm.test.domain.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.zzm.test.service.CogradientImgFileUtil;

@Configuration
public class CodeTest {
	
	
	@PostConstruct
	public void test() {
		 try{
			 CogradientImgFileUtil.versouSshUtil("172.16.6.33","root","Keyidea@SetSn",22);
	            List<String> processes = new ArrayList<String>();
	            processes.add("tomcat");
	            processes.add("qwer");
	            
	            for(String process:processes){
	    				List<String> r = CogradientImgFileUtil.getCmdRes("ps -ef|grep "+process,"UTF-8");
	    				if(r.size()<=2){//说明没有进程（会返回一行 ps -ef ...的）
	    					System.out.println("船只： "+process+"进程丢失          ");
	    				}
	    		}
	    		CogradientImgFileUtil.close();
	        }catch (Exception e){
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
}
