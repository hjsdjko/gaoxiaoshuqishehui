








const menu = {
    list() {
        return [
    {
        "backMenu":[
        ],
        "frontMenu":[
        ],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"否",
        "hasFrontRegister":"否",
        "roleName":"管理员",
        "tableName":"users"
    },
    {
        "backMenu":[
			
			{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"活动发布信息",
                        "menuJump":"列表",
                        "tableName":"huodongfabu"
                    }
                ],
                "menu":"活动发布信息"
            }
			,
			{
			    "child":[
			        {
			            "buttons":[
			                "查看"
			            ],
			            "menu":"活动报名信息",
			            "menuJump":"列表",
			            "tableName":"huodongbaoming"
			        }
			    ],
			    "menu":"活动报名信息"
			}
			,
			{
                "child":[
                    {
                        "buttons":[
                            "查看",
                            "新增"
                        ],
                        "menu":"爱心捐物信息",
                        "menuJump":"列表",
                        "tableName":"juanzheng"
                    }
                ],
                "menu":"爱心捐物信息"
            }
			,
			{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"活动宣传信息",
                        "menuJump":"列表",
                        "tableName":"news"
                    }
                ],
                "menu":"活动宣传信息"
            }
			,
			{
                "child":[
                    {
                        "buttons":[
                            "查看"
                        ],
                        "menu":"优秀事迹栏目信息",
                        "menuJump":"列表",
                        "tableName":"youxiushiji"
                    }
                ],
                "menu":"优秀事迹栏目信息"
            }
        ],
        "frontMenu":[
        ],
        "hasBackLogin":"是",
        "hasBackRegister":"否",
        "hasFrontLogin":"是",
        "hasFrontRegister":"是",
        "roleName":"学生",
        "tableName":"xuesheng"
    }
]

	}
}
export default menu;
