package jp.kobespiral.santasandastamprally.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザのエンティティ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Column(name="user_id", nullable=false)
    @Id
    UUID userId;   //ユーザID

    @Column(name="name", nullable=true)
    @NotBlank
    String name; // 名前

    @Column(name="email", nullable=true)
    @Email
    String email; // E-mail

    @Column(name="last_login_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    Date lastLoginAt; // 最終ログイン日時

    @Column(name="created_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt; // 作成日時

    @Column(name="updated_at", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt; // 最終更新日時

    @Column(name="deleted_at", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    Date deletedAt; // 削除日時

    @Column(name="deleted_by", nullable=true)
    Long deletedBy; // 削除者
}