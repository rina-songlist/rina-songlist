#!/bin/bash

image_name="rina/rina-songlist"
container_name="rina-songlist"

echo "移除原有镜像和容器"
result=$(docker ps | grep $container_name)
if [[ "$result" != "" ]]
then
echo "stop $container_name"
docker stop $container_name
fi
result1=$(docker ps -a | grep $container_name)
if [[ "$result1" != "" ]]
then
echo "rm $container_name"
docker rm $container_name
fi
result2=$(docker images | grep $image_name)
if [[ "$result2" != "" ]]
then
echo "rmi $image_name:latest"
docker rmi $image_name:latest
fi
echo "开始编译"