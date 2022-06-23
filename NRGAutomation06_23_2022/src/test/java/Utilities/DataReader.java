package Utilities;

import apphooks.Base;

/**
 * 
 * @author         :VNatarajan
 * @since          :Sep 25, 2017
 * @filename       :DataReader.java
 * @version		   :
 * @description    :
 */
public abstract class DataReader {
	private Base base;

	public DataReader(Base base) {
		this.base = base;
	}
		
	public String get(String string) {
		return string;
		
	}

	public String getTestId() {
		return null;
	}

}

