package com.repcar.user.enums;

public enum UserRole {
	ROLE_NOT_ASSIGNED(0),
	ROLE_ADMIN(1),
	ROLE_USER(2),
	ROLE_ANONYMOUS(3),
	ROLE_OPERATOR(4);

	private int id;

	private UserRole(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static UserRole roleNameById(int id) {
		for (UserRole roleName : UserRole.values()) {
			if (roleName.getId() == id) {
				return roleName;
			}
		}
		return null;
	}

	public static int roleIdByValue(String value) {
		for (UserRole roleName : UserRole.values()) {
			if (roleName.toString().equals(value)) {
				return roleName.getId();
			}
		}
		return 0;
	}

}
