package com.bizvane.couponfacade.models.po;

import java.io.Serializable;
import java.util.Date;

public class FileTaskPO implements Serializable {
    /**
     * 只读.
    主键自增. file_task_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "主键自增",name = "fileTaskId", required = false,example = "")
    private Long fileTaskId;

    /**
     * 只读.
    所属企业id. sys_company_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属企业id",name = "sysCompanyId", required = false,example = "")
    private Long sysCompanyId;

    /**
     * 只读.
    所属品牌id. sys_brand_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "所属品牌id",name = "sysBrandId", required = false,example = "")
    private Long sysBrandId;

    /**
     * 只读.
    任务ID. task_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务ID",name = "taskId", required = false,example = "")
    private Long taskId;

    /**
     * 只读.
    任务记录. task_type_code
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务记录",name = "taskTypeCode", required = false,example = "")
    private String taskTypeCode;

    /**
     * 只读.
    任务名称. task_name
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "任务名称",name = "taskName", required = false,example = "")
    private String taskName;

    /**
     * 只读.
    文件ID. file_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "文件ID",name = "fileId", required = false,example = "")
    private String fileId;

    /**
     * 只读.
    文件名称. file_name
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "文件名称",name = "fileName", required = false,example = "")
    private String fileName;

    /**
     * 只读.
    文件类型. file_type
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "文件类型",name = "fileType", required = false,example = "")
    private String fileType;

    /**
     * 只读.
    文件目录. file_directory
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "文件目录",name = "fileDirectory", required = false,example = "")
    private String fileDirectory;

    /**
     * 只读.
    文件下载unl地址. file_unl
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "文件下载unl地址",name = "fileUnl", required = false,example = "")
    private String fileUnl;

    /**
     * 只读.
    文件进度（0到100,初始默认10）. file_status
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "文件进度（0到100,初始默认10）",name = "fileStatus", required = false,example = "")
    private Long fileStatus;

    /**
     * 只读.
    预计导出时间. file_task_date
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "预计导出时间",name = "fileTaskDate", required = false,example = "")
    private Date fileTaskDate;

    /**
     * 只读.
    备注. remark
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "备注",name = "remark", required = false,example = "")
    private String remark;

    /**
     * 只读.
    创建人id. create_user_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人id",name = "createUserId", required = false,example = "")
    private Long createUserId;

    /**
     * 只读.
    创建人. create_user_name
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建人",name = "createUserName", required = false,example = "")
    private String createUserName;

    /**
     * 只读.
    创建时间. create_date
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "创建时间",name = "createDate", required = false,example = "")
    private Date createDate;

    /**
     * 只读.
    修改人id. modified_user_id
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人id",name = "modifiedUserId", required = false,example = "")
    private Long modifiedUserId;

    /**
     * 只读.
    修改人. modified_user_name
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改人",name = "modifiedUserName", required = false,example = "")
    private String modifiedUserName;

    /**
     * 只读.
    修改时间. modified_date
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "修改时间",name = "modifiedDate", required = false,example = "")
    private Date modifiedDate;

    /**
     * 只读.
    数据有效性（1有效，0无效）. valid
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    @io.swagger.annotations.ApiModelProperty(value = "数据有效性（1有效，0无效）",name = "valid", required = false,example = "")
    private Boolean valid;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    private static final long serialVersionUID = 1L;

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getFileTaskId() {
        return fileTaskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileTaskId(Long fileTaskId) {
        this.fileTaskId = fileTaskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getSysCompanyId() {
        return sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setSysCompanyId(Long sysCompanyId) {
        this.sysCompanyId = sysCompanyId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getSysBrandId() {
        return sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setSysBrandId(Long sysBrandId) {
        this.sysBrandId = sysBrandId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getTaskTypeCode() {
        return taskTypeCode;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setTaskTypeCode(String taskTypeCode) {
        this.taskTypeCode = taskTypeCode == null ? null : taskTypeCode.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getFileDirectory() {
        return fileDirectory;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory == null ? null : fileDirectory.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getFileUnl() {
        return fileUnl;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileUnl(String fileUnl) {
        this.fileUnl = fileUnl == null ? null : fileUnl.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getFileStatus() {
        return fileStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileStatus(Long fileStatus) {
        this.fileStatus = fileStatus;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Date getFileTaskDate() {
        return fileTaskDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setFileTaskDate(Date fileTaskDate) {
        this.fileTaskDate = fileTaskDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public String getModifiedUserName() {
        return modifiedUserName;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName == null ? null : modifiedUserName.trim();
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * 只读. 
     *
     * @mbg.generated 2018-09-01 17:31:17
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}