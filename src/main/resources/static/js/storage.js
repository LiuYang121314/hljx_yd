$(function () {
    $(".click").click(function () {
        console.log($(".banzu").trigger("change").val())
        if ($(".banzu").trigger("change").val() == (-1)) {
            $(".warning").html("班组属性不能为空！")
            return false;
        } else if ($(".packway").trigger("change").val() == (-1)) {
            $(".warning").html("包装方式属性不能为空！")
            return false;
        } else if ($(".stock").trigger("change").val() == (-1)) {
            $(".warning").html("入库仓库属性不能为空！")
            return false;
        } else if ($(".stockPla").trigger("change").val() == (-1)) {
            $(".warning").html("入库仓位属性不能为空！")
            return false;
        } else {
            $(".warning").html("");
            $(".messTwo").hide();
            $(".message").show();
        }
    });
    $(".return").click(function () {
        $(".messTwo").show();
        $(".message").hide();
    });
    $(".banzu").change(function () {
        var banzu = ($(this).val());
        console.log(banzu)
        if (banzu == "") {
            if ($('.banzutips').text() == "") {
                $('.banzutips').text('*');
            }
        } else {
            $(".banzutips").empty();
        }
    });
    $(".packway").change(function () {
        var banzu = ($(this).val());
        console.log(banzu)
        if (banzu == "") {
            if ($('.packwaytips').text() == "") {
                $('.packwaytips').text('*');
            }
        } else {
            $(".packwaytips").empty();
        }
    });
    //获取过磅类型
    console.info("get start");
    $.ajax({
        url: "submsg/measureInType",
        type: "POST",
        success: function (data) {
            console.info(data);
            $(".bangType").empty();
            $(".bangType").append("<option value='-1'>请选择过磅类型</option>");
            $.each(data, function (i, v) {
                var text = "<option value='" + v.fInterID + "'>" + v.fName + "</option>"
                $(".bangType").append(text);
            });
        },
        error: function () {
            console.log("error")
        }
    });
    console.info("get start");


    /*//监控变化，获取物料
        $('.aa').bind('input propertychange', function(){
            console.log($(".aa").val());
         if($(".aa").val().length<5){
             return false;
         }else{
             var code = $(".select2-search__field").val();
            console.info(code);
            $.ajax({
                url: "/item/icitems"
                , type: "POST"
                ,data:{"fNumber": code}
                , success: function (data) {
                    console.info(data);
                }
                , error: function (msg) {
                    console.info("获取物料代码失败");
                    console.info(msg);
                }
            });
         }
     });*/

    //获取当前用户
    $.ajax({
        url: "/session"
        , type: "POST"
        , data: {"parameName": "user"}
        , success: function (data) {
            console.info(data);
            $("input[name='fBiller']").val(data.fname);
        }
        , error: function () {
            console.info("error");
        }
    });
    //获取班组
    $.ajax({
        url: "/item/item3001"
        , type: "POST"
        , success: function (data) {
            console.info(data);
            $(".banzu").empty();
            $(".banzu").append("<option value='-1'>请选择班组</option>");
            $.each(data, function (i, v) {
                var text = "<option value='" + v.fitemID + "'>" + v.fname + "</option>"
                $(".banzu").append(text);
            });
        }
        , error: function (mes) {
            console.info("获取班组失败");
            console.info(mes);
        }
    });
    //获取包装方式
    $.ajax({
        url: "/item/packageType"
        , type: "POST"
        , success: function (data) {
            console.info(data);
            $(".packway").empty();
            $(".packway").append("<option value='-1'>请选择包装方式</option>");
            $.each(data, function (i, v) {
                var text = "<option value='" + v.fid + "'>" + v.fname + "</option>";
                $(".packway").append(text);
            });
        }
        , error: function (msg) {
            console.info("获取包装方式失败");
            console.info(msg);
        }
    });
    //获取入库仓库
    $.ajax({
        url: "/stock/getStocks"
        , type: "POST"
        , success: function (data) {
            console.info(data);
            $(".stock").empty();
            $(".stock").append("<option value='-1'>请选择入库仓库</option>");
            $.each(data, function (i, v) {
                v = $.parseJSON(v)
                var text = "<option value='" + v.fItemID + '|' + v.fspGroupID + "'>" + v.fName + "</option>";
                $(".stock").append(text);
            });
        }
        , error: function (msg) {
            console.info("获取仓库失败");
            console.info(msg);
        }
    });

    $(".stock").change(function (e) {
        var optionVal = $(".stock").val();
        if (optionVal == -1) {
        } else {

            var groupId = optionVal.split('|')[1];
            $.ajax({
                url: "/stock/getPlace"
                , type: "POST"
                , data: {"groupID": groupId}
                , success: function (data) {
                    console.info(data);
                    $(".stockPla").empty();
                    $(".stockPla").append("<option value='-1'>请选择入库仓位</option>");
                    $.each(data, function (i, v) {
                        v = $.parseJSON(v);
                        console.info(v);
                        var text = "<option value='" + v.fspID + "'>" + v.fName + "</option>";
                        $(".stockPla").append(text);

                    });
                }
                , error: function (msg) {
                    console.info("获取库位失败");
                    console.info(msg);
                }
            });
        }
    });
    //保存单据
    $(".save").click(function () {
        var arr = $(".museFill");
        $.each(arr, function (i, v) {
            console.info(v.value);
            if (v.value == "" || v.value == -1) {
                $(".warning").html($(v).prev().find("span").text() + "属性不能为空！");
            } else (
                $.ajax({
                    url: "/tbos/saveWeight"
                    , type: "POST"
                    , data: $(".weigh").serialize()
                    , success: function (data) {
                        data = $.parseJSON(data).data
                        if (data.success) {
                            location.href = "/index";
                            // location.href="/user";
                        }
                    }
                    , error: function (msg) {
                        console.info(msg);
                    }
                })
            );
        });
    });
    //新增
    $(".new").click(function () {
        /* $('.banzu').select2('val', "");*/
        $('.banzu').select2('data', null);
        /*$(".banzu").empty();*/
        $('select option').remove()
        $(".message input").val("");
        $(".bangType").empty();
    })
});