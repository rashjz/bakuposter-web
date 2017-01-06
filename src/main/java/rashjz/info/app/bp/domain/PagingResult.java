/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mobby
 */
public class PagingResult implements java.io.Serializable {

    private List<Content> list = new ArrayList<Content>();
    Integer totalResult = 0;

    public List<Content> getList() {
        return list;
    }

    public void setList(List<Content> list) {
        this.list = list;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

}
