package de.afp.java_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    public ThreadModel(){}

    public ThreadModel(Long threadId, String threadTitle, User user, Subforum subforum){
        this.threadId = threadId;
        this.threadTitle = threadTitle;
        this.user = user;
        this.subforum = subforum;

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
}
