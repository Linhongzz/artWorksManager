layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Status = {
        tableId: "statusTable"
    };

    /**
     * 初始化表格的列
     */
    Status.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'artId', sort: true, title: '作品id'},
            {field: 'status', sort: true, title: '当前状态'},
            {field: 'statusId', sort: true, title: '状态id'},
            {field: 'operator', sort: true, title: '操作人'},
            {field: 'opeTime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Status.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Status.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Status.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/status/add',
            tableId: Status.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Status.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/status/edit?id=' + data.id,
            tableId: Status.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Status.exportExcel = function () {
        var checkRows = table.checkStatus(Status.tableId);
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
    Status.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/status/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Status.tableId);
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
        elem: '#' + Status.tableId,
        url: Feng.ctxPath + '/status/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Status.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Status.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Status.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Status.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Status.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Status.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Status.onDeleteItem(data);
        }
    });
});
