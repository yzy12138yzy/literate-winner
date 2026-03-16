<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="订单编号" prop="dingdanbianhao">
				<el-input v-model="ruleForm.dingdanbianhao" 
					placeholder="订单编号" clearable :disabled=" false  ||ro.dingdanbianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="服务名称" prop="fuwumingcheng">
				<el-input v-model="ruleForm.fuwumingcheng" 
					placeholder="服务名称" clearable :disabled=" false  ||ro.fuwumingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="服务类型" prop="fuwuleixing">
				<el-input v-model="ruleForm.fuwuleixing" 
					placeholder="服务类型" clearable :disabled=" false  ||ro.fuwuleixing"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="服务时长" prop="fuwushizhang">
				<el-input v-model="ruleForm.fuwushizhang" 
					placeholder="服务时长" clearable :disabled=" false  ||ro.fuwushizhang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="服务图片" v-if="type!='cross' || (type=='cross' && !ro.fuwutupian)" prop="fuwutupian">
				<file-upload
					tip="点击上传服务图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.fuwutupian?ruleForm.fuwutupian:''"
					@change="fuwutupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="服务图片" prop="fuwutupian">
				<img v-if="ruleForm.fuwutupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.fuwutupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.fuwutupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="预约时间" prop="yuyueshijian">
				<el-date-picker
					:disabled=" false  ||ro.yuyueshijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.yuyueshijian" 
					type="datetime"
					placeholder="预约时间">
				</el-date-picker>
			</el-form-item>
			<el-form-item class="add-item" label="预约说明" prop="yuyueshuoming">
				<el-input v-model="ruleForm.yuyueshuoming" 
					placeholder="预约说明" clearable :disabled=" false  ||ro.yuyueshuoming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="用户账号" prop="yonghuzhanghao">
				<el-input v-model="ruleForm.yonghuzhanghao" 
					placeholder="用户账号" clearable :disabled=" false  ||ro.yonghuzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="用户姓名" prop="yonghuxingming">
				<el-input v-model="ruleForm.yonghuxingming" 
					placeholder="用户姓名" clearable :disabled=" false  ||ro.yonghuxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="手机" prop="shouji">
				<el-input v-model="ruleForm.shouji" 
					placeholder="手机" clearable :disabled=" false  ||ro.shouji"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="住址" prop="zhuzhi">
				<el-input v-model="ruleForm.zhuzhi" 
					placeholder="住址" clearable :disabled=" false  ||ro.zhuzhi"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="员工工号" prop="yuangonggonghao">
				<el-select  @change="yuangonggonghaoChange" v-model="ruleForm.yuangonggonghao" placeholder="请选择员工工号">
					<el-option
						v-for="(item,index) in yuangonggonghaoOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="员工姓名" prop="yuangongxingming">
				<el-input v-model="ruleForm.yuangongxingming" 
					placeholder="员工姓名" clearable :disabled=" false  ||ro.yuangongxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="店铺名称" prop="dianpumingcheng">
				<el-input v-model="ruleForm.dianpumingcheng" 
					placeholder="店铺名称" clearable :disabled=" false  ||ro.dianpumingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="服务状态" prop="fuwuzhuangtai">
				<el-select v-model="ruleForm.fuwuzhuangtai" placeholder="请选择服务状态" :disabled="true  ||ro.fuwuzhuangtai" >
					<el-option
						v-for="(item,index) in fuwuzhuangtaiOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont "></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont "></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					dingdanbianhao : false,
					fuwumingcheng : false,
					fuwuleixing : false,
					fuwushizhang : false,
					fuwutupian : false,
					yuyueshijian : false,
					yuyueshuoming : false,
					yonghuzhanghao : false,
					yonghuxingming : false,
					shouji : false,
					zhuzhi : false,
					yuangonggonghao : false,
					yuangongxingming : false,
					dianpumingcheng : false,
					fuwuzhuangtai : false,
					crossuserid : false,
					crossrefid : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					dingdanbianhao: '',
					fuwumingcheng: '',
					fuwuleixing: '',
					fuwushizhang: '',
					fuwutupian: '',
					yuyueshijian: '',
					yuyueshuoming: '',
					yonghuzhanghao: '',
					yonghuxingming: '',
					shouji: '',
					zhuzhi: '',
					yuangonggonghao: '',
					yuangongxingming: '',
					dianpumingcheng: '',
					fuwuzhuangtai: '未服务' ,
					crossuserid: '',
					crossrefid: '',
				},
				yuangonggonghaoOptions: [],
				fuwuzhuangtaiOptions: [],


				rules: {
					dingdanbianhao: [
					],
					fuwumingcheng: [
					],
					fuwuleixing: [
					],
					fuwushizhang: [
					],
					fuwutupian: [
					],
					yuyueshijian: [
					],
					yuyueshuoming: [
					],
					yonghuzhanghao: [
					],
					yonghuxingming: [
					],
					shouji: [
						{ validator: this.$validate.isMobile, trigger: 'blur' },
					],
					zhuzhi: [
					],
					yuangonggonghao: [
					],
					yuangongxingming: [
					],
					dianpumingcheng: [
					],
					fuwuzhuangtai: [
					],
					crossuserid: [
					],
					crossrefid: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='dingdanbianhao'){
							this.ruleForm.dingdanbianhao = obj[o];
							this.ro.dingdanbianhao = true;
							continue;
						}
						if(o=='fuwumingcheng'){
							this.ruleForm.fuwumingcheng = obj[o];
							this.ro.fuwumingcheng = true;
							continue;
						}
						if(o=='fuwuleixing'){
							this.ruleForm.fuwuleixing = obj[o];
							this.ro.fuwuleixing = true;
							continue;
						}
						if(o=='fuwushizhang'){
							this.ruleForm.fuwushizhang = obj[o];
							this.ro.fuwushizhang = true;
							continue;
						}
						if(o=='fuwutupian'){
							this.ruleForm.fuwutupian = obj[o].split(",")[0];
							this.ro.fuwutupian = true;
							continue;
						}
						if(o=='yuyueshijian'){
							this.ruleForm.yuyueshijian = obj[o];
							this.ro.yuyueshijian = true;
							continue;
						}
						if(o=='yuyueshuoming'){
							this.ruleForm.yuyueshuoming = obj[o];
							this.ro.yuyueshuoming = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
						if(o=='zhuzhi'){
							this.ruleForm.zhuzhi = obj[o];
							this.ro.zhuzhi = true;
							continue;
						}
						if(o=='yuangonggonghao'){
							this.ruleForm.yuangonggonghao = obj[o];
							this.ro.yuangonggonghao = true;
							continue;
						}
						if(o=='yuangongxingming'){
							this.ruleForm.yuangongxingming = obj[o];
							this.ro.yuangongxingming = true;
							continue;
						}
						if(o=='dianpumingcheng'){
							this.ruleForm.dianpumingcheng = obj[o];
							this.ro.dianpumingcheng = true;
							continue;
						}
						if(o=='fuwuzhuangtai'){
							this.ruleForm.fuwuzhuangtai = obj[o];
							this.ro.fuwuzhuangtai = true;
							continue;
						}
						if(o=='crossuserid'){
							this.ruleForm.crossuserid = obj[o];
							this.ro.crossuserid = true;
							continue;
						}
						if(o=='crossrefid'){
							this.ruleForm.crossrefid = obj[o];
							this.ro.crossrefid = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.dianpumingcheng!=''&&json.dianpumingcheng) || json.dianpumingcheng==0){
							this.ruleForm.dianpumingcheng = json.dianpumingcheng;
							this.ro.dianpumingcheng = true;
						}
					}
				});
				this.$http.get('option/baojieayi/yuangonggonghao', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.yuangonggonghaoOptions = res.data.data;
					}
				});
				this.fuwuzhuangtaiOptions = "已服务,未服务".split(',')

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},
			// 下二随
			yuangonggonghaoChange () {
				this.$http.get('follow/baojieayi/yuangonggonghao?columnValue=' + this.ruleForm.yuangonggonghao, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						if(res.data.data.yuangongxingming){
							this.ruleForm.yuangongxingming = res.data.data.yuangongxingming
						}
					}
				});
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`fuwufenpei/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				var finishNum = 0;
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
								else {
									crossuserid=Number(localStorage.getItem('frontUserid'));
									crossrefid=obj['id'];
									crossoptnum=localStorage.getItem('statusColumnName');
									crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
								}
							}
							if(crossrefid && crossuserid) {
								this.ruleForm.crossuserid=crossuserid;
								this.ruleForm.crossrefid=crossrefid;
								var params = {
									page: 1,
									limit: 10,
									crossuserid:crossuserid,
									crossrefid:crossrefid,
								}
								await this.$http.get('fuwufenpei/list', {
									params: params
								}).then(res => {
									finishNum = res.data.data.total
								});
							}
							if(finishNum>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							}
						}


						await this.$http.post(`fuwufenpei/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			fuwutupianUploadChange(fileUrls) {
				this.ruleForm.fuwutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border-radius: 0px;
				padding: 6px 0 0;
				margin: 0 0 20px 0;
				background: none;
				border-color: #475a8310;
				border-width:  0 0 0px;
				border-style: solid;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #475a8330;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 44px;
					border-radius: 4px;
					background: #0066D4;
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 44px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 1px solid #0066D450;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					color: #0066D4;
					display: inline-block;
					font-size: 16px;
					line-height: 44px;
					border-radius: 4px;
					background: #fff;
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 44px;
					.icon {
						color: #333;
					}
					.text {
						color: #0066D4;
					}
				}
				.closeBtn:hover {
					color: #80593c;
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
