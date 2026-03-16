package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FuwujiluEntity;
import com.entity.view.FuwujiluView;

import com.service.FuwujiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
@RestController
@RequestMapping("/fuwujilu")
public class FuwujiluController {
    @Autowired
    private FuwujiluService fuwujiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwujiluEntity fuwujilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fuwujilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("baojieayi")) {
			fuwujilu.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			fuwujilu.setDianpumingcheng((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();


        //查询结果
		PageUtils page = fuwujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwujilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwujiluEntity fuwujilu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();

        //查询结果
		PageUtils page = fuwujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwujilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwujiluEntity fuwujilu){
       	EntityWrapper<FuwujiluEntity> ew = new EntityWrapper<FuwujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwujilu, "fuwujilu")); 
        return R.ok().put("data", fuwujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwujiluEntity fuwujilu){
        EntityWrapper< FuwujiluEntity> ew = new EntityWrapper< FuwujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwujilu, "fuwujilu")); 
		FuwujiluView fuwujiluView =  fuwujiluService.selectView(ew);
		return R.ok("查询服务记录成功").put("data", fuwujiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fuwujilu,deSens);
        return R.ok().put("data", fuwujilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwujiluEntity fuwujilu = fuwujiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fuwujilu,deSens);
        return R.ok().put("data", fuwujilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwujilu);
        fuwujiluService.insert(fuwujilu);
        return R.ok().put("data",fuwujilu.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwujilu);
        fuwujiluService.insert(fuwujilu);
        return R.ok().put("data",fuwujilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwujiluEntity fuwujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwujilu);
        //全部更新
        fuwujiluService.updateById(fuwujilu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
