package com.shiro.entity;

import java.util.Date;

/**
 * Created by liuenxi on 2017/12/12.
 */
public class User {

    /**
     * 用户ID
     */
    private Long fId;
    /**
     * 员工编号
     */
    private String fUserAccount;
    /**
     * 用户名
     */
    private String fUserName;
    /**
     * 用户密码
     */
    private String fPassWord;

    /**
     * 角色ID-->临时字段
     */
    private Integer roleId;
    /**
     * 角色名称-->临时字段
     */
    private String roleName;
    /**
     * 创建时间
     */
    private java.util.Date fCreateTime;
    /**
     * 创建人
     */
    private Long fCreateUserId;
    /**
     * 修改时间
     */
    private java.util.Date fUpdateTime;
    /**
     * 修改人
     */
    private Long fUpdateUserId;

    /**
     * 密码输入错误次数
     */
    private Integer fErrorTimes;

    /**
     * 0男1女
     */
    private Integer fSex;
    /**
     * 出生时间
     */
    private java.util.Date fBrithdayTime;

    /**
     * 民族
     */
    private String fNation;
    /**
     * 户口类型 0 本地农村 1外地农村 2本地城镇 3外地城镇
     */
    private Integer fPopulation;
    /**
     * 固定号码
     */
    private String fTel;
    /**
     * 学历 0博士 1硕士 2本科 3大专4高中
     */
    private Integer fEducational;
    /**
     * 分机
     */
    private String fExtension;
    /**
     * 手机号
     */
    private String fPhone;
    /**
     * 在职状态 1在职 2离职 3停薪留职
     */
    private Integer fPayroll;
    /**
     * 入职时间
     */
    private java.util.Date fJoinTime;

    /**
     * 离职时间
     */
    private java.util.Date fLeaveTime;

    /**
     * 紧急联系人
     */
    private String fEmergency;
    /**
     * 紧急联系人电话
     */
    private String fEmergencyTel;
    /**
     * 部门id
     */
    private Long fDepartmentId;
    /**
     * 岗位id
     */
    private Long fStationId;
    /**
     * 员工属性 1内部人员 2外部人员
     */
    private Integer fEmplyoeeType;
    /**
     * 身份证
     */
    private String fIdCard;
    /**
     * 籍贯省
     */
    private Long fBornProvice;
    /**
     * 籍贯市
     */
    private Long fBornCity;
    /**
     * 籍贯县
     */
    private Long fBornDistrict;

    /**
     * 籍贯区
     */
    private Long fBornTown;

    /**
     * 户籍省
     */
    private Long fCensusProvice;
    /**
     * 户籍市
     */
    private Long fCensusCity;
    /**
     * 户籍县
     */
    private Long fCensusDistrict;
    /**
     * 户籍区
     */
    private Long fCensusTown;
    /**
     * 户籍地址
     */
    private String fCensusAddr;
    /**
     * 现居住省
     */
    private Long fNowPlaceProvice;
    /**
     * 先居住市区
     */
    private Long fNowPlaceCity;
    /**
     * 现居住县
     */
    private Long fNowDistrict;
    /**
     * 现居住区
     */
    private Long fNowTown;

    /**
     * 详细地址
     */
    private String fAddrDetail;
    /**
     * 英语等级 2:英语二级 4:英语四级 6:英语六级 8:英语八级
     */
    private String fEnglishLevel;
    /**
     * 用户头像
     */
    private String fUserImage;
    /**
     * 用户角色的名称 方便查询
     */
    private String fRoleName;

    private String fCompanyId;

    /**
     * 籍贯名称
     */
    private String fBornName;
    /**
     * 户籍名字
     */
    private String fCensusName;

    /**
     * 现居住地名字
     */
    private String fNowName;
    /**
     * 国籍
     */
    private String fNationality;

    /**
     * 开户银行
     */
    private String fDepositBank;
    /**
     * 银行账号
     */
    private String fCardNumbers;
    /**
     * 员工保密信息准确无误 1:有选 其他：没选
     */
    private String fConfidential;
    /**
     * 考勤卡号
     */
    private String fCardNo;

    private String fDepositBankPoint;

    // =========辅助字段=========================================================================
    /**
     * 入职时间
     */
    private String fJoinTimeStr;

    /**
     * 离职时间
     */
    private String fLeaveTimeStr;

    /**
     * 出生日期
     */
    private String fBrithdayTimeStr;

    /**
     * 岗位名称
     *
     * @return
     */
    private String fPositionName;

    /**
     * 部门名称
     *
     * @return
     */

    private String fDepartment;

    /**
     * 公司名
     */
    private String fCompany;

    /**
     * 开始出生年份
     */
    private String startDay;
    /**
     * 结束出生年份
     */
    private String endByDay;

    private String startAge;

    private String endAge;

    private String startJoinTime;

    private String endJoinTime;

    private String PositionStr;

    private  Integer fPositionLevel;

    private String fSelectItems;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getfUserAccount() {
        return fUserAccount;
    }

    public void setfUserAccount(String fUserAccount) {
        this.fUserAccount = fUserAccount;
    }

    public String getfUserName() {
        return fUserName;
    }

    public void setfUserName(String fUserName) {
        this.fUserName = fUserName;
    }

    public String getfPassWord() {
        return fPassWord;
    }

    public void setfPassWord(String fPassWord) {
        this.fPassWord = fPassWord;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Long getfCreateUserId() {
        return fCreateUserId;
    }

    public void setfCreateUserId(Long fCreateUserId) {
        this.fCreateUserId = fCreateUserId;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Long getfUpdateUserId() {
        return fUpdateUserId;
    }

    public void setfUpdateUserId(Long fUpdateUserId) {
        this.fUpdateUserId = fUpdateUserId;
    }

    public Integer getfErrorTimes() {
        return fErrorTimes;
    }

    public void setfErrorTimes(Integer fErrorTimes) {
        this.fErrorTimes = fErrorTimes;
    }

    public Integer getfSex() {
        return fSex;
    }

    public void setfSex(Integer fSex) {
        this.fSex = fSex;
    }

    public Date getfBrithdayTime() {
        return fBrithdayTime;
    }

    public void setfBrithdayTime(Date fBrithdayTime) {
        this.fBrithdayTime = fBrithdayTime;
    }

    public String getfNation() {
        return fNation;
    }

    public void setfNation(String fNation) {
        this.fNation = fNation;
    }

    public Integer getfPopulation() {
        return fPopulation;
    }

    public void setfPopulation(Integer fPopulation) {
        this.fPopulation = fPopulation;
    }

    public String getfTel() {
        return fTel;
    }

    public void setfTel(String fTel) {
        this.fTel = fTel;
    }

    public Integer getfEducational() {
        return fEducational;
    }

    public void setfEducational(Integer fEducational) {
        this.fEducational = fEducational;
    }

    public String getfExtension() {
        return fExtension;
    }

    public void setfExtension(String fExtension) {
        this.fExtension = fExtension;
    }

    public String getfPhone() {
        return fPhone;
    }

    public void setfPhone(String fPhone) {
        this.fPhone = fPhone;
    }

    public Integer getfPayroll() {
        return fPayroll;
    }

    public void setfPayroll(Integer fPayroll) {
        this.fPayroll = fPayroll;
    }

    public Date getfJoinTime() {
        return fJoinTime;
    }

    public void setfJoinTime(Date fJoinTime) {
        this.fJoinTime = fJoinTime;
    }

    public Date getfLeaveTime() {
        return fLeaveTime;
    }

    public void setfLeaveTime(Date fLeaveTime) {
        this.fLeaveTime = fLeaveTime;
    }

    public String getfEmergency() {
        return fEmergency;
    }

    public void setfEmergency(String fEmergency) {
        this.fEmergency = fEmergency;
    }

    public String getfEmergencyTel() {
        return fEmergencyTel;
    }

    public void setfEmergencyTel(String fEmergencyTel) {
        this.fEmergencyTel = fEmergencyTel;
    }

    public Long getfDepartmentId() {
        return fDepartmentId;
    }

    public void setfDepartmentId(Long fDepartmentId) {
        this.fDepartmentId = fDepartmentId;
    }

    public Long getfStationId() {
        return fStationId;
    }

    public void setfStationId(Long fStationId) {
        this.fStationId = fStationId;
    }

    public Integer getfEmplyoeeType() {
        return fEmplyoeeType;
    }

    public void setfEmplyoeeType(Integer fEmplyoeeType) {
        this.fEmplyoeeType = fEmplyoeeType;
    }

    public String getfIdCard() {
        return fIdCard;
    }

    public void setfIdCard(String fIdCard) {
        this.fIdCard = fIdCard;
    }

    public Long getfBornProvice() {
        return fBornProvice;
    }

    public void setfBornProvice(Long fBornProvice) {
        this.fBornProvice = fBornProvice;
    }

    public Long getfBornCity() {
        return fBornCity;
    }

    public void setfBornCity(Long fBornCity) {
        this.fBornCity = fBornCity;
    }

    public Long getfBornDistrict() {
        return fBornDistrict;
    }

    public void setfBornDistrict(Long fBornDistrict) {
        this.fBornDistrict = fBornDistrict;
    }

    public Long getfBornTown() {
        return fBornTown;
    }

    public void setfBornTown(Long fBornTown) {
        this.fBornTown = fBornTown;
    }

    public Long getfCensusProvice() {
        return fCensusProvice;
    }

    public void setfCensusProvice(Long fCensusProvice) {
        this.fCensusProvice = fCensusProvice;
    }

    public Long getfCensusCity() {
        return fCensusCity;
    }

    public void setfCensusCity(Long fCensusCity) {
        this.fCensusCity = fCensusCity;
    }

    public Long getfCensusDistrict() {
        return fCensusDistrict;
    }

    public void setfCensusDistrict(Long fCensusDistrict) {
        this.fCensusDistrict = fCensusDistrict;
    }

    public Long getfCensusTown() {
        return fCensusTown;
    }

    public void setfCensusTown(Long fCensusTown) {
        this.fCensusTown = fCensusTown;
    }

    public String getfCensusAddr() {
        return fCensusAddr;
    }

    public void setfCensusAddr(String fCensusAddr) {
        this.fCensusAddr = fCensusAddr;
    }

    public Long getfNowPlaceProvice() {
        return fNowPlaceProvice;
    }

    public void setfNowPlaceProvice(Long fNowPlaceProvice) {
        this.fNowPlaceProvice = fNowPlaceProvice;
    }

    public Long getfNowPlaceCity() {
        return fNowPlaceCity;
    }

    public void setfNowPlaceCity(Long fNowPlaceCity) {
        this.fNowPlaceCity = fNowPlaceCity;
    }

    public Long getfNowDistrict() {
        return fNowDistrict;
    }

    public void setfNowDistrict(Long fNowDistrict) {
        this.fNowDistrict = fNowDistrict;
    }

    public Long getfNowTown() {
        return fNowTown;
    }

    public void setfNowTown(Long fNowTown) {
        this.fNowTown = fNowTown;
    }

    public String getfAddrDetail() {
        return fAddrDetail;
    }

    public void setfAddrDetail(String fAddrDetail) {
        this.fAddrDetail = fAddrDetail;
    }

    public String getfEnglishLevel() {
        return fEnglishLevel;
    }

    public void setfEnglishLevel(String fEnglishLevel) {
        this.fEnglishLevel = fEnglishLevel;
    }

    public String getfUserImage() {
        return fUserImage;
    }

    public void setfUserImage(String fUserImage) {
        this.fUserImage = fUserImage;
    }

    public String getfRoleName() {
        return fRoleName;
    }

    public void setfRoleName(String fRoleName) {
        this.fRoleName = fRoleName;
    }

    public String getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(String fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    public String getfBornName() {
        return fBornName;
    }

    public void setfBornName(String fBornName) {
        this.fBornName = fBornName;
    }

    public String getfCensusName() {
        return fCensusName;
    }

    public void setfCensusName(String fCensusName) {
        this.fCensusName = fCensusName;
    }

    public String getfNowName() {
        return fNowName;
    }

    public void setfNowName(String fNowName) {
        this.fNowName = fNowName;
    }

    public String getfNationality() {
        return fNationality;
    }

    public void setfNationality(String fNationality) {
        this.fNationality = fNationality;
    }

    public String getfDepositBank() {
        return fDepositBank;
    }

    public void setfDepositBank(String fDepositBank) {
        this.fDepositBank = fDepositBank;
    }

    public String getfCardNumbers() {
        return fCardNumbers;
    }

    public void setfCardNumbers(String fCardNumbers) {
        this.fCardNumbers = fCardNumbers;
    }

    public String getfConfidential() {
        return fConfidential;
    }

    public void setfConfidential(String fConfidential) {
        this.fConfidential = fConfidential;
    }

    public String getfCardNo() {
        return fCardNo;
    }

    public void setfCardNo(String fCardNo) {
        this.fCardNo = fCardNo;
    }

    public String getfDepositBankPoint() {
        return fDepositBankPoint;
    }

    public void setfDepositBankPoint(String fDepositBankPoint) {
        this.fDepositBankPoint = fDepositBankPoint;
    }

    public String getfJoinTimeStr() {
        return fJoinTimeStr;
    }

    public void setfJoinTimeStr(String fJoinTimeStr) {
        this.fJoinTimeStr = fJoinTimeStr;
    }

    public String getfLeaveTimeStr() {
        return fLeaveTimeStr;
    }

    public void setfLeaveTimeStr(String fLeaveTimeStr) {
        this.fLeaveTimeStr = fLeaveTimeStr;
    }

    public String getfBrithdayTimeStr() {
        return fBrithdayTimeStr;
    }

    public void setfBrithdayTimeStr(String fBrithdayTimeStr) {
        this.fBrithdayTimeStr = fBrithdayTimeStr;
    }

    public String getfPositionName() {
        return fPositionName;
    }

    public void setfPositionName(String fPositionName) {
        this.fPositionName = fPositionName;
    }

    public String getfDepartment() {
        return fDepartment;
    }

    public void setfDepartment(String fDepartment) {
        this.fDepartment = fDepartment;
    }

    public String getfCompany() {
        return fCompany;
    }

    public void setfCompany(String fCompany) {
        this.fCompany = fCompany;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndByDay() {
        return endByDay;
    }

    public void setEndByDay(String endByDay) {
        this.endByDay = endByDay;
    }

    public String getStartAge() {
        return startAge;
    }

    public void setStartAge(String startAge) {
        this.startAge = startAge;
    }

    public String getEndAge() {
        return endAge;
    }

    public void setEndAge(String endAge) {
        this.endAge = endAge;
    }

    public String getStartJoinTime() {
        return startJoinTime;
    }

    public void setStartJoinTime(String startJoinTime) {
        this.startJoinTime = startJoinTime;
    }

    public String getEndJoinTime() {
        return endJoinTime;
    }

    public void setEndJoinTime(String endJoinTime) {
        this.endJoinTime = endJoinTime;
    }

    public String getPositionStr() {
        return PositionStr;
    }

    public void setPositionStr(String positionStr) {
        PositionStr = positionStr;
    }

    public Integer getfPositionLevel() {
        return fPositionLevel;
    }

    public void setfPositionLevel(Integer fPositionLevel) {
        this.fPositionLevel = fPositionLevel;
    }

    public String getfSelectItems() {
        return fSelectItems;
    }

    public void setfSelectItems(String fSelectItems) {
        this.fSelectItems = fSelectItems;
    }
}
