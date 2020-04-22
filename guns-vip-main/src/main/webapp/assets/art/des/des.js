layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Des = {
        tableId: "desTable"
    };

    /**
     * 初始化表格的列
     */
    Des.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'artId', sort: true, title: '对应作品id'},
            {field: 'desTime', sort: true, title: '损毁时间'},
            {field: 'desReason', sort: true, title: '损毁原因'},
            {field: 'operator', sort: true, title: '操作人'},
            {field: 'opeTime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Des.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Des.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Des.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/des/add',
            tableId: Des.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Des.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/des/edit?id=' + data.id,
            tableId: Des.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Des.exportExcel = function () {
        var checkRows = table.checkStatus(Des.tableId);
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
    Des.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/des/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Des.tableId);
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
        elem: '#' + Des.tableId,
        url: Feng.ctxPath + '/des/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Des.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Des.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Des.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Des.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Des.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Des.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Des.onDeleteItem(data);
        }
    });
});
