package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaojieayiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaojieayiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaojieayiView;


/**
 * 保洁阿姨
 *
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
public interface BaojieayiService extends IService<BaojieayiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaojieayiVO> selectListVO(Wrapper<BaojieayiEntity> wrapper);
   	
   	BaojieayiVO selectVO(@Param("ew") Wrapper<BaojieayiEntity> wrapper);
   	
   	List<BaojieayiView> selectListView(Wrapper<BaojieayiEntity> wrapper);
   	
   	BaojieayiView selectView(@Param("ew") Wrapper<BaojieayiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaojieayiEntity> wrapper);

   	

}

