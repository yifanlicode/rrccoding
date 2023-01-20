superglobals

• predefined variables in PHP that are always accessible, regardless of scope - and
you can access them from any function, class or file
• There are 9 PHP superglobals; we're going to focus on just two of them today



#### Get

- $_GET can be used to collect form data after submitting an HTML form with method='get' in the form tag

- collects data via the URL

  - <a href='test_get.php?subject=PHP&web=W3schools.com'>

- POST

  - $_POST is used to collect form data as well as pass variable using method='post' in the form tag

  - Data is passed using the HTTP headers ,rather than the URL that the GET uses

    