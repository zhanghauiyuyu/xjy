package com.jk.model;


import java.io.Serializable;

public class Tree implements Serializable {
    private static final long serialVersionUID = -7174432501041268307L;
    private Integer p_id;
    private String p_text;
    private String p_href;
    private Integer p_parentid;
    private String p_icon;

    public String getP_href() {
        return p_href;
    }

    public void setP_href(String p_href) {
        this.p_href = p_href;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_text() {
        return p_text;
    }

    public void setP_text(String p_text) {
        this.p_text = p_text;
    }

    public Integer getP_parentid() {
        return p_parentid;
    }

    public void setP_parentid(Integer p_parentid) {
        this.p_parentid = p_parentid;
    }

    public String getP_icon() {
        return p_icon;
    }

    public void setP_icon(String p_icon) {
        this.p_icon = p_icon;
    }
}
