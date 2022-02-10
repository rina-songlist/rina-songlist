
<div align="center">
<img src="https://raw.githubusercontent.com/ArvinJr/TyporaPictureDatabase/main/rina%E5%A4%B4%E5%83%8F.jpg" alt="大莉头像" width=360 height=360 />

# 林莉奈点歌网页服务端~~暂定~~

</div>

---

该系统当前主旨为B站up [**林莉奈RinaHayashi**](https://space.bilibili.com/1243266187) 服务的点歌系统后台

[直播间传送门](https://live.bilibili.com/22742508?spm_id_from=333.999.0.0)

绝赞更新中 ✿✿ヽ(°▽°)ノ✿

## 所用到的技术栈

`Spring Boot(SSM)`、`docker	`、`JWT`等

## 当前主要功能

- 模糊查曲(歌名或歌手名均可)
- 随机歌曲(需配合前端使用)
- 分页功能

## 将要推出的功能

- [ ] 管理后台
- [ ] 自动统计当前直播所被点到的歌，并与OBS联动

## 使用方法

### 使用前准备
1. [下载](https://github.com/ArvinJr/rina/releases/download/v1.0-beta/v1.0-beta.zip) 并解压压缩包
2. 需安装`docker` [安装方法](https://www.runoob.com/docker/centos-docker-install.html) 国内用户可以考虑使用镜像源
3. 需安装`MySQL:5.7`, 按需配置数据库用户
```bash
docker run -itd --name mysql-test -p 3306:3306 mysql:5.7
```
4. 使用 `schema.sql` 初始化数据库， 并使用 `data_initials.sql` 导入初始数据

### 开始使用
1. 导入已打包好的 `docker` 镜像

```bash
docker load -i rina-songlist-1.0.rar
```

2. 使用 `.env` 或是环境变量启动项目，一下是启动示例：

```bash
docker run -itd --name my-rina-songlist \
   -p 8080:8080 \
   -e DATABASE_URL=localhost:3306/rina \
   -e DATABASE_USERNAME=root \
   -e DATABASE_PASSWORD=123456 \
   -e SPRING_ACTIVE_PROFILE=prod \
   -e TOKEN_EXPIRE_TIME=60*1000L \
   rina/rina-songlist:1.0
```

3. 详细API接口信息详情请查看 [ApiDoc](./docs/ApiDoc.md)

## 开发相关

本项目是由 [`Intellij IDEA`](https://www.jetbrains.com/idea/) 编辑，JDK版本为 `jdk8`，使用 `MAVEN` 构建

❗️❗️❗️运行时环境变量时使用`.env` 文件，并使用 [EnvFile](https://www.jetbrains.com/idea/) 插件调用，`VSCode`与`Eclipse`用户请自行寻找适合的插件
