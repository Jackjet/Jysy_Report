<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report Resource</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style>
        .row{
            box-shadow: 3px 3px 8px #80beff;
            padding: 10px;
            margin-bottom: 30px;
        }
        form{
            box-shadow: 0px 0px 18px 3px #4e808b;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <h1>复旦 - 教育事业</h1>
            <blockquote>
                detail.xlsx 切割
            </blockquote>
            <form action="/detail" method="post" enctype="multipart/form-data">
                文件:<input type="file" name="file"/>
                <input class="btn btn-info" type="submit" value="提交"/>
            </form>
            <hr>
            <blockquote>
                all.excel切 割
            </blockquote>
            <form action="/province" method="post" enctype="multipart/form-data">
                文件:<input type="file" name="file"/><input class="btn btn-info" type="submit" value="提交"/>
            </form>
        </div>
        <div class="row">
            <h1>富邦华一</h1>
            <blockquote>
                富邦华一登录人数明细报表
                <hr>
                <pre>
                    SELECT `account`.`name` as `用户名`,`account`.`fullname` as `姓名` ,`org`.`name` as `部门名称`,
                    `log`.`createtime` as `登录时间`,`log`.`terminal` as `终端`
                    FROM `vmb_account` as `account`
                    INNER JOIN `login_log` as `log` on `log`.`name`  = `account`.`name`
                    INNER JOIN `vmb_member` as `member` on `member`.`accountId`  = `account`.`accountId`
                    INNER JOIN `vmb_org` as `org` on `org`.`orgId`  = `member`.`ordId`
                    INNER JOIN `vmb_collegeorg` as `colorg` on `colorg`.`orgId`  = `member`.`ordId`
                    INNER JOIN `vmb_college` as `college` on `college`.`collegeId`  = `colorg`.`collegeId`
                    WHERE `log`.`createtime` >"2017-05-01 00:00:00"
                    AND `log`.`createtime` <"2017-06-01 00:00:00"
                    AND `college`.`code` ="fbhy"
                    GROUP BY `log`.`logid` ;
                </pre>
            </blockquote>
            <form>
                <a class="btn btn-primary" href="/fbhy/loginreport">点击下载</a>
            </form>
            <blockquote>
                富邦华一评论的数据
                <hr>
                <pre>
                    SELECT `lear`.`name` as `课程名称`,concat("'",`account`.`name`) as `用户名`,`account`.`fullname` as `姓名`,
                    `comments`.`comments` as `评论内容`,`comments`.`commenttime` as `评论时间`,`org_info`.`name` as `所在组织`
                    FROM `vmb_comments` as `comments`
                    INNER JOIN `vmb_account` as `account` on `account`.`accountId`  = `comments`.`accountId`
                    INNER JOIN `vmb_learningactivity` as `lear` on `lear`.`learningActivityId`  = `comments`.`learningActivityId`
                    INNER JOIN `vmb_college` as `college` on `college`.`collegeId`  = `comments`.`collegeid`
                    INNER JOIN `vmb_member` as `member` on `member`.`accountId`  = `account`.`accountId`
                    INNER JOIN `cache_org_info` as `org_info` on `org_info`.`orgid`  = `member`.`ordId`
                    WHERE `college`.`code` ="yynkxfjy"
                    AND `comments`.`commenttime`  > "2017-06-01 00:00:00"
                    AND `comments`.`commenttime`  < "2017-06-20 11:59:59"
                    GROUP BY `comments`.`commentsId` ;
                </pre>
            </blockquote>
            <form>
                <a class="btn btn-primary">还未实现</a>
            </form>
        </div>
        <div class="row">
            <h1>江苏银行</h1>
            <blockquote>
                用户状态
                <hr>
                <pre>
                SELECT concat("'",`account`.`account_name`) as `用户名` ,`account`.`account_fullname` as `姓名` ,
                case when `account`.`account_status` = 1
                then "启用"
                else "禁用"
                end as `用户状态`
                FROM `cache_account_info` as `account`
                WHERE `account`.`college_id` =209
                AND `account`.`accountid` not in (
                SELECT `account`.`accountid`
                FROM `cache_account_info` as `account`
                INNER JOIN `vmb_studyrecorde` as `study` on `study`.`accountid`  = `account`.`accountid`
                INNER JOIN `vmb_learningactivity` as `lear` on `lear`.`learningActivityId`  = `study`.`learningactivityid`
                WHERE `account`.`college_id` =209
                AND `lear`.`code` ="pxyw_1_170010");
                </pre>
            </blockquote>
            <form>
                <a class="btn btn-primary">还未实现</a>
            </form>
        </div>
        <div class="row">
            <h1>天安财险</h1>
            <blockquote>
                天安财险报表
                <hr>
                <pre>
                    select sum(if( starttime<'2017-4-1',BIGTIMEDIFF(endtime,starttime),0))  as '累计学习时长',
                    sum(if(starttime>'2017-3-1' and starttime<'2017-4-1',BIGTIMEDIFF(endtime,starttime),0)) as '月累计学习时长',
                    a.orgid,org.name from cache_accountcollegeactive a
                    inner join vmb_studyrecorde b on a.collegeid=b.collegeid and a.`accountid` =b.accountid
                    inner join vmb_org org on a.orgid=org.orgid
                    where a.collegeid=70 group by a.orgid;
                </pre>
            </blockquote>
            <form>
                <a class="btn btn-primary">还未实现</a>
            </form>
        </div>
    </div>
</body>
</html>