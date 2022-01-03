package com.eStore.bear.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private Integer mobile;

    private String password;

    private Date insertDate;

    private Date expiredDate;
}
