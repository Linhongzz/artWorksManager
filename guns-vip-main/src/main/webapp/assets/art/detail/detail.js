layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Detail = {
        tableId: "detailTable"
    };

    /**
     * 初始化表格的列
     */
    Detail.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'name', sort: true, title: '作品名称'},
            {field: 'author', sort: true, title: '作者'},
            {field: 'size', sort: true, title: '尺寸'},
            {field: 'literalSign', sort: true, title: '款识'},
            {field: 'creationDate', sort: true, title: '创作日期'},
            {field: 'source', sort: true, title: '来源'},
            {field: 'category', sort: true, title: '类别'},
            {field: 'certificate', sort: true, title: '收藏证书号'},
            {field: 'photo', sort: true, title: '照片',templet:'<div><img src="/detail/file/download?filename={{d.photo}}"></div>'},
            {field: 'operator', sort: true, title: '操作人'},
            {field: 'opeTime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Detail.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Detail.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Detail.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/detail/add',
            tableId: Detail.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Detail.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/detail/edit?id=' + data.id,
            tableId: Detail.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Detail.exportExcel = function () {
        var checkRows = table.checkStatus(Detail.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Detail.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/detail/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Detail.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Detail.tableId,
        url: Feng.ctxPath + '/detail/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Detail.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Detail.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Detail.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Detail.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Detail.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Detail.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Detail.onDeleteItem(data);
        }
    });
});
