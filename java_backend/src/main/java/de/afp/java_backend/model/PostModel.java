package de.afp.java_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PostModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String content;
    @ManyToOne @JoinColumn(name = "thread_id", nullable = false)
    private ThreadModel threadModel;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public PostModel() {
    }

    public PostModel(Long postId, String content, ThreadModel threadModel, User user) {
        this.postId = postId;
        this.content = content;
        this.threadModel = threadModel;
        this.user = user;
    }

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ThreadModel getThreadModel() {
        return this.threadModel;
    }

    public void setThreadModel(ThreadModel threadModel) {
        this.threadModel = threadModel;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
