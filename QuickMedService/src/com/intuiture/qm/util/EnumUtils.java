package com.intuiture.qm.util;

public enum EnumUtils {
	MODULE("MODULE", 0), SUBMODULE("SUBMODULE", 1), CATEGORY("", 2), ITEM("ITEM", 3),CASHONDELIVERY("CASH_ON_DELIVERY",4),NETBANKING("NET_BANKING",5);
	private final String state;
	private final int value;

	private EnumUtils(String state, int value) {
		this.state = state;
		this.value = value;
	}

	public String getState() {
		return state;
	}

	public int getValue() {
		return value;
	}
}
