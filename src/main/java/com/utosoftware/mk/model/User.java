package com.utosoftware.mk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private long id;
	private String username;
	private String emailId;
	private String password;
}
