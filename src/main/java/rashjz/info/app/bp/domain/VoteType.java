package rashjz.info.app.bp.domain;
// Generated Aug 19, 2016 3:16:01 PM by Hibernate Tools 4.3.1



/**
 * VoteType generated by hbm2java
 */
public class VoteType  implements java.io.Serializable {


     private Integer typeId;
     private String description;

    public VoteType() {
    }

    public VoteType(String description) {
       this.description = description;
    }
   
    public Integer getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


