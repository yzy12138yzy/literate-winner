<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">家政保洁预约系统</p></div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuzhanghao">
						<div class="label" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuxingming">
						<div class="label" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="zhuzhi">
						<div class="label" :class="changeRules('zhuzhi')?'required':''">住址：</div>
						<el-input v-model="registerForm.zhuzhi"  placeholder="请输入住址" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="dianpumingcheng">
						<div class="label" :class="changeRules('dianpumingcheng')?'required':''">店铺名称：</div>
						<el-input v-model="registerForm.dianpumingcheng"  placeholder="请输入店铺名称" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="dianpudizhi">
						<div class="label" :class="changeRules('dianpudizhi')?'required':''">店铺地址：</div>
						<el-input v-model="registerForm.dianpudizhi"  placeholder="请输入店铺地址" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="fuwufanwei">
						<div class="label" :class="changeRules('fuwufanwei')?'required':''">服务范围：</div>
						<el-input v-model="registerForm.fuwufanwei"  placeholder="请输入服务范围" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="lianxidianhua">
						<div class="label" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="yingyeshijian">
						<div class="label" :class="changeRules('yingyeshijian')?'required':''">营业时间：</div>
						<el-input v-model="registerForm.yingyeshijian"  placeholder="请输入营业时间" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="yingyezhizhao">
						<div class="label" :class="changeRules('yingyezhizhao')?'required':''">营业执照：</div>
						<file-upload
							tip="点击上传营业执照"
							action="file/upload"
							:limit="1"
							:type="3"
							:multiple="true"
							:fileUrls="registerForm.yingyezhizhao?registerForm.yingyezhizhao:''"
							@change="jiazhenggongsiyingyezhizhaoUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhenggongsi'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="jiazhenggongsitouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="yuangonggonghao">
						<div class="label" :class="changeRules('yuangonggonghao')?'required':''">员工工号：</div>
						<el-input v-model="registerForm.yuangonggonghao"  placeholder="请输入员工工号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="yuangongxingming">
						<div class="label" :class="changeRules('yuangongxingming')?'required':''">员工姓名：</div>
						<el-input v-model="registerForm.yuangongxingming"  placeholder="请输入员工姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="nianling">
						<div class="label" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input v-model.number="registerForm.nianling"  placeholder="请输入年龄" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="shouji">
						<div class="label" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="baojieayitouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="gongzuojingyan">
						<div class="label" :class="changeRules('gongzuojingyan')?'required':''">工作经验：</div>
						<el-input v-model="registerForm.gongzuojingyan"  placeholder="请输入工作经验" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='baojieayi'" prop="dianpumingcheng">
						<div class="label" :class="changeRules('dianpumingcheng')?'required':''">店铺名称：</div>
						<el-select v-model="registerForm.dianpumingcheng" placeholder="请选择店铺名称" >
							<el-option
								v-for="(item,index) in baojieayidianpumingchengOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            baojieayidianpumingchengOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					xingbie: '',
					shouji: '',
					zhuzhi: '',
					zhekou: Number('1') ,
					touxiang: '',
					status: '',
				}
			}
			if(this.tableName=='jiazhenggongsi'){
				this.registerForm = {
					dianpumingcheng: '',
					mima: '',
					mima2: '',
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
				this.registerForm = {
					yuangonggonghao: '',
					mima: '',
					mima2: '',
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
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',');
			if ('yonghu' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }];
				this.requiredRules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
				this.requiredRules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.zhuzhi = [{ required: true, message: '请输入住址', trigger: 'blur' }];
				this.requiredRules.zhuzhi = [{ required: true, message: '请输入住址', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.dianpumingcheng = [{ required: true, message: '请输入店铺名称', trigger: 'blur' }];
				this.requiredRules.dianpumingcheng = [{ required: true, message: '请输入店铺名称', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.dianpudizhi = [{ required: true, message: '请输入店铺地址', trigger: 'blur' }];
				this.requiredRules.dianpudizhi = [{ required: true, message: '请输入店铺地址', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.fuwufanwei = [{ required: true, message: '请输入服务范围', trigger: 'blur' }];
				this.requiredRules.fuwufanwei = [{ required: true, message: '请输入服务范围', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
				this.requiredRules.lianxidianhua = [{ required: true, message: '请输入联系电话', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.yingyeshijian = [{ required: true, message: '请输入营业时间', trigger: 'blur' }];
				this.requiredRules.yingyeshijian = [{ required: true, message: '请输入营业时间', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.yingyezhizhao = [{ required: true, message: '请上传营业执照', trigger: 'blur' }];
				this.requiredRules.yingyezhizhao = [{ required: true, message: '请上传营业执照', trigger: 'blur' }]
			}
			if ('jiazhenggongsi' == this.tableName) {
				this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
			}
			if ('baojieayi' == this.tableName) {
				this.rules.yuangonggonghao = [{ required: true, message: '请输入员工工号', trigger: 'blur' }];
				this.requiredRules.yuangonggonghao = [{ required: true, message: '请输入员工工号', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.yuangongxingming = [{ required: true, message: '请输入员工姓名', trigger: 'blur' }];
				this.requiredRules.yuangongxingming = [{ required: true, message: '请输入员工姓名', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumerNotNull, trigger: 'blur' }];
				this.requiredRules.nianling = [{ required: true, message: '请输入年龄', trigger: 'blur' }]
			}
			if ('baojieayi' == this.tableName) {
				this.rules.shouji = [{ required: true, validator: this.$validate.isMobileNotNull, trigger: 'blur' }];
				this.requiredRules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			this.$http({
				url: `option/jiazhenggongsi/dianpumingcheng`,
				method: "get",
				params: {}
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.baojieayidianpumingchengOptions = data.data;
				}
			});
			if ('baojieayi' == this.tableName) {
				this.rules.status = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		yonghutouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		jiazhenggongsiyingyezhizhaoUploadChange(fileUrls) {
			this.registerForm.yingyezhizhao = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		jiazhenggongsitouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		baojieayitouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(this.tableName=='jiazhenggongsi'){
						this.registerForm.sfsh = '待审核'
					}
					if(`jiazhenggongsi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`baojieayi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background-repeat: no-repeat;
		background-size: 100% 105% !important;
		background: url(http://codegen.caihongy.cn/20241010/b69d118332f9468884d1a35f8134443d.jpg);
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		background-position: center center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20241010/b69d118332f9468884d1a35f8134443d.jpg);
		.rgs-form {
			padding: 20px 150px 0 80px;
			margin: 0 40% 10% 0;
			z-index: 10;
			background: #fff;
			display: flex;
			width: 800px;
			justify-content: flex-start;
			align-items: center;
			height: auto;
			.rgs-form2 {
				width: 100%;
				.title {
					margin: 0 0 30px -80px;
					color: #333;
					background: none;
					font-weight: 600;
					width: calc(100% + 230px);
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					padding: 0;
					margin: 0 auto 20px;
					background: none;
					width: 100%;
					position: relative;
					/deep/.el-form-item__content {
						padding: 0 0 0 120px;
						display: block;
						width: 100%;
						.label {
							padding: 0 5px 0 0;
							z-index: 999;
							color: #333;
							left: 0;
							width: 120px;
							font-size: 16px;
							line-height: 40px;
							position: absolute !important;
							text-align: right;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							margin: 0 10px 0 0;
							color: red;
							left: 110px;
							position: inherit;
							content: "*";
						}
						.el-input {
							flex: 1;
							width: 100%;
						}
						.el-input .el-input__inner {
							border: 1px solid #0A75E750;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input .el-input__inner:focus {
							border: 1px solid #0A75E7;
							border-radius: 0;
							padding: 0 10px;
							outline: none;
							color: #666;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input-number {
							flex: 1;
							width: 100%;
						}
						.el-input-number .el-input__inner {
							text-align: left;
							border: 1px solid #0A75E750;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input-number .el-input-number__decrease {
							display: none;
						}
						.el-input-number .el-input-number__increase {
							display: none;
						}
						.el-select {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-select .el-input__inner {
							border: 1px solid #0A75E750;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-select .el-input__inner:focus {
							border: 1px solid #0A75E7;
							border-radius: 0;
							padding: 0 10px;
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-date-editor {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-date-editor .el-input__inner {
							border: 1px solid #0A75E750;
							border-radius: 0;
							padding: 0 10px 0 30px;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-date-editor .el-input__inner:focus {
							border: 1px solid #0A75E7;
							border-radius: 0;
							padding: 0 10px 0 30px;
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px solid #0A75E750;
							cursor: pointer;
							border-radius: 0px;
							color: #0A75E760;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 50px;
							text-align: center;
							height: 50px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px solid #0A75E750;
							cursor: pointer;
							border-radius: 0px;
							color: #0A75E760;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 50px;
							text-align: center;
							height: 50px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px solid #0A75E750;
							cursor: pointer;
							border-radius: 0px;
							color: #0A75E760;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 50px;
							text-align: center;
							height: 50px;
						}
						.el-upload__tip {
							color: #666;
							font-size: 15px;
						}
						.emailInput {
							border: 1px solid #0A75E750;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							margin: 0;
							color: #606266;
							background: #fff;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.emailInput:focus {
							border: 1px solid #0A75E7;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							outline: none;
							color: #606266;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-btn {
							border: 1px solid #0A75E7;
							cursor: pointer;
							border-radius: 0 0px 0px 0;
							padding: 0 10px;
							margin: 0;
							color: #fff;
							background: #0A75E7;
							width: 110px;
							font-size: 15px;
							border-width: 1px 1px 1px 0;
							float: right;
							height: 40px;
						}
						.el-btn:hover {
							opacity: 1;
						}
						
						.el-input__inner::placeholder {
							color: #999;
							font-size: 15px;
						}
						input::placeholder {
							color: #999;
							font-size: 15px;
						}
						.editor {
							margin: 0;
							background: #fff;
							width: calc(100% - 0px);
							height: auto;
						}
					}
				}
				.register-btn {
					margin: 20px auto;
					width: 100%;
				}
				.register-btn1 {
					padding: 0 0 0 120px;
					width: 100%;
				}
				.register-btn2 {
					padding: 0 0 0 120px;
					margin: 10px auto;
					width: 100%;
					text-align: right;
				}
				.register_btn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 30px;
					margin: 0 0px;
					color: #0A75E7;
					background: #caeeff;
					font-weight: 600;
					letter-spacing: 4px;
					width: auto;
					font-size: 18px;
					height: 40px;
				}
				.register_btn:hover {
				}
				.has_btn {
					cursor: pointer;
					padding: 0;
					color: #555;
					display: inline-block;
					text-decoration: none;
					font-size: 15px;
					line-height: 40px;
				}
				.has_btn:hover {
					opacity: 0.8;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	::-webkit-scrollbar {
		display: none;
	}
</style>
