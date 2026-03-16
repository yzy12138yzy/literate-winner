package com.entity.view;

import com.entity.JiazhengfuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 家政服务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
@TableName("jiazhengfuwu")
public class JiazhengfuwuView  extends JiazhengfuwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiazhengfuwuView(){
	}
 
 	public JiazhengfuwuView(JiazhengfuwuEntity jiazhengfuwuEntity){
 	try {
			BeanUtils.copyProperties(this, jiazhengfuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
