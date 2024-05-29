package com.palette.palettepetsback.member.entity;

import com.palette.palettepetsback.config.auditing.BaseEntity;
import com.palette.palettepetsback.member.dto.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    private String email;
    private String password;
    @Column(name = "member_name")
    private String memberName;
    @Column(name = "member_nickname")
    private String memberNickname;
    @Column(name = "member_address")
    private String memberAddress;
    @Column(name = "member_birth")
    private String memberBirth;
    @Column(name = "member_gender")
    private String memberGender;
    @Column(name = "member_phone")
    private String memberPhone;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "member_image")
    private String memberImage;
    @Column(name = "login_type")
    private String loginType;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Builder
    public Member(String email, String password, String memberName,String memberNickname, String memberAddress,
                  String memberGender, String memberPhone,
                  String memberImage,
                  Role role ){
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberAddress = memberAddress;
        this.memberGender = memberGender;
        this.memberPhone = memberPhone;
        this.memberImage = memberImage;
        this.role = role;
    }

    public Member(Long memberId, String email, Role role) {
        this.memberId = memberId;
        this.email = email;
        this.role = role;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
}