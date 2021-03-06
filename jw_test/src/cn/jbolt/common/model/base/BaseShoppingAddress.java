package cn.jbolt.common.model.base;
import cn.jbolt.base.JBoltBaseModel;

/**
 * 
 * Generated by JBolt, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseShoppingAddress<M extends BaseShoppingAddress<M>> extends JBoltBaseModel<M>{

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setUserId(java.lang.Integer userId) {
		set("user_id", userId);
		return (M)this;
	}
	
	public java.lang.Integer getUserId() {
		return getInt("user_id");
	}

	public M setLocation(java.lang.String location) {
		set("location", location);
		return (M)this;
	}
	
	public java.lang.String getLocation() {
		return getStr("location");
	}

	public M setIsDefault(java.lang.Integer isDefault) {
		set("is_default", isDefault);
		return (M)this;
	}
	
	public java.lang.Integer getIsDefault() {
		return getInt("is_default");
	}

}
