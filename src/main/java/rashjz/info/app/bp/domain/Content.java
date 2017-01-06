package rashjz.info.app.bp.domain;
// Generated Aug 19, 2016 3:16:01 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Content generated by hbm2java
 */
public class Content  implements java.io.Serializable {


     private Integer recId;
     private String title;
     private String description;
     private Integer releaseYear;
     private Float rating;
     private Date endDate;
     private Date insDate;
     private String videoUrl;
     private String imgUrl;
     private Integer locationId;
     private String genre;
     private String note;
     private String status;
     private Integer typeId;
     private Integer ageAllow;
     private Float price;
     private String producer;
     private String writer;

    public Content() {
    }

    public Content(String title, String description, Integer releaseYear, Float rating, Date endDate, Date insDate, String videoUrl, String imgUrl, Integer locationId, String genre, String note, String status, Integer typeId, Integer ageAllow, Float price, String producer, String writer) {
       this.title = title;
       this.description = description;
       this.releaseYear = releaseYear;
       this.rating = rating;
       this.endDate = endDate;
       this.insDate = insDate;
       this.videoUrl = videoUrl;
       this.imgUrl = imgUrl;
       this.locationId = locationId;
       this.genre = genre;
       this.note = note;
       this.status = status;
       this.typeId = typeId;
       this.ageAllow = ageAllow;
       this.price = price;
       this.producer = producer;
       this.writer = writer;
    }
   
    public Integer getRecId() {
        return this.recId;
    }
    
    public void setRecId(Integer recId) {
        this.recId = recId;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getReleaseYear() {
        return this.releaseYear;
    }
    
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    public Float getRating() {
        return this.rating;
    }
    
    public void setRating(Float rating) {
        this.rating = rating;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getInsDate() {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }
    public String getVideoUrl() {
        return this.videoUrl;
    }
    
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public Integer getLocationId() {
        return this.locationId;
    }
    
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public Integer getAgeAllow() {
        return this.ageAllow;
    }
    
    public void setAgeAllow(Integer ageAllow) {
        this.ageAllow = ageAllow;
    }
    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getProducer() {
        return this.producer;
    }
    
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getWriter() {
        return this.writer;
    }
    
    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Content{" + "recId=" + recId + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear + ", rating=" + rating + ", endDate=" + endDate + ", insDate=" + insDate + ", videoUrl=" + videoUrl + ", imgUrl=" + imgUrl + ", locationId=" + locationId + ", genre=" + genre + ", note=" + note + ", status=" + status + ", typeId=" + typeId + ", ageAllow=" + ageAllow + ", price=" + price + ", producer=" + producer + ", writer=" + writer + '}';
    }




}


