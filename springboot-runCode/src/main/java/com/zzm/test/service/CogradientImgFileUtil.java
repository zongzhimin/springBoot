package com.zzm.test.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class CogradientImgFileUtil {
	private static final Logger log     = LoggerFactory.getLogger(CogradientImgFileUtil.class);

    private static ChannelExec          channelExec;

    private static Session              session = null;

    private static int                  timeout = 60000;    

    // 测试代码
    public static void main(String[] args){
        try{
            versouSshUtil("172.16.6.33","root","Keyidea@SetSn",22);
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

    /**
     * 连接远程服务器
     * @param host ip地址
     * @param userName 登录名
     * @param password 密码
     * @param port 端口
     * @throws Exception
     */
    public static void versouSshUtil(String host,String userName,String password,int port) throws Exception{
        log.info("尝试连接到....host:" + host + ",username:" + userName + ",password:" + password + ",port:"
                + port);
        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象
        session.setPassword(password); // 设置密码
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
    }

    /**
     * 在远程服务器上执行命令
     * @param cmd 要执行的命令字符串
     * @param charset 编码
     * @throws Exception
     */
    public static void runCmd(String cmd,String charset) throws Exception{
        channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName(charset)));
        String buf = null;
        while ((buf = reader.readLine()) != null){
            System.out.println(buf);
        }
        reader.close();
        channelExec.disconnect();
    }
    
    public static List<String> getCmdRes(String cmd,String charset) throws Exception{
    	List<String> res = new ArrayList<String>();
    	channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName(charset)));
        String buf = null;
        while ((buf = reader.readLine()) != null){
            res.add(buf);
        }
        reader.close();
        channelExec.disconnect();
        return res;
    }
    public static void close(){
    	if(null!=session){
    		session.disconnect();
    	}
    }
}
