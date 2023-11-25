package com.diplomado.SegundoTrabajoV1.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
//@Table(name = "user")
@Table(name = "\"user\"")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user",
              cascade = CascadeType.ALL,
              orphanRemoval = true,
              fetch = FetchType.EAGER)
    private UserDetail userDetail;

    public User() {
    }

    public User(String username, String password, String email, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

//    public UserDetail getUserDetail() {
//        return userDetail;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public void setUserDetail(UserDetail userDetail) {
        if (userDetail == null) {
            if (this.userDetail != null) {
                this.userDetail.setUser(null);
            }
        } else {
            userDetail.setUser(this);
        }
        this.userDetail = userDetail;
    }

    @JsonManagedReference
    public UserDetail getUserDetail() {
        return userDetail;
    }
}
