package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.BaojieayiDao;
import com.entity.BaojieayiEntity;
import com.service.BaojieayiService;
import com.entity.vo.BaojieayiVO;
import com.entity.view.BaojieayiView;

@Service("baojieayiService")
public class BaojieayiServiceImpl extends ServiceImpl<BaojieayiDao, BaojieayiEntity> implements BaojieayiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaojieayiEntity> page = this.selectPage(
                new Query<BaojieayiEntity>(params).getPage(),
                new EntityWrapper<BaojieayiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaojieayiEntity> wrapper) {
		  Page<BaojieayiView> page =new Query<BaojieayiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<BaojieayiVO> selectListVO(Wrapper<BaojieayiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaojieayiVO selectVO(Wrapper<BaojieayiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaojieayiView> selectListView(Wrapper<BaojieayiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaojieayiView selectView(Wrapper<BaojieayiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
