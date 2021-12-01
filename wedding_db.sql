/*
 Navicat Premium Data Transfer

 Source Server         : gll
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : wedding_db

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 01/12/2021 11:24:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advisement
-- ----------------------------
DROP TABLE IF EXISTS `advisement`;
CREATE TABLE `advisement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片链接',
  `business_ower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属商家',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `is_show` int(1) NULL DEFAULT 1 COMMENT '是否显示，是为0，否为1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '前台公告栏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advisement
-- ----------------------------
INSERT INTO `advisement` VALUES (1, 'Queen Mae Lee婚纱设计师店\r\n分享Queen Mae Lee婚纱设计', '从默默无闻到盈盈相待 我是“Queen Mae Lee”明眸善眯里的永如初见！ 用心的设计，上乘的材质，在没有完美，只有追求完美的道路上前进！', '../static/1.jpg', 'Queen Mae Lee婚纱设计师店', '2021-02-19 16:00:49', 1);
INSERT INTO `advisement` VALUES (2, '浠曼婚礼定制', 'Golden Wedding浠曼婚礼定制承诺意向金随时可退', '../static/2.jpg', 'Golden Wedding', '2021-02-17 00:29:41', 0);
INSERT INTO `advisement` VALUES (3, '婚礼策划', '瑾•婚礼创立于2016年，是一所综合时尚与传统,满足各类人士对不同婚典要求的婚庆策划公司，是由80、90后团队为主力的婚礼策划公司。公司致力于打造轻奢婚礼服务品牌,婚礼统筹-策划-实施一站式服务。关于', '../static/3.jpg', '瑾婚礼', '2021-02-17 00:29:41', 0);
INSERT INTO `advisement` VALUES (4, 'FLOWERQUEEN花城皇后婚纱礼服', '1200平一站式婚礼殿堂，三个独立试衣间，一对一试纱服务', '../static/4.jpg', 'FLOWERQUEEN花城皇后', '2021-02-17 00:29:41', 0);
INSERT INTO `advisement` VALUES (5, '可及婚礼', '可及婚礼承诺意向金随时可退', '../static/5.jpg', '可及婚礼', '2021-02-17 00:29:41', 0);
INSERT INTO `advisement` VALUES (7, '巴黎婚纱全球旅拍（华南总店）', '巴黎婚纱全球旅拍（华南总店）承诺下单7天内可退\r\n巴黎婚纱全球旅拍（华南总店）承诺下单7天内可退\r\n巴黎婚纱全球旅拍（华南总店）承诺下单7天内可退', '../static/6.jpg', '张大大', '2021-02-19 15:54:59', 1);

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `roleId` int(4) NULL DEFAULT NULL COMMENT '所属角色id',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `card_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `support_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照',
  `is_locked` int(1) NULL DEFAULT NULL COMMENT '1正常，0锁定',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (1, 'mama', '12345678', NULL, 2, '15889836831', '老色批', NULL, NULL, 1, '2021-04-24 03:49:10');

-- ----------------------------
-- Table structure for client_user
-- ----------------------------
DROP TABLE IF EXISTS `client_user`;
CREATE TABLE `client_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户账号',
  `nickname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户昵称',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `real_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '真实姓名',
  `birthday` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '生日',
  `card_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '身份证号码',
  `role_id` int(4) NULL DEFAULT NULL COMMENT '用户角色id',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户头像',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `integral` int(11) NULL DEFAULT 0 COMMENT '用户剩余积分',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '1为正常，0为禁止',
  `level` int(2) NULL DEFAULT 0 COMMENT '等级',
  `addres` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '详细地址',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `sex` int(1) NULL DEFAULT 1 COMMENT '性别，0未知，1男，2女，3保密',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE,
  INDEX `level`(`level`) USING BTREE,
  INDEX `status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client_user
-- ----------------------------
INSERT INTO `client_user` VALUES (1, 'lily', '爆米花', NULL, '12345678', NULL, NULL, NULL, 2, 'https://thirdwx.qlogo.cn/mmopen/vi_32/icypRbicuubAP5qoN5Zlknvu1oLBRbMHbAYGHLs9rJeKbd6gFobHwbIFL6UbY8ILw50mJPWMbcn66RBiacUVpGfhw/132', NULL, 0, 1, 0, '中国,陕西,西安', '2021-02-06 12:48:37', 1);
INSERT INTO `client_user` VALUES (2, '夜深了', NULL, NULL, '12345678', NULL, NULL, NULL, 2, NULL, NULL, NULL, 1, NULL, NULL, '2021-04-06 01:03:45', NULL);
INSERT INTO `client_user` VALUES (3, 'hhh', NULL, NULL, '12345678', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, '2021-04-13 21:57:40', NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `looked_time` int(11) NULL DEFAULT 1 COMMENT '浏览次数',
  `comment_star` int(11) NULL DEFAULT 3 COMMENT '评论星级，>=3为中好评，<3为差评',
  `approve_time` int(11) NULL DEFAULT 0 COMMENT '赞同次数',
  `assess_time` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsId`(`goods_id`) USING BTREE,
  CONSTRAINT `goodsId` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (33, 'nice!!', NULL, 10907, 'hhh', NULL, NULL, NULL, '2021-04-24 07:01:39');
INSERT INTO `comment` VALUES (34, '灰常好，值得一试！！', NULL, 15, 'hhh', NULL, NULL, NULL, '2021-04-24 09:09:01');
INSERT INTO `comment` VALUES (35, '商家人热情，服务周到，而且价格实惠，值得推荐！！', NULL, 25, 'hhh', NULL, NULL, NULL, '2021-04-24 10:13:37');

-- ----------------------------
-- Table structure for good_type
-- ----------------------------
DROP TABLE IF EXISTS `good_type`;
CREATE TABLE `good_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类型',
  `type_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型介绍  ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '房间类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good_type
-- ----------------------------
INSERT INTO `good_type` VALUES (1, '推荐', '');
INSERT INTO `good_type` VALUES (2, '结婚用品', '婚礼所需物品');
INSERT INTO `good_type` VALUES (3, '婚纱摄影', '婚纱照拍摄');
INSERT INTO `good_type` VALUES (4, '婚纱礼服', '婚纱礼服定制或租用');
INSERT INTO `good_type` VALUES (5, '婚宴酒店', '婚礼场地');
INSERT INTO `good_type` VALUES (6, '婚礼策划套餐', '一站式服务');

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品表主键id',
  `goods_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品名',
  `goods_intro` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品简介',
  `goods_type_id` int(11) NOT NULL DEFAULT 0 COMMENT '关联分类id',
  `goods_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/admin/dist/img/no-img.png' COMMENT '商品主图',
  `goods_detail_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品详情',
  `original_price` decimal(11, 2) NOT NULL DEFAULT 1.00 COMMENT '商品价格',
  `selling_price` decimal(11, 2) NOT NULL DEFAULT 1.00 COMMENT '商品实际售价',
  `stock_num` int(11) NOT NULL DEFAULT 0 COMMENT '商品库存数量',
  `tag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '商品标签',
  `goods_sell_status` int(4) NOT NULL DEFAULT 0 COMMENT '商品上架状态 0-下架 1-上架',
  `sell_num` int(11) NULL DEFAULT 0 COMMENT '销售量',
  `business_id` int(11) NOT NULL COMMENT '所属商家id',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10912 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (1, '广州十甫假日酒店', '豪华四星', 1, '../static/goodsInfo/h.jpg', '酒店介绍\r\n酒店位于荔湾区繁华的上下九步行街，由洲际酒店管理集团管理。无柱宴会厅325㎡设有大型高清LED显示屏，可容纳23桌中式婚宴。西餐厅可容纳260人西式婚宴。酒店设有天台露天泳池，可举行户外证婚仪式。', 5988.00, 7999.00, 1, '4个婚宴厅&4套套餐', 1, 0, 1);
INSERT INTO `goods_info` VALUES (2, '广州博雅假日酒店', '五星豪华', 1, '../static/goodsInfo/login_bg.jpg', '酒店座落于风景秀丽，拥有广州之“肺”之称的白云山脚下，位于广州市白云区金钟横路177号。毗邻万达广场与兴发广场，距广州火车站不到三公里路程。', 9980.00, 6999.00, 1, '西式户外草坪婚礼&网红ins风', 1, 0, 1);
INSERT INTO `goods_info` VALUES (3, '广州香格里拉大酒店', '两个婚宴厅', 1, '../static/goodsInfo/login_bg.jpg', '广州香格里拉大酒店位于城中新商业区的黄金地段，坐拥青葱园林，俯瞰珠江的秀丽景致，以“亚洲式殷勤待客之道”为旅客们诠释香格里拉之典范。5800平方米的户外庭院、露天泳池以及推杆练习场，让宾客尽享舒适 　', 8999.00, 8999.00, 1, '4个婚宴厅&5套套餐', 1, 0, 1);
INSERT INTO `goods_info` VALUES (4, '薇薇新娘婚纱摄影', '扫地机器人+登记照', 1, '../static/goodsInfo/f.jpg', '九大奢华路线任选其一【门票车费商家支付】 路线1:惠州哈施塔特影视基地 路线2：清远卡萨布兰卡 路线3：江门环球影视城 路线4：中山高凡游艇会 路线5：佛山国艺影视城 路线6：深圳玫瑰海岸 路线7：惠州十里滩 路线8: 深圳澳洲世纪摄影基地 路线9: 百万葵园', 9999.00, 6999.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (5, '广州婚纱摄影套餐', '【轻奢定制】店长推荐+底片全送+无隐形消费', 1, '../static/goodsInfo/i.jpg', '造型\n新娘服装3套\n新郎服装3套\n服装说明男女各3套礼服服务\n造型说明集团新锐化妆师一对一服务 整体妆面造型3套 国际一线品牌化妆品定制妆容\n场景\n拍摄场景纯内景\n内景数量8个以上\n内景说明【free界外单元】经典棚拍艺术，包含肖像、单背等拍摄风格\n拍摄\n拍摄天数1天\n拍摄张数100张\n精修张数20张\n入册张数20张', 9999.00, 6999.00, 1, '底片全送&无隐形消费', 1, 0, 1);
INSERT INTO `goods_info` VALUES (6, '2号唐厨明星级婚礼殿堂', '超赞厨艺', 5, '../static/goodsInfo/j.jpg', '多个精致宴会厅选择，提供一站式婚礼服务，包括豪华梦幻婚礼场地布置（留影区，签到区，T台，交接亭等），四大金刚（摄影，摄像，化妆，主持），新郎和新娘服装，兄弟团和姐妹团服装，席前视频播放等等服务。', 99999.00, 69998.00, 1, '一站式&粤菜名店', 1, 0, 1);
INSERT INTO `goods_info` VALUES (7, '丹尼·英伦婚纱摄影', '新品·轻奢内景+九州岛网红景点+8套服装一价全包', 3, '../static/goodsInfo/d.jpg', 'A 线:深圳玫瑰小镇（5万平方摄影基地+7万平方花海+中世纪欧洲小镇+七大教堂群+欧式古堡+欧洲风情街+浪漫玫瑰和薰衣草花海+奢华欧式3D内景）+玫瑰小镇海景（五星推荐） B 线:丹尼英伦室内景+深圳西涌悬崖海景 C 线:丹尼英伦室内景棚 + 深圳渔农居牧场 D 线:丹尼英伦室内景棚 + 清远九龙湖欧洲小镇（欧洲街道+5万平方中世纪欧式建筑+草坪+湖景+英伦桥景）（五星推荐） F线: 丹尼英伦室内景棚 + 广州景点任选', 10888.00, 9999.00, 1, '九州岛&网红景点', 1, 0, 1);
INSERT INTO `goods_info` VALUES (8, '绿岛ParkCafe户外婚礼会所', '梦幻仙境', 5, '../static/goodsInfo/k.jpg', '酒店介绍\r\n位于越秀公园地铁站附近，毗邻兰圃公园，周边繁华，交通便利，拥有大型免费停车场，户外大草坪，室内轻松自助餐区，求婚、结婚、周年庆等浪漫的西式宴会，让众多宾客喜出望外，美好的回忆萦绕于心', 14000.00, 69993.00, 1, '情侣探店&试餐尊享5折优惠', 1, 0, 1);
INSERT INTO `goods_info` VALUES (9, '美悦盛宴一站式婚礼会馆', '广州粤菜名店、巨型天幕可绽放仪式冷烟花', 5, '../static/goodsInfo/l.jpg', '美悦盛宴是华南地区一站式婚礼会馆品牌，旗下共有6家门店，遍布广州各区核心商圈，提供一站式婚礼服务，包含婚礼场地，婚礼佳肴，摄影摄像，化妆主持，婚礼管家等，选择美悦，花更少的钱，办更美更浪漫的高端婚礼', 20000.00, 69997.00, 1, '浪漫&高端', 1, 0, 1);
INSERT INTO `goods_info` VALUES (10, '2号唐厨明星级婚礼殿堂', '人气高', 5, '../static/goodsInfo/m.jpg', '多个精致宴会厅选择，提供一站式婚礼服务，包括豪华梦幻婚礼场地布置（留影区，签到区，T台，交接亭等），四大金刚（摄影，摄像，化妆，主持），新郎和新娘服装，兄弟团和姐妹团服装，席前视频播放等等服务。', 99999.00, 69998.00, 1, '一站式&粤菜名店', 1, 0, 1);
INSERT INTO `goods_info` VALUES (11, '广州婚纱摄影套餐', '【轻奢定制】店长推荐+底片全送+无隐形消费', 3, '../static/goodsInfo/g.jpg', '造型\n新娘服装3套\n新郎服装3套\n服装说明男女各3套礼服服务\n造型说明集团新锐化妆师一对一服务 整体妆面造型3套 国际一线品牌化妆品定制妆容\n场景\n拍摄场景纯内景\n内景数量8个以上\n内景说明【free界外单元】经典棚拍艺术，包含肖像、单背等拍摄风格\n拍摄\n拍摄天数1天\n拍摄张数100张\n精修张数20张\n入册张数20张', 9999.00, 6999.00, 1, '底片全送&无隐形消费', 1, 0, 1);
INSERT INTO `goods_info` VALUES (12, '丹尼·英伦婚纱摄影', '新品·轻奢内景+九州岛网红景点+8套服装一价全包', 3, '../static/goodsInfo/d.jpg', 'A 线:深圳玫瑰小镇（5万平方摄影基地+7万平方花海+中世纪欧洲小镇+七大教堂群+欧式古堡+欧洲风情街+浪漫玫瑰和薰衣草花海+奢华欧式3D内景）+玫瑰小镇海景（五星推荐） B 线:丹尼英伦室内景+深圳西涌悬崖海景 C 线:丹尼英伦室内景棚 + 深圳渔农居牧场 D 线:丹尼英伦室内景棚 + 清远九龙湖欧洲小镇（欧洲街道+5万平方中世纪欧式建筑+草坪+湖景+英伦桥景）（五星推荐） F线: 丹尼英伦室内景棚 + 广州景点任选', 10888.00, 9999.00, 1, '九州岛&网红景点', 1, 0, 1);
INSERT INTO `goods_info` VALUES (13, '麦田映像婚纱摄影', '原创爆款·轻奢定制', 3, '../static/goodsInfo/e.jpg', '丹尼英伦1000㎡独享5星级内景，提供佳能5D IV 及全套镜头群 提供英国Bowens保荣灯光组合及全套附件', 16000.00, 15888.53, 1, '明星同款&预约立减', 1, 0, 1);
INSERT INTO `goods_info` VALUES (14, '薇薇新娘婚纱摄影', '新品·轻奢内景+九州岛网红景点+8套服装一价全包', 3, '../static/goodsInfo/f.jpg', '酒店介绍\r\n位于越秀公园地铁站附近，毗邻兰圃公园，周边繁华，交通便利，拥有大型免费停车场，户外大草坪，室内轻松自助餐区，求婚、结婚、周年庆等浪漫的西式宴会，让众多宾客喜出望外，美好的回忆萦绕于心', 20000.00, 6999.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (15, '广州婚纱摄影套餐', '梦幻仙境', 2, '../static/goodsInfo/a.jpg', '美悦盛宴是华南地区一站式婚礼会馆品牌，旗下共有6家门店，遍布广州各区核心商圈，提供一站式婚礼服务，包含婚礼场地，婚礼佳肴，摄影摄像，化妆主持，婚礼管家等，选择美悦，花更少的钱，办更美更浪漫的高端婚礼', 99999.00, 69997.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (16, '2号唐厨明星级婚礼殿堂', '广州粤菜名店、巨型天幕可绽放仪式冷烟花', 2, '../static/goodsInfo/n.jpg', '多个精致宴会厅选择，提供一站式婚礼服务，包括豪华梦幻婚礼场地布置（留影区，签到区，T台，交接亭等），四大金刚（摄影，摄像，化妆，主持），新郎和新娘服装，兄弟团和姐妹团服装，席前视频播放等等服务。', 9999.00, 69998.00, 1, '裙褂+晚礼服', 1, 0, 1);
INSERT INTO `goods_info` VALUES (17, '丹尼·英伦婚纱摄影', '人气高', 2, '../static/goodsInfo/o.jpg', '造型\n新娘服装3套\n新郎服装3套\n服装说明男女各3套礼服服务\n造型说明集团新锐化妆师一对一服务 整体妆面造型3套 国际一线品牌化妆品定制妆容\n场景\n拍摄场景纯内景\n内景数量8个以上\n内景说明【free界外单元】经典棚拍艺术，包含肖像、单背等拍摄风格\n拍摄\n拍摄天数1天\n拍摄张数100张\n精修张数20张\n入册张数20张', 10888.00, 6999.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (18, '绿岛ParkCafe户外婚礼会所', '【轻奢定制】店长推荐+底片全送+无隐形消费', 2, '../static/goodsInfo/p.jpg', 'A 线:深圳玫瑰小镇（5万平方摄影基地+7万平方花海+中世纪欧洲小镇+七大教堂群+欧式古堡+欧洲风情街+浪漫玫瑰和薰衣草花海+奢华欧式3D内景）+玫瑰小镇海景（五星推荐） B 线:丹尼英伦室内景+深圳西涌悬崖海景 C 线:丹尼英伦室内景棚 + 深圳渔农居牧场 D 线:丹尼英伦室内景棚 + 清远九龙湖欧洲小镇（欧洲街道+5万平方中世纪欧式建筑+草坪+湖景+英伦桥景）（五星推荐） F线: 丹尼英伦室内景棚 + 广州景点任选', 16000.00, 9999.00, 1, '裙褂+晚礼服', 1, 0, 1);
INSERT INTO `goods_info` VALUES (19, '美悦盛宴一站式婚礼会馆', '新品·轻奢内景+九州岛网红景点+8套服装一价全包', 2, '../static/goodsInfo/q.jpg', '品牌创办历史：风雅阁婚庆策划有限公司是一家专为新人提供全方位婚礼策划服务的公司，由80、90后婚礼策划、时尚、广告各界领域精英团队组成，创立于2010年，是专注于婚礼创意策划、量身定做、一站式服务公司', 20000.00, 15888.53, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (20, '咏赞', '梦幻仙境', 4, '../static/goodsInfo/c.jpg', '汇爱婚礼自2006年成立伊始就致力于打造私人专属的品质婚礼，以细腻独特的婚礼理念、完善细致的婚礼服务、时尚前沿的设计方案得到客户、媒体及同行们的广泛好评。', 99999.00, 6999.00, 1, '裙褂+晚礼服', 1, 0, 1);
INSERT INTO `goods_info` VALUES (21, '咏赞洋服', '广州粤菜名店、巨型天幕可绽放仪式冷烟花', 4, '../static/goodsInfo/1.jpg', '汇爱一直追求在实现新人梦想的同时探索更多可能，十余年脚步，让我们更懂得源于爱情本质的表达——以不拘一格的艺术精神突破陈规桎梏，融入真实深刻的人文关怀，精益求精。', 9999.00, 69997.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (23, 'UHEY Wedding 元禧婚纱', '热销结婚礼服套餐', 4, '../static/goodsInfo/3.jpg', '九大奢华路线任选其一【门票车费商家支付】 路线1:惠州哈施塔特影视基地 路线2：清远卡萨布兰卡 路线3：江门环球影视城 路线4：中山高凡游艇会 路线5：佛山国艺影视城 路线6：深圳玫瑰海岸 路线7：惠州十里滩 路线8: 深圳澳洲世纪摄影基地 路线9: 百万葵园', 16000.00, 6999.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (24, '咏赞洋服', '西服定制', 4, '../static/goodsInfo/4.jpg', '九大奢华路线任选其一【门票车费商家支付】 路线1:惠州哈施塔特影视基地 路线2：清远卡萨布兰卡 路线3：江门环球影视城 路线4：中山高凡游艇会 路线5：佛山国艺影视城 路线6：深圳玫瑰海岸 路线7：惠州十里滩 路线8: 深圳澳洲世纪摄影基地 路线9: 百万葵园', 20000.00, 9999.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (25, '幕后婚礼定制', '\r\n汇爱婚礼致力于打造私人专属的品质婚礼.以细腻独特的婚礼理念、完善细致的婚礼服务,时尚前沿的设计方案得到客户、媒体及同行的广泛好评.迄今为止,已为撒贝宁李白,惠若琪等多位明星举办婚礼.', 6, '../static/goodsInfo/5.jpg', '品牌创办历史：风雅阁婚庆策划有限公司是一家专为新人提供全方位婚礼策划服务的公司，由80、90后婚礼策划、时尚、广告各界领域精英团队组成，创立于2010年，是专注于婚礼创意策划、量身定做、一站式服务公司', 99999.00, 15888.53, 1, '【给力银钻】', 1, 0, 1);
INSERT INTO `goods_info` VALUES (26, '森色婚尚策划', '咨询礼', 6, '../static/goodsInfo/6.jpg', '汇爱婚礼自2006年成立伊始就致力于打造私人专属的品质婚礼，以细腻独特的婚礼理念、完善细致的婚礼服务、时尚前沿的设计方案得到客户、媒体及同行们的广泛好评。', 9999.00, 6999.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (27, '星元素婚礼', '送西装优惠劵500元\r\n', 6, '../static/goodsInfo/7.jpg', '汇爱一直追求在实现新人梦想的同时探索更多可能，十余年脚步，让我们更懂得源于爱情本质的表达——以不拘一格的艺术精神突破陈规桎梏，融入真实深刻的人文关怀，精益求精。', 10888.00, 69997.00, 1, '\r\n680元定制男士衬衫水&晶摆台', 1, 0, 1);
INSERT INTO `goods_info` VALUES (28, '幸福婚礼', '约惠2021，优惠活动进行时，等你来拿！', 6, '../static/goodsInfo/8.jpg', '迄今为止，汇爱已为邓超孙俪、撒贝宁李白、惠若琪等多位明星举办婚礼。', 16000.00, 69998.00, 1, '明星婚礼顾问', 1, 0, 1);
INSERT INTO `goods_info` VALUES (29, '汇爱婚礼', '到店礼', 6, '../static/goodsInfo/9.jpg', '汇爱婚礼广州分公司 ,汇爱婚礼自成立伊始就致力于打造私人专属品质婚礼，以细腻的婚礼理念、完善细致的服务、时尚前沿的设计方案得到客户、媒体及同行们的广泛好评\r\n迄今为止，汇爱已为邓超孙俪、撒贝宁、惠若琪等', 9999.00, 6999.00, 1, '【五大金刚】+【花车装饰】', 1, 0, 1);
INSERT INTO `goods_info` VALUES (10907, '上海婚礼', '但是可能的', 6, '../static/goodsInfo/12.jpg', '一站式婚礼', 9622.00, 5252.00, 1, '高大上', 1, 0, 1);
INSERT INTO `goods_info` VALUES (10909, '哈哈哈', '分手的f', 2, '../static/goodsInfo/11.jpg', 'fest', 615.00, 895.00, 1, '高的', 1, 0, 1);
INSERT INTO `goods_info` VALUES (10910, '河南婚庆', '菜鸟的寄顺丰的', 2, '../static/goodsInfo/11.jpg', '等会我今年大四', 888.36, 9666.65, 1, '高大上', 1, 0, 1);
INSERT INTO `goods_info` VALUES (10911, '天津婚礼策划', '特惠套餐·简约星空婚礼·一价全包·省心服务', 6, '../static/goodsInfo/13.jpg', '\n星元素主要为新人提供创意婚礼策划、个性婚礼定制、主题婚礼设计等婚礼一条龙服务；从每一个爱情故事中提取创意元素，让婚礼更加浪漫、惊喜、感动', 10000.63, 9999.30, 1, '简约&全包', 1, 0, 1);

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录情况',
  `u_id` int(11) NULL DEFAULT NULL COMMENT '用户ID，只有不是账号不存在的情况下才记录',
  `succeed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否成功',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录日期',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0为false，1为true',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 202 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (144, '正常登录', 1, '成功', '2021-04-06 01:15:41', 1);
INSERT INTO `login_log` VALUES (145, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (146, '登出', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (147, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (148, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (149, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (150, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (151, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (152, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (153, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (154, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (155, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (156, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (157, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (158, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (159, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (160, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (161, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (162, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (163, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (164, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (165, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (166, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (167, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (168, '用户不存在', NULL, '失败', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (169, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (170, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (171, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (172, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (173, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (174, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (175, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (176, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (177, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (178, '用户已冻结', NULL, '失败', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (179, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (180, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (181, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (182, '用户不存在', NULL, '失败', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (183, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (184, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (185, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (186, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (187, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (188, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (189, '登出', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (190, '用户不存在', NULL, '失败', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (191, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (192, '用户不存在', NULL, '失败', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (193, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (194, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (195, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (196, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (197, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (198, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (199, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (200, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);
INSERT INTO `login_log` VALUES (201, '正常登录', 1, '成功', '2021-03-17 18:25:37', 0);

-- ----------------------------
-- Table structure for order_type
-- ----------------------------
DROP TABLE IF EXISTS `order_type`;
CREATE TABLE `order_type`  (
  `id` int(11) NOT NULL,
  `status_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_type
-- ----------------------------
INSERT INTO `order_type` VALUES (0, '订单取消');
INSERT INTO `order_type` VALUES (1, '等待商家接单');
INSERT INTO `order_type` VALUES (2, '商家接单');
INSERT INTO `order_type` VALUES (3, '预约成功');
INSERT INTO `order_type` VALUES (4, '等待服务');
INSERT INTO `order_type` VALUES (5, '服务进行中');
INSERT INTO `order_type` VALUES (6, '服务结束');
INSERT INTO `order_type` VALUES (7, '订单完成');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `roleId` int(11) NOT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`roleId`, `permission`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '/wedding/admin/**');
INSERT INTO `permission` VALUES (1, '/wedding/admin/page/**');
INSERT INTO `permission` VALUES (2, '/wedding/admin/good/**');
INSERT INTO `permission` VALUES (2, '/wedding/admin/goodType/**');
INSERT INTO `permission` VALUES (2, '/wedding/admin/page/**');
INSERT INTO `permission` VALUES (2, '/wedding/admin/reserve/edit');
INSERT INTO `permission` VALUES (2, 'wedding/admin/order/**');
INSERT INTO `permission` VALUES (3, '/wedding/client/**');

-- ----------------------------
-- Table structure for reserve_record
-- ----------------------------
DROP TABLE IF EXISTS `reserve_record`;
CREATE TABLE `reserve_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(35) NULL DEFAULT NULL COMMENT '订单编号',
  `goods_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预定商品id',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '服务开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '服务结束时间',
  `get_person_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名字',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '生成时间',
  `flag` int(1) NULL DEFAULT 1 COMMENT '订单状态id，0为预约，1为取消预约',
  `client_id` int(11) NULL DEFAULT NULL COMMENT '预约客户ID',
  `progressId` int(11) NULL DEFAULT NULL COMMENT '预约进度',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `num` int(11) NULL DEFAULT 1 COMMENT '數量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订房记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reserve_record
-- ----------------------------
INSERT INTO `reserve_record` VALUES (28, NULL, '10907', '2021-05-05 09:00:00', '2021-05-06 10:00:00', 'hhh', '13411221952', '天津市天津市河东区&sfdsv', '2021-04-24 06:55:47', 1, 3, 0, NULL, 1);
INSERT INTO `reserve_record` VALUES (31, NULL, '15', '2021-06-01 09:00:00', '2021-06-01 10:00:00', 'hhh', '13477889526', '山西省太原市迎泽区&学校', '2021-04-24 09:02:01', 0, 3, 7, NULL, 1);
INSERT INTO `reserve_record` VALUES (32, NULL, '4', '2021-05-03 08:00:00', '2021-05-03 10:00:00', '哼哼哼', '13577889643', '河北省唐山市路南区&开源大道', '2021-04-24 09:13:08', 0, 3, 1, NULL, 1);
INSERT INTO `reserve_record` VALUES (33, NULL, '25', '2021-05-03 06:00:00', '2021-05-03 07:00:00', 'hhh', '14578974562', '天津市天津市和平区&dsgd ', '2021-04-24 10:10:59', 0, 3, 7, NULL, 1);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色等级',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色职能',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色：后台管理员的权限角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'manager', '1', '管理员');
INSERT INTO `role` VALUES (2, 'business', '2', '商家');
INSERT INTO `role` VALUES (3, 'customer', '3', '客户');

-- ----------------------------
-- Table structure for shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `shop_cart`;
CREATE TABLE `shop_cart`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间/注册时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `goods_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_cart
-- ----------------------------
INSERT INTO `shop_cart` VALUES (64, '2021-04-13 22:06:41', '2021-04-13 22:06:41', 1, 10904, 120);
INSERT INTO `shop_cart` VALUES (68, '2021-04-14 23:14:25', '2021-04-14 23:14:25', 1, 10007, 126);
INSERT INTO `shop_cart` VALUES (69, '2021-04-14 23:14:30', '2021-04-14 23:14:30', 1, 10016, 126);
INSERT INTO `shop_cart` VALUES (70, '2021-04-24 06:54:52', '2021-04-24 06:54:52', 1, 10907, 3);

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '建议人',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES (8, '可以新增与商家线上交流聊天功能吗', 126, 3, '2021-04-24 03:49:10');
INSERT INTO `suggestion` VALUES (9, 'xsdfsjff', 3, 3, '2021-04-24 07:02:32');
INSERT INTO `suggestion` VALUES (10, '建议可以优化9999', 3, 3, '2021-04-24 09:11:51');
INSERT INTO `suggestion` VALUES (11, '建议可以优化在线聊天功能！！', 3, 3, '2021-04-24 10:14:20');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登陆名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT 'MD5加密后的密码',
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '电话号码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `roleId` int(4) NOT NULL COMMENT '所属角色',
  `is_deleted` int(1) NULL DEFAULT 0 COMMENT '注销标识字段(0-正常 1-已注销)',
  `locked_flag` int(1) NOT NULL DEFAULT 0 COMMENT '锁定标识字段(0-未锁定 1-已锁定)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'lili', 'lily', '123456', '', '123', 1, 0, 0, '2021-03-10 17:57:47');
INSERT INTO `sys_user` VALUES (10, '小红', '123', '123', '13411221952', '123', 1, 1, 1, '2021-03-16 14:50:34');
INSERT INTO `sys_user` VALUES (11, '小绿', '123', '456', '13411221952', '123', 1, 0, 0, '2021-03-16 14:50:35');
INSERT INTO `sys_user` VALUES (12, '小明', '123', '123', '12466975521', '123', 1, 0, 0, '2021-03-16 14:50:35');
INSERT INTO `sys_user` VALUES (13, '罗麻麻', '123', '1314', '12466975524', '123', 1, 0, 0, '2021-03-16 14:50:35');
INSERT INTO `sys_user` VALUES (24, '憨憨', '夜深了', '123456', '13478796256', NULL, 4, 0, 0, '2021-04-13 21:25:15');
INSERT INTO `sys_user` VALUES (25, '刚好', '咕噜噜', '123456', '13455449875', NULL, 4, 0, 0, '2021-04-13 22:19:02');

-- ----------------------------
-- Table structure for upload_log
-- ----------------------------
DROP TABLE IF EXISTS `upload_log`;
CREATE TABLE `upload_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `roleid` int(4) NULL DEFAULT NULL,
  `operation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作名称',
  `create_user` int(20) NOT NULL COMMENT '用户名id',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `is_del` int(4) NOT NULL DEFAULT 0 COMMENT '是否删除，否为0，是为1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图片上传记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upload_log
-- ----------------------------
INSERT INTO `upload_log` VALUES (1, '1', 1, '上传头像', 1, '2021-02-17 00:00:00', 0);
INSERT INTO `upload_log` VALUES (2, '2342', 1, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (3, '2342', 1, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (4, '2342', 1, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (5, '2342', 1, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (6, '2342', 1, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (7, '2342', 2, '', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (8, '2342', 2, '', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (9, 'http://127.0.0.1:9000//resources/static/7c62100b301f45d5b31157e6b87ecf08.jpg', 2, '', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (10, 'http://127.0.0.1:9000//resources/static/c0d430ba916e4e1aad90b0c5469c9baa.jpg', 2, '', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (11, 'http://127.0.0.1:9000//resources/static/a3bc236dc29244818d5d50842617c120.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (12, 'http://127.0.0.1:9000//resources/static/477bd64848ca4f668299ab1b12f977f8.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (13, 'http://127.0.0.1:9000//resources/static/57be2d17c4f247d3866bb95b99c87ce9.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (14, 'http://127.0.0.1:9000//resources/static/ba46798f79d74f7688a3affa8c6616e4.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (15, 'http://127.0.0.1:9000//resources/static/459e11fc14cb45a9bb4874066eda12b3.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (16, 'http://127.0.0.1:9000//resources/static/5a66889aab7546c5b72e317e69f1175e.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (17, 'http://127.0.0.1:9000//resources/static/69597c4e16154ae48347ea6824599d93.jpg', 3, '添加商品', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (18, 'http://127.0.0.1:9000//resources/static/ce12fc48b36b4d7e9c53577aef3c77e0.jpg', 4, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (19, 'http://127.0.0.1:9000//resources/static/acc3f025c3ad4a37aae6c1c0947dfaa0.jpg', 4, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (20, 'http://127.0.0.1:9000//resources/static/6870a094c4424f6790fb29e570667791.jpg', 4, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (21, 'http://127.0.0.1:9000//resources/static/dd781ce1ba804fa6b5a34d72cd6ddc20.jpg', 4, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (22, 'http://127.0.0.1:9000//resources/static/fa2a2a3018984cb4aeb7e53a3851a2bd.jpg', 4, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (23, 'http://127.0.0.1:9000//resources/static/9ca57c25e4ab43fb91228fa755e3c1cc.jpg', 4, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (24, 'http://127.0.0.1:9000//resources/static/f20e90bca90843db9aac35799f0817b4.jpg', 1, '上传头像', 1, '2021-02-18 00:00:00', 0);
INSERT INTO `upload_log` VALUES (25, 'http://127.0.0.1:9000//resources/static/e7d58be613584bf0898f5eb3f278ee8c.jpg', 1, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (26, 'http://127.0.0.1:9000//resources/static/3ab7c28944154b63a54eb776c2fc0a7c.jpg', 2, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (27, 'http://127.0.0.1:9000//resources/static/06237ce8ee534752a781a6c7d68cbbc3.jpg', 2, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (28, 'http://127.0.0.1:9000//resources/static/22c2f5e6e90147019419cd562adec474.jpg', 2, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (29, 'http://127.0.0.1:9000//resources/static/42ec4040a62f4d1a956599dc15ef6e67.jpg', 2, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (30, 'http://127.0.0.1:9000//resources/static/29dcd2fa6f7949d698788bb12036f911.jpg', 2, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (31, 'http://127.0.0.1:9000//resources/static/cda93941fbee410e8f2e695f8fc8e22d.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (32, 'http://127.0.0.1:9000//resources/static/528c9e006a9a4e749bb7f5c5d06b3883.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (33, 'http://127.0.0.1:9000//resources/static/4240e4308c2d4e5a9ba4c5da679fd735.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (34, 'http://127.0.0.1:9000//resources/static/b04f5184c94e4c4093dbd8037a923b6e.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (35, 'http://127.0.0.1:9000//resources/static/fc661fa4fabf4412b376c5adf0229617.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (36, 'http://127.0.0.1:9000//resources/static/0e6bbfc918014bb39daa8b09561fa315.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (37, 'http://127.0.0.1:9000//resources/static/a5d90690f5c845c098d49a3c38e7d7c8.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (38, 'http://127.0.0.1:9000//resources/static/3b815a24104742cf9bf35dedeb2f301c.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (39, 'http://127.0.0.1:9000//resources/static/96587f4e6caa4c0fb058bf25b2e77ee5.jpg', NULL, '', 1, '2021-02-19 00:00:00', 0);
INSERT INTO `upload_log` VALUES (40, NULL, 1, '添加商品信息', 0, '2021-03-21 01:42:30', 0);
INSERT INTO `upload_log` VALUES (41, NULL, 1, '添加商品信息', 9, '2021-03-21 02:02:24', 0);
INSERT INTO `upload_log` VALUES (42, '../static/login_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 18:55:10', 0);
INSERT INTO `upload_log` VALUES (43, '../static/goodsInfologin_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 19:08:49', 0);
INSERT INTO `upload_log` VALUES (44, '../static/goodsInfo、/login_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 19:17:32', 0);
INSERT INTO `upload_log` VALUES (45, '../static/goodsInfo/login_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 19:19:46', 0);
INSERT INTO `upload_log` VALUES (46, '../static/goodsInfo/login_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 21:55:07', 0);
INSERT INTO `upload_log` VALUES (47, '../static/goodsInfo/login_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 22:05:39', 0);
INSERT INTO `upload_log` VALUES (48, '../static/goodsInfo/login_bg.jpg', 2, '添加商品信息', 1, '2021-04-13 22:12:52', 0);
INSERT INTO `upload_log` VALUES (49, '../static/goodsInfo/lunbo1.jpg', 2, '添加商品信息', 1, '2021-04-15 00:45:22', 0);
INSERT INTO `upload_log` VALUES (50, '../static/goodsInfo/12.jpg', 2, '添加商品信息', 1, '2021-04-24 06:52:24', 0);
INSERT INTO `upload_log` VALUES (51, '../static/goodsInfo/11.jpg', 2, '添加商品信息', 1, '2021-04-24 06:53:48', 0);
INSERT INTO `upload_log` VALUES (52, '../static/goodsInfo/11.jpg', 2, '添加商品信息', 1, '2021-04-24 09:00:03', 0);
INSERT INTO `upload_log` VALUES (53, '../static/goodsInfo/13.jpg', 2, '添加商品信息', 1, '2021-04-24 10:09:19', 0);

-- ----------------------------
-- Table structure for user_address
-- ----------------------------
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户地址id',
  `uid` int(10) NOT NULL COMMENT '用户id',
  `real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `pro_city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '省市区',
  `detail` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '收货人详细地址',
  `longitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '经度',
  `latitude` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '纬度',
  `is_default` int(1) NOT NULL DEFAULT 0 COMMENT '是否默认',
  `is_del` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `is_default`(`is_default`) USING BTREE,
  INDEX `is_del`(`is_del`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_address
-- ----------------------------
INSERT INTO `user_address` VALUES (1, 2, '小脑斧', NULL, '', '大宅门', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (2, 9, '默默', NULL, '', '长安花园', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (3, 5, '1111', NULL, '', '11111', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (4, 32, '默默', NULL, '', '海伦斯', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (5, 4, '张三', NULL, '', '新港中路397号', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (6, 3, '吵吵', NULL, '', '后卫寨启航时代广场', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (7, 44, '邓鹏飞', NULL, '', '123', '0', '0', 1, 1);
INSERT INTO `user_address` VALUES (8, 46, '杨', NULL, '', '123123', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (9, 45, '羊羊', NULL, '', '华清路32号', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (10, 59, '邓鹏飞', NULL, '', '世纪大道启航时代广场A座(未央区西咸路501号)', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (11, 61, '裴明', NULL, '', '曲江三迪枫丹(西安市雁塔区)', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (12, 62, '邓鹏飞', NULL, '', '世纪大道启航时代广场A座(未央区西咸路501号)', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (13, 86, '李宇锋', NULL, '', '丰李', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (14, 77, 'klloo', NULL, '', 'l12', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (15, 44, '邓鹏飞', NULL, '', '启航时代广场A座1104室', '0', '0', 1, 1);
INSERT INTO `user_address` VALUES (16, 12, '王文超', NULL, '', '韩森寨二十九街坊三单元', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (17, 44, '邓鹏飞', NULL, '', '李家村万达广场1楼', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (18, 97, '彭显示', NULL, '', '上农批', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (19, 102, '去去去', NULL, '', '1231', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (20, 105, '123', NULL, '', '123456', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (21, 60, '邓鹏飞', NULL, '', '123', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (22, 60, '邓鹏飞', NULL, '', '123', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (23, 60, '邓鹏飞', NULL, '', '123', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (24, 60, '邓鹏飞', NULL, '', '123123', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (25, 60, '邓鹏飞', NULL, '', '123123', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (26, 60, '邓鹏飞', NULL, '', '123', '0', '0', 1, 1);
INSERT INTO `user_address` VALUES (27, 60, '邓鹏飞', NULL, '', '123', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (28, 3, 'wwc', NULL, '', '启航时代广场', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (29, 3, '啦啦', NULL, '', '啦啦啦', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (30, 3, '哦哦', NULL, '', '啦啦啦啦啦', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (31, 3, '噼噼啪啪', NULL, '', '后卫寨', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (32, 3, '噼噼啪啪', NULL, '', '后卫寨', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (33, 3, '1', NULL, '', '1', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (34, 3, '9999', NULL, '', '11', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (35, 3, '8888', NULL, '', '1111', '0', '0', 0, 0);
INSERT INTO `user_address` VALUES (36, 59, '邓鹏飞', NULL, '', '世纪大道启航时代广场A座(未央区西咸路501号)', '0', '0', 0, 1);
INSERT INTO `user_address` VALUES (37, 59, '邓鹏飞', NULL, '', '世纪大道启航时代广场A座(未央区西咸路501号)', '0', '0', 1, 0);
INSERT INTO `user_address` VALUES (38, 120, 'lily', '13411221952', '北京市北京市西城区', '贫民窟', NULL, NULL, 0, 0);
INSERT INTO `user_address` VALUES (39, 120, 'lily', '13411221952', '北京市北京市西城区', '贫民窟', NULL, NULL, 0, 0);
INSERT INTO `user_address` VALUES (40, 120, 'lily', '13411221952', '北京市北京市西城区', '贫民窟', NULL, NULL, 0, 0);
INSERT INTO `user_address` VALUES (41, 120, '咕噜噜', '13411221956', '北京市北京市东城区', '大三的', NULL, NULL, 0, 0);
INSERT INTO `user_address` VALUES (42, 120, '第三方', '13569874561', '北京市北京市西城区', '是否', NULL, NULL, 0, 0);
INSERT INTO `user_address` VALUES (43, 120, '打多少', '18964523789', '天津市天津市和平区', '人间仙境', NULL, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
