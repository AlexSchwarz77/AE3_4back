package de.afp.java_backend.model;

import java.time.LocalDateTime;

public class SubHelper {
    private String subTitle;
    private LocalDateTime date;
    private String content;

    public SubHelper(){}
    public SubHelper(String subTitle, LocalDateTime date, String content){
        this.subTitle = subTitle;
        this.date = date;
        this.content = content;
    }

    public String getSubTitle(){
        return this.subTitle;
    }

    public void setSubTitle(String subTitle){
        this.subTitle = subTitle;
    }

    public LocalDateTime getDate(){
        return this.date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
