package com.eStore.bear.user.dto;

import com.eStore.bear.user.utils.UserConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    private String id;

    @NotBlank(message = UserConstants.USER_NAME)
    private String name;

    @Pattern(regexp = UserConstants.PATTERN_EMAIL, message = UserConstants.USER_EMAIL_VALID)
    @Column(unique = true)
    private String email;

    @Pattern(regexp = UserConstants.PATTERN_PHONE, message = UserConstants.USER_PHONE_VALID)
    @Column(unique = true)
    private String mobile;

    @Pattern(regexp = UserConstants.PATTERN_PASSWORD, message = UserConstants.USER_PASSWORD)
    private String password;

    private Date insertDate;

    private Date expiredDate;

    @AssertTrue(message = UserConstants.USER_EMAIL + ":" + UserConstants.USER_PHONE)
    private boolean isValid() {
        return this.email != null && this.mobile != null;
    }
}
