<template>
	<view class="content">
		<view
			:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(51, 153, 153, 1)","margin":"0 0 10rpx 0","borderWidth":"0","borderStyle":"solid","height":"108rpx"}'
			v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title"
				:style='{"width":"170rpx","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>学生姓名
			</view>
			<input style="padding: 0 30upx"
				:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 0)","borderColor":"rgba(51, 153, 153, 1)","borderRadius":"16rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengName" placeholder="学生姓名" readonly></input>
		</view>
		<view
			:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(51, 153, 153, 1)","margin":"0 0 10rpx 0","borderWidth":"0","borderStyle":"solid","height":"108rpx"}'
			v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title"
				:style='{"width":"170rpx","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>身份证号
			</view>
			<input style="padding: 0 30upx"
				:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 0)","borderColor":"rgba(51, 153, 153, 1)","borderRadius":"16rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengIdNumber" placeholder="身份证号" readonly></input>
		</view>
		<view
			:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(51, 153, 153, 1)","margin":"0 0 10rpx 0","borderWidth":"0","borderStyle":"solid","height":"108rpx"}'
			v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title"
				:style='{"width":"170rpx","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>手机号
			</view>
			<input style="padding: 0 30upx"
				:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 0)","borderColor":"rgba(51, 153, 153, 1)","borderRadius":"16rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengPhone" placeholder="手机号" readonly></input>
		</view>
		<view
			:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(51, 153, 153, 1)","margin":"0 0 10rpx 0","borderWidth":"0","borderStyle":"solid","height":"108rpx"}'
			v-if="tableName=='xuesheng'" class="cu-form-group">
			<view class="title"
				:style='{"width":"170rpx","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>年级
			</view>
			<input style="padding: 0 30upx"
				:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 0)","borderColor":"rgba(51, 153, 153, 1)","borderRadius":"16rpx","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengNianji" placeholder="年级" readonly></input>
		</view>
		<view
			:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(51, 153, 153, 1)","margin":"0 0 10rpx 0","borderWidth":"0","borderStyle":"solid","height":"108rpx"}'
			v-if="tableName=='xuesheng'" @tap="xueshengPhotoTap" class="cu-form-group">
			<view class="title"
				:style='{"width":"170rpx","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>照片
			</view>
			<image
				:style='{"width":"76rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"0","textAlign":"left","height":"76rpx"}'
				v-if="ruleForm.xueshengPhoto" class="avator" :src="ruleForm.xueshengPhoto" mode=""></image>
			<image
				:style='{"width":"76rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"0","textAlign":"left","height":"76rpx"}'
				v-else class="avator" src="../../static/center/face.jpeg" mode=""></image>
		</view>

		<view class="btn">
			<view class="box" :style="{width: 'auto'}">
				<button @tap="update()" class="cu-btn lg"
					:style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"rgba(153, 0, 51, 1)","borderColor":"rgba(153, 0, 51, 1)","borderRadius":"8rpx","color":"#fff","borderWidth":"0","width":"auto","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'>保存</button>
			</view>

			<view class="box" :style="{width: 'auto'}">
				<button @tap="logout()" class="cu-btn lg"
					:style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"rgba(0, 102, 51, 1)","borderColor":"#E6A23C","borderRadius":"8rpx","color":"#fff","borderWidth":"0px","width":"auto","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'>退出登录</button>
			</view>
		</view>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
			ref="createTime" themeColor="#333333"></w-picker>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				ruleForm: {},
				tableName: "",
				youxiushijiTypesOptions: [],
				youxiushijiTypesIndex: 0,
			}
		},
		async onLoad() {
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.ruleForm = res.data;
			this.tableName = table;
			// 自定义下拉框值

			if (this.tableName == 'xuesheng') {
				let params = {
					page: 1,
					limit: 100,
					dicCode: 'youxiushiji_types',
				}
				let res = await this.$api.page(`dictionary`, params);

				this.youxiushijiTypesOptions = res.data.list
			}
			// this.styleChange()
		},
		methods: {
			// 日期控件
			createTimeConfirm(val) {
				console.log(val)
				this.ruleForm.createTime = val.result;
				this.$forceUpdate();
			},
			// // 下拉变化
			// styleChange() {
			// 	this.$nextTick(() => {
			// 		// document.querySelectorAll('.cu-form-group .uni-input-input').forEach(el=>{
			// 		//   el.style.backgroundColor = this.userInfoForm.list.input.backgroundColor
			// 		// })
			// 	})
			// },
			// 获取uuid
			getUUID() {
				return new Date().getTime();
			},
			logout() {
				uni.setStorageSync('token', '');
				this.$utils.jump('../login/login');
			},
			// 注册
			async update() {
				if ((!this.ruleForm.xueshengName) && `xuesheng` == this.tableName) {
					this.$utils.msg(`学生姓名不能为空`);
					return
				}
				if (`xuesheng` == this.tableName && this.ruleForm.xueshengPhone && (!this.$validate.isMobile(this.ruleForm
						.xueshengPhone))) {
					this.$utils.msg(`手机应输入手机格式`);
					return
				}
				if (`xuesheng` == this.tableName && this.ruleForm.xueshengIdNumber && (!this.$validate.checkIdCard(this
						.ruleForm.xueshengIdNumber))) {
					this.$utils.msg(`身份证应输入正确格式`);
					return
				}
				if ((!this.ruleForm.xueshengPhoto) && `xuesheng` == this.tableName) {
					this.$utils.msg(`照片不能为空`);
					return
				}


				let table = uni.getStorageSync("nowTable");
				await this.$api.update(table, this.ruleForm);
				this.$utils.msgBack('修改成功');;
			},
			xueshengPhotoTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.xueshengPhoto = _this.$base.url + 'upload/' + res.file;
					_this.$forceUpdate();
				});
			},

			toggleTab(str) {
				this.$refs[str].show();
			}

		}
	}
</script>

<style lang="scss" scoped>
	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
		background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	.avator {
		width: 110upx;
		height: 110upx;
		border-radius: 50%;
		margin-left: 30upx;
	}

	.cu-form-group.active {
		justify-content: space-between;
	}

	.cu-btn {
		width: 100%;
	}

	.right-input {
		flex: 1;
		text-align: left;
		line-height: 88rpx;
	}

	.btn {
		display: flex;
		align-items: center;
		justify-content: center;
		flex-wrap: wrap;
		padding: 20upx 0;
	}

	.box {
		width: auto;
		padding: 0 10upx;
		box-sizing: border-box;
		margin-bottom: 20upx;
	}

	.cu-btn {
		width: 100% !important;
	}

	.picker-select-input {
		line-height: 88rpx;
	}
</style>
