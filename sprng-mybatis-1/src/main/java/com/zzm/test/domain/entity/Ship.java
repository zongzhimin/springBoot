package com.zzm.test.domain.entity;

import java.io.Serializable;

public class Ship implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 所在行的索引(默认设置为-1)
	 */
	private  int index=-1;
	
	/**
	 * 升级文件地址
	 */
	private String filepath;

	/**
	 * 用户名
	 */
	private String username = "root";

	/**
	 * 密码
	 */
	private String password = "KeyideaDatabase";

	/**
	 * shipid
	 */
	private int shipid;

	/**
	 * 序列号
	 */
	private String seaphone;

	/**
	 * 唯一编号
	 */
	private int id;

	/**
	 * 船名
	 */
	private String name;

	/**
	 * 文件名
	 */
	private String filename;

	/**
	 * 上传的目标目录
	 */
	private String ftppath;

	/**
	 * 船舶ip
	 */
	private String ipaddr;
	
	/**
	 * 待执行的linux命令
	 */
	private String command;
	
	/**
	 * 状态:0-ping不通；1-网络正常;2-数据包上传成功；3-升级成功
	 */
	private int status;
	

	/**
	 * 备注
	 */
	private String tips;
	
	/**
	 * 
	 */
	private int loadstation;
	
	
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public int getLoadstation() {
		return loadstation;
	}

	public void setLoadstation(int loadstation) {
		this.loadstation = loadstation;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getFtppath() {
		return ftppath;
	}

	public void setFtppath(String ftppath) {
		this.ftppath = ftppath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeaphone() {
		return seaphone;
	}

	public void setSeaphone(String seaphone) {
		this.seaphone = seaphone;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getShipid() {
		return shipid;
	}

	public void setShipid(int shipid) {
		this.shipid = shipid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ship() {
	}

	@Override
	public String toString() {
		return "Ship [index=" + index + ", filepath=" + filepath
				+ ", username=" + username + ", password=" + password
				+ ", shipid=" + shipid + ", seaphone=" + seaphone + ", id="
				+ id + ", name=" + name + ", filename=" + filename
				+ ", ftppath=" + ftppath + ", ipaddr=" + ipaddr + ", command="
				+ command + ", status=" + status + ", tips=" + tips
				+ ", loadstation=" + loadstation + "]";
	}
	
}
