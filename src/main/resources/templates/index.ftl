<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>File Resource</title>
</head>
<body>
    <h1>detail.xlsx 切割</h1>
    <form action="/detail" method="post" enctype="multipart/form-data">
        文件:<input type="file" name="file"/><br/>
        <input type="submit" value="提交"/>
    </form>


    <h1>all.excel切 割</h1>
    <form action="/province" method="post" enctype="multipart/form-data">
        文件:<input type="file" name="file"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>