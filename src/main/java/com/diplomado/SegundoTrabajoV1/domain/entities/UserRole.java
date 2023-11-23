package com.diplomado.SegundoTrabajoV1.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @SequenceGenerator(
            name = "user_role_id_seq",
            sequenceName = "user_role_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_role_id_seq")
    private Long id;

    @Column(nullable = false)
    private Boolean active;

    @Column(name = "created_at",
            columnDefinition = "TIMESTAMP",
            nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",
                nullable=false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name="role_id",
            nullable=false)
    private Role role;

    public UserRole() {
    }

    public UserRole(Boolean active, LocalDateTime createdAt, User user, Role role) {
        this.active = active;
        this.createdAt = createdAt;
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
