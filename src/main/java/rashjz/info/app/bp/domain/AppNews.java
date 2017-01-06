/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.domain;

import java.util.Date;

/**
 *
 * @author rasha_000
 */
public class AppNews implements java.io.Serializable {

    private Integer recId;
    private String title;
    private String content;
    private Date insDate;
    private String img;
    private String video;
    private Integer hitCount;
    private String note;
    private String status;

    public AppNews(Integer recId, String title, String content, Date insDate, String img, String video, Integer hitCount, String note, String status) {
        this.recId = recId;
        this.title = title;
        this.content = content;
        this.insDate = insDate;
        this.img = img;
        this.video = video;
        this.hitCount = hitCount;
        this.note = note;
        this.status = status;
    }

    public AppNews() {
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
