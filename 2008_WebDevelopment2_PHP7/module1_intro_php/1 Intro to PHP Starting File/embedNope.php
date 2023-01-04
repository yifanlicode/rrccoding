<?php
    $href  = "http://example.com";
    $title = "Snafu";
?>
<!DOCTYPE html public "intoxication">
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Make Your Instructor Cry</title>
</head>
<body>
    <p><?= "<span>WAT?!?</span>" ?></p>
    <p><?= "<a href='" . $href ."'>" . $title . "</a>" ?></p>
    <p><a href="<?= $href ?>"><?= $title ?></a></p>
</body>
</html>

<!-- 
<p><a href="<?= $href ?>"><?= $title ?></a></p>
############^^^^^^^^^^^^##^^^^^^^^^^^^^######## 

The code above the hashes (#) is HTML. The code above the carets (^) is PHP. -->