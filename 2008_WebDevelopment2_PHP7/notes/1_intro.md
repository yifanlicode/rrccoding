## Install and Configure XMAPP

#### Install

Download XMAPP ： [website](https://www.apachefriends.org/download.html)

AMP is an acronym */*ˈækrənɪm/ that stands for [Apache](https://www.google.com/url?q=http://en.wikipedia.org/wiki/Apache_HTTP_Server&sa=D&source=editors&ust=1672979902209346&usg=AOvVaw0Be0goVS901j8ekYy67G_S) (our web-server), [MySQL](https://www.google.com/url?q=http://en.wikipedia.org/wiki/Mysql&sa=D&source=editors&ust=1672979902209839&usg=AOvVaw32XTri18tO4lX_4boVfWXX)/MariaDb (our database) and [PHP](https://www.google.com/url?q=http://en.wikipedia.org/wiki/Php&sa=D&source=editors&ust=1672979902210116&usg=AOvVaw3mXN8TlAM_ZZ_c_TQR6mxV) (our programming language).



#### Configure

By default Apache will be configured to communicate using TCP/IP port 80. Your laptop may have other services running on port 80 (existing Web Server) or port 443 (VMWare), so we are going to change the port used by Apache.

- To edit the Apache config file: Listen 31337
- locate the `httpd-ssl.conf` file within the xampp install and change it so that it listens on port 500 instead of 443.
- Once both Apache and MySQL are running without errors you should be able to load up the loopback address via your web-browser: [http://localhost:31337/](https://www.google.com/url?q=http://localhost:31337/&sa=D&source=editors&ust=1672979902213934&usg=AOvVaw2R-4KH0Zyi1izBB45OLMXI) or[ ](https://www.google.com/url?q=http://127.0.0.1:31337/&sa=D&source=editors&ust=1672979902214386&usg=AOvVaw3N8qgIiH83e0fNSO9IAiEb)[http://127.0.0.1:31337/](https://www.google.com/url?q=http://127.0.0.1:31337/&sa=D&source=editors&ust=1672979902214716&usg=AOvVaw1QYEYbzgG0FGJXn3FSESB4)

