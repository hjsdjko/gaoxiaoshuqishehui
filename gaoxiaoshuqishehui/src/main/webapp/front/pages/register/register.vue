








<template>
	<view class="content">
		<view class="logo">
			<image :style='{"boxShadow":"0 0 16rpx #59f43e","borderColor":"#ccc","borderRadius":"40rpx","borderWidth":"2rpx","width":"160rpx","borderStyle":"solid","url":"http://localhost:8080/gaoxiaoshuqishehui/img/logo.jpg","isShow":false,"height":"160rpx"}' src='http://localhost:8080/gaoxiaoshuqishehui/img/logo.jpg' mode="aspectFill"></image>
		</view>
		<view v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
			<input
				:style='{"borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"20rpx","color":"#333","textAlign":"left","borderWidth":"4rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.username" type="text" class="uni-input" name="" placeholder="学号" />
		</view>
		<view v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
			<input
				:style='{"borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"20rpx","color":"#333","textAlign":"left","borderWidth":"4rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengName" type="text" class="uni-input" name="" placeholder="姓名" />
		</view>
		<view v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
			<input
				:style='{"borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"20rpx","color":"#333","textAlign":"left","borderWidth":"4rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.password" type="password" class="uni-input" name="" placeholder="密码" />
		</view>
		<view v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
			<input
				:style='{"borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"20rpx","color":"#333","textAlign":"left","borderWidth":"4rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengPhone" type="text" class="uni-input" name="" placeholder="手机" />
		</view>
		<view v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
			<input
				:style='{"borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"20rpx","color":"#333","textAlign":"left","borderWidth":"4rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
				v-model="ruleForm.xueshengIdNumber" type="text" class="uni-input" name="" placeholder="身份证" />
		</view>
		<view v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
			<picker @change="xueshengsexTypesChange" :value="xueshengsexTypesIndex" :range="xueshengsexTypesOptions" range-key="indexName">
				<view
					:style='{"borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"20rpx","color":"#333","textAlign":"left","borderWidth":"4rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx"}'
					class="uni-input">{{ruleForm.sexValue?ruleForm.sexValue:"请选择性别"}}</view>
			</picker>
		</view>
		<view>
			<button @tap="register" type="primary"
				:style='{"borderColor":"rgba(254, 254, 254, 1)","backgroundColor":"rgba(153, 0, 51, 1)","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0px","fontSize":"32rpx","borderStyle":"solid","height":"90rpx"}'>注册</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				xueshengsexTypesOptions: [],
				xueshengsexTypesIndex: 0,
				ruleForm: {},
				tableName: ""
			}
		},
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
			this.tableName = table;

			// 自定义下拉框值
			if (this.tableName == 'xuesheng') {
				let params = {
					page: 1,
					limit: 100,
					dicCode: 'sex_types',
				}
				let res = await this.$api.page(`dictionary`, params);
				this.xueshengsexTypesOptions = res.data.list
			}

			this.styleChange()
		},
		methods: {

			// 下拉变化
			xueshengsexTypesChange(e) {
				this.xueshengsexTypesIndex = e.target.value
				this.ruleForm.sexValue = this.xueshengsexTypesOptions[this.xueshengsexTypesIndex].indexName
				this.ruleForm.sexTypes = this.xueshengsexTypesOptions[this.xueshengsexTypesIndex].codeIndex
			},

			styleChange() {
				this.$nextTick(() => {
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID() {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if ((!this.ruleForm.username) && `xuesheng` == this.tableName) {
					this.$utils.msg(`姓名不能为空`);
					return
				}
				if ((!this.ruleForm.password) && `xuesheng` == this.tableName) {
					this.$utils.msg(`密码不能为空`);
					return
				}
				if ((!this.ruleForm.xueshengName) && `xuesheng` == this.tableName) {
					this.$utils.msg(`姓名不能为空`);
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
				await this.$api.register(`xuesheng`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	$color-primary: #b49950;

	.content {
		padding: 100upx;
	}

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

	.logo {
		text-align: center;

		image {
			height: 200upx;
			width: 200upx;
			margin: 0 0 60upx;
		}
	}

	.uni-form-item {
		margin-bottom: 40upx;
		padding: 0;

		.uni-input {
			font-size: 30upx;
			padding: 7px 0;
		}
	}

	button[type="primary"] {
		background-color: $color-primary;
		border-radius: 0;
		font-size: 34upx;
		margin-top: 60upx;
	}

	.links {
		text-align: center;
		margin-top: 40upx;
		font-size: 26upx;
		color: #999;

		view {
			display: inline-block;
			vertical-align: top;
			margin: 0 10upx;
		}

		.link-highlight {
			color: $color-primary
		}
	}

	.picker-select-input {
		line-height: 80rpx;
	}
</style>
