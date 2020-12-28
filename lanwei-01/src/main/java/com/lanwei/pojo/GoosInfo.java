package com.lanwei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/* 封装商品信息  */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class GoosInfo {

	private Integer goosId;//商品ID
	private String goosname; //商品名称
	private String madeIn;//产地
	private String manufacturer;//制造商
	private Double price;//商品价格
	private String spec; //规格

}
