<template>
    <mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback"
                  :bottom="100">
        <view class="container">
            <view>
                <swiper class="swiper" :indicator-dots='".swiper-pagination"==null?false:true'
                        :autoplay='autoplaySwiper' :circular='true' indicator-active-color='rgba(255, 0, 0, 1)'
                        indicator-color='rgba(0, 0, 0, 0.3)' :duration='1000' :interval='intervalSwiper'
                        :vertical='"vertical"=="horizontal"?false:true'>
                    <swiper-item v-for="(swiper,index) in swiperList" :key="index">
                        <image mode="aspectFill" :src="swiper"></image>
                    </swiper-item>
                </swiper>
            </view>
            <view class="detail-content">
				<view class="name shop-title"
				      :style='{"boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"rgba(102, 204, 204, 1)","color":"#000","borderRadius":"20rpx","borderWidth":"2rpx","fontSize":"32rpx","borderStyle":"solid","margin-top":"5rpx","height":"100rpx"}'>
				    标题：{{detail.youxiushijiName}}
				</view>
                <view class="detail-list-item"
                      :style='{"boxShadow":"0 0 10rpx rgba(0,0,0,.3)","margin":"0 0 10rpx 0","borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"10rpx","borderWidth":"2rpx","borderStyle":"solid","height":"68rpx"}'>
                    <view class="lable"
                          :style='{"width":"auto","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>
                        相关人物：
                    </view>
                    <view class="text" :style='{"color":"#333","textAlign":"left","fontSize":"28rpx"}'>
                        {{detail.youxiushijiRenwu}}
                    </view>
                </view>
				<view class="detail-list-item"
				      :style='{"boxShadow":"0 0 10rpx rgba(0,0,0,.3)","margin":"0 0 10rpx 0","borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"10rpx","borderWidth":"2rpx","borderStyle":"solid","height":"68rpx"}'>
				    <view class="lable"
				          :style='{"width":"auto","fontSize":"28rpx","color":"rgba(51, 153, 153, 1)","textAlign":"left"}'>
				        事迹类型：
				    </view>
				    <view class="text" :style='{"color":"#333","textAlign":"left","fontSize":"28rpx"}'>
				        {{detail.youxiushijiValue}}
				    </view>
				</view>
            </view>


            <view class="time-content"
                  :style='{"boxShadow":"0 0 16rpx rgba(0,0,0,.3)","margin":"0 0 10rpx 0","borderColor":"rgba(51, 153, 153, 1)","backgroundColor":"#fff","borderRadius":"0","borderWidth":"2rpx","borderStyle":"solid","height":"100%"}'
                  style="height:auto !important;">
                <view class="header" :style='{"color":"rgba(51, 153, 153, 1)","fontSize":"28rpx"}'>
                    详情:
                </view>
                <view class="content" :style='{"color":"#333","fontSize":"28rpx"}'>
                    {{detail.youxiushijiContent}}
                </view>
            </view>

        </view>

    </mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				autoplaySwiper: false ? true : false,
				intervalSwiper: false ? $template2.front.base.swiper.autoplay.delay : 5000,
				btnColor: ['#409eff', '#67c23a', '#909399', '#e6a23c', '#f56c6c', '#356c6c', '#351c6c', '#f093a9',
					'#a7c23a', '#104eff', '#10441f', '#a21233', '#503319'
				],
				id: '',
				detail: {},//本页面数据对象
				swiperList: [],//主图
				commentList: [],//评论留言数据集合
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: {},//登录学生信息
				collectionFlag: 0,//收藏
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			this.id = options.id;
		},
		async onShow(options) {
			// 渲染数据
			this.init();
			
			let table = uni.getStorageSync("nowTable");
			// 获取学生信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(() => {
				return (0.5 - Math.random());
			});
			let cleanType = uni.getStorageSync('youxiushijiState')
			if (cleanType) {
				uni.removeStorageSync('youxiushijiState')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
			}
			
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
		    //下载
            download(url) {
                let _this = this;
                uni.downloadFile({
                    url: url,
                    success: (res) => {
                        if (res.statusCode === 200) {
                            _this.$utils.msg('下载成功');
                            window.open(url);
                        }
                    }
                });
            },
			// 获取详情
			async init() {
				let res = await this.$api.info('youxiushiji', this.id);
				this.detail = res.data;
				// 主图
				this.swiperList = this.detail.youxiushijiPhoto ? this.detail.youxiushijiPhoto.split(",") : [];
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let res = await this.$api.list('youxiushiji', {
					page: mescroll.num,
					limit: mescroll.size,
					youxiushijiId: this.id
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

			},
		}
	}
</script>

<style lang="scss">
    .container {
        // padding-bottom: 80upx;
    }

    .container:after {
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

    .swiper {
        width: 100%;
        height: 450 upx;

        image {
            width: 100%;
        }
    }

    .detail-content {
        font-size: 28 upx;
        color: #888888;
        // padding: 10upx 20upx;
        background: #FFFFFF;
        line-height: 45 upx;

        .name {
            font-size: 38 rpx;
            font-weight: blod;
            // margin-bottom: 20upx;
            padding-top: 20 upx;
        }

        .price {
            font-size: 33 rpx;
            color: red;
            // margin-top: 20upx;
        }
    }

    .time-content {
        background: #FFFFFF;
        padding: 30 upx;
        font-size: 30 upx;
        border-radius: 20 upx;
        margin-top: 20 upx;

        .header {
            font-size: 33 upx;
            margin-bottom: 20 upx;
        }
    }

    .bottom-content {
        position: fixed;
        bottom: 0;
        left: 0;
        width: 100%;
    }

    .comoment-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding-bottom: 12 upx;

        .btn-comment-content {
            color: #DD514C;
            font-weight: bold;
            padding: 0 12 upx;
        }
    }

    .comment-item {
        margin-bottom: 10 upx;
        border-bottom: 1px solid #EEEEEE;
        padding-bottom: 20 upx;

        .content {
            margin-left: 20 upx;
            margin-top: 20 upx;
        }
    }

    .icon {
        width: 50 upx;
        height: 50 upx;
    }

    .popup-content {
        .popup-form {
            background: #FFFFFF;
            margin-top: 20 upx;
        }

        .btn-content {
            text-align: right;
            background: #FFFFFF;

            button {
                margin-left: 20 upx;
                margin-right: 20 upx;
                margin-bottom: 20 upx;
            }
        }
    }

    .detail-list-item {
        padding: 0 24 upx;
        box-sizing: border-box;
        display: flex;
        align-items: center;
        height: 68 upx;
        border-bottom: 2 upx solid #efefef;
        background-color: #fff;

        .lable {
            font-size: 28 upx;
            color: #000;
        }

        .text {
            flex: 1;
            font-size: 24 upx;
            color: #FF00FF;
            text-align: left;
        }

        &.favor {
            .el-icon-star-on {
                color: inherit;
                font-size: inherit;
            }
        }
    }

    .detail-content .shop-title {
        padding: 20 upx 24 upx;
        box-sizing: border-box;
        line-height: 100rpx;
    }

    .priceFavor {
        height: 96 upx !important;
    }

    .priceFavor .text {
        font-size: 64 upx !important;
        color: red !important;
    }

    .priceFavor .icon {
        font-size: 56 upx !important;
        text-align: right !important;
        color: red !important;
    }
</style>
