# 大力歌单后台API接口文档

## 1. API V1 接口说明

- 接口基准地址：`http://127.0.0.1:8888/`
- 服务端已开启 CORS 跨域支持
- API V1 认证统一使用 Token 认证
- 需要授权的 API ，必须在请求头中使用 `Authorization` 字段提供 `token` 令牌
- 使用 HTTP Status Code 标识状态
- 数据返回格式统一使用 JSON

### 1.1. 支持的请求方法

- GET（SELECT）：从服务器取出资源（一项或多项）。
- POST（CREATE）：在服务器新建一个资源。
- PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
- PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
- DELETE（DELETE）：从服务器删除资源。
- HEAD：获取资源的元数据。
- OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

### 1.2. 通用返回状态说明

| *状态码* | *含义*                | *说明*                                              |
| -------- | --------------------- | --------------------------------------------------- |
| 200      | OK                    | 请求成功                                            |
| 201      | CREATED               | 创建成功                                            |
| 204      | DELETED               | 删除成功                                            |
| 400      | BAD REQUEST           | 请求的地址不存在或者包含不支持的参数                |
| 401      | UNAUTHORIZED          | 未授权                                              |
| 403      | FORBIDDEN             | 被禁止访问                                          |
| 404      | NOT FOUND             | 请求的资源不存在                                    |
| 422      | Unprocesable entity   | [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误 |
| 500      | INTERNAL SERVER ERROR | 内部错误                                            |

---

## 2. 登陆

## 3. 歌单展示 `/song-list`

### 3.1. 普通用户的数据列表

- 请求路径`/public-list`

- 请求方法`GET`

- 请求参数

  | 参数名       | 参数说明         | 参数类型 | 备注     |
  | ------------ | ---------------- | -------- | -------- |
  | pageSize     | 页面展示的数据量 | Integer  | 不能为空 |
  | pageNum      | 当前页数         | Integer  | 不能为空 |
  | orderBy | 排序依据 |String|不能为空|
  | withDesc | 是否倒序排序 |Boolean|不能为空|
  | ids          | 歌曲IDs          | Long[]   | 可以为空 |
  | nameOrArtist | 歌名或歌手名     | String   | 可以为空 |




- 相应参数

- | 参数名   | 参数说明   |
  | -------- | ---------- |
  | total    | 总数据条数 |
  | id       | 歌曲ID     |
  | name     | 歌曲名     |
  | artist   | 歌手名     |
  | language | 语言       |

  

- 响应数据

  ``` json
  {
    "code": 200,
    "message": "请求成功",
    "data": [
      {
        "id": 14,
        "name": "影炎≒Variation",
        "artist": "vocaloid",
        "language": "日文"
      },
      {
        "id": 198,
        "name": "影炎 Variation",
        "artist": "vocaloid",
        "language": "日文"
      }
    ],
    "total": 2
  }
  ```

  