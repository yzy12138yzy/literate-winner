package com.dao;

import com.entity.BaojieayiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaojieayiVO;
import com.entity.view.BaojieayiView;


/**
 * 保洁阿姨
 * 
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
public interface BaojieayiDao extends BaseMapper<BaojieayiEntity> {
	
	List<BaojieayiVO> selectListVO(@Param("ew") Wrapper<BaojieayiEntity> wrapper);
	
	BaojieayiVO selectVO(@Param("ew") Wrapper<BaojieayiEntity> wrapper);
	
	List<BaojieayiView> selectListView(@Param("ew") Wrapper<BaojieayiEntity> wrapper);

	List<BaojieayiView> selectListView(Pagination page,@Param("ew") Wrapper<BaojieayiEntity> wrapper);

	
	BaojieayiView selectView(@Param("ew") Wrapper<BaojieayiEntity> wrapper);
	

}
