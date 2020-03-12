package com.lumengjun.hgshop.pojo;

import java.io.Serializable;
/**
 * 规格选项
 * @author ASUS
 *
 */
public class SpecOption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5617799569942216617L;
	//主键
	private Integer id;
	//选项
	private String optionName;
	//规格Id
	private Integer specId;
	//状态
	private Integer orders=0;
	
	private String specName;
	
	

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "SpecOption [id=" + id + ", optionName=" + optionName
				+ ", specId=" + specId + ", orders=" + orders + "]";
	}

	public SpecOption(Integer id, String optionName, Integer specId,
			Integer orders) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.specId = specId;
		this.orders = orders;
	}

	public SpecOption() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((optionName == null) ? 0 : optionName.hashCode());
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
		SpecOption other = (SpecOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optionName == null) {
			if (other.optionName != null)
				return false;
		} else if (!optionName.equals(other.optionName))
			return false;
		return true;
	}
	
	
	
}
