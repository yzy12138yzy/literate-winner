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

import com.entity.FuwuyuyueEntity;
import com.entity.view.FuwuyuyueView;

import com.service.FuwuyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务预约
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
@RestController
@RequestMapping("/fuwuyuyue")
public class FuwuyuyueController {
    @Autowired
    private FuwuyuyueService fuwuyuyueService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuyuyueEntity fuwuyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiazhenggongsi")) {
			fuwuyuyue.setDianpumingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			fuwuyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();


        //查询结果
		PageUtils page = fuwuyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuyuyue), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FuwuyuyueEntity fuwuyuyue, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();

        //查询结果
		PageUtils page = fuwuyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuyuyue), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuyuyueEntity fuwuyuyue){
       	EntityWrapper<FuwuyuyueEntity> ew = new EntityWrapper<FuwuyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuyuyue, "fuwuyuyue")); 
        return R.ok().put("data", fuwuyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuyuyueEntity fuwuyuyue){
        EntityWrapper< FuwuyuyueEntity> ew = new EntityWrapper< FuwuyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuyuyue, "fuwuyuyue")); 
		FuwuyuyueView fuwuyuyueView =  fuwuyuyueService.selectView(ew);
		return R.ok("查询服务预约成功").put("data", fuwuyuyueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuyuyueEntity fuwuyuyue = fuwuyuyueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fuwuyuyue,deSens);
        return R.ok().put("data", fuwuyuyue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuyuyueEntity fuwuyuyue = fuwuyuyueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fuwuyuyue,deSens);
        return R.ok().put("data", fuwuyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuyuyue);
        fuwuyuyueService.insert(fuwuyuyue);
        return R.ok().put("data",fuwuyuyue.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuyuyue);
        fuwuyuyueService.insert(fuwuyuyue);
        return R.ok().put("data",fuwuyuyue.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwuyuyueEntity fuwuyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuyuyue);
        //全部更新
        fuwuyuyueService.updateById(fuwuyuyue);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwuyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
