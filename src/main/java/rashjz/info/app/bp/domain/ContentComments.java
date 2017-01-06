package rashjz.info.app.bp.domain;
// Generated Aug 19, 2016 3:16:01 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ContentComments generated by hbm2java
 */
public class ContentComments  implements java.io.Serializable {


     private Integer recId;
     private String deviceMacId;
     private Integer contentId;
     private String userComment;
     private String status;
     private String userEmail;
     private Date insDate;

    public ContentComments() {
    }

	
    public ContentComments(Date insDate) {
        this.insDate = insDate;
    }
    public ContentComments(String deviceMacId, Integer contentId, String userComment, String status, String userEmail, Date insDate) {
       this.deviceMacId = deviceMacId;
       this.contentId = contentId;
       this.userComment = userComment;
       this.status = status;
       this.userEmail = userEmail;
       this.insDate = insDate;
    }
   
    public Integer getRecId() {
        return this.recId;
    }
    
    public void setRecId(Integer recId) {
        this.recId = recId;
    }
    public String getDeviceMacId() {
        return this.deviceMacId;
    }
    
    public void setDeviceMacId(String deviceMacId) {
        this.deviceMacId = deviceMacId;
    }
    public Integer getContentId() {
        return this.contentId;
    }
    
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }
    public String getUserComment() {
        return this.userComment;
    }
    
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public Date getInsDate() {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }




}


