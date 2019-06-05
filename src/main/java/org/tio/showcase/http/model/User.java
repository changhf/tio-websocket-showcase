package org.tio.showcase.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 7038736722168521022L;
	
	private Integer id;
	
	private String loginname;

	private String nick;

	private String ip;



}
