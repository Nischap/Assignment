package com.uxpsystems.assignment.dao;

import com.uxpsystems.assignment.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {

    private Long userId;

    private String userName;

    private String password;

    private Status status;
}
