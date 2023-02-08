## Cookie

### setcookie（）参数讲解

`setcookie` 函数有七个参数：

1. `name`：必需，表示 cookie 的名称。

2. `value`：必需，该值存储在客户端计算机上; 不要存储敏感信息

3. `expire`：可选，表示 cookie 在什么时候过期。它是一个 Unix 时间戳，表示在当前时间加上该数字的秒数后过期。如果将其设置为 0，则 cookie 在浏览器关闭时过期。

4. `path`：可选，表示 cookie 的作用路径。如果留空，则 cookie 将与当前请求的目录相关联。*“/”*，则 cookie 将在整个范围内可用

5. `domain`：可选，表示 cookie 的作用域。如果留空，则 cookie 将与当前请求的域相关联。

   `（例如*“www.houdunren.com”*）将使 cookie 可用于该子域及其所有其他子域（即 w2.www.houdunren.com）。要使cookie可用于整个域（包括其所有子域），只需将值设置为域名（在本例中为*“houdunren.com”*）`

6. `secure`：可选，表示 cookie 是否仅通过安全的（HTTPS）连接传输。如果该值为 `true`，则该 cookie 只能通过安全的连接传输；否则，它可以通过安全或不安全的连接传输。

7. `httponly`：可选，表示该 cookie 是否仅通过 HTTP 请求发送，而不能通过客户端脚本读取。如果该值为 `true`，则该 cookie 仅通过 HTTP 请求发送；否则，它可以通过客户端脚本读取。



举例：
```php
<?php

// 不写时间,或者写 0 表示浏览器关闭即失效
setcookie('web','yifan.com');

//Set cookie valid for seven days
setcookie('w3c','w3c.com',60*60*24*7+time());

//Allow cookies to be valid only in the /app access path 相当于到 w3c.com/app
setcookie('w3c', 'w3c.com', 0,'/app');

//Set the access domain name
//  '/'Cookie 的作用路径，表示在整个网站下都可以访问到这个 cookie。
//Cookie 的作用域，只有在 php.test 域名下才可以访问到这个 cookie。
setcookie('web','rrc.com',0,'/','php.test');

//Set https access only
//第五个参数留空意味着该 cookie 将与当前请求的域相关联。
//第六个参数为 true 意味着该 cookie 只能通过安全的（HTTPS）连接传输。

setcookie('web','hdcms.com',0,'/','',true);

//Do not allow javascript to operate cookies
//第四个参数留空意味着该 cookie 将与当前请求的目录相关联。
//第五个参数留空意味着该 cookie 将与当前请求的域相关联。
//第六个参数为 false 意味着该 cookie 可以通过安全或不安全的连接传输。
//第七个参数为 false 意味着该 cookie 可以被客户端脚本读取。
//最后一个参数为 true 意味着该 cookie 只能通过 HTTP 请求发送，不能通过客户端脚本读取。
setcookie('web','hdcms.com',0,'','',false,false,true);

//delete cookie by set the time
setcookie('name','my.com',1);


?>
```

### 基本使用

#### 开启会话

必须要开启 SESSION 才可以使用，有两种方法可以开启会话。

1. 使用脚本开启会话，要保证在使用会话的所有脚本中执行。

````php
session_start();
````

2. 通过修改 php.ini 配置项 `session.auto_start`，自动开启会话（不建议使用）



#### 会话变量

使用超全局数组 `$_SESSION` 来使用会话变量。

**设置变量**

```php
$_SESSION['name']='houdunren.com';
```

**删除变量**

```php
unset($_SESSION['name']);
```

**删除所有变量**

```php
$_SESSION = [];
# 或使用函数删除
session_destroy();
```

### 常用函数

####  

#### session_save_path

设置服务器会话数据储存目录，必须在 session_start 前使用。

#### session_id

通过 `session_id` 函数来获取/设置当前会话 ID。

#### session_name

获取或设置会话 COOKIE 名称，如果设置会话名称则需要在 session_id 前调用。

### 垃圾回收

#### session.gc_probability

session 清除无效 session 的基率。

#### session.gc_divisor

启动垃圾回收程序的概率。概率计算公式为：session.gc_probability/session.gc_divisor，如果网站访问量大建议将概率降低如 1/1000~5000。

#### session.gc_maxlifetime

session 文件过期时间，超过这个时间没有使用的 session 将视为垃圾，将在下次垃圾回收时删除。

### 自定义驱动

自定义 SESSION 处理驱动可以让我们更灵活的管理 SESSION，并更好的服务我们网站业务。

```php
<?php
class FileHandle implements SessionHandlerInterface
{
    //写入目录
    protected $path = 'session';
    //过期时间
    protected $maxlifetime = 1440;
    /**
     * 构建函数
     *
     * @param string $path 保存目录
     * @param integer $maxlifetime 过期时间
     */
    public function __construct(string $path = 'session', int $maxlifetime = 1440)
    {
        $this->path = realpath($path);
        $this->maxlifetime = $maxlifetime;
    }
    /**
     * 关闭
     *
     * @return void
     */
    public function close()
    {
        return true;
    }
    /**
     * 销毁
     *
     * @param [type] $session_id
     * @return void
     */
    public function destroy($session_id)
    {
        return (bool)@unlink($this->path . '/' . $session_id);
    }
    /**
     * 垃圾回收
     *
     * @param [type] $maxlifetime
     * @return void
     */
    public function gc($maxlifetime)
    {
        foreach (glob($this->path . '/*') as $file) {
            if (filemtime($file) + $this->maxlifetime < time()) {
                @unlink($file);
            }
        }
        return true;
    }
    /**
     * 开启
     *
     * @param [type] $save_path
     * @param [type] $session_name
     * @return void
     */
    public function open($save_path,  $session_name)
    {
        is_dir($this->path) or mkdir($this->path, 0755, true);
        return true;
    }
    /**
     * 读取会话数据
     *
     * @param [type] $session_id
     * @return void
     */
    public function read($session_id)
    {
        return file_get_contents($this->path . '/' . $session_id);
    }
    /**
     * 写入会话
     *
     * @param [type] $session_id
     * @param [type] $session_data
     * @return void
     */
    public function write($session_id,  $session_data)
    {
        return (bool)file_put_contents($this->path . '/' . $session_id, $session_data);
    }
}
```

调用方法

```php
<?php
include 'Session.php';
//声明会话引擎
session_set_save_handler(new FileHandle);
session_start();
$_SESSION['web'] = 'houdunren.com';
$_SESSION['cms'] = 'hdcms.com';

print_r($_SESSION);
```

1. 