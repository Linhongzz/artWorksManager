/**
 * 添加或者修改页面
 */
var DetailInfoDlg = {
    data: {
        name: "",
        author: "",
        size: "",
        literalSign: "",
        creationDate: "",
        source: "",
        category: "",
        certificate: "",
        photo: ""
    }
};


layui.use(['form', 'admin', 'ax','upload','laydate'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var upload = layui.upload;
    var laydate= layui.laydate;
    //执行一个laydate实例
    laydate.render({
        elem: '#creationDate' //指定元素
    });

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#test1'
        ,url: '/detail/upload/'
        ,accept:'images'
        ,size:50000
        ,before: function(obj){

            obj.preview(function(index, file, result){

                $('#demo1').attr('src', result);
            });
        }
        ,done: function(res){
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            //上传成功
            var demoText = $('#demoText');
            demoText.html('<span style="color: #4cae4c;">上传成功</span>');

            var fileupload = $(".image");
            fileupload.attr("value",res.data.src);
            console.log(fileupload.attr("value"));
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/detail/addItem", function (data) {
            Feng.success("添加成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();

        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

});