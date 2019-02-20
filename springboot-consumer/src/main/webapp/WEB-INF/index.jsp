<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/01/25
  Time: 下午 02:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/js-boot/base.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12" style="height: 80px;">
            <nav class="navbar navbar-default navbar-static-top">
                <div class="container-fluid">
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    </div>
    <div class="row" style="height: 625px;">
        <div class="col-xs-3" style="height: 100%;">
            <div id="tree"></div>
        </div>
        <div class="col-xs-9 " style="height: 100%;">
            <div class="nav nav-tabs"></div>
            <div class="tab-content">
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function(){
        inittree();
    })
   function getTree(){
        $.ajax({
            url:"./findTree",
            type : "post",
            dataType : "json",
            async : false,
            success : function(data) {
                value = data;
            }
        })
        return value;
    }
    $("#tree").treeview({
        data: getTree(),
        onhoverColor: "#f5f5f5",
        //levels: 0 ,
        selectedBackColor: 'black', //设置被选中的节点背景颜色
        selectedColor: 'red', //设置被选择节点的字体、图标颜色
        collapseIcon: "glyphicon glyphicon-star-empty",
        expandIcon: "glyphicon glyphicon-star",
        //showCheckbox: true,   //是否显示复选框
        highlightSelected: true,    //是否高亮选中
        //multiSelect: false,    //多选
        onNodeChecked: function (event,data) {
            alert(data.nodeId);

        },
        onNodeSelected: function (event, node) {
           alert(123)
             if (node.nodes == undefined) {
               if (node.href != null) {
                    $.ajax({
                        url: node.href,
                        type: "post",
                        dataType: "html",
                        success: function (data) {
                            $.addtabs.add({
                                title: node.text,
                                content: data
                            })
                        }
                    })
                }
             }
        }
    })
</script>

</html>
