package com.upsidedown.model;

import java.util.*;
import java.time.LocalDate;
public class User {
	
	
	public enum usertype {
		 BUYER (0), SELLER (1);
		
		private final int typeCode;
		private static Map<Integer, usertype> type = new HashMap<>();
		
		usertype(int typeCode) {
			this.typeCode = typeCode;
		}
		
		static {
	        for (usertype user : usertype.values()) {
	            type.put(user.typeCode, user);
	        }
	    }

	    public static usertype valueOf(int user) {
	        return (usertype) type.get(user);
	    }

	    public int getValue() {
	        return typeCode;
	    }
	}
	
	
	private int userId;
	private String name;
	private LocalDate dateOfBirth;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private String address;
	private usertype user;
	private double walletAmt;
	
	
	public User() {
	
	}


	public User(int userId, String name, LocalDate dateOfBirth, String email, String phoneNumber, String username,
			String password, String address, usertype user, double walletAmt) {
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.address = address;
		this.user = user;
		this.walletAmt = walletAmt;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	
	public int getUser() {
		return user.typeCode;
	}

	public void setUser(int user) {
		this.user = usertype.valueOf(user);
	}


	public double getWalletAmt() {
		return walletAmt;
	}


	public void setWalletAmt(double walletAmt) {
		this.walletAmt = walletAmt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		long temp;
		temp = Double.doubleToLongBits(walletAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (user != other.user)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(walletAmt) != Double.doubleToLongBits(other.walletAmt))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password + ", address="
				+ address + ", user=" + user + ", walletAmt=" + walletAmt + "]";
	}
	
	
	
	
	
	
	
}
