package com.client.entity;

import java.util.Date;

public class ZmSitePageLogBean {

	private String fId;

	/**
	 * 站点-页面表的fId
	 */
	private String fZmSitePageId;

	/**
	 * 站点管理-站点ID
	 */
	private String fZmSiteId;

	/**
	 * 页面ID
	 */
	private String fPageId;

	/**
	 * 页面名称
	 */
	private String fPageName;

	/**
	 * 类型:页面，灯箱，页眉，页脚，宣传页
	 */
	private Integer fPageType;

	/**
	 * 页面域名
	 */
	private String fPageDomain;

	/**
	 * 族蚂二级域名
	 */
	private String fSecDomain;

	/**
	 * 发布状态
	 */
	private Integer fSiteState;

	/**
	 * PC数据
	 */
	private String fPcData;

	/**
	 * 手机数据
	 */
	private String fPhoneData;

	/**
	 * 更新时间
	 */
	private Date fUpdateTime;

	/**
	 * 标题
	 */
	private String fTitle;

	/**
	 * 说明
	 */
	private String fDescription;

	/**
	 * 关键字
	 */
	private String fKeywords;

	/**
	 * 代码版本：发布版本，手动保存，自动保存
	 */
	private Integer fType;

	/**
	 * 验证类型（1、无限制2、密码限制3、仅限会员）
	 */
	private Integer fLoginLimit;

	/**
	 * 密码限制
	 */
	private String fPasswordLimit;

	/**
	 * URL
	 */
	private String fUrl;

	/**
	 * 1自动保存 2手动保存
	 */
	private Integer fSaveType;

	/**
	 * 序号
	 */
	private Integer fSort;

	/**
	 * 是否在导航条显示
	 */
	private Integer fIsInNavigation;

	/**
	 * 是否设为首页
	 */
	private Integer fIsHome;

	/**
	 * 显示页眉
	 */
	private Integer fIsShowGoHead;

	/**
	 * 显示页脚
	 */
	private Integer fIsShowGoFoot;

	/**
	 * 
	 */
	private Long fTempletId;

	/**
	 * 页面是否有效 1有效 0无效
	 */
	private Integer fState;

	/**
	 * 父节点ID
	 */
	private String fParentId;

	/**
	 * 创建人ID
	 */
	private Long fCreateId;

	/**
	 * 创建人类型：员工，会员
	 */
	private Integer fCreateType;

	/**
	 * 创建时间
	 */
	private Date fCreateTime;

	/**
	 * 更新人ID
	 */
	private Long fUpdateId;

	/**
	 * 更新人类型：员工，会员
	 */
	private Integer fUpdateType;

	/**
	 * html内容
	 */
	private String fHtml;
	
	/**
     * 页面已有组件配置
     */
    private String fPageConfig;
    
    /**
     * 页面背景设置
     */
    private String fBgHtml;
    
    private String fSiteVersion;
    
    private String fSitePageVersion;
	
	private Integer fLevel;

	private String levelName;
	
	private String fComment;

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public String getfZmSiteId() {
		return fZmSiteId;
	}

	public void setfZmSiteId(String fZmSiteId) {
		this.fZmSiteId = fZmSiteId;
	}

	public String getfPageId() {
		return fPageId;
	}

	public void setfPageId(String fPageId) {
		this.fPageId = fPageId;
	}

	public String getfPageName() {
		return fPageName;
	}

	public void setfPageName(String fPageName) {
		this.fPageName = fPageName;
	}

	public Integer getfPageType() {
		return fPageType;
	}

	public void setfPageType(Integer fPageType) {
		this.fPageType = fPageType;
	}

	public String getfPageDomain() {
		return fPageDomain;
	}

	public void setfPageDomain(String fPageDomain) {
		this.fPageDomain = fPageDomain;
	}

	public String getfSecDomain() {
		return fSecDomain;
	}

	public void setfSecDomain(String fSecDomain) {
		this.fSecDomain = fSecDomain;
	}

	public Integer getfSiteState() {
		return fSiteState;
	}

	public void setfSiteState(Integer fSiteState) {
		this.fSiteState = fSiteState;
	}

	public String getfPcData() {
		return fPcData;
	}

	public void setfPcData(String fPcData) {
		this.fPcData = fPcData;
	}

	public String getfPhoneData() {
		return fPhoneData;
	}

	public void setfPhoneData(String fPhoneData) {
		this.fPhoneData = fPhoneData;
	}

	public Date getfUpdateTime() {
		return fUpdateTime;
	}

	public void setfUpdateTime(Date fUpdateTime) {
		this.fUpdateTime = fUpdateTime;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getfDescription() {
		return fDescription;
	}

	public void setfDescription(String fDescription) {
		this.fDescription = fDescription;
	}

	public String getfKeywords() {
		return fKeywords;
	}

	public void setfKeywords(String fKeywords) {
		this.fKeywords = fKeywords;
	}

	public Integer getfType() {
		return fType;
	}

	public void setfType(Integer fType) {
		this.fType = fType;
	}

	public Integer getfLoginLimit() {
		return fLoginLimit;
	}

	public void setfLoginLimit(Integer fLoginLimit) {
		this.fLoginLimit = fLoginLimit;
	}

	public String getfPasswordLimit() {
		return fPasswordLimit;
	}

	public void setfPasswordLimit(String fPasswordLimit) {
		this.fPasswordLimit = fPasswordLimit;
	}

	public String getfUrl() {
		return fUrl;
	}

	public void setfUrl(String fUrl) {
		this.fUrl = fUrl;
	}

	public Integer getfSaveType() {
		return fSaveType;
	}

	public void setfSaveType(Integer fSaveType) {
		this.fSaveType = fSaveType;
	}

	public Integer getfSort() {
		return fSort;
	}

	public void setfSort(Integer fSort) {
		this.fSort = fSort;
	}

	public Integer getfIsInNavigation() {
		return fIsInNavigation;
	}

	public void setfIsInNavigation(Integer fIsInNavigation) {
		this.fIsInNavigation = fIsInNavigation;
	}

	public Integer getfIsHome() {
		return fIsHome;
	}

	public void setfIsHome(Integer fIsHome) {
		this.fIsHome = fIsHome;
	}

	public Integer getfIsShowGoHead() {
		return fIsShowGoHead;
	}

	public void setfIsShowGoHead(Integer fIsShowGoHead) {
		this.fIsShowGoHead = fIsShowGoHead;
	}

	public Integer getfIsShowGoFoot() {
		return fIsShowGoFoot;
	}

	public void setfIsShowGoFoot(Integer fIsShowGoFoot) {
		this.fIsShowGoFoot = fIsShowGoFoot;
	}

	public Long getfTempletId() {
		return fTempletId;
	}

	public void setfTempletId(Long fTempletId) {
		this.fTempletId = fTempletId;
	}

	public Integer getfState() {
		return fState;
	}

	public void setfState(Integer fState) {
		this.fState = fState;
	}

	public String getfParentId() {
		return fParentId;
	}

	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}

	public Long getfCreateId() {
		return fCreateId;
	}

	public void setfCreateId(Long fCreateId) {
		this.fCreateId = fCreateId;
	}

	public Integer getfCreateType() {
		return fCreateType;
	}

	public void setfCreateType(Integer fCreateType) {
		this.fCreateType = fCreateType;
	}

	public Date getfCreateTime() {
		return fCreateTime;
	}

	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	public Long getfUpdateId() {
		return fUpdateId;
	}

	public void setfUpdateId(Long fUpdateId) {
		this.fUpdateId = fUpdateId;
	}

	public Integer getfUpdateType() {
		return fUpdateType;
	}

	public void setfUpdateType(Integer fUpdateType) {
		this.fUpdateType = fUpdateType;
	}

	public String getfHtml() {
		return fHtml;
	}

	public void setfHtml(String fHtml) {
		this.fHtml = fHtml;
	}

	public Integer getfLevel() {
		return fLevel;
	}

	public void setfLevel(Integer fLevel) {
		this.fLevel = fLevel;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getfZmSitePageId() {
		return fZmSitePageId;
	}

	public void setfZmSitePageId(String fZmSitePageId) {
		this.fZmSitePageId = fZmSitePageId;
	}

	public String getfComment() {
		return fComment;
	}

	public void setfComment(String fComment) {
		this.fComment = fComment;
	}

	public String getfPageConfig() {
		return fPageConfig;
	}

	public void setfPageConfig(String fPageConfig) {
		this.fPageConfig = fPageConfig;
	}

	public String getfSiteVersion() {
		return fSiteVersion;
	}

	public void setfSiteVersion(String fSiteVersion) {
		this.fSiteVersion = fSiteVersion;
	}

	public String getfSitePageVersion() {
		return fSitePageVersion;
	}

	public void setfSitePageVersion(String fSitePageVersion) {
		this.fSitePageVersion = fSitePageVersion;
	}

	public String getfBgHtml() {
		return fBgHtml;
	}

	public void setfBgHtml(String fBgHtml) {
		this.fBgHtml = fBgHtml;
	}

}