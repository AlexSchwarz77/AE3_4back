package de.afp.java_backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class ThreadModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long threadId;
    private String threadTitle;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne @JoinColumn(name = "sub_forum_id", nullable = false)
    private Subforum subforum;
    private LocalDateTime date;
    @Lob
    @Column(length=1024)
    private String content;

    public ThreadModel(){}

    public ThreadModel(Long threadId, String threadTitle, User user, Subforum subforum, LocalDateTime date, String content){
        this.threadId = threadId;
        this.threadTitle = threadTitle;
        this.user = user;
        this.subforum = subforum;
        this.date = date;
        this.content = content;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getThreadTitle() {
        return this.threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subforum getSubforum(){
        return this.subforum;
    }

    public void setSubforum(Subforum subforum){
        this.subforum = subforum;
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
