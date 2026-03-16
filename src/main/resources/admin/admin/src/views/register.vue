<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__fadeInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">家政保洁预约系统</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('zhuzhi')?'required':''">住址：</div>
						<el-input  v-model="ruleForm.zhuzhi"  autocomplete="off" placeholder="住址"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('dianpumingcheng')?'required':''">店铺名称：</div>
						<el-input  v-model="ruleForm.dianpumingcheng"  autocomplete="off" placeholder="店铺名称"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('dianpudizhi')?'required':''">店铺地址：</div>
						<el-input  v-model="ruleForm.dianpudizhi"  autocomplete="off" placeholder="店铺地址"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('fuwufanwei')?'required':''">服务范围：</div>
						<el-input  v-model="ruleForm.fuwufanwei"  autocomplete="off" placeholder="服务范围"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('yingyeshijian')?'required':''">营业时间：</div>
						<el-input  v-model="ruleForm.yingyeshijian"  autocomplete="off" placeholder="营业时间"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('yingyezhizhao')?'required':''">营业执照：</div>
						<file-upload
							tip="点击上传营业执照"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.yingyezhizhao?ruleForm.yingyezhizhao:''"
							@change="jiazhenggongsiyingyezhizhaoUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jiazhenggongsitouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('yuangonggonghao')?'required':''">员工工号：</div>
						<el-input  v-model="ruleForm.yuangonggonghao"  autocomplete="off" placeholder="员工工号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('yuangongxingming')?'required':''">员工姓名：</div>
						<el-input  v-model="ruleForm.yuangongxingming"  autocomplete="off" placeholder="员工姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="baojieayitouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('gongzuojingyan')?'required':''">工作经验：</div>
						<el-input  v-model="ruleForm.gongzuojingyan"  autocomplete="off" placeholder="工作经验"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'">
						<div class="lable" :class="changeRules('dianpumingcheng')?'required':''">店铺名称：</div>
						<el-select v-model="ruleForm.dianpumingcheng" placeholder="请选择店铺名称" >
							<el-option
								v-for="(item,index) in baojieayidianpumingchengOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
            baojieayidianpumingchengOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					shouji: '',
					zhuzhi: '',
					zhekou: '1',
					touxiang: '',
					status: '',
				}
			}
			if(this.tableName=='jiazhenggongsi'){
				this.ruleForm = {
					dianpumingcheng: '',
					mima: '',
					dianpudizhi: '',
					fuwufanwei: '',
					lianxidianhua: '',
					yingyeshijian: '',
					yingyezhizhao: '',
					touxiang: '',
					sfsh: '',
					shhf: '',
					status: '',
				}
			}
			if(this.tableName=='baojieayi'){
				this.ruleForm = {
					yuangonggonghao: '',
					mima: '',
					yuangongxingming: '',
					nianling: '',
					shouji: '',
					touxiang: '',
					gongzuojingyan: '',
					dianpumingcheng: '',
					status: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.zhuzhi = [{ required: true, message: '请输入住址', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.dianpumingcheng = [{ required: true, message: '请输入店铺名称', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.dianpudizhi = [{ required: true, message: '请输入店铺地址', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.fuwufanwei = [{ required: true, message: '请输入服务范围', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.lianxidianhua = [{ required: true, message: '请输入联系电话', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.yingyeshijian = [{ required: true, message: '请输入营业时间', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.yingyezhizhao = [{ required: true, message: '请输入营业执照', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.yuangonggonghao = [{ required: true, message: '请输入员工工号', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.yuangongxingming = [{ required: true, message: '请输入员工姓名', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.nianling = [{ required: true, message: '请输入年龄', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
			this.$http({
				url: `option/jiazhenggongsi/dianpumingcheng`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.baojieayidianpumingchengOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiazhenggongsiyingyezhizhaoUploadChange(fileUrls) {
            this.ruleForm.yingyezhizhao = fileUrls;
        },
        jiazhenggongsitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        baojieayitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if((!this.ruleForm.xingbie) && `yonghu` == this.tableName){
				this.$message.error(`性别不能为空`);
				return
			}
			if((!this.ruleForm.shouji) && `yonghu` == this.tableName){
				this.$message.error(`手机不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
			if((!this.ruleForm.zhuzhi) && `yonghu` == this.tableName){
				this.$message.error(`住址不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			  if(this.tableName=='jiazhenggongsi'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.dianpumingcheng) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`店铺名称不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.dianpudizhi) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`店铺地址不能为空`);
				return
			}
			if((!this.ruleForm.fuwufanwei) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`服务范围不能为空`);
				return
			}
			if((!this.ruleForm.lianxidianhua) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`联系电话不能为空`);
				return
			}
			if(`jiazhenggongsi` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			if((!this.ruleForm.yingyeshijian) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`营业时间不能为空`);
				return
			}
            if(this.ruleForm.yingyezhizhao!=null) {
                this.ruleForm.yingyezhizhao = this.ruleForm.yingyezhizhao.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.yingyezhizhao) && `jiazhenggongsi` == this.tableName){
				this.$message.error(`营业执照不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.yuangonggonghao) && `baojieayi` == this.tableName){
				this.$message.error(`员工工号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `baojieayi` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `baojieayi` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yuangongxingming) && `baojieayi` == this.tableName){
				this.$message.error(`员工姓名不能为空`);
				return
			}
			if((!this.ruleForm.nianling) && `baojieayi` == this.tableName){
				this.$message.error(`年龄不能为空`);
				return
			}
			if(`baojieayi` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.shouji) && `baojieayi` == this.tableName){
				this.$message.error(`手机不能为空`);
				return
			}
			if(`baojieayi` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240808/4690bab5e91648408e9ba44aedb3ccb2.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240808/4690bab5e91648408e9ba44aedb3ccb2.jpg);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: flex-end;
	align-items: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		border-radius: 10px;
		padding: 30px 20px 20px;
		box-shadow: -10px 0px 13px -7px #000000, 10px 0px 13px -7px #000000, 5px 5px 15px 5px rgba(0,0,0,0);
		margin: 20px 20% 20px 0;
		background: #4dc57b;
		width: 550px;
		}
		border-radius: 0;
		padding: 0;
		margin: 0;
		background: none;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-end;
		align-items: center;
		position: relative;
		height: auto;
		.title {
			padding: 0 8% 0 15%;
			margin: 20px  20px 0;
			color: #000;
			top: 0;
			left: 0;
			background: none;
			font-weight: 600;
			width: calc(78% - 500px);
			font-size: 28px;
			line-height: 50px;
			position: absolute;
			text-align: left;
		}
		.list-item {
			padding: 0 0 0 0px;
			margin: 0 0 10px 120px;
			width: calc(90% - 130px);
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: block;
			}
			.lable {
				padding: 0 10px 0 0;
				color: #fff;
				left: -130px;
				width: 130px;
				font-size: 16px;
				line-height: 34px;
				position: absolute !important;
				text-align: right;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px 0 30px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid rgba(255, 255, 255, .5);
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid rgba(255, 255, 255, .5);
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid rgba(255, 255, 255, .5);
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #fff;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: rgba(255, 255, 255, .6);
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 110px;
				position: absolute;
				content: "*";
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px 0 0 0px;
				padding: 0 10px;
				margin: 0;
				color: #fff;
				background: none;
				flex: 1;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			input:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			input::placeholder {
				color: rgba(255, 255, 255, .6);
				font-size: 16px;
			}
			button {
				border: 0;
				cursor: pointer;
				border-radius: 0 0px 0px 0;
				padding: 0;
				margin: 3px 0 0;
				color: #333;
				background: #f5f5f5;
				width: 150px;
				font-size: 15px;
				height: 34px;
			}
			button:hover {
				opacity: 1;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 20px auto 0 120px;
			color: rgba(0, 0, 0, 1);
			background: #fff;
			display: block;
			width: calc(90% - 130px);
			font-size: 16px;
			height: 40px;
		}
		.r-btn:hover {
			border: 0px solid rgba(85, 170, 0, 1.0);
			color: #00ad45;
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0 0 0 120px;
			color: #fff;
			display: inline-block;
			text-decoration: underline;
			width: 80%;
			font-size: 16px;
			line-height: 50px;
			text-align: center;
		}
		.r-login:hover {
			color: #333;
			opacity: 0.8;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
