#!/bin/bash
# shellcheck disable=SC2006
# shellcheck disable=SC2002

image_name="rina/rina-songlist"
container_name="rina-songlist"

echo "开始部署"
# 查看当前版本
this_version=`cat ./pom.xml | grep "version" | awk 'NR==3{print}' | sed 's/<version>//g' | sed 's/<\/version>//g' | sed 's/[[:space:]]//g'`
echo "$this_version"

# 登陆私服
docker login -u jenkins --password-stdin

# 更改tag
docker tag "$image_name":"$this_version" "$image_name":latest
docker tag "$image_name":"$this_version" 192.168.0.9:8084/rina/"$container_name":"$this_version"
docker images | grep "$image_name"

# 正式开始部署
docker run -d --name $container_name --restart=unless-stopped -p 8080:8080 --env-file ./envs/test.env -v /home/arvin/docker/projects/rina-songlist/logs:/var/rina_log "$image_name":latest
#docker run -d --name $container_name --restart=unless-stopped -p 8080:8080 --env-file ./envs/dev.env "$image_name":latest
docker network connect myProjects $container_name

# 推送镜像
docker push 192.168.0.9:8084/rina/"$container_name":"$this_version"

# 删除不必要的镜像
docker rmi "$image_name":"$this_version"
docker rmi 192.168.0.9:8084/rina/"$container_name":"$this_version"
docker images | grep "$image_name"
