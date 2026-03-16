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

import com.entity.FuwufenpeiEntity;
import com.entity.view.FuwufenpeiView;

import com.service.FuwufenpeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务分配
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-06 08:48:06
 */
@RestController
@RequestMapping("/fuwufenpei")
public class FuwufenpeiController {
    @Autowired
    private FuwufenpeiService fuwufenpeiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwufenpeiEntity fuwufenpei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fuwufenpei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("baojieayi")) {
			fuwufenpei.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			fuwufenpei.setDianpumingcheng((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<FuwufenpeiEntity> ew = new EntityWrapper<FuwufenpeiEntity>();


        //查询结果
		PageUtils page = fuwufenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwufenpei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FuwufenpeiEntity fuwufenpei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FuwufenpeiEntity> ew = new EntityWrapper<FuwufenpeiEntity>();

        //查询结果
		PageUtils page = fuwufenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwufenpei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwufenpeiEntity fuwufenpei){
       	EntityWrapper<FuwufenpeiEntity> ew = new EntityWrapper<FuwufenpeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwufenpei, "fuwufenpei")); 
        return R.ok().put("data", fuwufenpeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwufenpeiEntity fuwufenpei){
        EntityWrapper< FuwufenpeiEntity> ew = new EntityWrapper< FuwufenpeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwufenpei, "fuwufenpei")); 
		FuwufenpeiView fuwufenpeiView =  fuwufenpeiService.selectView(ew);
		return R.ok("查询服务分配成功").put("data", fuwufenpeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwufenpeiEntity fuwufenpei = fuwufenpeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fuwufenpei,deSens);
        return R.ok().put("data", fuwufenpei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwufenpeiEntity fuwufenpei = fuwufenpeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fuwufenpei,deSens);
        return R.ok().put("data", fuwufenpei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwufenpeiEntity fuwufenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwufenpei);
        fuwufenpeiService.insert(fuwufenpei);
        return R.ok().put("data",fuwufenpei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwufenpeiEntity fuwufenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwufenpei);
        fuwufenpeiService.insert(fuwufenpei);
        return R.ok().put("data",fuwufenpei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwufenpeiEntity fuwufenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwufenpei);
        //全部更新
        fuwufenpeiService.updateById(fuwufenpei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwufenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
