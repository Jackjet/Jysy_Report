<html>
<head>
<#include "common/header.ftl" >
    <script src="/static/js/datepicker.js"></script>
    <link href="/static/css/datepicker.less">
    <script src="/static/js/reportDetail.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <blockquote>
                <h2>教育事业-detail.xlsx报表导出</h2>
            </blockquote>
        </div>
        <div class="row">
            <form class="form-horizontal" action="/jysy/detail" method="post">
                <div class="form-group">
                    <label class="col-sm-1 control-label">时间选择:</label>
                    <div class="col-sm-11">
                        <input id="myDateTime" style="text" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                     <div class="col-sm-offset-1 col-sm-11">
                         <button class="btn btn-primary">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>