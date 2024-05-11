<template>
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">

		<view class="cu-bar bg-white search" :style="[{top:CustomBar + 'px'}]">
			<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName"
				:value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
				<view>
					<image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image>
				</view>
			</picker>
			<view class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="searchForm.huodongfabuName" type="text" placeholder="活动发布名称"></input>
			</view>
			<view class="action">
				<button @tap="search" class="cu-btn bg-gradual-green shadow-blur round">搜索</button>
			</view>
		</view>
		
	<scroll-view scroll-x="true" class="tabView"
				 :style='{"padding":"12rpx 12rpx","boxShadow":"0 0 12rpx rgba(255,0,0,0)","margin":"0","borderColor":"rgba(200, 200, 200, 1)","backgroundColor":"rgba(255, 255, 255, 1)","borderRadius":"0","borderWidth":"2rpx","width":"100%","borderStyle":"solid","height":"auto"}'>
		<view :style='categoryName===0' class="tab" :class="categoryName===0?'tabActive':''" @tap="categoryClick(0)">
			全部</view>
		<view :style='categoryName===item.codeIndex?sactiveItem:sitem' class="tab"
			  v-for="(item,index) in huodongfabuTypesList" :key="index"
			  :class="categoryName===item.codeIndex?'tabActive':''" @tap="categoryClick(item.codeIndex)">
			{{item.indexName}}</view>
	</scroll-view>
		
		<view class="uni-product-list" :style='{"borderRadius":"0","backgroundColor":"#efefef"}'>
			<view @tap="onDetailTap(product)" class="uni-product" :style='{"borderRadius":"8rpx","backgroundColor":"rgba(245, 242, 242, 1)"}' v-for="(product,index) in list" :key="index">
		        <view class="uni-product-title" :style='{"fontSize":"28rpx","lineHeight":"56rpx","color":"rgba(0, 102, 51, 1)","textAlign":"center"}'>{{product.huodongfabuName}}</view>
		        <view class="image-view">
		            <image :style='{"borderRadius":"170rpx","width":"400rpx","height":"300rpx"}' mode="aspectFill" class="uni-product-image" :src="product.huodongfabuPhoto?product.huodongfabuPhoto.split(',')[0]:''"></image>
		        </view>
				<view style="display: flex;justify-content: space-between;">
					<text v-if="isAuth('huodongfabu','修改')" class="cuIcon-edit" @click.stop="onUpdateTap(product.id)">修改</text>
					<text v-if="isAuth('huodongfabu','删除')" class="cuIcon-delete" @click.stop="onDeleteTap(product.id)">删除</text>
				</view>
			</view>
		</view>
		



		<button v-if="isAuth('huodongfabu','新增')" class="add-btn" @click="onAddTap()">新增</button>

	</mescroll-uni>
</template>


<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff', '#67c23a', '#909399', '#e6a23c', '#f56c6c', '#356c6c', '#351c6c', '#f093a9',
					'#a7c23a', '#104eff', '#10441f', '#a21233', '#503319'
				],
				queryList: [{
						queryName: "活动发布名称",
					}
				],
				sactiveItem: {
					"padding": "0 20rpx",
					"boxShadow": "0 0 0px rgba(0,0,0,.3)",
					"margin": "0 12rpx",
					"borderColor": "rgba(242, 199, 68, 1)",
					"backgroundColor": "rgba(242, 199, 68, 1)",
					"color": "rgba(0, 0, 0, 1)",
					"borderRadius": "40rpx",
					"borderWidth": "2rpx",
					"width": "auto",
					"lineHeight": "56rpx",
					"fontSize": "24rpx",
					"borderStyle": "solid"
				},
				sitem: {
					"padding": "0 20rpx",
					"boxShadow": "0 0 0px rgba(0,0,0,.3)",
					"margin": "0 12rpx",
					"borderColor": "rgba(215, 215, 215, 1)",
					"backgroundColor": "rgba(247, 247, 247, 1)",
					"color": "#333",
					"borderRadius": "40rpx",
					"borderWidth": "2rpx",
					"width": "auto",
					"lineHeight": "56rpx",
					"fontSize": "24rpx",
					"borderStyle": "solid"
				},
				list: [],
                user:{},
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm: {},
				/*1111*/
				huodongfabuTypesList: [],
				categoryName: 0,
				CustomBar: '0'
			};
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(() => {
				return (0.5 - Math.random());
			});

            let _this = this
            let table = uni.getStorageSync("nowTable");
            // 获取学生信息
            let resA = await _this.$api.session(table);
            _this.user = resA.data;
            _this.btnColor = _this.btnColor.sort(() => {
                return (0.5 - Math.random());
            });

	   		//当前表的 活动类型 字段 字典表查询方法
		  	let huodongfabuTypes = await this.$api.page('dictionary', {
			 	 page: 1,
			  	limit: 100,
		  		dicCode:'huodongfabu_types'
		  	});
		  	this.huodongfabuTypesList = huodongfabuTypes.data.list;


			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		onLoad() {
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
			//查询条件切换
			queryChange(e) {
				this.searchForm.huodongfabuName = "";
			},
			//类别搜索
			categoryClick(categoryName) {
				this.categoryName = categoryName;
				this.mescroll.resetUpScroll();
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}

							if (this.categoryName != 0) {
                                params.huodongfabuTypes = this.categoryName
                            }


				let res = await this.$api.list(`huodongfabu`, params);
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
				this.$utils.jump(`./detail?id=${item.id}`)
			},
			// 修改
			onUpdateTap(id) {
				this.$utils.jump(`./add-or-update?id=${id}`)
			},
			// 添加
			onAddTap() {
				this.$utils.jump(`./add-or-update`)
			},
			onDeleteTap(id) {
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('huodongfabu', JSON.stringify([id]));
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.mescroll.resetUpScroll()
						}
					}
				});
			},
			// 搜索
			async search() {
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				if (this.searchForm.huodongfabuName) {
					searchForm['huodongfabuName'] = this.searchForm.huodongfabuName
				}
				let res = await this.$api.list(`huodongfabu`, searchForm);
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
		}
	};
</script>

<style>
	/* product */
	page {
		background: #EEEEEE;
	}
	
	view {
		font-size: 28upx;
	}
	
	.tabView {
		display: flex;
		align-items: center;
		justify-content: flex-start;
		background: #ffffff;
		height: 60upx;
		margin-bottom: 20upx;
		white-space: nowrap;
		box-shadow: 0px 1px 14px 0px rgba(38, 38, 35, 0.07);
		margin-top: 6upx;
	}
	
	.tab {
		text-align: center;
		display: inline-block;
		margin: 0 12rpx;
		padding: 0 20rpx;
		width: auto;
		line-height: 56rpx;
		color: #333;
		font-size: 24rpx;
		border-radius: 40rpx;
		border-width: 2rpx;
		border-style: solid;
		border-color: rgba(215, 215, 215, 1);
		background-color: rgba(247, 247, 247, 1);
		box-shadow: 0 0 0px rgba(0, 0, 0, .3);
	}
	
	.tabActive {
		margin: 0 12rpx;
		padding: 0 20rpx;
		width: auto;
		line-height: 56rpx;
		color: rgba(0, 0, 0, 1);
		font-size: 24rpx;
		border-radius: 40rpx;
		border-width: 2rpx;
		border-style: solid;
		border-color: rgba(242, 199, 68, 1);
		background-color: rgba(242, 199, 68, 1);
		box-shadow: 0 0 0px rgba(0, 0, 0, .3);
	}
	
	.tab:last-of-type {
		border: none;
	}
	
	.uni-product-list {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		flex-direction: row;
		margin-top: 0upx;
		justify-content: space-around;
	}
	
	.uni-product {
		padding: 10upx;
		margin: 10upx;
		display: flex;
		flex-direction: column;
		background: #FFFFFF;
	}
	
	.image-view {
		height: 330upx;
		width: 330upx;
		margin: 12upx 0;
	}
	
	.uni-product-image {
		height: 330upx;
		width: 330upx;
	}
	
	.uni-product-title {
		width: 300upx;
		word-break: break-all;
		display: -webkit-box;
		overflow: hidden;
		line-height: 1.5;
		text-overflow: ellipsis;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 2;
	}
	
	.uni-product-price {
		margin-top: 10upx;
		font-size: 28upx;
		line-height: 1.5;
		position: relative;
	}
	
	.uni-product-price-original {
		color: #e80080;
	}
	
	.uni-product-price-favour {
		color: #888888;
		text-decoration: line-through;
		margin-left: 10upx;
	}
	
	.uni-product-tip {
		position: absolute;
		right: 10upx;
		background-color: #ff3333;
		color: #ffffff;
		padding: 0 10upx;
		border-radius: 5upx;
	}
	
	uni-image>div,
	uni-image>img {
		width: 100%;
		height: 140px;
		object-fit: cover;
	}
	
	.add-btn {
		position: fixed;
		left: 30upx;
		right: 30upx;
		// #ifndef MP
		bottom: 106upx;
		// #endif
		// #ifdef MP-WEIXIN
		bottom: 16upx;
		// #endif
		z-index: 95;
		display: flex;
		align-items: center;
		justify-content: center;
		width: 690upx;
		height: 80upx;
		font-size: 32upx;
		color: #fff;
		background-color: red;
		border-radius: 10upx;
		box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
	}
	
	.list {
		padding: 20upx 20upx 20upx;
	}
	
	.listm {
		background: #fff;
		border-radius: 15upx;
		box-shadow: 0 0 2upx rgba(0, 0, 0, 0.1);
		margin-bottom: 20upx;
		padding: 30upx;
	}
	
	.listmpic {
		border-radius: 10upx;
		width: 166upx;
		margin-right: 20upx;
	}
	
	.listmr {
		// width: 460upx;
		display: inline-block;
		flex: 1;
		display: flex;
		justify-content: space-between;
		flex-direction: column;
	}
	.address-box {
	    display: flex;
	    align-items: center;
	}
</style>
