<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#list users>
    <#items as user>
    <p>ID: ${user.id}</p>
    <p>Login: ${user.login}</p>
    <p>Name: ${user.name}</p>
    <p>Login: ${user.login}</p>
    <p>Age: ${user.age}</p>
    </#items>
</#list>

</body>
</html>