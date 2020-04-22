layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Return = {
        tableId: "returnTable"
    };

    /**
     * 初始化表格的列
     */
    Return.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'artId', sort: true, title: ''},
            {field: 'returnTime', sort: true, title: '归还时间'},
            {field: 'returnee', sort: true, title: '归还人'},
            {field: 'acceptance', sort: true, title: '验收情况'},
            {field: 'acceptor', sort: true, title: '验收人'},
            {field: 'operator', sort: true, title: '操作人'},
            {field: 'opeTime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Return.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Return.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Return.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/return/add',
            tableId: Return.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Return.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/return/edit?id=' + data.id,
            tableId: Return.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Return.exportExcel = function () {
        var checkRows = table.checkStatus(Return.tableId);
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
    Return.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/return/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Return.tableId);
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
        elem: '#' + Return.tableId,
        url: Feng.ctxPath + '/return/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Return.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Return.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Return.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Return.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Return.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Return.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Return.onDeleteItem(data);
        }
    });
});
