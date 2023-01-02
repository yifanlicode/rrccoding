# Install phpmyadmin.
DATA="$(wget https://www.phpmyadmin.net/home_page/version.txt -q -O-)";
URL="$(echo $DATA | cut -d ' ' -f 3)";
VERSION="$(echo $DATA | cut -d ' ' -f 1)";
wget https://files.phpmyadmin.net/phpMyAdmin/${VERSION}/phpMyAdmin-${VERSION}-all-languages.tar.gz;

# Make a directory in /usr/share for the PHP admin stuff
mkdir /usr/share/phpmyadmin;

# Move phpMyAdmin files to /usr/share/phpmyadmin
mv phpMyAdmin-${VERSION}-all-languages.tar.gz /usr/share/phpmyadmin; 

# Change to the new phpmyadmin directory
cd /usr/share/phpmyadmin;

# Extract downloaded Archive.
tar xvf phpMyAdmin-${VERSION}-all-languages.tar.gz;

# Move the phpMyAdmin files to the proper folder
mv /usr/share/phpmyadmin/phpMyAdmin-${VERSION}-all-languages/* /usr/share/phpmyadmin;

# Misc required directories
mkdir -p /var/lib/phpmyadmin/tmp;
chown -R www-data:www-data /var/lib/phpmyadmin;
mkdir /etc/phpmyadmin;
cp /usr/share/phpmyadmin/config.sample.inc.php /usr/share/phpmyadmin/config.inc.php;

# add the necessary files to the config.inc.php file
echo ' '  >>/usr/share/phpmyadmin/config.inc.php;
echo '/** Set the secret passphrase */'  >>/usr/share/phpmyadmin/config.inc.php;
echo "\$cfg['blowfish_secret'] = 'H20xcGXxfSd8JwrwV1h6KW6s2rER631';" >>/usr/share/phpmyadmin/config.inc.php;
echo ' '  >>/usr/share/phpmyadmin/config.inc.php;
echo '/** Set the temp directory */'  >>/usr/share/phpmyadmin/config.inc.php;
echo "\$cfg['TempDir'] = '/var/lib/phpmyadmin/tmp';" >>/usr/share/phpmyadmin/config.inc.php;
