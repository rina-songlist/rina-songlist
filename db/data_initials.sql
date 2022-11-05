-- ----------------------------
-- Table structure for menu
-- ----------------------------

INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '系统管理', 'iconfont icon-activity', '', NULL, 1, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '用户展示', 'iconfont icon-createtask', NULL, NULL, 2, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '用户管理', 'iconfont icon-workbench', '/pc/system/users', 1, 1, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '角色管理', 'iconfont icon-group', '/pc/system/role', 1, 2, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '菜单管理', 'iconfont icon-workbench', '/pc/system/menu', 1, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, '歌单展示', 'iconfont icon-document', '/pc/show/song-list', 2, 1, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu` (`menu_id`, `menu_name`, `menu_icon`, `menu_url`, `menu_parent_id`, `menu_order_value`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, '许可管理', 'aaa', '/pc/system/permission', 1, 4, 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Records of menu_permission
-- ----------------------------
INSERT INTO `menu_permission` (`menu_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu_permission` (`menu_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu_permission` (`menu_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, 14, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu_permission` (`menu_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, 21, 'admin', NOW(), 'admin', NOW());
INSERT INTO `menu_permission` (`menu_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, 18, 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'system', '系统管理', NULL, 1, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 'user', '用户权限', 1, 1, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, 'sys:user:view', '查看用户', 2, 1, 1, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, 'sys:user:edit', '编辑用户', 2, 2, 1, 0, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, 'sys:user:delete', '删除用户', 2, 3, 1, 0, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, 'sys:user:changeRole', '更改用户权限', 2, 4, 1, 0, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, 'role', '角色权限', 1, 2, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, 'sys:role: view', '查看权限', 7, 1, 1, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, 'sys:role:edit', '编辑角色', 7, 2, 1, 0, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, 'sys:role:delete', '删除角色', 7, 3, 1, 0, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, 'sys:role:changeMenu', '更改角色可见菜单', 7, 4, 1, 0, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, 'sys:role:changePermission', '更改角色操作许可', 7, 5, 1, 0, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (13, 'menu', '菜单权限', 1, 3, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (14, 'sys:menu:view', '查看菜单', 13, 1, 1, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (15, 'sys:menu:edit', '编辑菜单', 13, 2, 1, 0, 14, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, 'sys:menu:delete', '删除菜单', 13, 3, 1, 0, 14, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (17, 'permission', '许可权限', 1, 4, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (18, 'sys:permission:view', '查看许可', 17, 1, 1, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (19, 'show', '用户展示', NULL, 2, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (20, 'songList', '歌单权限', 19, 1, 0, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (21, 'sys:songList:view', '查看歌单', 20, 1, 1, 1, NULL, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (22, 'sys:songList:edit', '编辑歌单', 20, 2, 1, 0, 21, 'admin', NOW(), 'admin', NOW());
INSERT INTO `permission` (`permission_id`, `permission_name`, `remark`, `permission_parent_id`, `permission_order_value`, `deepest`, `disabled`, `main_permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (23, 'sys:songList:delete', '删除歌单', 20, 3, 1, 0, 21, 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Table structure for role
-- ----------------------------
INSERT INTO `role` (`role_id`, `role_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'admin', 'admin', NOW(), 'admin', NOW());
INSERT INTO `role` (`role_id`, `role_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 'guest', 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 1, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 2, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 4, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 5, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 6, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 2, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_menu` (`role_id`, `menu_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 6, 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 4, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 5, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 6, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 9, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 10, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 11, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 12, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 14, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 15, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 16, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 18, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 21, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 22, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 23, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 3, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 8, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 14, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 18, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_permission` (`role_id`, `permission_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 21, 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
INSERT INTO `role_user` (`role_id`, `user_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 1, 'admin', NOW(), 'admin', NOW());
INSERT INTO `role_user` (`role_id`, `user_id`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 16, 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Table structure for song_list
-- ----------------------------
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (1, '残酷な天使のテーゼ', '高橋洋子', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (2, 'Oblivious', 'Kalafina', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (3, 'あなたがいた森', '樹海', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (4, 'disillusion', 'タイナカ　サイチ', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (5, '愛き夜道', '魂音泉', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (6, '夢想歌', 'Suara', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (7, 'feel it still', 'Portugal. The Man', '英文', 'admin', NOW(), 'admin', '2022-02-06 06:49:04');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (8, 'same old love', 'Selena Gomez', '英文', 'admin', NOW(), 'admin', '2022-02-06 06:49:04');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (9, 'First Love', '宇多田ヒカル', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (10, 'Beautiful World', '宇多田ヒカル', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (11, 'トリノコシティ', 'vocaloid', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (12, 'zoetrope', 'やなぎなぎ', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (13, 'mermaid festa vol. 1', 'μ''s', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (14, '影炎≒Variation', 'vocaloid', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (15, '海色', 'AKINO', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (16, '-ERROR', 'vocaloid', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (17, 'シャルル', 'vocaloid', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (18, 'ヒバナ', 'vocaloid', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (19, '千本桜', 'vocaloid', '日文', 'admin', NOW(), 'admin', '2022-02-06 06:47:07');
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (20, 'KING', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (21, '乙女解剖', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (22, 'ロキ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (23, '恋は戦争', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (24, 'ブリキノダンス', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (25, '天ノ弱', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (26, 'からくりピエロ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (27, 'ロミオとシンデレラ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (28, 'ロストワンの号哭', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (29, '東京テディベア', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (30, '弱虫モンブラン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (31, '恋愛裁判', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (32, 'ドーナツホール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (33, '脳漿炸裂ガール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (34, 'メルト', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (35, '砂の惑星', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (36, '六兆年と一夜物語', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (37, '太陽系ディスコ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (38, 'メランコリック', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (39, 'マトリョシカ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (40, 'いーあるふぁんくらぶ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (41, '心做し', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (42, 'パンダヒーロー', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (43, '独りんぼエンヴィー', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (44, '劣等上等', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (45, '妄想税', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (46, '裏表ラバーズ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (47, 'magnet', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (48, 'ワールドイズマイン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (49, '夜咄ディセイブ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (50, 'え？あぁ、そう。', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (51, 'Just Be Friends', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (52, 'ブラック✭ロックシューター', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (53, 'ローリンガール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (54, 'モザイクロール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (55, 'Calc.', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (56, 'カゲロウデイズ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (57, 'チルドレンレコード', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (58, '二息歩行', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (59, 'バレリーコ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (60, '右肩の蝶', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (61, 'アイロニ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (62, '地球最後の告白を', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (63, 'セツナトリップ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (64, '炉心融解', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (65, '1925', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (66, 'サリシノハラ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (67, 'アンハッピーリフレイン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (68, 'ハッピーシンセサイザ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (69, 'インビジブル', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (70, '深海少女', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (71, 'fire flower', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (72, 'ECHO', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (73, 'ギガンティックotn', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (74, '嗚呼、素晴らしきニャン生', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (75, 'リンネ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (76, 'いかないで', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (77, 'BAD END NIGHT', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (78, '拝啓ドッペルゲンガー', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (79, 'GIMME X GIMME', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (80, 'from y to y', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (81, 'blessing', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (82, '初めての恋が終わる時', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (83, 'いろは唄', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (84, '十面相', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (85, 'ハロ/ハワユ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (86, '再教育', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (87, 'ネトゲ廃人シュプレヒコール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (88, 'バビロン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (89, '虎視眈々', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (90, '疑心暗鬼', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (91, '心拍数＃0822', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (92, '悪ノ召使', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (93, 'サンドリヨン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (94, 'Ready Steady', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (95, 'ピエロ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (96, '人生リセットボタン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (97, 'ケッペキショウ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (98, '天樂', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (99, 'ルカルカナイトフィーバー', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (100, '繰り返し一粒', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (101, '敗北の少年', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (102, 'リモコン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (103, 'glow', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (104, 'オレンジ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (105, 'シリョクケンサ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (106, 'おちゃめ機能', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (107, 'ガランド', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (108, '小夜子', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (109, '自傷無色', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (110, '脳内革命ガール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (111, '結んで開いて羅刹と骸', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (112, 'パラジクロロベンゼン', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (113, '#NAME?', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (114, 'トリノコシティ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (115, 'Dear', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (116, 'ツギハギスタッカート', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (117, 'ACUTE', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (118, 'WAVE', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (119, 'tell your world', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (120, 'しんでしまうとはなさけない', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (121, 'just a game', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (122, 'ペテン師が笑う頃に', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (123, '恋愛勇者', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (124, '告白予行練習', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (125, '夕立のりぼん', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (126, 'FREELY TOMORROW', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (127, 'NO LOGIC', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (128, 'しわ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (129, 'MASKED BITCH', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (130, '悪ノ娘', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (131, 'スキキライ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (132, '会いたい', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (133, 'Mr. Music', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (134, 'Leia', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (135, 'カミサマネジマキ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (136, 'エゴママ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (137, '歌に形はないけれど', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (138, '一心不乱', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (139, '世田谷ナイトサファリ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (140, 'キャットフード', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (141, 'リスキーゲーム', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (142, '愛言葉', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (143, '心臓デモクラシー', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (144, '上弦の月', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (145, 'Hello, worker', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (146, 'elect', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (147, 'とても痛い痛がりたい', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (148, 'イノコリ先生', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (149, 'ドレミファロンド', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (150, 'Badbye', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (151, '被害妄想携帯女子', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (152, 'こちら、幸福安心委員会', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (153, 'ジッタードール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (154, '下剋上', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (155, 'トキヲ・ファンカ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (156, 'アヤノの幸福理論', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (157, 'rain stops, good-bye', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (158, '火葬曲', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (159, 'ラズベリーモンスター', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (160, '夏に去りし君を思フ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (161, 'Sweet Devil', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (162, 'ポーカーフェイス', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (163, 'SPICE!', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (164, '桜前線異常ナシ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (165, '刹那プラス', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (166, 'Shake it!', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (167, '少年と魔法のロボット', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (168, 'グリグリメガネと月光虫', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (169, 'Getcha!', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (170, 'ヨンジュウナナ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (171, 'ローリンガール', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (172, '文学少年の憂鬱', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (173, 'Palette', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (174, '純情スカート', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (175, 'KILLER LADY', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (176, '僕は初音ミクとキスをした', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (177, 'ggrks - ググレカスー', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (178, '泣き虫カレシ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (179, '星の唄', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (180, '夕日坂', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (181, '恋愛フィロソフィア', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (182, 'connecting', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (183, 'カーニバル', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (184, 'bouquet', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (185, 'Perfect Crime', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (186, '春に一番近い街', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (187, 'Loops & loops', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (188, 'solitude', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (189, 'it''s no way', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (190, 'ANIMAる', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (191, '飴か夢', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (192, 'HOPE', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (193, '初恋の絵本', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (194, 'カガリビト', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (195, '疑心暗鬼', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (196, '心裏×Navigation', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (197, '東京電脳探偵団', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (198, '影炎 Variation', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (199, 'テロメアの産声', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (200, 'ヒビカセ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (201, '狂喜乱舞', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (202, 'knife', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (203, '月・影・舞・華', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (204, '笹舟', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (205, 'なまえのないうた', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (206, 'MUGIC', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (207, 'Reon', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (208, 'マリオネットシンドローム', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (209, '空想少女への恋手紙', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (210, '蛍', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (211, '6900000000', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (212, 'cat''s dance', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (213, '恋空予報', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (214, '百年夜行', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (215, 'te-yut-te', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (216, 'ur-style', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (217, 'Sweets & Bitters', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (218, '狐ノ嫁入り', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (219, 'めめめめめ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (220, '花のうた', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (221, '空間 formation', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (222, 'if', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (223, 'smiling', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (224, 'ponponpon', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (225, '君が好き', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (226, '感弩≠Reduction', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (227, 'flashback', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (228, 'とおせんぼ', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (229, 'daze', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());
INSERT INTO rina.song_list (song_id, song_name, song_artist, song_language, create_by, create_time, update_by, update_time) VALUES (230, 'days', 'vocaloid', '日文', 'admin', NOW(), 'admin', NOW());

-- ----------------------------
-- Table structure for user
-- ----------------------------
INSERT INTO `user` (`user_id`, `user_name`, `password`, `status`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'admin', '$2a$10$THJaKjA.PHhMXwNvDasp3egCjsJe8OGXlA96D7BIUaRGEGPk8EkF.', 1, 'admin', NOW(), 'admin', NOW());
INSERT INTO `user` (`user_id`, `user_name`, `password`, `status`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, 'tester', '$2a$10$LBklC2HCTvlzIEbPTaJICO9e8kDyLwYDVHzixO6GU/hZlFpgFZrxa', 1, 'admin', NOW(), 'admin', NOW());
