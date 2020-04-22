layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Display = {
        tableId: "displayTable"
    };

    /**
     * 初始化表格的列
     */
    Display.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'artId', sort: true, title: ''},
            {field: 'startTime', sort: true, title: '开始时间'},
            {field: 'reason', sort: true, title: '事由'},
            {field: 'user', sort: true, title: '使用人'},
            {field: 'organizer', sort: true, title: '主办方'},
            {field: 'exhibition', sort: true, title: '会展名称'},
            {field: 'location', sort: true, title: '展出地点'},
            {field: 'receiver', sort: true, title: '接收人'},
            {field: 'estReturnTime', sort: true, title: '预计归还时间'},
            {field: 'returnId', sort: true, title: '归还情况id'},
            {field: 'operator', sort: true, title: '操作人'},
            {field: 'opeTime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Display.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Display.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Display.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/display/add',
            tableId: Display.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Display.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/display/edit?id=' + data.id,
            tableId: Display.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Display.exportExcel = function () {
        var checkRows = table.checkStatus(Display.tableId);
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
    Display.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/display/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Display.tableId);
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
        elem: '#' + Display.tableId,
        url: Feng.ctxPath + '/display/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Display.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Display.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Display.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Display.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Display.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Display.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Display.onDeleteItem(data);
        }
    });
});
