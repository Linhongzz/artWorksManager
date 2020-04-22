layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Donate = {
        tableId: "donateTable"
    };

    /**
     * 初始化表格的列
     */
    Donate.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'artId', sort: true, title: ''},
            {field: 'appTime', sort: true, title: '时间'},
            {field: 'reason', sort: true, title: '事由'},
            {field: 'user', sort: true, title: '使用人'},
            {field: 'recipient', sort: true, title: '受赠单位（人）'},
            {field: 'operator', sort: true, title: '操作人'},
            {field: 'opeTime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Donate.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Donate.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Donate.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/donate/add',
            tableId: Donate.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Donate.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/donate/edit?id=' + data.id,
            tableId: Donate.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Donate.exportExcel = function () {
        var checkRows = table.checkStatus(Donate.tableId);
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
    Donate.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/donate/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Donate.tableId);
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
        elem: '#' + Donate.tableId,
        url: Feng.ctxPath + '/donate/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Donate.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Donate.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Donate.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Donate.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Donate.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Donate.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Donate.onDeleteItem(data);
        }
    });
});
