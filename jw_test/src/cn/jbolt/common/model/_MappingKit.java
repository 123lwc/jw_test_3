package cn.jbolt.common.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JBolt, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("comment", "id", Comment.class);
		arp.addMapping("manager", "id", Manager.class);
		arp.addMapping("order", "id", Order.class);
		arp.addMapping("product", "id", Product.class);
		arp.addMapping("shopping_address", "id", ShoppingAddress.class);
		arp.addMapping("shopping_cart", "id", ShoppingCart.class);
		arp.addMapping("store", "id", Store.class);
		arp.addMapping("user", "id", User.class);
	}
}

