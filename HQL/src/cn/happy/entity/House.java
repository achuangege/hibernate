package cn.happy.entity;

import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by cgg on 2017/1/12.
 */
public class House {
    private Integer id;
    private String title;
    //描述
    private String description;
    private Integer price;
    //发布时间
    private Date pubdate;
    //面积
    private Integer floorage;
    //联系人
    private String contact;
    //用户编号
    private Integer user_id;
    //类型编号
    private Integer type_id;
    //街道编号
    private Integer street_id;

    public Integer getId() {
        return id;
    }

    public House() {
    }

    public House(Integer price, String contact) {
        this.price = price;
        this.contact = contact;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getStreet_id() {
        return street_id;
    }

    public void setStreet_id(Integer street_id) {
        this.street_id = street_id;
    }
}
