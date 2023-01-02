## Intro to JSON



**Structured Data** 

JSON 是结构化的

In today’s modern apps, most data comes from an outside source. Using databases to control and parse that data would be cumbersome and tedious. 

> parse/*pɑːrs*/ （计算机）句法分析 解析
>
> cumbersome /*ˈkʌmbərsəm*/ 笨重复杂的
>
> tedious/ˈtiːdiəs/ 冗长的

Instead, flat files are used to handle data exchange.

Until a few years ago, the most common vehicle for this data was XML (extensible markup language). It was so widely used that XML was included in modern web methodology acronyms like [AJAX](https://en.wikipedia.org/wiki/Ajax_(programming)). 

> methodology /ˌmeθəˈdɑːlədʒi/方法论，一套方法
>
> acronym /ˈækrənɪm/  首字母缩略词

XML was used to structure data much like what an HTML would look like. 

Data was contained within tags. However, for simple data transfers, XML was too verbose. For simple data transfers, JSON, with a much simpler interface, should be used. 

verbose/vɜːrˈboʊs/ 冗长的

## Synchronous VS Asynchronous

**Synchronous requests** mean that before the state of a webpage can change, a call to a web server must be made. This results in a page-refreshing.意味着在网页状态改变之前，必须对网络服务器进行调用。这就导致了页面的刷新。（web1)

> Synchronous */*ˈsɪŋkrənəs/ 同步
>
> Asynchronous/*eɪˈsɪŋkrənəs*/ 异步

**Asynchronous requests** remove the need for page refreshes. 

消除了页面刷新的需要。(web2)

The JSON can act as an intermediary between the client and the web server. Calls to change the state of a page now only have to be done with the JSON file.改变页面状态的调用现在只需要通过JSON文件完成。

> intermediary*/*ˌɪntərˈmiːdieri*/* 中间人 媒介



##  JSON 

JSON  JavaScript Object Notation

- Data representation format
- commonly used for APIs and Configs
- Lightweight and Easy to Read/Write
- Integrates Easily With Most Languages



JSON Types

- Strings  `"hello world"`
- Numbers `10`
- Booleans  `true`
- null  `null`
- Arrays   `[1,2,3]`
- Objects (most used)  : {"key":"value"}  {"age":30}

#### JSON syntax

JSON is based on Javascript objects. It’s made up of *key and value pairs* that describe and contain the data. 

可以这么理解：

> JSON 是 JS 对象的字符串表示法，它使用文本表示一个 JS 对象的信息，本质是一个字符串。
>
> `var obj = { a:'hello', b: 'World'};`

![img](https://lh5.googleusercontent.com/29maHAuCojT9ItWZoZ5yPmOgpcjmOrXP_tSDD404h9dEen9zN_U8JhQeMbErjJz4QDyyt7mlCL7eKZIP2dmTRDrt88YE8oRpAAgsUXt-6bWr40Wpx0vV6XVIkr2gBBVmnlBEWShzy1FZCM1T8CWsFn7WDTThvDAPFoIXYMSKBq5mW6-Ffci87SLLsYyo)

Here, there are 3 records of weather data. 

Each entry is for another city. Notice the keys (*name, temperature, ...*) and the values (*Winnipeg, 27, ...*).



#### Loading JSON

We need to load the JSON file into our Javascript so we can parse and then use the data. 

**NOTE:** Keep in mind that in this course, our priority is to parse and use the JSON, not how it’s loaded. That will be covered more indepthly in the next course.

![img](https://lh3.googleusercontent.com/ArGS4Behkdwh5BlIbmlZ03Hom5q0EBfwCI4S1z-c9cL2Fw1CguSKXXZT3nuq5y5Jr8qmIZxglmZ8DPXNGC3I8QnZo1BrWV_VjpxcC519I-Yb6KZgHUxEFbCt7sfRVbXvH2fyaSuKH9LUsnxh5XuSMhcn2589no8-TmBEB1BqZIWSWbtyGyi7oF-O7NjN)

Here we’re retrieving/*/*rɪˈtriːvɪŋ*/* JSON using the ***fetch API*.** 

This will retrieve JSON via a URL that’s passed to it. 

The `then `methods will first, handle the retrieval `检索` of JSON, and second, handle the next steps of execution`/*ˌeksɪˈkjuːʃ(ə)n/`. 

In this case, passing the `data` to a function called `createWeather.`

 What is of note here is the passing of functions as parameters in the `them` methods.

 These are functions that will execute once the data has been retrieved. These are called *`callbacks`.*

 A *callback* is any function (anonymous or otherwise) that will eventually get called back to the calling scope. This is how asynchronous works.

 This code is running based on the promise that the JSON will be loaded properly. 

**Weather Example**

Using the JSON above, let’s create some HTML elements with values derived from the JSON file.

**Important Note:** Unless you are using a web server, only Firefox will work when importing JSON files. Chrome blocks all external data sources unless you are running your pages on a web server.![img](https://lh4.googleusercontent.com/2teygUoM06vW44fKXeqa8UZ7GmL0rQOrAo2UxfIfhoKcoYBjxckKXP3VUo5dK84byzNw2UUCEc0gFjNjiexrMUDNpsfkNFQqcTN6XKZ9gr4nZLYmWllODD8wQwnsJbVEOZoXnY_qA8SvChYa47TE-Sa4RwZI0U9WTptwsVpNmqqNdKE7a-2Jh_p2ZlGt)

First we’re grabbing the body and div elements from the markup. These will be used to add our newly created elements to. Next we’re going to loop through the *`weatherData`* variable, which contains the JSON that was parsed earlier.

![img](https://lh5.googleusercontent.com/7Yh7DicFcWplHuIbKHFaKLTnVJrHoihhaCq5pPohFNYHgb81r2qVPBB0QOwT4JwkWi2HxBXCrwbyLTFwygfvg5274W3ZM41Z_xzAkda3BOTH2lN0kTOlc8bJGH7awICKK2i5j8dXXqE0VawYCa79q0k1iPOYaLpdQNKTksvpx0TkcQfR1GGv7Kj0mN5o)

By using the *`Object.keys`* method, we can retrieve all the keys in our iteration through `weatherData` (if this was the first time through, we would be accessing the *Winnipeg* record). 

> iteration*/*ˌɪtəˈreɪʃn/ 迭代

These keys will be used to create data for labels that will be created in a bit. The *`Object.values`* method is similar, but it retrieves all the values from this iteration in weatherData. Using these methods is never required, but for a simple example, it makes our new elements easier.

![img](https://lh6.googleusercontent.com/6LQkpWy-mnE5jHsP03enH43q_Axay6_fKFi3IRLMdfmSmh_n7Nk7_LkcwImK4jpoJJs0RwT9wtvsDHS-RSM_4PK7dflkQaELqztFCKF9SQrRZ13mI29zwbX5Llvgn0XE3athe5-Kw2WPdL3Drl3DxJ_9eKIQxoMbpZAA3HtSMqH1ShoaEDU-VuMAjYLn)

After creating a `section`, `h1`, and `ul`, *dot notation* is being used to retrieve the value associated with the *name* key. 

This value is used in a template literal to add content to the `h1 `element.

After all elements have content, they are then inserted into the markup using the [insertBefore method](https://developer.mozilla.org/en-US/docs/Web/API/Node/insertBefore). 

Previously, appendChild was the only way we’d seen to insert a new element into the markup. 

`insertBefore` allows more control, as we can state exactly where in the markup the new element is to be inserted, rather than just added to the end.To finish our example, an li, label, and span element will all be created and have data from the JSON added to it. A loop is going to be used to make the code as generic as possible.![img](https://lh5.googleusercontent.com/WvM4XtiykruieNu0kxSxc0OImSneMOgDXHDkdekUjVHc99oUFI4_6OMJbBvOSMgIbLG_eCvVBNQFy4b9nwq9bzPhgqxJaD_aESq8r6sn3e6wIwOuTBqfWq-f2BMvcSb9cpAEoC5ZCLD4GlYQiEXFX89e1eU0U7GiPB5Jayz9NvpTd-78MuMJIiXzL89J)When viewed in Firefox, this is what the resulting page should look like: ![img](https://lh4.googleusercontent.com/3wMXRuEjlc8VR0zHKTIdz0nOieEx1_pd3A7egCzpWA2-KF8Yk3RSJCLjWkX0smQ2M4-uc56keJeRaFgphSAfytuoax4aLWxwAHqeztGedrsQ-Nbe9UZEnOjx5ZE055ZSsD38YI1llZWtinxcMrw7tb4C46ZLHd2rGNUZmacjJM1xXfAbNgEFgBd_P10E)JSON is a simple, but powerful tool in our web development skill set. In the next course there will be more complex uses of JSON, but an introduction to how it works is an important asset.