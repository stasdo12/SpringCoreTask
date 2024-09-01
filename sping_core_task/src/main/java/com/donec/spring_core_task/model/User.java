package com.donec.spring_core_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean isActive;
}
