# Install PHP.
apt -y update;
apt -y install wget php php-cgi php-mysqli php-pear php-mbstring php-gettext libapache2-mod-php php-common php-phpseclib php-mysql;

# Install MariaDB.
apt -y update;
apt -y install software-properties-common gnupg2;
add-apt-repository 'deb [arch=amd64] http://mariadb.mirror.liquidtelecom.com/repo/10.4/debian buster main';
apt update;
apt install mariadb-server;
