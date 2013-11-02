package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * JobSandbox entity. @author MyEclipse Persistence Tools
 */

public class JobSandbox  implements java.io.Serializable {


    // Fields    

     private String jobId;
     private String jobName;
     private Timestamp runTime;
     private String poolId;
     private String statusId;
     private String parentJobId;
     private String previousJobId;
     private String serviceName;
     private String loaderName;
     private BigDecimal maxRetry;
     private String authUserLoginId;
     private String runAsUser;
     private String runtimeDataId;
     private String recurrenceInfoId;
     private String tempExprId;
     private BigDecimal currentRecurrenceCount;
     private BigDecimal maxRecurrenceCount;
     private String runByInstanceId;
     private Timestamp startDateTime;
     private Timestamp finishDateTime;
     private Timestamp cancelDateTime;
     private Timestamp lastUpdatedStamp;
     private Timestamp lastUpdatedTxStamp;
     private Timestamp createdStamp;
     private Timestamp createdTxStamp;


    // Constructors

    /** default constructor */
    public JobSandbox() {
    }

	/** minimal constructor */
    public JobSandbox(String jobId) {
        this.jobId = jobId;
    }
    
    /** full constructor */
    public JobSandbox(String jobId, String jobName, Timestamp runTime, String poolId, String statusId, String parentJobId, String previousJobId, String serviceName, String loaderName, BigDecimal maxRetry, String authUserLoginId, String runAsUser, String runtimeDataId, String recurrenceInfoId, String tempExprId, BigDecimal currentRecurrenceCount, BigDecimal maxRecurrenceCount, String runByInstanceId, Timestamp startDateTime, Timestamp finishDateTime, Timestamp cancelDateTime, Timestamp lastUpdatedStamp, Timestamp lastUpdatedTxStamp, Timestamp createdStamp, Timestamp createdTxStamp) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.runTime = runTime;
        this.poolId = poolId;
        this.statusId = statusId;
        this.parentJobId = parentJobId;
        this.previousJobId = previousJobId;
        this.serviceName = serviceName;
        this.loaderName = loaderName;
        this.maxRetry = maxRetry;
        this.authUserLoginId = authUserLoginId;
        this.runAsUser = runAsUser;
        this.runtimeDataId = runtimeDataId;
        this.recurrenceInfoId = recurrenceInfoId;
        this.tempExprId = tempExprId;
        this.currentRecurrenceCount = currentRecurrenceCount;
        this.maxRecurrenceCount = maxRecurrenceCount;
        this.runByInstanceId = runByInstanceId;
        this.startDateTime = startDateTime;
        this.finishDateTime = finishDateTime;
        this.cancelDateTime = cancelDateTime;
        this.lastUpdatedStamp = lastUpdatedStamp;
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
        this.createdStamp = createdStamp;
        this.createdTxStamp = createdTxStamp;
    }

   
    // Property accessors

    public String getJobId() {
        return this.jobId;
    }
    
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return this.jobName;
    }
    
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Timestamp getRunTime() {
        return this.runTime;
    }
    
    public void setRunTime(Timestamp runTime) {
        this.runTime = runTime;
    }

    public String getPoolId() {
        return this.poolId;
    }
    
    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

    public String getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getParentJobId() {
        return this.parentJobId;
    }
    
    public void setParentJobId(String parentJobId) {
        this.parentJobId = parentJobId;
    }

    public String getPreviousJobId() {
        return this.previousJobId;
    }
    
    public void setPreviousJobId(String previousJobId) {
        this.previousJobId = previousJobId;
    }

    public String getServiceName() {
        return this.serviceName;
    }
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLoaderName() {
        return this.loaderName;
    }
    
    public void setLoaderName(String loaderName) {
        this.loaderName = loaderName;
    }

    public BigDecimal getMaxRetry() {
        return this.maxRetry;
    }
    
    public void setMaxRetry(BigDecimal maxRetry) {
        this.maxRetry = maxRetry;
    }

    public String getAuthUserLoginId() {
        return this.authUserLoginId;
    }
    
    public void setAuthUserLoginId(String authUserLoginId) {
        this.authUserLoginId = authUserLoginId;
    }

    public String getRunAsUser() {
        return this.runAsUser;
    }
    
    public void setRunAsUser(String runAsUser) {
        this.runAsUser = runAsUser;
    }

    public String getRuntimeDataId() {
        return this.runtimeDataId;
    }
    
    public void setRuntimeDataId(String runtimeDataId) {
        this.runtimeDataId = runtimeDataId;
    }

    public String getRecurrenceInfoId() {
        return this.recurrenceInfoId;
    }
    
    public void setRecurrenceInfoId(String recurrenceInfoId) {
        this.recurrenceInfoId = recurrenceInfoId;
    }

    public String getTempExprId() {
        return this.tempExprId;
    }
    
    public void setTempExprId(String tempExprId) {
        this.tempExprId = tempExprId;
    }

    public BigDecimal getCurrentRecurrenceCount() {
        return this.currentRecurrenceCount;
    }
    
    public void setCurrentRecurrenceCount(BigDecimal currentRecurrenceCount) {
        this.currentRecurrenceCount = currentRecurrenceCount;
    }

    public BigDecimal getMaxRecurrenceCount() {
        return this.maxRecurrenceCount;
    }
    
    public void setMaxRecurrenceCount(BigDecimal maxRecurrenceCount) {
        this.maxRecurrenceCount = maxRecurrenceCount;
    }

    public String getRunByInstanceId() {
        return this.runByInstanceId;
    }
    
    public void setRunByInstanceId(String runByInstanceId) {
        this.runByInstanceId = runByInstanceId;
    }

    public Timestamp getStartDateTime() {
        return this.startDateTime;
    }
    
    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getFinishDateTime() {
        return this.finishDateTime;
    }
    
    public void setFinishDateTime(Timestamp finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public Timestamp getCancelDateTime() {
        return this.cancelDateTime;
    }
    
    public void setCancelDateTime(Timestamp cancelDateTime) {
        this.cancelDateTime = cancelDateTime;
    }

    public Timestamp getLastUpdatedStamp() {
        return this.lastUpdatedStamp;
    }
    
    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Timestamp getLastUpdatedTxStamp() {
        return this.lastUpdatedTxStamp;
    }
    
    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    public Timestamp getCreatedStamp() {
        return this.createdStamp;
    }
    
    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    public Timestamp getCreatedTxStamp() {
        return this.createdTxStamp;
    }
    
    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }
   








}