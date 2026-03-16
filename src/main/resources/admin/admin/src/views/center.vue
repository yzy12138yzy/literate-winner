<template>
	<div :style='{"color":"#666","padding":"30px","fontSize":"16px"}'>
		<el-form
			:style='{"padding":"30px 20% 30px 10%","borderColor":"#ddd","borderRadius":"12px","borderStyle":"solid","borderWidth":"1px","background":"rgba(255,255,255,0)"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" readonly						placeholder="用户账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" 						placeholder="用户姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in yonghuxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" 						placeholder="手机" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="住址" prop="zhuzhi">
					<el-input v-model="ruleForm.zhuzhi" 						placeholder="住址" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="折扣" prop="zhekou">
					<el-input v-model="ruleForm.zhekou" readonly						placeholder="折扣" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="yonghutouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='jiazhenggongsi'"  label="店铺名称" prop="dianpumingcheng">
					<el-input v-model="ruleForm.dianpumingcheng" readonly						placeholder="店铺名称" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='jiazhenggongsi'"  label="店铺地址" prop="dianpudizhi">
					<el-input v-model="ruleForm.dianpudizhi" 						placeholder="店铺地址" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='jiazhenggongsi'"  label="服务范围" prop="fuwufanwei">
					<el-input v-model="ruleForm.fuwufanwei" 						placeholder="服务范围" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='jiazhenggongsi'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" 						placeholder="联系电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='jiazhenggongsi'"  label="营业时间" prop="yingyeshijian">
					<el-input v-model="ruleForm.yingyeshijian" 						placeholder="营业时间" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='jiazhenggongsi'" label="营业执照" prop="yingyezhizhao">
					<file-upload
						tip="点击上传营业执照"
						action="file/upload"
						:limit="3"
						:type="3"
						:multiple="true"
						:fileUrls="ruleForm.yingyezhizhao?ruleForm.yingyezhizhao:''"
						@change="jiazhenggongsiyingyezhizhaoUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='jiazhenggongsi'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="jiazhenggongsitouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='baojieayi'"  label="员工工号" prop="yuangonggonghao">
					<el-input v-model="ruleForm.yuangonggonghao" readonly						placeholder="员工工号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='baojieayi'"  label="员工姓名" prop="yuangongxingming">
					<el-input v-model="ruleForm.yuangongxingming" 						placeholder="员工姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='baojieayi'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" 						placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='baojieayi'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" 						placeholder="手机" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='baojieayi'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="baojieayitouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='baojieayi'"  label="工作经验" prop="gongzuojingyan">
					<el-input v-model="ruleForm.gongzuojingyan" 						placeholder="工作经验" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='baojieayi'"  label="店铺名称" prop="dianpumingcheng">
					<el-select v-model="ruleForm.dianpumingcheng"  placeholder="请选择店铺名称">
						<el-option
							v-for="(item,index) in baojieayidianpumingchengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"2px 20px","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
					<el-button class="btn3" :style='{"border":"0px solid #ccc","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#fff","borderRadius":"4px","background":"#00ad45","width":"auto","fontSize":"16px","minWidth":"110px","height":"40px"}' type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
						提交
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
import { 
	isNumber,
	isIntNumer,
	isMobile,
} from "@/utils/validate";

export default {
	data() {
		return {
			ruleForm: {},
			flag: '',
			usersFlag: false,
			yonghuxingbieOptions: [],
			baojieayidianpumingchengOptions: [],
		};
	},
	mounted() {
		var table = this.$storage.get("sessionTable");
		this.flag = table;
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.ruleForm = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
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
	},
	methods: {
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
		usersimageUploadChange(fileUrls) {
			this.ruleForm.image = fileUrls;
		},
		onUpdateHandler() {
			if((!this.ruleForm.yonghuzhanghao)&& 'yonghu'==this.flag){
				this.$message.error('用户账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
				this.$message.error('密码不能为空');
				return
			}

			if((!this.ruleForm.yonghuxingming)&& 'yonghu'==this.flag){
				this.$message.error('用户姓名不能为空');
				return
			}


			if((!this.ruleForm.xingbie)&& 'yonghu'==this.flag){
				this.$message.error('性别不能为空');
				return
			}


			if((!this.ruleForm.shouji)&& 'yonghu'==this.flag){
				this.$message.error('手机不能为空');
				return
			}


			if( 'yonghu' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
			if((!this.ruleForm.zhuzhi)&& 'yonghu'==this.flag){
				this.$message.error('住址不能为空');
				return
			}




			if( 'yonghu' ==this.flag && this.ruleForm.zhekou&&(!isNumber(this.ruleForm.zhekou))){
				this.$message.error(`折扣应输入数字`);
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}


			if( 'yonghu' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
				this.$message.error(`状态应输入整数`);
				return
			}
			if((!this.ruleForm.dianpumingcheng)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('店铺名称不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('密码不能为空');
				return
			}

			if((!this.ruleForm.dianpudizhi)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('店铺地址不能为空');
				return
			}


			if((!this.ruleForm.fuwufanwei)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('服务范围不能为空');
				return
			}


			if((!this.ruleForm.lianxidianhua)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('联系电话不能为空');
				return
			}


			if( 'jiazhenggongsi' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			if((!this.ruleForm.yingyeshijian)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('营业时间不能为空');
				return
			}


			if((!this.ruleForm.yingyezhizhao)&& 'jiazhenggongsi'==this.flag){
				this.$message.error('营业执照不能为空');
				return
			}


			if(this.ruleForm.yingyezhizhao!=null) {
				this.ruleForm.yingyezhizhao = this.ruleForm.yingyezhizhao.replace(new RegExp(this.$base.url,"g"),"");
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}






			if( 'jiazhenggongsi' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
				this.$message.error(`状态应输入整数`);
				return
			}
			if((!this.ruleForm.yuangonggonghao)&& 'baojieayi'==this.flag){
				this.$message.error('员工工号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'baojieayi'==this.flag){
				this.$message.error('密码不能为空');
				return
			}

			if((!this.ruleForm.yuangongxingming)&& 'baojieayi'==this.flag){
				this.$message.error('员工姓名不能为空');
				return
			}


			if((!this.ruleForm.nianling)&& 'baojieayi'==this.flag){
				this.$message.error('年龄不能为空');
				return
			}


			if( 'baojieayi' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.shouji)&& 'baojieayi'==this.flag){
				this.$message.error('手机不能为空');
				return
			}


			if( 'baojieayi' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}






			if( 'baojieayi' ==this.flag && this.ruleForm.status&&(!isIntNumer(this.ruleForm.status))){
				this.$message.error(`状态应输入整数`);
				return
			}
			if('users'==this.flag && this.ruleForm.username.trim().length<1) {
				this.$message.error(`用户名不能为空`);
				return	
			}
			if(this.flag=='users'){
				this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
			}
			this.$http({
				url: `${this.$storage.get("sessionTable")}/update`,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "修改信息成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							if(this.flag=='users'){
								this.$storage.set('headportrait',this.ruleForm.image)
							}
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
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
				padding: 0 10px 0 0;
				color: #666;
				font-weight: 500;
				width: 180px;
				font-size: 16px;
				line-height: 40px;
				text-align: right;
			}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 0 12px;
				color: #666;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 0 10px 0 30px;
				color: #666;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
				border: 0px solid #ccc;
				cursor: pointer;
				border-radius: 0px;
				color: #666;
				background: #fff;
				object-fit: cover;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
				border: 0px solid #ccc;
				cursor: pointer;
				border-radius: 0px;
				color: #666;
				background: #fff;
				object-fit: cover;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 16px;
				min-width: 400px;
				height: 120px;
			}
	
	.add-update-preview .btn3 {
				border: 0px solid #ccc;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 10px 0 0;
				color: #fff;
				background: #00ad45;
				width: auto;
				font-size: 16px;
				min-width: 110px;
				height: 40px;
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
