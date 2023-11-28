package de.afp.java_backend.model;

import java.time.LocalDateTime;

public class ThreadHelper {
    private String subTitle;
    private LocalDateTime date;
    private String content;
    private Long threadId;

    public ThreadHelper(){}
    public ThreadHelper(String subTitle, LocalDateTime date, String content, Long threadId){
        this.subTitle = subTitle;
        this.date = date;
        this.content = content;
        this.threadId = threadId;
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

    public Long getThreadId(){
        return this.threadId;
    }

    public void setThreadId(Long threadId){
        this.threadId = threadId;
    }
}
