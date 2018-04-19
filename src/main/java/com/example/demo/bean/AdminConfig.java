package com.example.demo.bean;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/12.
 */
public class AdminConfig {

    private Integer id;
    private Integer adminId;
    private String autograph;
    private String headPortraitUrl;
    private Integer sex;
    private String welcoming;
    private String email;
    private String nickName;
    private String reserve1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getWelcoming() {
        return welcoming;
    }

    public void setWelcoming(String welcoming) {
        this.welcoming = welcoming;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    @Override
    public String toString() {
        return "AdminConfig{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", autograph='" + autograph + '\'' +
                ", headPortraitUrl='" + headPortraitUrl + '\'' +
                ", sex=" + sex +
                ", welcoming='" + welcoming + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", reserve1='" + reserve1 + '\'' +
                '}';
    }
}
