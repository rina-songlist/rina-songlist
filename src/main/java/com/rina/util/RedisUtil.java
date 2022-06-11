package com.rina.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis的工具类
 * @author arvin
 * @date 2022/06/03
 */
@Component
@RequiredArgsConstructor
public class RedisUtil {

	private final RedisTemplate<String, Object> template;


	/**
	 * 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
	 *
	 * @param key
	 * @return
	 */
	public long ttl(String key) {
		return template.getExpire(key);
	}

	/**
	 * 实现命令：expire 设置过期时间，单位秒
	 *
	 * @param key
	 * @return
	 */
	public void expire(String key, long timeout) {
		template.expire(key, timeout, TimeUnit.SECONDS);
	}

	/**
	 * 判断key是否存在
	 * @param key 键
	 * @return true 存在 false不存在
	 */
	public boolean hasKey(String key) {
		return template.hasKey(key);
	}

	/**
	 * 实现命令：DEL key，删除一个或多个key
	 *
	 * @param key
	 */
	@SuppressWarnings("unchecked")
	public void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				template.delete(key[0]);
			} else {
				template.delete((Collection<String>) CollectionUtils.arrayToList(key));
			}
		}
	}

	// ================================String=================================
	/**
	 * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
	 *
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value) {
		template.opsForValue().set(key, value);
	}

	/**
	 * 实现命令：SET key value EX seconds，设置key-value和超时时间（秒）
	 *
	 * @param key
	 * @param value
	 * @param timeout
	 *            （以秒为单位）
	 */
	public void set(String key, Object value, long timeout) {
		template.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
	}

	/**
	 * 实现命令：GET key，返回 key所关联的字符串值。
	 *
	 * @param key
	 * @return value
	 */
	public Object get(String key) {
		return key == null ? null : template.opsForValue().get(key);
	}

	/**
	 * 实现命令：INCR key，key增加delta
	 *
	 * @param key
	 * @return
	 */
	public long incr(String key, long delta) {
		return template.opsForValue().increment(key, delta);
	}

	// ===============================list=================================
	/**
	 * 实现命令：LRANGE key start stop,根据偏移量区间获取区间内元素
	 * @param key 键
	 * @param start 开始
	 * @param end 结束 0 到 -1代表所有值
	 * @return
	 */
	public List<Object> lRange(String key, long start, long end) {
		try {
			return template.opsForList().range(key, start, end);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 实现命令：LLEN key，获取list的长度
	 * @param key 键
	 * @return
	 */
	public long lSize(String key) {
		try {
			return template.opsForList().size(key);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 实现命令：LINDEX key index 通过索引 获取list中的值
	 * @param key 键
	 * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
	 * @return
	 */
	public Object lIndex(String key, long index) {
		try {
			return template.opsForList().index(key, index);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 实现命令：LPUSH key value 将一个value 插入到列表 key 的表头
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public boolean lLeftPush(String key, Object value) {
		try {
			template.opsForList().leftPush(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：LPUSH key value [value ...]将多个value 插入到列表 key 的表头
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public boolean lLeftPushAll(String key, List<Object> value) {
		try {
			template.opsForList().leftPushAll(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：RPUSH key value 将一个value 插入到列表 key 的表尾(最右边)
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public boolean lRightPush(String key, Object value) {
		try {
			template.opsForList().rightPush(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：RPUSH key value 将一个value 插入到列表 key 的表尾(最右边) 并设置key过期时间
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 * @return
	 */
	public boolean lRightPush(String key, Object value, long time) {
		try {
			template.opsForList().rightPush(key, value);
			if (time > 0) {
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：RPUSH key value [value ...] 将多个value 插入到列表 key 的表尾(最右边)
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public boolean lRightPushAll(String key, List<Object> value) {
		try {
			template.opsForList().rightPushAll(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：RPUSH key value [value ...] 将多个value 插入到列表 key 的表尾(最右边)并设置key过期时间
	 *
	 * @param key 键
	 * @param value 值
	 * @param time 时间(秒)
	 * @return
	 */
	public boolean lRightPushAll(String key, List<Object> value, long time) {
		try {
			template.opsForList().rightPushAll(key, value);
			if (time > 0) {
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：LSET key index value 将列表 key 下标为 index 的元素的值设置为 value
	 * @param key 键
	 * @param index 索引
	 * @param value 值
	 * @return
	 */
	public boolean lSet(String key, long index, Object value) {
		try {
			template.opsForList().set(key, index, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 实现命令：LREM key count value
	 * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
	 *
	 * count 的值可以是以下几种：
	 *  count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
	 *  count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
	 *  count = 0 : 移除表中所有与 value 相等的值。
	 * @param key 键
	 * @param count 移除多少个
	 * @param value 值
	 * @return 移除的个数
	 */
	public long lRemove(String key, long count, Object value) {
		try {
			Long remove = template.opsForList().remove(key, count, value);
			return remove;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// ============================set=============================
	/**
	 * 实现命令：SMEMBERS key 返回集合 key 中的所有成员
	 * @param key 键
	 * @return
	 */
	public Set<Object> sMembers(String key) {
		try {
			return template.opsForSet().members(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 实现命令：SISMEMBER key member 判断 member 元素是否集合 key 的成员
	 * @param key 键
	 * @param value 值
	 * @return true 存在 false不存在
	 */
	public boolean sIsMember(String key, Object value) {
		try {
			return template.opsForSet().isMember(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 实现命令：SADD key member [member ...] 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
	 * @param key 键
	 * @param values 值 可以是多个
	 * @return 成功个数
	 */
	public long sAdd(String key, Object... values) {
		try {
			return template.opsForSet().add(key, values);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 实现命令：SADD key member [member ...] 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
	 * 并设置过期时间
	 * @param key 键
	 * @param time 时间(秒)
	 * @param values 值 可以是多个
	 * @return 成功个数
	 */
	public long sAdd(String key, long time, Object... values) {
		try {
			Long count = template.opsForSet().add(key, values);
			if (time > 0) {
				expire(key, time);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 实现命令：SCARD key 返回集合 key 的基数(集合中元素的数量)。
	 * @param key 键
	 * @return
	 */
	public long sSize(String key) {
		try {
			return template.opsForSet().size(key);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 实现命令：SREM key member [member ...] 移除集合 key 中的一个或多个 member 元素，不存在的 member 元素会被忽略。
	 * @param key 键
	 * @param values 值 可以是多个
	 * @return 移除的个数
	 */
	public long sRemove(String key, Object... values) {
		try {
			Long count = template.opsForSet().remove(key, values);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// ================================hashMap=================================
	/**
	 * 实现命令：HGET key field 返回哈希表 key 中给定域 field 的值。
	 * @param key 键 不能为null
	 * @param item 项 不能为null
	 * @return 值
	 */
	public Object hGet(String key, String item) {
		return template.opsForHash().get(key, item);
	}

	/**
	 * 实现命令：HGETALL key 获取hashKey对应的所有键值
	 * @param key 键
	 * @return 对应的多个键值
	 */
	public Map<Object, Object> hEntries(String key) {
		return template.opsForHash().entries(key);
	}

	/**
	 * 实现命令：HSET key field value 将哈希表 key 中的域 field 的值设为 value 。
	 * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。
	 * 如果域 field 已经存在于哈希表中，旧值将被覆盖。
	 * @param key 键
	 * @param item 项
	 * @param value 值
	 * @return true 成功 false失败
	 */
	public boolean hPut(String key, String item, Object value) {
		try {
			template.opsForHash().put(key, item, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 实现命令：HSET key field value 将哈希表 key 中的域 field 的值设为 value 。并设置过期时间
	 * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。
	 * 如果域 field 已经存在于哈希表中，旧值将被覆盖。
	 * @param key 键
	 * @param item 项
	 * @param value 值
	 * @param time 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
	 * @return true 成功 false失败
	 */
	public boolean hPut(String key, String item, Object value, long time) {
		try {
			template.opsForHash().put(key, item, value);
			if (time > 0) {
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：HMSET key field value [field value ...] 同时将多个 field-value (域-值)对设置到哈希表 key 中。
	 * 会覆盖哈希表中已存在的域。
	 * @param key 键
	 * @param map 对应多个键值
	 * @return true 成功 false 失败
	 */
	public boolean hPutAll(String key, Map<String, Object> map) {
		try {
			template.opsForHash().putAll(key, map);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 实现命令：HMSET key field value [field value ...] 同时将多个 field-value (域-值)对设置到哈希表 key 中。
	 * 并设置过期时间
	 * @param key 键
	 * @param map 对应多个键值
	 * @param time 时间(秒)
	 * @return true成功 false失败
	 */
	public boolean hPutAll(String key, Map<String, Object> map, long time) {
		try {
			template.opsForHash().putAll(key, map);
			if (time > 0) {
				expire(key, time);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 实现命令：HDEL key field [field ...] 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
	 * @param key 键 不能为null
	 * @param item 项 可以使多个 不能为null
	 */

	public void hDelete(String key, Object... item) {
		template.opsForHash().delete(key, item);
	}

	/**
	 * 实现命令：HEXISTS key field 查看哈希表 key 中，给定域 field 是否存在。
	 * @param key 键 不能为null
	 * @param item 项 不能为null
	 * @return true 存在 false不存在
	 */
	public boolean hHasKey(String key, String item) {
		return template.opsForHash().hasKey(key, item);
	}

	/**
	 * 实现命令：HINCRBY key field increment 为哈希表 key 中的域 field 的值加上增量 increment
	 * @param key 键
	 * @param item 项
	 * @param by 要增加几(可以为负值)
	 * @return
	 */
	public double hIncrement(String key, String item, double by) {
		return template.opsForHash().increment(key, item, by);
	}

}
